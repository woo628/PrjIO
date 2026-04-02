package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode01 {

	public static void main(String[] args) throws IOException {
		// 1. 전국의 롯데백화점의 갯수 출력
		String path = Zipcode01.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 skip
		String line = "";
		int cnt = 0;
		while ((line = br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bungi = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
//			if (dong.contains("롯데백화점")) {
			if (dong.indexOf("현대백화점") > -1) {
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
