package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String abc(UploadFile ulf) {
		return "uploadform";
	}

	@PostMapping("/upload")
	public String submit(UploadFile ulf, Model model, BindingResult result) {
		InputStream ips = null;
		OutputStream ops = null;
		
		// 업로드된 파일 검사
		MultipartFile file = ulf.getFile();
		String fileName = file.getOriginalFilename();
		
		if(result.hasErrors()) { // 파일에 오류가 있을 경우
			return "err";
		}
		
		try {
			ips = file.getInputStream();
			File newFile = new File("C:\\workSpring\\springSou\\wDazz6Spr23FileUpload\\src\\main\\resources\\static\\upload\\" + fileName);
			if(!newFile.exists()) { // 해당 파일이 존재하지 않을 경우
				newFile.createNewFile();
			}
			ops = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = ips.read(bytes)) != -1) { // 자료가 아닌 동안
				ops.write(bytes, 0, read);				
			}
		} catch (Exception e) {
			System.out.println("file submit ERROR : " + e.getMessage());
			return "err";
		} finally {
			try {
				ips.close();
				ops.close();
			} catch (Exception e2) {
				System.out.println("file submit - finally ERROR : " + e2.getMessage());
			}
		}
		model.addAttribute("filename", fileName);
		return "uploadfile";
	}
	
}
