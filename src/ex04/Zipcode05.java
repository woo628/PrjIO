package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Zipcode05 {

	public static void main(String[] args) throws IOException {
		String path = Zipcode05.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File inFile = new File(path + fname);
		if (!inFile.exists()) { // 파일이 존재하지 않을 경우
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
//		===========================================================
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String line = "";
		int totcnt = 0;
		
		long startTime = System.nanoTime();

//		HashSet = 무순 정렬					
//		TreeSet = 가나다라 정렬
		
		Set<String> set = new HashSet<>();
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			set.add(sido);
			totcnt++;
		}
		
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
//		============================================================
		br.close();
		fr.close();
		
		for (String sido : set) {
			System.out.println(sido);
		}
		System.out.println(set.size() + "건");
		
		System.out.println("전체 자료수:" + totcnt);
		System.out.printf("실행시간: %.2f s",execTime);
	}

}
