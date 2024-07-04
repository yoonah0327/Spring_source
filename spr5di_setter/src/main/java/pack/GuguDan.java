package pack;

public class GuguDan {
	public int[] numberCalc(int dan) {
		int[] re = new int[9];
		
		for(int i =0; i<re.length; i++) {
			re[i] = dan*(i+1);
		}
		return re;
	}
}
