package com.example.aliyun_oss.web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;

@Controller
@RequestMapping(value = "/shangchuan")
@SuppressWarnings({"unused","unchecked","rawtypes"})
/**
 *
 * @author zqh
 *
 */
public class UploadController {

		@GetMapping("/upuploadjsp")
	    public String upload() {
	        return "upload";
	    }
		@PostMapping("/importOSS")
	    public String importOSS(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, ModelMap map) {
	        boolean a = false;
	        String fileName = file.getOriginalFilename();
	        File newFile = new File(fileName);
	        FileOutputStream os;
			try {
				os = new FileOutputStream(newFile);
				os.write(file.getBytes());
		        os.close();
		        file.transferTo(newFile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String uploadUrl="";
	        //上传到OSS
//	        String uploadUrl = AliyunOSSUtil.upload(newFile);
	        System.err.println("URL----"+uploadUrl);
	        map.addAttribute("URL",uploadUrl);
	        return "upload2";
	    }

}
