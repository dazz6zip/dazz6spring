package pack.controller;

import java.util.Scanner;

import pack.model.SangpumImpl;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter si;
	private String[] result;
	
	public void setSi(SangpumInter si) {
		this.si = si;
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
			result = si.calcMoney(sp, st, pr);
		} catch (Exception e) {
			System.out.println("inputData() ERROR : " + e.getMessage());
		}
	}

	@Override
	public void showData() {
		System.out.println(result[0] + "의 금액은 " + result[1] + "원입니다.");
	}
}
