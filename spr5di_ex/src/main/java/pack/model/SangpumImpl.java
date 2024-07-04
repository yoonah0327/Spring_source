package pack.model;

public class SangpumImpl implements SangpumInter {
	
	@Override
	public String[] calcMoney(String sang, int su, int dan) {
		String res[] = new String[2];
		
		res[0] = sang;
		res[1] = Integer.toString(su * dan);
		
		//부모 상품인터를 자식인 상품임플이 오버라이딩으로 받는다.
		// 이 상품임플은 칼크머니에서 곱하기 역할을 수행한다.
		// 원한다면 상품임플2는 더하기역할 수행하게 만들수도있다
		
		return res;
	}
}
