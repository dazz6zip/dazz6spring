package anno02_resource;

import org.springframework.stereotype.Component;

@Component("aaa")
public class Abc02 { // POJO : 순수하게 멤버와 메소드로만 구성 (상속 등이 없음)
	private int nai;
	
	public int getNai() {
		return nai;
	}
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
}
