package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class C04_SingletonPattern {

@Test
public void test01(){
	//singleton pattern, bir class'dan birden fazla obje üretilmesine izin vermeyen bir pattern olarak kabul görmüştür
	//driver class'ını driver üretmek üzere kullanıyoruz
	//ancak driver class'ında driver siminde bir instance var,able da var
	//ve biz obje üreterek bu instance driver'a ulaşabiliriz.
	
	// Driver driver = new Driver();
	// Driver driver2 = new Driver();
	// Driver driver3 = new Driver();
	
	//singleton patternda amaç obje oluşturulmamasını sağlamaktır
	
}
}
