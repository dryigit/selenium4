package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTesData {
public Map<String, Object> setUpTestData(){
	
	HashMap<String, Object> expectedData = new HashMap<>();
	expectedData.put("statusCode",200);
	expectedData.put("completed",false);
	expectedData.put("title", "quis ut nam facilis et officia qui");
	expectedData.put("userId",1);
	expectedData.put("via","1.1 vegur");
	expectedData.put("Server","cloudflare");
	System.out.println(expectedData);
	
	
	return expectedData;
}
}
