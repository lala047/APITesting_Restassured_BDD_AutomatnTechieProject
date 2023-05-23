package restAsssuredTests;


import static io.restassured.RestAssured.given;   // copy and paste these 2 imports
import static org.hamcrest.Matchers.equalTo; // copy and paste these 2 imports

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Demo4_DELETE_REQUEST {
		
		@Test
		public void testPUT() {

			RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
			RestAssured.basePath= "/delete/2";
	
			Response response=	  // The below 'given, when , then' will be stored in this variable
			given() 
		    
			.when()  //get,post,put,delete ...
					.delete()
			
			.then()   // Validate status code & response body...
					.statusCode(200)
					.statusLine("HTTP/1.1 200 OK")
					.log().all()  //<-- This will show the updated info in the Response Body
					.extract().response();  //<---This particular will trigger the response to be stored in the variable 'Response response=
		
					String jsonAsString=response.asString();  // <---- This will convert the Jason response to Strng fmt
					Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"),true);
	}

}
