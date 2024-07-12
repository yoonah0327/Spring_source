package pack;

import org.springframework.stereotype.Repository;

@Repository
public class DataDaoImpl implements DataDao{
	@Override
	public void selectData() {
		System.out.println("~ db 연동후 자료읽기 처리 ~");
		
	}
}
