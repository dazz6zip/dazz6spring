package anno01_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/* (참고) 계층(Layers)별 어노테이션 구분
- Application Layer : 클라이언트와 데이터 입출력을 제어함. 			@Controller...
- Domain Layer : 애플리케이션 중심이며, 업무 처리를 담당함. 		@Service... 
- Infrastructure Layer : DB에 대한 영속성(persistence) 등을 담당함. @Repository
*/

//@Component 도 가능하지만,
//비지니스 로직이기 때문에 @Service 사용

//@Service("senderProcess")
//@Scope("singleton") 과 같은 의미
@Service
public class SenderProcess {
	
	// @Autowired : Bean 의 자동 삽입을 위해 사용되는 annotation 
	// name 으로 매핑되는 것이 아닌 type 으로 매핑되는 것
	// 만약 SenderInter 를 implements 한 Sender01, Sender02 class 가 있고 둘 다 @Component 어노테이션을 달아 줬을 경우
	// 같은 타입(SenderInter)이 두 개 이상이기 때문에 오류 발생함
	// Qualifier() annotation 을 사용하여 해당 @Autowired 이 어떤 Component 와 연결되어야 하는지 명시해 주면 해결됨
	// 참고 : Qualifier는 Autowired의 보조 annotation
	
	// @Component 처럼 객체 생성 annotation 이 선행되어야 함
	
	/* field injection */
//	private Sender sender;
	@Autowired
	@Qualifier("sender")
	private SenderInter senderInter; // interface 를 instance 할 수 없으므로 SenderInter의 하위 클래스를 찾아 Autowired
	// 간단하기 때문에 주로 많이 사용
	// 테스트가 불편한 단점
	
//	/* setter injection */
//	@Autowired
//	public void setSender(Sender sender) {
//		this.sender = sender;
//	}
//	// 코드가 장황해지는 단점
//	
//	/* constructor injection */
//	@Autowired
//	public SenderProcess(Sender sender) {
//		this.sender = sender;
//	}
//	// 불변성
//	// 테스트가 편함
//	// 생성자가 너무 많아지는 단점
	
	public void displayData() {
		senderInter.show();
	}
}
