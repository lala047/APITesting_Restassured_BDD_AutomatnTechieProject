package restAsssuredTests;


/*given()<--  You put the body e.g names , email , pw etc and one of the Headers e.g (contentType("application/json") . This is either provided or found on the Test Data provided or when you manually use postman
 * 
 * BODY		<--------  This will be  part of the 'given()' as it is a POST api
  “FirstName” : “value”
   “LastName” : “value”,
   “UserName” : “value”,
   “Password” : “value”,
   “Email”    : “Value”

SUCCESS RESPONSE
“SuccessCode”: “OPERATION_SUCCESS”,       <---- These are what you will verify 
“Message”: “Operation completed successfully” <----- These are what you will verify 
STATUS CODE : 201     <------------ These are what you will verify */

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class Demo2_POST_Requestt {
	public static HashMap map = new HashMap();
	
	  String getFirstName=RestUtils.getFirstName();  //<---   Call the methods from the Restutils class without
	  String getLastName= RestUtils.getLastName();
	  String empUserName= RestUtils.getUserName();
	  String empPassword= RestUtils.getPassword();

	
	@BeforeClass
	public void postdata() {
		
		  map.put("FirstName", getFirstName); 
		  map.put("LastName",getLastName); 
		  map.put("UserName", empUserName);
		  map.put("Password", empPassword);
		 


//Specify base URI
RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
RestAssured.basePath= "/create";
	}
	
	@Test
	public void testPOST() {
		
		given() //set cookies, add auth, add param, set headers info etc
				.contentType("application/json")
				.body(map)   //select the byte[] body
	    
		.when()  //get,post,put,delete ...
		.post()
		
		.then()   // Validate status code & response body...
				.statusCode(200)
		.and()
				.body("status", equalTo("success"))//select list <Argument>) verifying that the body of the response contains this
		.and()
				.body("message",equalTo("Successfully! Record has been added."))

				.log().all();   //<-- This will show the created info in the Response Body
   
	}
	
}