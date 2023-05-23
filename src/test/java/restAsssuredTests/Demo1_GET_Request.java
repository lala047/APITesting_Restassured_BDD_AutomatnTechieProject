/*HOW TO SEND 'GET' REQUEST 
URL:htttp://resapi.demoqa.com/utilities/weather/city/hyderabad
	VALIDATIONS: Validate if what you got from postman is the same as what you got from RestAssured using these validation points.
	Status code- 200k
	Status line: HTTP/1.1 200k
	Response body : This is the info (response you get when you click 'send')
	Header (Content- Type, Content- Encoding etc)*/
	


package restAsssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request {
	
	@Test
	public void getWeather() {
		
	//STRUCTURE
		given() //set cookies, add auth, add param, set headers info etc ('given' can be left empty if there is no prerequisite to be passed)
		.when()  //get,post,put,delete ...
				.get("http://demoqa.com/utilities/weather/city/hyderabad ")
		.then()   // Validate status code, extract response, extract headers cookies & response body...
		
				//VALIDATE
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City",equalTo("hyderabad"))      //List<Argument>arguments Response    <--- pic this option
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();   //<-- This will show the info in the Response Body (log Response)
	
}
	
}