package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter cm;
	// SangpumImpl 도 쓸 수는 있지만, SangpumInter를 implements 한 class 들을 전부 활용할 수 있게 하기 위해서 interface(MyInter)
	// 만약 SangpumImpl 로 멤버 필드를 선언하여 생성자에서 주소를 치환받을 경우, 오직 SangpumImple 만 사용 가능하게 됨
	private String[] result;

	public MyImpl(SangpumInter cm) {
		// constructor injection
		this.cm = cm;
	}

	@Override
	public void inputData() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("상품 : ");
			String sp = sc.next();
			System.out.print("수량 : ");
			int st = sc.nextInt();
			System.out.print("단가 : ");
			int pr = sc.nextInt();
			result = cm.calcMoney(sp, st, pr);
		} catch (Exception e) {
			System.out.println("inputData() ERROR : " + e.getMessage());
		}
	}

	@Override
	public void showData() {
		System.out.println(result[0] + "의 금액은 " + result[1] + "원입니다.");
	}
}
