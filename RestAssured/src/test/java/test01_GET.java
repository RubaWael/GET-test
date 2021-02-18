import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
public class test01_GET {

	@Test
	void test1(){
		Response response = get("http://192.168.200.91:8080/demo-server/employee-module/ruba");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
	}
	
	@Test
	void test2() {
		given().get("http://192.168.200.91:8080/demo-server/employee-module/ruba").then().statusCode(200)
		.body("maxSalary",equalTo(10000))
		.body("totalSalaries",equalTo(15000))
		.body("employeeCount",equalTo(2))
		.body("minSalary",equalTo(5000))
		
		.body("items.firstName",hasItems("Blaise", "John"))
		.body("items.lastName",hasItems("Pascal", "Smith"))
		.body("items.id",hasItems(438745745094f, 438768422146f))
		.body("items.salary",hasItems(10000, 5000));
		
	}
}
