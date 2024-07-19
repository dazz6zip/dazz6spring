package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class WDazz6Spr14DbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WDazz6Spr14DbJpaApplication.class, args).getBean(WDazz6Spr14DbJpaApplication.class).execute();
	}
	
	@Autowired
	ProductCrudRepository pcrt;
	
	private void execute() {
		System.out.println("\n! execute\n"); 
//		insertData();
		selectData();
	}
	
	private void insertData() {
//		ProductVo vo = new ProductVo();
//		vo.setSang("볼펜");
//		vo.setSu(3);
//		vo.setDan(3000);
//		System.out.println("등록 데이터 : " + pcrt.save(vo));
		
		ProductVo vo = new ProductVo();
		vo.setCode(2);
		vo.setSang("폼폼푸린");
		vo.setSu(1);
		vo.setDan(30000);
		pcrt.save(vo);
	}
	
	private void selectData() {
		System.out.println("전체 자료 읽기 : DBMS에 독립적");
		List<ProductVo> list = pcrt.findAll();
		System.out.println("\n코드\t상품\t수량\t단가"); 
		for (ProductVo p : list) {
			System.out.println(p.getCode() + "\t" + p.getSang() + "\t" + p.getSu() + "\t" + p.getDan());
		}
		
		ProductVo vo = pcrt.findById(2).get();
		System.out.println("\n코드\t상품\t수량\t단가"); 
		System.out.println(vo.getCode() + "\t" + vo.getSang() + "\t" + vo.getSu() + "\t" + vo.getDan());
		
		
		System.out.println("\n\n----- JPQL 사용 -----\n\n");
		
		List<ProductVo> plist = pcrt.findAllData(); 
		System.out.println("\n코드\t상품\t수량\t단가"); 
		for (ProductVo p : plist) {
			System.out.println(p.getCode() + "\t" + p.getSang() + "\t" + p.getSu() + "\t" + p.getDan());
		}
		
		ProductVo pvo = pcrt.findByCode(1);
		System.out.println("\n코드\t상품\t수량\t단가"); 
		System.out.println(pvo.getCode() + "\t" + pvo.getSang() + "\t" + pvo.getSu() + "\t" + pvo.getDan());
		
		ProductVo pvop1 = pcrt.findByCodePersonal1(2); 
		System.out.println("\n코드\t상품\t수량\t단가"); 
		System.out.println(pvop1.getCode() + "\t" + pvop1.getSang() + "\t" + pvop1.getSu() + "\t" + pvop1.getDan());
		
		ProductVo pvop2 = pcrt.findByCodePersonal2(3);
		System.out.println("\n코드\t상품\t수량\t단가"); 
		System.out.println(pvop2.getCode() + "\t" + pvop2.getSang() + "\t" + pvop2.getSu() + "\t" + pvop2.getDan());
		
		List<ProductVo> plist1 = pcrt.findByCodePersonal3(2, "도시락");
		System.out.println("\n코드\t상품\t수량\t단가"); 
		for (ProductVo p : plist1) {
			System.out.println(p.getCode() + "\t" + p.getSang() + "\t" + p.getSu() + "\t" + p.getDan());
		}
		
		List<ProductVo> plist2 = pcrt.findAllData2();
		System.out.println("\n코드\t상품\t수량\t단가"); 
		for (ProductVo p : plist2) {
			System.out.println(p.getCode() + "\t" + p.getSang() + "\t" + p.getSu() + "\t" + p.getDan());
		}
	}
}
