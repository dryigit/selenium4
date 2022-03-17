package get_http_request.day07;

import base_url.JasonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JasonPlaceHolder {
/*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

@Test
public void test16(){
	//URL Oluşturma
	spec04.pathParams("bir", "todos","iki",7);
	//Expected data oluşturma
	
	Map<String, Object>expectedData = new HashMap<>();
	expectedData.put("user_id",1);
	expectedData.put("id",7);
	expectedData.put("title","illo expedita consequatur quia in");
	expectedData.put("completed",false);
	System.out.println("Expected Data " + expectedData);
	
	// request ve response
	
	Response response= given().spec(spec04).when().get("/{bir}/{iki}");
	//response.prettyPrint();
	
	
	//datayı json'dan java'ya dönüştürmeye    :de-serialization
	//datayı java'dan json'ya dönüştürmeye  :Serialization
	
	Map<String, Object>actualData=response.as(HashMap.class); //de-serialization
	System.out.println("Actual Data " + actualData);
	
	Assert.assertEquals(expectedData.get("user_Id"), actualData.get("user_Id"));
	Assert.assertEquals(expectedData.get("id"),actualData.get("id"));;
	Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
	Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));
	
	
}

}
