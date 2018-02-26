package io.silsub1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyNote {
	Scanner sc = new Scanner(System.in);

	public MyNote() {
	}

	public void fileSave() { // 저장용 메소드
		System.out.print("파일에 저장할 내용을 입력하시오 : ");

		StringBuilder stb = new StringBuilder();

		while (true) { // 파일의 내용을 입력 받는 구문
			String str = sc.next();

			if (str.equals("exit"))
				break;

			stb.append(str + "\n");
		}

		System.out.print("내용을 저장 하시겠습니까?(Y/N) : ");
		if (sc.next().toUpperCase().charAt(0) == 'Y') {
			System.out.print("저장할 파일 명 :");
			String fileName = sc.next();

			try (FileWriter fw = new FileWriter(fileName);) {

				fw.write(stb.toString());

				System.out.println(fileName + "에 성공적으로 저장 되었습니다.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void fileOpen() { // 불러오기 메소드
		System.out.print("open 할 파일 명 :");
		String fileName = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			while (true) {
				String str = br.readLine();

				if (str == null) {
					break;
				} else {
					System.out.println(str);
				}
			}
			System.out.println(fileName + "의 내용을 정상적으로 읽어 왔습니다. ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileEdit() { // 수정용 메소드
		// 읽어와서 수정하고 다시 저장하는 메소드
		StringBuilder stb = new StringBuilder();
		System.out.print("수정할 파일 명 : ");
		String fileName = sc.next();

		// 1.파일의 정보를 읽어와야 함

		try (BufferedReader br = new BufferedReader(new FileReader(fileName));
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))) {

			while (true) {

				String str = br.readLine();

				if (str == null)
					break;
				System.out.println(str);
			}
			
			// 2.읽어온 정보에 추가할 내용을 기입
			System.out.println("수정할 파일의 내용을 입력하세요.");

			while (true) {
				String content = sc.next();

				if (content.equals("exit")) {
					break;
				}
				stb.append(content+ "\n");
			}

			System.out.print("변경할 내용을 파일을 추가하시겠습니까? (Y/N) : ");
			if (sc.next().toUpperCase().charAt(0) == 'Y') {
				System.out.println("변경할 정보를 저장합니다.");

				bw.write(stb.toString());
				System.out.println("변경한 정보를 저장했습니다.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		

		// 3.추가한 뒤에 다시 저장

	}
}
