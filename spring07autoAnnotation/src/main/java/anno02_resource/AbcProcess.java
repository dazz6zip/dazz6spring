package anno02_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class AbcProcess {
	
	@Resource(name="abc01") // java annotation // 객체 변수 이름으로 매핑
	private Abc01 abc01;
	private Abc02 abc02;
	
	@Resource(name="aaa") // Abc02 클래스에서 @Component("aaa") 로 지정해 줬기 때문에 Resource도 aaa로 지정
	public void setA2(Abc02 a2) {
		this.abc02 = a2;
	}
	
	public void showData() {
		abc01.setIrum("금요일");
		abc02.setNai(23);
		
		String str = "이름 : " + abc01.getIrum();
		str += "\n나이 : " + abc02.getNai();
		System.out.println(str);
	}
}

/*
@Autowired
- Spring annotation
- type mapping

@Resource
- Java annotation
- name mapping
 */