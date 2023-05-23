package restAsssuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;   // copy and paste these 2 imports to remove errors
import static org.hamcrest.Matchers.equalTo; // copy and paste these 2 imports

/*
(1) Test Status Code
(2) Log Response
(3) Verifying Single content in response body
(4) Verifying Multiple contents in response body
Setting parameters & headers
*/


public class Demo5_BasicValidations_JSON {
	
	//(1) TEST STATUS CODE  (2) LOG RESPONSE
	
	@Test(priority=1)
	public void teststatuscode() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();   //<----- LOG RESPONSE gives detailed information about the response
		
		//or
		//given().when().get("("http://jsonplaceholder.typicode.com/posts/5").then()..statusCode(200);
	}
	
	
	//(3) VERIFY SINGLE CONTENT IN RESPONSE BODY
	
	/*{ 
		"RestResponse" : {
		"messages" : [ "Country found matching code [IN]."],
		"result" :{
		"name" : "India",    <---- If you want to verify the 'name'  which is inside the attribute, u use jason pathfinder(which you downloaded to you chrome).  You copy this whole response body and put in it, then copy for example 'name' and put in the 'search node' and submit, then copy the path e.g  '.RestResponse.result.name' and use this in your code (.body). The pathfinder is used when you have complex situation
		"alpha2_code" : "IN"		|
									|
		"alpha3_code" : "IND" */ //	|
								//	|	
								//	|
	@Test(priority=2)			//	|
public void testSingleContent() {//	|
		given()
		.when()					//	|
				.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()					//	|
		.statusCode(200)		//	V
		.body("RestResponse.result.name", equalTo( "India"));
	}


//(4) VERIFY MULTIPLE CONTENTS IN RESPONSE BODY

/*{ 
"RestResponse" : {
"messages" : [ "Total [249] records found."],
"result" :[ {
"name" : "Afghanistan",  //multiple countries
"alpha2_code" : "AF"									
"alpha3_code" : "AFG" 
{
"name" : "Albania",    //multiple countries
"alpha2_code" : "AL"									
"alpha3_code" : "ALB" 
{
"name" : "Algeria",     //multiple countries
"alpha2_code" : "DZ"									
"alpha3_code" : "DZA" 
{  */
												
@Test(priority=3)	
public void testMultipleContent() {
//given()

//.when()					
	//	.get("http://services.groupkt.com/country/get/all")  //<----- This is used when the request involves 'GET ALL' , NOT GET A SINGLE VALUE
//.then()						
//	    .body("RestResponse.result.name", hasItems ("Afghanistan","Albania","Algeria"));


}

// (4) SETTING PARAMETERS & HEADER         <----- These are prerequisites to a test and should be part of'given'



@Test(priority=4)	
public void testParametersAndHeaders() {
	
	given()
				.param("MyName","Pavan") // <--- It comes in keys and value (This is an example) . If you dont have parameters , ten 'given' is left blank
				.header("MyHeader","Indian")			//<--- It comes in keys and value(This is an example)

	.when()					
			.get("http://services.groupkt.com/country/get/iso2code/IN")
	.then()			
			.statusCode(200)
			.body("RestResponse.result.name", equalTo("magnam facilis autem"));
}

}

