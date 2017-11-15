package com.ocr.exception;

import java.io.FileNotFoundException;
/**
 * Exception personnalis�e pour afficher une erreure qui n'en est pas.
 * @author John
 */
public class MyFileException extends FileNotFoundException {


	private static final long serialVersionUID = 1933180583148907879L;

	public MyFileException(){
		System.out.println("fichier pas l� !");
	}  
	
	public MyFileException(String msg){
		super(msg);
	}  
}
