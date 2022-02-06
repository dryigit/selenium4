package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class H01_Q1 {

@Test
public void test() throws InterruptedException {
	// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
	Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
	// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
	// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
	List<WebElement> allProducts=Driver.getDriver().findElements(By.xpath("//p[@class='shelf-item__title']"));
	int numOfProduct=0;
	for (WebElement product : allProducts) {
		numOfProduct++;
		System.out.println(numOfProduct+". product is " + product.getText());
	}
	// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
	List<String> allProductsarr=new ArrayList<String>();
	for (WebElement product : allProducts ) {
		allProductsarr.add(product.getText());
	}
	// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
	// (Her ürün 1 defadan fazla eklenemez!)
	System.out.println("=======================Task 4 =====================");
	Random randomProduct = new Random();
	List <WebElement> addedToCart=Driver.getDriver().findElements(By.xpath("//div[@class='shelf-item__thumb']"));
	int randomnum=5;
	for (int i=1; i<=randomnum; i++){
		WebElement addCartClick=addedToCart.get(randomProduct.nextInt(addedToCart.size()));
		addCartClick.click();
		WebElement closeSideBar=Driver.getDriver().findElement(By.xpath("//div[@class='float-cart__close-btn']"));
		closeSideBar.click();
		Thread.sleep(200);
		addedToCart.remove(addCartClick);
		System.out.println("The product "+allProducts.get(randomProduct.nextInt(addedToCart.size())).getText() + " is added to the cart.");
	}
	WebElement bagQuantity= Driver.getDriver().findElement(By.xpath("(//span[@class='bag__quantity'])[1]"));
	bagQuantity.click();
	System.out.println("=======================Task 5 =====================");
	// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
	int sayi=17;
	int urunNo=1;
	double total=0.00;
	DecimalFormat df = new DecimalFormat("###.##");
	for (int i = 17; i <=21; i++){
		WebElement priceForProduct=Driver.getDriver().findElement(By.xpath("(//div[@class='shelf-item__price'])["+ sayi +"]"));
		String firstprc= priceForProduct.getText().replaceAll("\\W", "");
		Double price=Double.parseDouble(firstprc)/100;
		System.out.println("Price for the " + urunNo + ". product on the website is: "+ df.format(price));
		sayi++;
		urunNo++;
		total+=price;
	}
	System.out.println();
	System.out.println("The total amount of the cart is "+ df.format(total) + " USD");
	System.out.println("=======================Task 6 =====================");
	// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
	WebElement actualTotalPriceElement=Driver.getDriver().findElement(By.xpath("//p[@class='sub-price__val']"));
	String actualTotal=actualTotalPriceElement.getText().replaceAll("\\W", "");
	Double actualPriceDouble=Double.parseDouble(actualTotal)/100;
	if(actualPriceDouble==total){
		System.out.println("Test Pass");
	}	Assert.assertEquals(actualPriceDouble, total);
	// 7.Checkout'a tıklayın
	WebElement checkout = Driver.getDriver().findElement(By.xpath("//div[text()='Checkout']"));
	checkout.click();
}
}


