package io.silsub1;

import java.util.Scanner;

public class MyNoteTest {

	public static void main(String[] args) {
		MyNote myM = new MyNote();
		Scanner sc = new Scanner(System.in);
		
		//수정
		System.out.println();
		do {
			System.out.println("=========My Note========");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("4. 끝내기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				myM.fileSave();
				break;
			case 2:
				myM.fileOpen();
				break;
			case 3:
				myM.fileEdit();
				break;
			case 4:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("번호를 다시 입력하세요");
				break;
			}

		} while (true);

	}

}
