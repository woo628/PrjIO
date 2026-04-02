package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode04 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 시도를 입력하세요(부산,대구,경남)");
		String sidos = sc.nextLine();
		String [] sis =  sidos.trim().split(",");
		String [] sidoList = new String[sis.length];
		int [] cnt = new int[sis.length];
		for (int i = 0; i < sidoList.length; i++) {
			sidoList[i] = sis[i].trim();			
			cnt[i] = 0;
		}
		
//		=============================================================
		String path = Zipcode04.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File file = new File(path + fname);
		if (!file.exists()) {
			System.out.println(file + " 이 없습니다");
			System.exit(-1); // 프로그램 강제 종료
		}
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
//		=============================================================
		
		br.readLine(); // 제목줄 skip
		String line = "";
		while ((line = br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bungi = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
			for (int i = 0; i < sis.length; i++) {
				if (sido.equals(sis[i])) {
					cnt[i]++;
				}
			}
		}
		for (int i = 0; i < sis.length; i++) {
			System.out.println(sis[i]+":"+cnt[i]);
		}
	
		
		
		br.close();
		fr.close();
	}

}
