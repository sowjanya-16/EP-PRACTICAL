package com.klu.main;

import java.sql.SQLException;

import com.klu.Bean.StudentBean;
import com.klu.insert.StudentInsertion;

public class Studentmain {
  public static void main(String[] args) throws ClassNotFoundException,SQLException {
	  StudentBean sb=new StudentBean();
	  sb.setRegno(1193);
	  sb.setName("Sowjanya");
	  sb.setEmail("nvs@gmail.com");
	  StudentInsertion si=new StudentInsertion();
	  try {
	  int i=si.StudentInsert(sb);
	  if(i>0)
	  {
		  System.out.println("insertion is successful");
	  }
	  else
	  {
		  System.out.println("insertion is fail");
	  }
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
  }
}

