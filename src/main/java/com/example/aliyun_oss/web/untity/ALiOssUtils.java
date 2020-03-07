package com.example.aliyun_oss.web.untity;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.example.aliyun_oss.web.pojo.component.ConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 马锴梁
 * @version 1.0
 * @date 2019/12/16 14:33
 */
@Slf4j
public class ALiOssUtils {
  static   String endpoint= ConstantProperties.POINT;
  static String accessKeyId=ConstantProperties.KEY_ID;
  static String accessKeySecret=ConstantProperties.KEY_SECRET;
  static String bucketName=ConstantProperties.BUCKET_NAME1;
  static String folder=ConstantProperties.HOST;

  static  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  static String dateStr = format.format(new Date());  //当前时间
//    创建bucket
    public static String createBucketName(String bucketName) {
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 存储空间
        if (!ossClient.doesBucketExist(bucketName)) {
            // 创建存储空间
            Bucket bucket = ossClient.createBucket(bucketName);
            ossClient.shutdown();
            return bucket.getName();
        }
        ossClient.shutdown();
        return bucketName;
    }
     /**
      * @author: mkl
      * @Description:删除bucket
      */
    public static void deleteBucket(String bucketName) {
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteBucket(bucketName);
        ossClient.shutdown();
        log.info("删除" + bucketName + "Bucket成功");
    }
     /**
      * @author: mkl
      * @Description:创造文件夹
      */
    public static String createFolder(String bucketName, String folder) {
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//         文件夹名 oss
        final String keySuffixWithSlash = folder+"/";
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
//             创建文件夹 有个天坑那就是文件夹创建必须夹/否则会以文件的形式进行创建
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            log.info("创建文件夹成功");
//             得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            ossClient.shutdown();
            return fileDir;
        }
        ossClient.shutdown();
        return keySuffixWithSlash;
    }
//    public String upLoadImage(File file){
//        String fileUrl = uploadImg2Oss(file);
//        String str = getImgUrl(fileUrl);
//        return str.trim();
//    }

//    public static String uploadImg2Oss(File file){
//        if(file.length()> 1024 * 1024 *20){
//            log.info("图片太大");
//            return "图片太大";
//        }
//
//        try {
//            String res = this.uploadObject2OSS(file);
//            if(!StringUtils.isEmpty(res)){
//                return file.getName();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
     /**
      * @author: mkl
      * @Description:上传文件
      */

//     public static OSS getOssclient(){
//       return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//     }
    public static  String uploadObject2OSSuplad(File file) {
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String resultStr = null;
        try {
            // 以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
            // 文件名
            String fileName = file.getName();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename=" + fileName);
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder+"/"+ fileName, is, metadata);
            Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
            URL url = ossClient.generatePresignedUrl(bucketName, folder +"/"+ fileName, expiration);
            ossClient.shutdown();
            is.close();
            return url.toString();
            // 解析结果
//            resultStr = putResult.getETag();

//            return resultStr;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return " ";
    }

//    public static  boolean uploads(List<File> files){
//      OSS ossClient=null;
//      String resultStr = null;
//      InputStream is=null;
//      try {
//        int i=0;
//        while (i<files.size()){
//          ossClient= new OSSClient(endpoint, accessKeyId, accessKeySecret);
//          // 以输入流的形式上传文件
//           is = new FileInputStream(files.get(i));
//          // 文件名
//          String fileName = files.get(i).getName();
//          // 创建上传Object的Metadata
//          ObjectMetadata metadata = new ObjectMetadata();
//          // 上传的文件的长度
//          metadata.setContentLength(is.available());
//          // 指定该Object被下载时的网页的缓存行为
//          metadata.setCacheControl("no-cache");
//          // 指定该Object下设置Header
//          metadata.setHeader("Pragma", "no-cache");
//          // 指定该Object被下载时的内容编码格式
//          metadata.setContentEncoding("utf-8");
//          // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
//          // 如果没有扩展名则填默认值application/octet-stream
//          metadata.setContentType(getContentType(fileName));
//          // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
//          metadata.setContentDisposition("filename=" + fileName);
//          // 上传文件 (上传文件流的形式)
//          PutObjectResult putResult = ossClient.putObject(bucketName, folder+ fileName, is, metadata);
//          Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
//          URL url = ossClient.generatePresignedUrl(bucketName, folder + fileName, expiration);
//          ossClient.shutdown();
//          i++;
//          if (is!=null)
//            is.close();
//            if (ossClient!=null)
//              ossClient.shutdown();
//        }
//        return true;
//      }catch (Exception e){
//        log.info(e+"-=====================");
//      }finally {
//        if (ossClient!=null)
//          ossClient.shutdown();
//
//      }
//      return false;
//    }



//    public String getImgUrl(String fileUrl) {
//        if (!StringUtils.isEmpty(fileUrl)) {
//            String[] split = fileUrl.split("/");
//            String url =  this.getUrl(folder+ split[split.length - 1]);
////                log.info(url);
////                String[] spilt1 = url.split("\\?");
////                return spilt1[0];
//            return url;
//        }
//        return null;
//    }
//    public String getUrl(String key) {
//        // 设置URL过期时间为10年  3600l* 1000*24*365*10
//        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//        // 生成URL
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
//        if (url != null) {
//            ossClient.shutdown();
//            return url.toString();
//        }
//        return null;
//    }
     /**
      * @author: mkl
      * @Description:下载文件至本地
      */
    public static void downLoadFile(String bucketName ,String folder,String localUrl ){
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.getObject(new GetObjectRequest(bucketName, folder), new File(localUrl));
        ossClient.shutdown();
    }
     /**
      * @author: mkl
      * @Description:删除文件
      */
    public static void deleteObjectFile(String bucketName ,String folder,String fileName ){
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(bucketName,folder+fileName);
        ossClient.shutdown();
    }
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".png".equalsIgnoreCase(fileExtension)) {
            return "image/png";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        // 默认返回类型
        return "";
    }
  public static String getSuffix(MultipartFile fileupload) {
    String originalFilename = fileupload.getOriginalFilename();
    String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    System.out.println(suffix);
    return suffix;
  }

  /**
   * 获得url链接
   *
   * @param objectName
   * @return
   */
  public static String getUrl(String objectName) {
    // 创建OSSClient实例。
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    // 设置权限(公开读)
    ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
    // 设置图片处理样式。
//        String style = "image/resize,m_fixed,w_100,h_100/rotate,90";
    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
    GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
    req.setExpiration(expiration);
//        req.setProcess(style);
    URL signedUrl = ossClient.generatePresignedUrl(req);
    // 关闭OSSClient。
    log.info("------OSS文件文件信息--------" + signedUrl.toString());
    ossClient.shutdown();
    if (signedUrl != null) {
      return signedUrl.toString();
    }
    return null;
  }

//    public static void main(String[] args) {
//        File file = new File("E:\\b.jpg");
//        String s = ALiOssUtils.uploadObject2OSS(file);
//        System.out.println(s);
//        ALiOssUtils.downLoadFile("mrefri","imagesa.jpg","D:\\迅雷\\666.jpg");
//
//    }
}
