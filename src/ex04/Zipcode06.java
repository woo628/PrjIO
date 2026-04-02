package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode06 {

	public static void main(String[] args) throws IOException {

		String path = Zipcode06.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File file = new File(path + fname);
		if (!file.exists()) {
			System.out.println(file + " 이 없습니다");
			System.exit(-1); // 프로그램 강제 종료
		}
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
// 		================================================================
		
		br.readLine(); // 제목줄 skip
		String line = "";
		
	
		while ((line = br.readLine())!= null) {
			PostVo vo = new PostVo(line);
			String dong = vo.getDong();
			if (dong.contains("부전2동")) {
				System.out.println("부전2동의 우편주소: " +vo.getZipcode());
			}
		}
	
		
		br.close();
		fr.close();
	}

}
