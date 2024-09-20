package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pack.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService csvc;
	
	@GetMapping("/alldatas")
	public String allDatas() {
		csvc.printAllData();
		return "전체 자료 출력"; 
	}

	/* 수정 uri */
	// http://localhost:8080/updatedata?name=홍길동
	@GetMapping("/updatedata")
	public String updateData(@RequestParam("name") String name) {
		csvc.updateData(name);
		return "자료 수정"; 
	}

	/* 삭제 uri */
	// http://localhost:8080/deletedata?name=고길동
	@GetMapping("/deletedata")
	public String deleteData(@RequestParam("name") String name) {
		csvc.deleteData(name);
		return "자료 삭제"; 
	}
}
