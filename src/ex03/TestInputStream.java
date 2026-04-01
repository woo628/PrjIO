package ex03;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream {

	public static void main(String[] args) throws IOException {
		// 현재경로
		String path = TestInputStream.class.getResource("").getPath();
		String inFile = path + "data2.dat";
		
		FileInputStream fis = new FileInputStream(inFile);
		
		int ch;
		while ((ch = fis.read()) != -1) { // EOF : End Of File(-1) 이 아닐 동안 반복
			System.out.print((char)ch);
		}
		
		
		fis.close();
	}

}
