package pack.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadContoller {

	@PostMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse res, @RequestParam("filename") String fileName) throws Exception {
		System.out.println("fileName : " + fileName);
		File file = new File("C:\\workSpring\\springSou\\wDazz6Spr23FileUpload\\src\\main\\resources\\static\\upload\\" + fileName);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		
		// 브라우저에 다운로드 지시
		res.setHeader("Content-Disposition", "attachment;filename= \"" + fn + "\"");
		// attachment : 열지 않고 바로 다운로드
		res.setContentLength(bytes.length);
		
		return bytes;
	}
}
