package tests.day08;

import org.testng.annotations.Test;

public class C01_Notations {

@Test (priority =9)
public void youtubeTest(){
	System.out.println("Youtxube test started");
}
@Test (priority =0)
public void amazonTest(){  //if priority is not assigned, priority=0 is default.
	System.out.println("Amazon test started");
}
@Test(priority =5)
public void bestBuyTest(){
	System.out.println("Bestbuy test started");
}

}
