package get_http_request;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest09  extends DummyBaseUrl {
/*
http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/

@Test
public void test01(){

spec02.pathParams("p1","api","p2","v1","p3","employee","p4","12");
Response response = given().spec(spec02).when().get("/{p1}/{p2}/{p3}/{p4}");
response.prettyPrint();

//matchers
response.then().assertThat().body("data.employee_name", equalTo("Quinn Flynn"),
		"data.employee_salary", equalTo(342000),
		"data.employee_age", equalTo(22));

//jsonpath
	JsonPath json = response.jsonPath();
	System.out.println("name is "+json.getString("data.employee_name"));
	System.out.println("salary is " + json.getInt("data.employee_salary"));
	System.out.println("employee age is " + json.getInt("data.employee_age"));
	
	
}
}
