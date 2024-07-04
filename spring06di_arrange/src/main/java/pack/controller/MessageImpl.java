package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter {
	// MessageImpl : MessageInter 타입의 하위 클래스 중 하나
	
	// constructor injection
	private String m1, m2;
	private int year;
	private MyInfoInter mii;
	
	// setter injection
	private String spec;
	private OutFileInter ofi;
	
	public MessageImpl(String m1, String m2, int year, MyInfoInter mii) {
		this.m1 = m1;
		this.m2 = m2;
		this.year = year;
		this.mii = mii;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setOfi(OutFileInter ofi) {
		this.ofi = ofi;
	}
	
	@Override
	public void sayHi() {
		String msg = "sayHi from MessageImpl class";
		msg += "\n" + m1 + " " + m2;
		msg += "\n" + (year + 2000) + "년";
		msg += "\n" + mii.myData();
		msg += "\n" + spec;
		
		System.out.println(msg); // console
		
		// 위 메시지를 파일로 출력하기
		ofi.outFile(msg);
	}
}
