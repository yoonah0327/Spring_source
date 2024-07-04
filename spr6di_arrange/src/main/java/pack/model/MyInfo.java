package pack.model;

public class MyInfo implements MyInfoInter { 
	//MyInfoInter타입의 파생(sub, child)클라스들중 하나로 MyInfo 작성.
	
	@Override
	public String myData() {
		
		return "취미는 축구";
	}
}
