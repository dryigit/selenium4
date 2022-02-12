package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="stepdefinitions",
		tags="@hero",
		dryRun=false
)

public class Runner {
//Runne class'ının body'sine hiçbir kod yazmıyoruz.
//bu class için önemli olan kullanacağımız iki adet notasyon.

//dryRun false yazıldığında belirlenen tag ile etiketlenen senaryoları sırasıyla çalıştırır
//dryRun true yazılırsa kodları çalıştırmadan eksik stepler olup olmadığını kontrol ede
//ve varsa bize eksikleri rapor eder.

//features ve glue olarak specific bir class veya feature dosyasını değil
//tüm klasör ve package'ı seçtik. Dolayısıyla step definitions package'ı içerisinde hangi class'da olursa olsun
//işimize yarayan bir step definition varsa rahatlıkla kullanabiliriz.

}
