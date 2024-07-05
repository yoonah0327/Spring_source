package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank; 
	
	@Autowired(required=false)//type으로 연결
	//있으면 사용 없으면 사용안하겠다. true일때 없으면 에러떨어짐. 
	private SinhanBank sinhanBank;
	
	@Resource(name="hanaBank") //name으로 연결
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank = sinhanBank;
		}else if(sel.equals("hana")) {
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}
	
	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct //생성자 처리 후 자동호출: 초기화 작업가능
	public void abc() {
		msg = "계좌 잔고: ";
	}
	
	@PreDestroy //웹서비스 종료직전 자동호출: 마무리 작업 가능
	public void def() {
		if(sinhanBank != null) sinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		//System.out.println("계좌잔고: "+bank.getMoeny());
		System.out.println(msg+ bank.getMoney());
	}
	
	
}
