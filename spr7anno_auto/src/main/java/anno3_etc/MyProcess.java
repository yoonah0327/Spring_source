package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {//@value변수의 값을 초기화하기 위해 사용할수도있다. 
	//Spring EL표현식. #{} 만들어진 component 객체를 이용. private은 getter를 
	@Value("#{dataInfo.name}")// {객체.멤버}
	private String name;
	
	private String part;
	
	@Autowired
	//public MyProcess(@Value("영업부") String part) { //생성자를 통해 영업부가 들어감.
	public MyProcess(@Value("#{dataInfo.part}") String part) { // @Value("#{dataInfo.part}통해 전산부가 들어옴. 
		this.part = part;
	} //그러나 xml이 우선순위임. 그러므로 xml에서 넣어준 값인 판매부가 출력된다.
	
	
	@Value("123")//""안적으면 typemispatch. 기본이 string type. "123"이렇게 넣으면 자동int로 전환. 
	private int age;
	
	@Value("1,2,3,4")
	private int arr[];
	
	
	public void showData() {
		System.out.println("name: "+ name);
		System.out.println("part: "+part);
		System.out.println("age: "+age);
		System.out.println(arr[0]+ " "+ arr[3]);
	}
}
