package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;

//@Controller
//@ResponseBody

// @RestController = @Controller + @ResponseBody  
// 비동기 처리에서 객체 데이터를 JSON 형태로 변환해 반환하는 역할
@RestController
public class MemberController {

	@Autowired
	private MemberDao dao;

	/*
	 * // @GetMapping("/members") // public String membersGet(Model model) { //
	 * model.addAttribute("list", dao.getList()); // return "list"; // }
	 * 
	 * @GetMapping("/members") public MemberDto membersGet(Model model) { MemberDto
	 * dto = new MemberDto(); dto.setNum(1); dto.setName("공기밥");
	 * dto.setAddr("강남구 역삼동"); return dto; }
	 * 
	 * @GetMapping("/insertForm") public String insertFormGet() { return
	 * "insertForm"; }
	 * 
	 * @PostMapping("/insert") public String insertPost(@RequestParam("name")String
	 * name, @RequestParam("addr")String addr) { // public String
	 * insertPost(MemberDto dto) { MemberDto dto = new MemberDto();
	 * dto.setName(name); dto.setAddr(addr); dao.insert(dto); return
	 * "redirect:members"; }
	 */

	// ---------- REST 요청 처리 ----------
	@GetMapping("/members")
	public List<MemberDto> membersGet() {
		// DB 자료를 읽어HTML 파일로 반환하는 것이 아니라
		// JSON 형태로 변환해 클라이언트(JavaScript Ajax 요청)에 반환
		System.out.println("GET 요청");
		return dao.getList();
	}

	@PostMapping("/members") // 추가 (INSERT)
	public Map<String, Object> memberPost(@RequestBody MemberDto dto) {
		// @RequestBody : 요청 본문에 담긴 값(JSON)을 자바 객체로 변환
		dao.insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}

	@GetMapping("/members/{num}")
	public MemberDto membersNumGet(@PathVariable("num") int num) {
		return dao.getData(num);
	}

	@PutMapping("/members/{num}")
	public Map<String, Object> membersNumPut(@PathVariable("num") int num, @RequestBody MemberDto dto) {
		dto.setNum(num);
		dao.update(dto);
		return Map.of("isSuccess", true);
//		map.put("isSuccess", true); return map; 와 같음
	}

	@DeleteMapping("/members/{num}")
	public Map<String, Object> membersNumDelete(@PathVariable("num") int num){
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
	
}
