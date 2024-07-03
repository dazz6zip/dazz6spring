package pack;

public class Message02 implements MessageInter {
	@Override
	public void sayHello(String name) {
		String imsi = name + "님";
		System.out.println(imsi + " 반갑습니다.");
	}
}
