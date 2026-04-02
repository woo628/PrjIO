package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode03 {

	public static void main(String[] args) throws IOException {

		String path = Zipcode03.class.getResource("").getPath();
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
		int cnt = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		while ((line = br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bungi = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
			if (sido.contains("부산")) {
				cnt++;}
			if (sido.contains("대구")) {
				cnt1++;}
			if (sido.contains("울산")) {
				cnt2++;}
		}
		System.out.println("부산:" + cnt);
		System.out.println("대구:" + cnt1);
		System.out.println("울산:" + cnt2);
		
		
		br.close();
		fr.close();
	}

}
