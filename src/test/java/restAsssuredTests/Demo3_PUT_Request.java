package restAsssuredTests;
/*given()<--  You put the body e.g names , email , pw etc and one of the Headers e.g (contentType("application/json") . This is eiter provided or found on the Test Data provided or when you manually use postman
 * 
 * BODY		<--------  This will be  part of the 'given()' as it is a POST api
  “Name” : “value”
   “Salary” : “value”,
   “Age” : “value”,
 

SUCCESS RESPONSE
“SuccessCode”: “OPERATION_SUCCESS”,       <---- These are what you will verify 
“Message”: “Operation completed successfully” <----- These are what you will verify 
STATUS CODE : 201     <------------ These are what you will verify */

import static io.restassured.RestAssured.given;   // copy and paste these 2 imports
import static org.hamcrest.Matchers.equalTo; // copy and paste these 2 imports

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Demo3_PUT_Request {

	public static HashMap map = new HashMap();
	
	  String empName=RestUtils.empName();  //<---   Call the methods from the Restutils class without
	  String empSal= RestUtils.empSal();
	  String empAge= RestUtils.empAge();
	  int emp_id= 11501 ;   //<---- This I.D is the only variable you will be changing if you want to update

	
	@BeforeClass
	public void putdata() {
		
		  map.put("name", empName);  
		  map.put("salary", empSal);
		  map.put("age", empAge);
		 


//Specify base URI
RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
RestAssured.basePath= "/update/"+emp_id;
	}
	
	@Test
	public void testPUT() {
		
		given() //set cookies, add auth, add param, set headers info etc
				.contentType("application/json")
				.body(map)   //select the byte[] body
	    
		.when()  //get,post,put,delete ...
				.put()
		
		.then()   // Validate status code & response body...
				.statusCode(200)
				.log().all();   //<-- This will show the updated info in the Response Body
	
	
}
}
