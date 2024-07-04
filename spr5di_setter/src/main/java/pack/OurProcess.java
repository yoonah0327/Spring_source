package pack;

import java.util.Iterator;

public class OurProcess {
	private String name;
	private int su;
	private GuguDan guguDan;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setGuguDan(GuguDan guguDan) {
		this.guguDan = guguDan;
	}
	
	@Override
	public String toString() {
		// 모든 클래스의 수퍼클래스인 object이 갖고있는 tostring을 오버라이딩한다
		int[] results= guguDan.numberCalc(su);
		String str = "";
		for(int i=0; i<results.length; i++) {
			str += su+ "*" + (i+1) + "=" + results[i] +"\n";
		}
		return "작성자: "+ name+ "\n" + su + "단 결과: " +"\n" + str;
	}
}
