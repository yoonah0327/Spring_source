package pack.other;

import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter{
	private String filePath; //출력파일 경로 기억
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		// 메시지를 파일로 출력
	try {
		FileWriter writer  = new FileWriter(filePath);
		writer.write(msg);
		writer.close();
		System.out.println("파일저장완료 확인멘트");
	} catch (Exception e) {
		System.out.println("outFile: "+e);
	}
		
	}

}
