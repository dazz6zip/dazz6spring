package pack.model;

public class MyInfo implements MyInfoInter {
	// MyInfo : MyInfoInter 타입의 하위 클래스 중 하나
	
	@Override
	public String myData() {
		return "취미 : 운동 (축구)";
	}
}
