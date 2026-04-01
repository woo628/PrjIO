package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipCode {

	public static void main(String[] args) throws IOException {
		String path = "D:/dev/java/PrjIO/src/ex04/";
		
		String filename = "zipcode_20130201(1).csv";
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 자료 입력");
		String line = "";
		br.readLine();
		String input = sc.nextLine();
		
		
		while ((line=br.readLine()) != null) {
			String [] li = line.trim().split(",");
			String ZIPCODE = li[0].trim();
			String SIDO = li[1].trim();
			String GUGUN = li[2].trim();
			String DONG = li[3].trim();
			String BUNGI = li[4].trim();
			int SEQ = Integer.parseInt(li[5].trim());
			
			if (line.contains(input)) {
				String fmt = "%s %s %s %s %s %d \n";
				String msg = String.format(fmt, ZIPCODE,SIDO,GUGUN,DONG,BUNGI,SEQ);
				System.out.print(msg);				
			}
		}
			
		
		br.close();
		fr.close();
	}

}
