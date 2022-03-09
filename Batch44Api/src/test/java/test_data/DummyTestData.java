package test_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {
/*
http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
14. Çalışan isminin "Haley Kennedy" olduğunu,
Çalışan sayısının 24 olduğunu,
Sondan 3. çalışanın maaşının 675000 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi

{
        "id": 10,
        "employee_name": "Sonya Frost",
        "employee_salary": 103600,
        "employee_age": 23,
        "profile_image": ""
 }

  olduğunu test edin.
*/
public HashMap<String, Object>setUpTestData(){
	//40,21 ve 19 yaslarında çalışanlar olup olmadığını test etmek için list oluşturduk
	List<Integer> yaslar = new ArrayList<>();
	yaslar.add(40);
	yaslar.add(21);
	yaslar.add(19);
	
	//10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi olup olmadığını test etmek için hashmap oluşturduk
	//
	//{
	//        "id": 10,
	//        "employee_name": "Sonya Frost",
	//        "employee_salary": 103600,
	//        "employee_age": 23,
	//        "profile_image": ""
	// }
	
	HashMap<String, Object>onuncuCalisan=new HashMap<>();
	onuncuCalisan.put("id",10);
	onuncuCalisan.put("employee_name","Sonya Frost");
	onuncuCalisan.put("employee_salary",103600);
	onuncuCalisan.put("employee_age",23);
	onuncuCalisan.put("profile_image","");
	
	//Status kodun 200 olduğunu,
	//14. Çalışan isminin "Haley Kennedy" olduğunu,
	//Çalışan sayısının 24 olduğunu,
	//Sondan 3. çalışanın maaşının 675000 olduğunu test etmek için aşağıdaki hashmap'i oluşturduk
	
	HashMap<String , Object>expectedData = new HashMap<>();
	expectedData.put("statusCode",200);
	expectedData.put("ondorduncuCalisan","Haley Kennedy");
	expectedData.put("calisanSayisi",24);
	expectedData.put("sondanUcuncuCalisanMaasi",675000);
	expectedData.put("arananYaslar",yaslar);
	expectedData.put("onuncuCalisan",onuncuCalisan);
	
	return expectedData;
	
}
}
