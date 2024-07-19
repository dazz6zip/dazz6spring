package pack.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@GetMapping("checkPrice")
	public String checkPrice(@RequestParam("name") String name, @RequestParam("price") int price) {
		String result = price >= 50000 ? "고가" : "저가";		
		return "상품명 : " + name + ", 가격 : " + price + "원 (" + result + ")";
	}
}
