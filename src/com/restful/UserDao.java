package com.restful;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
   public List<User> getAllUsers(){
	   
	   List<User> userList = null;
	   try {
		   File file = new File("f:\\Users.dat");
		   System.out.println(file.exists());
		   if(!file.exists()) {
			   User user = new User(1, "Zhou Yutong", "Teacher");
			   userList = new ArrayList<User>();
			   userList.add(user);
			   try {
				   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				   oos.writeObject(userList);
				   oos.close();
			   }catch(FileNotFoundException e) {
				   e.printStackTrace();
			   }catch(IOException e) {
				   e.printStackTrace();
			   }

			   		   
		   }else {
			   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		       userList = (List<User>)ois.readObject();
			   ois.close();
		   }
		   
	   }
	   catch(IOException e) {
		   e.printStackTrace();
		   
	   }catch(ClassNotFoundException e) {
		   e.printStackTrace();
	   }
	   
	   return userList;
   }
	
}
