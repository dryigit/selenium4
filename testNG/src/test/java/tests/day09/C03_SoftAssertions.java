package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertions {

@Test
public void test(){
	int a=10;
	int b=20;
	int c=30;
	
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(a,b,"1st test failed");//failed
	softAssert.assertTrue(a>b,"2. test failed");//failed
	softAssert.assertTrue(a<c,"3. test failed");//passed
	softAssert.assertTrue(c>b, "4. test failed");//passed
	softAssert.assertTrue(c<a,"5. test failed");//failed
	
	//assertAll demezsek class çalışır ve passed yazar çünkü raporlama yapmaz sadece kodlar çalışır.
	
	softAssert.assertAll();
	System.out.println("eğer soft assertlardan fail olan varsa bu assert çalışmaz");
	// assertAll demezsek class calisir ve passed yazar , cunku aslinda raporlama yapmaz sadece kodlar calismis olur
	softAssert.assertAll();
	System.out.println("eger softassert'lerden fail olan varsa bu satir calismaz");
}

}
