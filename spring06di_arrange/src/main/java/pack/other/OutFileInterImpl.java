package pack.other;

import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter {
	private String filePath; // 출력 파일 경로
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		// 메시지를 파일로 출력
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(msg);
			fw.close();
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("outFile : " + e.getMessage());
		}
	}
}
