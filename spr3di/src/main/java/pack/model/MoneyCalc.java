package pack.model;

public class MoneyCalc implements MoneyInter {

	@Override
	public int[] calcMoney(int money) { //45678원 
		/*
		int re[] = new int[5]; // 만원짜리까지만 할 생각
		re[0] = money /10000; //만자리 값: 4
		re[1] = money % 10000 /1000; //천자리값 : 5
		re[2] = money % 10000 %1000 /100; //6
 		re[3] = money % 10000 %1000 %100 /10; //7
		re[4] = money % 10000 %1000 %100 %10; //8
	
		return re; //너무 단순해보여서 for문으로 수정해서 다시 적기.
		*/
		int re[] = new int[5];
		int divisor= 10000;
		for(int i=0; i <re.length; i++) {
			re[i] = money/ divisor;
			money %= divisor;
			divisor /= 10;
		}
		return re;
	}

}
