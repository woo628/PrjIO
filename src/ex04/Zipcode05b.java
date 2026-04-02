package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Zipcode05b {

	public static void main(String[] args) throws IOException {
		
		List<String> sidoList = new ArrayList<>();
		List<Integer> sidoCntList = new ArrayList<>();
		
		String path = Zipcode05b.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File inFile = new File(path + fname);
		if (!inFile.exists()) { // 파일이 존재하지 않을 경우
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
//		===========================================================
		br.readLine();
		String line = "";
		String prevSido = "";
		
		int sidoCnt = 0; // 시도별 주소수

		int pos = -1;	// 전체시도수 포지션
		
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			
			if (!sido.equals(prevSido)) {
				sidoList.add(sido);
				sidoCntList.add(1);
				prevSido = sido;
				pos++;
		
			} else {
				sidoCnt = sidoCntList.get(pos) + 1;				
				sidoCntList.set(pos, sidoCnt);
			}
		
		}
//		============================================================
		br.close();
		fr.close();
		
		for (int i = 0; i < sidoList.size(); i++) {
			System.out.println(sidoList.get(i) + "=" + sidoCntList.get(i));
		}
		System.out.println("도시수: " + (pos + 1));
	}

}
