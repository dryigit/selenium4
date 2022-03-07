package Day08;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest19 extends DummyBaseUrl {
/*
http://dummy.restapiexample.com/api/v1/employees
1) Status kodunun 200,
2) 10’dan büyük tüm id'leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,
3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu
4) Maası 350000 den büyük olan tüm employee name'leri ekrana yazdırın
     ve bunların içerisinde "Charde Marshall" olduğunu test edin
*/
@Test
public void test19(){
	//1- URL Oluşturma
spec02.pathParams("parametre1","api","parametre2","v1","parametre3","employees");
	Response response = given().spec(spec02).when().get("/{parametre1}/{parametre2}/{parametre3}");
	//response.prettyPrint();
	
	// 1) Status kodunun 200 olduğunu test et,
	Assert.assertEquals(200, response.statusCode());
	
	// 2) 10’dan büyük tüm id'leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu test edin,
	JsonPath json = response.jsonPath();
	List<Integer> idList= json.getList("data.findAll{it.id>10}.id");
	System.out.println(idList);
	//yukarıda kullandığımız it.id>10 groovy dili.
	//bu kısım if yerine kullanılarak id si 10 dan büyükleri bulmak için kullanıldı.
	//groovy ile loop kullanmadan response'dan gelen değerleri bir şarta göre yazdırabiliriz.
	
	//3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu test et
	
	List<Integer> age = json.getList("data.findAll{it.employee_age<30}.employee_age");
	System.out.println(age);
	Collections.sort(age);
	Assert.assertEquals(23, (int) age.get(age.size() - 1));
	//Assert.assertTrue(age.get(age.size()-1)==23);
	
	// 4) Maası 350000 den büyük olan tüm employee name'leri ekrana yazdırın
	// ve bunların içerisinde "Charde Marshall" olduğunu test edin
	
	List<Integer>salaryList=json.getList("data.findAll{it.employee_salary>350000}.employee_name");
	System.out.println(salaryList);
	
	Assert.assertTrue(salaryList.contains("Charde Marshall"));
	
}
}
