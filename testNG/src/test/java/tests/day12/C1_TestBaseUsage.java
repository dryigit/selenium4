package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Allerts;

public class C1_TestBaseUsage {
@Test
public void test01(){
	
	//projeniz içerisindeki herhangi bir class'dan obje oluşturabilir ve o obje sayesinde ait olduğu class'daki
	//tüm veriable ve methodlara
	//(access modifies izin verdiği sürece)ulaşabilirim.
	C01_Allerts obj= new C01_Allerts();
	
	//eğer proje kapsamında bir class'dan obje oluşturulmasını engellemek istiyorsanız
	//1- o class'ın constructor'ını private yapabiliriz
	//2- class'ın kendisini abstract yapabiliriz.
	// birinci method çok tercih edilmez çünkü oop consetp'e uymaz. çok sınırlı sayıda kullanımı vardır.
	// ikinci method'u kullanabiliriz. Böylece o class'daki abstract olayan (concrete) methodları override etmek
	//mecburiyeti olmadan kullanabiliriz.
	//ama obje oluşturamayız.
	
	//örneğin biz test base class'ını abstract yaptığımızdan, obje oluşturamayız.
	//ama child class'lardan test base'deki setup ve teardown methodlarını kulalnabilirz
	
	
}
}
