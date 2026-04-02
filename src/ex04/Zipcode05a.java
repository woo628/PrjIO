package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zipcode05a {

	public static void main(String[] args) throws IOException {
	
		String path = Zipcode05a.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 skip
		String line = "";
		
		Set<String> checkSet = new HashSet<>();
		while ((line = br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bungi = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
			if (checkSet.add(sido)) {
				System.out.println(sido);
			}
			
		}
	
		
		
		br.close();
		fr.close();
	}

}
