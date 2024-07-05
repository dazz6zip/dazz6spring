package anno03_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	// @Value : 변수 값을 초기화하기 위해 사용하기도 함
	
	@Value("#{dataInfo.name}")
	private String name;
	// Spring EL : #{표현식}, 만들어진 Component 객체를 이용,
	// private는 getter를 이용해서 가져옴
	// 속성 값을 참조할 때는 ${property.name}
	
	private String part;
	
	@Autowired
//	public MyProcess(@Value("영업부") String part) { // 영업부를 this.part 에 치환
	public MyProcess(@Value("#{dataInfo.part}") String part) { // dataInfo 의 part 값을 this.part 에 치환
		this.part = part;
	}
	
	@Value("123") // Value annotation default -> String
	private int age;
	
	@Value("1, 2, 3, 4")
	private int[] arr;
	
	public void showData() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("age : " + age);
		System.out.print("arr : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}
