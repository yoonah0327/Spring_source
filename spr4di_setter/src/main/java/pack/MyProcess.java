package pack;

public class MyProcess { //DI 중 setter injection사용
	//extends상속 지양. 
	private int nai; //기본형
	private String name;
	private ShowData showData; //참조형. ShowData타입의 showData객체 생성. 클래스의 포함관계.
	
	public MyProcess() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNn(int nai) {
		this.nai = nai;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 "+name+"나이는 "+nai+
				"별명은 "+showData.processNickName()+"취미는 "+showData.processHobby());
	}
}
