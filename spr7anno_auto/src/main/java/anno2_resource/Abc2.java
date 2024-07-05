package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa") //객체변수이름 aaa로
public class Abc2 { //pojo
	private int nai;
	
	public int getNai() {
		return nai;
	}
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	
	
}
