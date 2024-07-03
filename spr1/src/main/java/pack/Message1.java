package pack;

public class Message1 implements MessageInter {
	@Override
	public void sayHello(String name) {
		System.out.println("하이하이~" + name+ "님!");

	}
}
