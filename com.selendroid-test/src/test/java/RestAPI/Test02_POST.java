package RestAPI;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Test02_POST {
    
    @Test
    public void test1_post() {
    	
		//    	  Map<String, Object> map = new HashMap<String, Object>();
		//    	  map.put("name", "Bton");
		//    	  map.put("job", "Teacher");
		//    	  
		//    	  System.out.println(map);
    	  
        
          JSONObject request = new JSONObject();
          request.put("name", "Bryant");
          request.put("Job", "BA");
	      System.out.println(request);
	      System.out.println(request.toJSONString());

 
    	  
    	  given().
            contentType(ContentType.JSON).
    	  	body(request.toJSONString()).
    	  when().
    	  	 post("https://reqres.in/api/users").
    	  then().
    	     statusCode(201).log().all();
	  
	               
        
    }
    
}