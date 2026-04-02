package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode02 {

	public static void main(String[] args) throws IOException {
//		2. (읍면동 건물명:
		Scanner sc = new Scanner(System.in);		
		
//		file
		String path = Zipcode02.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 skip
		String line = "";
		int cnt = 0;
		System.out.println("읍면동 건물명:");
		String inAddr = sc.nextLine();
		
		while ((line = br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bungi = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
//			if (dong.contains("롯데백화점")) {
			if (dong.indexOf(inAddr) > -1) {
				String fmt = "[%s] %s %s %s %s %d \n";
				String addr = String.format(fmt,zipcode,sido,gugun,dong,bungi,seq);
				System.out.print(addr);
				cnt++;
			}
		}
		System.out.print(cnt + " 건");
		
		
		br.close();
		fr.close();
	}

}
