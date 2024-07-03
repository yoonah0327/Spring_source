package pack.model;

public class SangpumImpl implements SangpumInter{ //implement= 구현하다
	
	@Override
	public int calcMoney(String sang, int su, int dan) {
		int re= su * dan;
		return re;
		
		// spr3di 처럼 배열로 해도 됨. 
		/*
		 * public String[] calcMoney(String sang, int su, int dan) {
		String rs[] = new String[2];
		
		rs[0] = sang;
		rs[1] = Integer.toString(su * dan);
		
		return rs;

		 */
	}
		

}
