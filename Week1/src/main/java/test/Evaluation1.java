package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evaluation1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("My name is Ka Hang Chan");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
	}

}
