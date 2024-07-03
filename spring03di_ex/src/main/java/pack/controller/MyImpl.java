package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter cm;
	private String sp;
	private int price;

	public MyImpl(SangpumInter cm) {
		this.cm = cm;
	}

	@Override
	public void inputData() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("상품 : ");
			sp = sc.next();
			System.out.print("수량 : ");
			int st = sc.nextInt();
			System.out.print("단가 : ");
			int pr = sc.nextInt();
			price = cm.calcMoney(st, pr);
		} catch (Exception e) {
			System.out.println("inputData() ERROR : " + e.getMessage());
		}

	}

	@Override
	public void showData() {
		System.out.println("상품명 : " + sp + "의 금액은 " + price + "원입니다.");
	}
}
