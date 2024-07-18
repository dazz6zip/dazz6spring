package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;
import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
@ComponentScan(basePackages={"other"}) // 패키지 이름이 다를 경우 수동 설정
public class WDazz6Spr13DbJpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(WDazz6Spr13DbJpaBasicApplication.class, args).getBean(WDazz6Spr13DbJpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crt;
	
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
//		insData(); // 추가 또는 수정
//		delData(); // 삭제
		selectData();
		
		class1.abc();
	}
 
	private void insData() { 
		ProductVo pvo = new ProductVo(4, "바보", 2, 1000);
		crt.save(pvo); 
		// 이미 있는 id 값에 값을 넣어 주려고 하면 update (수정)
	}
	
	private void delData() { 
		crt.deleteById(4);  
	}
	
	private void selectData() {
		/* 전체 레코드 읽기 */
		List<ProductVo> list = (List<ProductVo>)crt.findAll();
		System.out.println("\n코드\t상품\t수량\t단가"); 
		for (ProductVo p : list) {
			System.out.println(p.getCode() + "\t" + p.getSang() + "\t" + p.getSu() + "\t" + p.getDan());
		}

		/* 레코드 한 개 읽기 */ 
		ProductVo vo = crt.findById(2).get();   
		System.out.println("\n" + vo.getCode() + "\t" + vo.getSang() + "\t" + vo.getSu() + "\t" + vo.getDan()); 
	}
	 
}
