package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Zipcode08 {

	public static void main(String[] args) throws IOException {

		String path = Zipcode08.class.getResource("").getPath();
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
		List<String> cities = Arrays.asList("서울","부산","대구","인천","광주","대전"
				,"울산","세종","강원","경기","경남","경북","전남","전북","제주","충남","충북");
		
		for (String s : cities) {
			
		
		String file2 = s + ".csv";
		FileWriter fw = new FileWriter(path2 + file2);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
//		================================================================
		String line = "";
		String prevSido = "";
		
		String title = s;
		bw.write(title);
		
		
		while ((line = br.readLine())!= null) {
			PostVo vo = new PostVo(line);
			String zipcode = vo.getZipcode();
			String sido = vo.getSido();
			String gugun = vo.getGugun();
			String dong = vo.getDong();
			String bunji = vo.getBunji();
			int seq = vo.getSeq();
			
			if (!sido.equals(prevSido)) {
				prevSido = sido;
				String msg = String.format("\n"+zipcode,sido,gugun,dong,bunji,seq);	
				bw.write(msg); 			
			} 
			
		}
	
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
		}
	}

}
