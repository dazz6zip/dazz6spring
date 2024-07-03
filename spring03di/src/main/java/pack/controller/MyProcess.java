package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements MyInter {
	private MoneyInter inter;
	private int[] re;
	
	public MyProcess(MoneyInter inter) {
		this.inter = inter;
		// interface는 스스로 new 할 수 없기 때문에 파라미터로 주소를 받아옴
	}
	
	@Override
	public void inputMoney() {
		// 금액 입력 후 MoneyInter type의 class를 이용하여 금액 단위별 갯수 계산
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 입력 : ");
			int mm = sc.nextInt();
			re = inter.calcMoney(mm);
		} catch (Exception e) {
			System.out.println("inputMoney() ERROR : " + e.getMessage());
		}
	}

	@Override
	public void showResult() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("만 원 : " + re[0] + "\n");
//		sb.append("천 원 : " + re[1] + "\n");
//		sb.append("백 원 : " + re[2] + "\n");
//		sb.append("십 원 : " + re[3] + "\n");
//		sb.append("일 원 : " + re[4] + "\n");
//		System.out.println(sb.toString());
		
		StringBuilder sb = new StringBuilder();
		String[] units = {"만 원", "천 원", "백 원", "십 원", "일 원"};
		for (int i = 0; i < units.length; i++) {
			sb.append(units[i] + " : " + re[i] + "\n");
		}
		System.out.println(sb.toString());
	}

}
