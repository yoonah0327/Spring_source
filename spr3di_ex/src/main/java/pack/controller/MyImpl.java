package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{ //extends sangpumImpl하면 이거하나만 쓸수있다. 
	//그러나 implements MyInter하면 다 할수있다. 심지어 다중도 됨.
	private SangpumInter inter; //SangpumInter 타입의 인터페이스 변수
	//클래스를 선언해주면, 해당 클래스하나만 가. 다양하게 다 쓰고싶어서 클래스가아닌 인터페이스를 선언.
	private int re;
	private String sang;
	//private String rs[];
	
	
	public MyImpl(SangpumInter inter) {
		this.inter = inter; // 인터페이스 다형성
	}
	
	@Override
	public void inputData() {// 스캐너를 통해 입력한 값들을 MoneyInter타입의 클래스이용해 계산
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("상품명 입력: ");
			sang = sc.next();
			//String sang = sc.next();
			System.out.println("수량 입력: ");
			int su = sc.nextInt();
			System.out.println("단가 입력: ");
			int dan = sc.nextInt();
			re= inter.calcMoney(sang, su, dan);
			//rs= inter.calcMoney(sang, su, dan);
		} catch (Exception e) {
			System.out.println("inputData err: "+ e.getMessage());
		}
		
	}
	@Override
	public void showData() {
		System.out.println("상품명은 "+sang+ " -> 금액은 "+ re);
		//System.out.println("상품명: " + rs[0] + "\n" + "금액은: " +  rs[1] + "원");

	}
	
}
