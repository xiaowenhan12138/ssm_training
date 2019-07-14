package cn.tedu.store.service.ex;

import java.io.Serializable;

public class UserNotFoundException 
	extends RuntimeException implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(){
		
	}
	public UserNotFoundException(String message){
		super(message);
	}
}
