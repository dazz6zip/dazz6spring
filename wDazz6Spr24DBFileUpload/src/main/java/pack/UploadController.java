package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/insert")
public class UploadController {

	@Autowired
	private FriendService fs;

	@GetMapping
	public String showInsertForm() {
		return "insert";
	}

	@PostMapping("/upload")
	public String handledFileUpload(@RequestParam("bunho") int bunho, 
									@RequestParam("irum") String irum,
									@RequestParam("junhwa") String junhwa, 
									@RequestParam("jikup") String jikup,
									@RequestParam("file") MultipartFile file,
									RedirectAttributes rdab) {
		if(!file.isEmpty() && file.getSize() > 2097152) { // 파일 크기 2MG 제한
			// Flash 속성 추가 메소드. 일회성으로, 주로 리다이렉트 후 사용자에게 메시지를 전달할 때 사용
			rdab.addFlashAttribute("message", "파일 크기가 초과되었습니다.");
			return "redirect:/insert";
		}
		
		if(!file.getContentType().startsWith("image/")) {
			// 입력된 파일이 이미지인지 확인
			rdab.addFlashAttribute("message", "이미지 파일을 등록해 주세요.");
			return "redirect:/insert";
		}
		
		try {
			Friend f = new Friend();
			f.setBunho(bunho);
			f.setIrum(irum);
			f.setJunhwa(junhwa);
			f.setJikup(jikup);
			System.out.println(file.getBytes());
			f.setSajin(file.getBytes());
			f.setImagetype(file.getContentType());
			
			fs.saveFriend(f);
		} catch (Exception e) {
			rdab.addFlashAttribute("message", "파일 저장 중 오류가 발생 : " + e);
			return "redirect:/insert";
		}
		
		
		return "redirect:/list";
	}
}
