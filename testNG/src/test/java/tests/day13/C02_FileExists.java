package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

@Test
public void test1(){
	System.out.println(System.getProperty("user.home"));
	
	//path of test folder on desktop
	//Users/mfyigit/Desktop/deneme
	
	String path = System.getProperty("user.home")+ "/Desktop/deneme/deneme.rtf";
	
	System.out.println(path);
	System.out.println(System.getProperty("user.dir")); //Gives the directory where our project is.
	
	//test that there is a file named test.rtf in the test folder on the desktop
	//First, the necessary dynamic path must be created to access this file.
	String filePath = System.getProperty("user.home")+ "/Desktop/deneme/deneme.rtf";
	System.out.println(Files.exists(Paths.get(filePath)));
	
	//test we have pom.xml in our project
	//    /Users/mfyigit/Documents/JAVA/Selenium4/testNG/pom.xml
	String pomPath=System.getProperty("user.dir") +"/pom.xml";
	
	Assert.assertTrue(Files.exists(Paths.get(pomPath)));
	//System.out.println(Files.exists(Paths.get(pomPath)));
	
}
}
