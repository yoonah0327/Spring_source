package pack;

public class MessageImpl implements MessageInter{
	// 핵심 로직 클래스: target
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHi() {
		System.out.println("안녕 "+name+ "님! BusinessLogic 수행" );
		// 현재 메소드 처리시간이 길다고 가정하고 인위적으로 지연시간부여
		int t=0;
		while(t<5) {
			try {
				Thread.sleep(1000);
				System.out.println("🎶");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("sayHi 처리완료😎😎");
		
	}

}
