package pack;

public class OurProcess {
	private String name;
	private int su;
	private GuguDan ggd;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSu(int su) {
		this.su = su;
	}
	
	public void setGgd(GuguDan ggd) {
		this.ggd = ggd;
	}
	
	@Override
	public String toString() {
		int[] results = ggd.numberCalc(su);
		String str = "";
		
		for (int i = 0; i < results.length; i++) {
			str += (su + "*" + (i + 1) + "=" + results[i] + "\n");
		}
		
		return "작성자 : " + name + "\n" + su + "단 결과\n" + str;
	}
}
