package get_http_request.Day09;

import base_url.JasonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTesData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetRequest21TestData extends JasonPlaceHolder {
/*
https://jsonplaceholder.typicode.com/todos/2
1) Status kodunun 200,
2) respose body'de,
         "completed": değerinin false
         "title": değerinin "quis ut nam facilis et officia qui"
         "userId" sinin 1 ve
    header değerlerinden
         "via" değerinin "1.1 vegur" ve
         "Server" değerinin "cloudflare" olduğunu test edin…
*/

@Test
public void test21(){
	// 1) URL OLUŞTURMA
	spec04.pathParams("1","todos","2",2);
	
	//2) EXPECTED DATA OLUŞTURMAK
	JsonPlaceHolderTesData expectedDataObject = new JsonPlaceHolderTesData();
	HashMap<String, Object>expectedData = (HashMap<String, Object>) expectedDataObject.setUpTestData();
	System.out.println("TEST DATANIN İÇİNDEKİ EXPECTED DATA" + expectedData);
	
	//3)  REQUEST RESPONSE
	Response response =given().spec(spec04).when().get("/{1}/{2}");
	response.prettyPrint();
	
	//DOĞRULAMA
	
	//1. YOL MATCHERS CLASS
	response.then().assertThat().statusCode((Integer)expectedData.get("statusCode"))
			.headers("via", Matchers.equalTo(expectedData.get("via")),
					"Server",Matchers.equalTo(expectedData.get("Server")))
			.body("userId", Matchers.equalTo(expectedData.get("userId"))
					,"title",Matchers.equalTo(expectedData.get("title"))
					,"completed",Matchers.equalTo(expectedData.get("completed")));
	//2. yol JSON PATH
	JsonPath json = response.jsonPath();
	Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
	Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
	Assert.assertEquals(expectedData.get("Server"), response.getHeader("Server"));
	Assert.assertEquals(expectedData.get("userId"), json.getInt("userId"));
	Assert.assertEquals(expectedData.get("title"), json.getString("title"));
	Assert.assertEquals(expectedData.get("completed"), json.getBoolean("completed"));
	
	
	
	
	//3. yol DE-SERIALIZATION
	
	HashMap<String, Object> actualData = response.as(HashMap.class);
	System.out.println(actualData);
	Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
	Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
	Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));
	
	
}

}
