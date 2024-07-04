package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter{
	//MessageInter타입의 파생클래스들 중 하나로 MessageImpl 작성.
	//constructor injection 
	private String message1, message2; //constructor injection 
	private int year;
	private MyInfoInter infoInter; //다형성: 자식의 메소드를 부모가 불러쓸수있다.
	
	//setter injection
	private String spec;
	private OutFileInter fileInter;
	
	//construction injection 연습
	public MessageImpl(String message1, String message2, int year, MyInfoInter infoInter) { //constructor injection 
		this.message1 = message1; //안녕안녕
		this.message2= message2; //잘가잘가
		this.year= year;
		this.infoInter = infoInter; 
	}
	
	//setter injection 연습
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	//출력연습
	@Override
	public void sayHi() {
		String msg = "MessageImpl 클래스에서 sayHi 내용: ";
		msg += "\n" + message1 + " "+ message2;
		msg += "\n" + (year+2000)+ "년";
		msg += "\n" + infoInter.myData() ; //다형성. 
		
		msg += "\n" + spec;
		
		System.out.println(msg); //console출력
		
		//위 msg를 파일로 출력하기
		fileInter.outFile(msg);
	}
}
