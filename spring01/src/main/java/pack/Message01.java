package pack;

public class Message01 implements MessageInter {
	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 안녕하세요.");
		
	}
}
