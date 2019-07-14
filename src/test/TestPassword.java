package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class TestPassword {
	//测试:字符串加密处理
	public static void testPassword(){
		String password = "admin";
		//加盐处理
		password += "你喜欢编程吗?";
		//得到密码的消息摘要
		String str = DigestUtils.md5Hex(password);
		System.out.println(str);
	}
	
	//测试:文件内容是否相同
	public void testInput() throws IOException{
		//获取文件的输入流对象
				InputStream input1
				    = new FileInputStream("pom.xml");
				InputStream input2
			        = new FileInputStream("pom2.xml");
				
				//返回文件的消息摘要
				String str1 = DigestUtils.md5Hex(input1);
				String str2 = DigestUtils.md5Hex(input2);
		        System.out.println(str1);
		        System.out.println(str2);
		        
	}
	public static void main(String[] args) throws IOException {
		testPassword();
        
	}

}
