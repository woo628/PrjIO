package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode07 {

	public static void main(String[] args) throws IOException {

		String path = Zipcode07.class.getResource("").getPath();
		String path2 = "D:/dev/java/PrjIO/src/ex04/";
		String fname = "zipcode_utf8.csv";
		
		File file = new File(path + fname);
		if (!file.exists()) {
			System.out.println(file + " 이 없습니다");
			System.exit(-1); // 프로그램 강제 종료
		}
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
// 		================================================================
		String file2 = "zipcode_utf8(부산진구).csv";
		FileWriter fw = new FileWriter(path2 + file2);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
//		================================================================
		br.readLine(); // 제목줄 skip
		String line = "";
		
		String title = "부산 진구의 우편번호";
		bw.write(title);
		
		while ((line = br.readLine())!= null) {
			PostVo vo = new PostVo(line);
			String gugun = vo.getGugun();
			String sido = vo.getSido();
			String zipcode = vo.getZipcode();
			
			if (sido.contains("부산") && gugun.contains("진구")) {
				
				
				String msg = String.format("\n"+zipcode);	
				bw.write(msg); 			
			} 
			
		}
	
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
	}

}
