package csvfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

public class newtask {
	@Test
	public void m1() throws IOException {   try
	          {
	                File status = new File("C:\\Users\\user\\project\\firstcsv\\k.csv");
	               if (status.delete())
	               {
	                    System.out.println("File deleted successfully");
	               }
	               else {
	            		  BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\user\\project\\firstcsv\\k.csv"));
	            	      String str;
	            	      while ((str = bufferedReader.readLine()) != null)
	            	      {
	            	           System.out.println(str);
	            	      }
	            	      bufferedReader.close();
	               }
 }
 catch (IOException ioe)
 {
      System.out.println("File not found");
     ioe.printStackTrace();
 }
	 
	          CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\user\\project\\firstcsv\\k.csv"));
	          String line1[] = {"indexno","userid","firstname","lastname","username","password", "emailid"};
	          writer.writeNext(line1);
	          writer.flush();
	      	System.out.println("Created");
	      	System.out.println("Enter the number of rows you want to enter");
	      	Scanner sc = new Scanner(System.in);
	      	int n = sc.nextInt();
	      	Faker faker = new Faker();

	      	for(int i=1;i<=n;i++) {
	      		
	      		String str1 = passwordgenerator();
	      		
	      		String indexno=indexno();
	      		
	      		String firstName = faker.name().firstName();
	      		String userid = firstName.concat(indexno);
	      		String lastName = faker.name().lastName();
	      		String str3=firstName.concat(".");
	      		String username=str3.concat(lastName);
	      		String emailid = username.concat("@gmail.com");
	      		String line2[]= {indexno,userid,firstName,lastName,username,str1,emailid};
	      		 writer.writeNext(line2);
	      		
	      	}
	      	 writer.flush();
}
	 
	  public static String passwordgenerator() {
			String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"
	                + "abcdefghijklmnopqrstuvxyz" + "@#";
			
			Random rand = new Random();
			HashSet<String> identifiers = new HashSet<String>();

		      
		    StringBuilder builder = new StringBuilder();
		    while(builder.toString().length() == 0) {
		    	   int length = rand.nextInt(5)+5;
		        for(int i = 0; i < length; i++) {
		            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
		        }
		        if(identifiers.contains(builder.toString())) {
		            builder = new StringBuilder();
		        }
		    }
		    return builder.toString();
		}
	  public static String indexno() {
			String lexicon="123456789";
			
			Random rand = new Random();
			HashSet<String> identifiers = new HashSet<String>();

		      
		    StringBuilder builder = new StringBuilder();
		  
		    while(builder.toString().length() == 0) {
		    	   int length = rand.nextInt(1)+2;
		        for(int i = 0; i < length; i++) {
		            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
		        }
		        if(identifiers.contains(builder.toString())) {
		            builder = new StringBuilder();
		        }}
		    // System.out.println(length);
		    	   return builder.toString();
		      }
}