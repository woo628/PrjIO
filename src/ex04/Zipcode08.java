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
            System.exit(-1);
        }

        // 1. 전체 데이터를 List에 담기 (한 번만 읽기)
        List<String> allLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
     
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            allLines.add(line);
        }
        br.close(); // 다 읽었으니 닫기

        // 2. 분류할 시도 리스트
        List<String> cities = Arrays.asList("서울","부산","대구","인천","광주","대전"
                ,"울산","세종","강원","경기","경남","경북","전남","전북","제주","충남","충북");

        // 3. 시도 리스트를 돌면서 파일 만들기
        for (String s : cities) {
            String file2 = s + ".csv";
            BufferedWriter bw = new BufferedWriter(new FileWriter(path2 + file2));

            for (String row : allLines) {
                PostVo vo = new PostVo(row);
                
                // 현재 도시(s)와 데이터의 시도명이 같으면 파일에 쓰기
                if (vo.getSido().equals(s)) {
                    bw.write(row);
                    bw.newLine(); // 줄바꿈
                }
            }
            
            bw.close(); // 각 도시 파일 작성이 끝나면 닫기
            System.out.println(s + ".csv 저장 완료!");
        }
    }
}
	


