package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.Bean;
import com.klu.CRUD.DAO;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException,SQLException {
	  Scanner sc=new Scanner(System.in);
	  Bean b=new Bean();
	  DAO d=new DAO();
	  while(true) {
	  System.out.println("1.insert");
	  System.out.println("2.display");
	  System.out.println("3.totalcost");
	  System.out.println("enter your option");
	  int option=sc.nextInt();
	  switch (option){
	  case 1:
	  
	  try {
		  int i = 0;
		     
			  System.out.println("enter values to be inserted");
			  System.out.println("enter itemid");
			  int id=sc.nextInt();
			  System.out.println("enter itemname");
			  String name=sc.next();
			  System.out.println("enter itemcost");
			  int cost=sc.nextInt();
			  b.setItemid(id);
			  b.setItemname(name);
			  b.setCostofitems(cost);
			  i=d.Insert(b);
		  
	  
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
	  case 2:
		  
			  d.Display(b);
	          break;
	  case 3:
		  d.totalSum();
		  break;
	  }
 }
}
}
