package pack;

// setter injection
public class MyProcess {
	private int nai;
	private String name;
	private ShowData sd;
	// 상속을 지양하기 위함
	
	public MyProcess() {
		
	}
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSd(ShowData sd) {
		this.sd = sd;
	}
	
	public void displayData() {
		System.out.println(name + "(" + nai + "세)\n별명 : " + sd.processNickName() + "\n취미 : " + sd.processHobby());
	}
}
