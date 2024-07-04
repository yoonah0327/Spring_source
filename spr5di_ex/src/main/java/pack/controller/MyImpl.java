package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter;    // SangpumInter 타입의 하위 클래스는 어떤 것이든 사용할 수 있음.
	//impl을 쓰면 곱하기만가능. inter를 받아야, 여러 impl들을 가져다 쓸수있다.
	private String res[];
	
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputData() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("상품 입력 : ");
			String sang = scanner.next();
			System.out.print("수량 입력 : ");
			int su = scanner.nextInt();
			System.out.print("단가 입력 : ");
			int dan = scanner.nextInt();
			
			res = inter.calcMoney(sang, su, dan);
		} catch (Exception e) {
			System.out.println("inputData err" + e.getMessage());
		}

	}

	
	@Override
	public void showData() {
		System.out.println("상품명 :" + res[0] + " => 금액은 " + res[1]);

	}

}
