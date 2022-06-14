package RestAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_GET {
	@Test
    void test01() {
        
        
    Response response = RestAssured.get("https://reqres.in/api/users?page=2");
    System.out.println(response.getBody().asString());
    System.out.println(response.asString());
    System.out.println(response.getStatusCode());
    System.out.println(response.getHeader("content-type"));
    System.out.println(response.getTime());
    
    // Validate status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200);
	}
    
    
    @Test
    void test02() {
        given()
        .get("https://reqres.in/api/users?page=2")
          .then()
            .statusCode(200).body("data[3].first_name", equalTo("Byron"));
    }
}
