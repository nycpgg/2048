package io.silsub3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BookManager {
	Scanner sc = new Scanner(System.in);

	public BookManager() {
	}

	public void fileSave() {
		Book[] bookArr = { 
				new Book("자바", "나예찬", 20000, null, 0.1), new Book("난 자바가", "이성환", 16000, null, 0.1),
				new Book("열혈강의", "허수정", 17000, null, 0.1), new Book("자바의 정석", "최지호", 22000, null, 0.1),
				new Book("자바라", "최희준", 18000, null, 0.1), };

		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Book.dat"));) {

			for (Book b : bookArr) {
				obj.writeObject(b);
			}

			obj.flush();

			System.out.println("books.dat 에 저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead(){
		Book[] bookArr= new Book[10];
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book.dat"));){
			
			for(int i =0;i<bookArr.length;i++){
				bookArr[i]=(Book)ois.readObject();
			}
			
			for(Book b : bookArr){
				System.out.println(b);
			}
			
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	

}
