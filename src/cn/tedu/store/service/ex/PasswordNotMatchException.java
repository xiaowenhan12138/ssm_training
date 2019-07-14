package cn.tedu.store.service.ex;

import java.io.Serializable;

public class PasswordNotMatchException 
	extends RuntimeException implements Serializable{
	public PasswordNotMatchException(){
		
	}
	public PasswordNotMatchException(String message){
		super(message);
	}
}
