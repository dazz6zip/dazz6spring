package anno01_auto;

import org.springframework.stereotype.Component;

/*
@Component
독립적 객체 생성시 사용됨
singleton pattern 으로 sender 객체 생성
객체 변수 이름은 sender
 
가독성을 위해 만들어진 @Component의 하위 어노테이션
@Controller
- 클라이언트의 요청이 들어왔을 때 처리함
@Service
- 비지니스 로직
@Repository
- 외부 I/O 처리

@Component("sender")
- 자동으로 생성되는 이름이 아닌 다른 이름으로 생성하고 싶을 때 사용
@Scope("singleton")
- singleton OR prototype
*/

@Component
public class Sender implements SenderInter {
	public void show() {
		System.out.println("show method from Sender");
	}
}
