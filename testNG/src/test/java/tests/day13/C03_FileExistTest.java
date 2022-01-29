package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistTest {
@Test
public void fileExisttest(){
	//test that our project has pom.xml
	String path = System.getProperty("user.dir") + "/pom.xml";
	Assert.assertTrue(Files.exists(Paths.get(path)));
}
}
