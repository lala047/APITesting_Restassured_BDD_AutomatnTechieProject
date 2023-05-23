package restAsssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

/*1) Verifying Single content in XML Response
	2) Verifying Multiple contents in XML Response
	3) Verifying all the content in XML response in one go
	4) XPath with text() function
	5) Find values using XML Path (XPath) in XML response body
	
	NOTE *XML HAS ROOTS AND TAGS
	*/
	

public class Demo_6BasicValidations_XML {
	//1) Verifying Single content in XML Response
	
	@Test (priority=1)
	public void testSingleContent() {
		
	given()
		
		
	.when()
			.get("http://thomas.bayer.com/sqlrest/CUSTOMER/15/")
	
	
														/*http://thomas.bayer.com/sqlrest/CUSTOMER/15/
																		|
																		|
																		V
														<CUSTOMER xmlns: xlink= "http://www.w3.org/1999/xlink">
																<script/>
																<script/>
		To verify if the ID is 15 ------>						<ID>15</ID
				|												<FIRSTNAME>Bill</FIRSTNAME>
				|												<LASTNAME>Clancy</LASTNAME>
				V												<STREET>319 Upland PL. </STREET>
																<CITY>Seattle</CITY>
  																</CUSTOMER */
			.then()
				.body("CUSTOMER.ID",equalTo("15")) //"I.D" is available inside the "CUSTOMER" root Tag  . list <Argument>) verifying that the body of the response contains this
				.log().all();
	
	}
	
	//2) Verifying Multiple contents in XML Response
	public void testMultipleContent() {
		
		given()
			
			
		.when()
				.get("http://thomas.bayer.com/sqlrest/CUSTOMER/15/")
		
		
															/*http://thomas.bayer.com/sqlrest/CUSTOMER/15/    NOTE *XML HAS ROOTS AND TAGS
																			|
																			|
																xml path	|
																|			V
																V
															<CUSTOMER xmlns: xlink= "http://www.w3.org/1999/xlink">    
																	<script/>
																	<script/>
			To verify all the contents ------>						<ID>15</ID
			To verify all the contents ------>						<FIRSTNAME>Bill</FIRSTNAME>
			To verify all the contents ------>						<LASTNAME>Clancy</LASTNAME>
			To verify all the contents ------>						<STREET>319 Upland PL. </STREET>
			To verify all the contents ------>						<CITY>Seattle</CITY>
	  																</CUSTOMER */
				.then()   //SPECIFY THE XML PATH (CUSTOMER ) AND VALUE (FIRSTNAME, LASTNAME ETC).
					.body("CUSTOMER.ID",equalTo("15")) //"I.D" is available inside the "CUSTOMER" root Tag  . list <Argument>) verifying that the body of the response contains this
					.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
					.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
					.body("CUSTOMER.STREET>",equalTo("319 Upland PL."))
					.body("CUSTOMER.CITY",equalTo("Seattle"))
					.log().all();
	
		
		                  // OR
		//(3)Verify all the  XML contents in 1 go using text() function
				//.then()  /SPECIFY THE XML PATH (CUSTOMER ) AND VALUE (FIRSTNAME, LASTNAME ETC).
				//	.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland PL.Seattle"))
				//	.log().all();
		/*	

		QUE: Thank you for your great effort and teaching us! What if I have to verify 1000 people's information then 1000 equalTo methods ? Is there any more easy way how to validate it?
		ANS: you can pass those 1000 people information from excel into the test method and do a for loop to validate*/
								
				
	
	}
	
	//5) Find values using XML Path (XPath) in XML response body
	
	
	@Test
	//public void testUsingXpath1() {
		
	//	given()
		
		
	//	.when()
		//		.get("http://thomas.bayer.com/sqlrest/CUSTOMER/15/")
				
	//	.then()
		//		.body(hasXPath("CUSTOMER/FIRSTNAME"), containsString("Bill")));
	
				
		//(5b)ANOTHER EXAMPLE
		
						/*http://www.thomas-buyer.com/sqlrest/INVOICE/
								|	
								V
							<INVOICEList xmlns:xlink= "http://www.w3.org/1999/xlink">       * INVOICEList is the root tag
								<script/>
								<script/>
								<INVOICE xlink:href="http://thomas-bayer.com/sqlrest/INVOICE/0/">0</INVOICE>
								<INVOICE xlink:href="http://thomas-bayer.com/sqlrest/INVOICE/0/">1</INVOICE>
To verify if ID is 15 ------>	<INVOICE xlink:href="http://thomas-bayer.com/sqlrest/INVOICE/0/">2</INVOICE>
								<INVOICE xlink:href="http://thomas-bayer.com/sqlrest/INVOICE/0/">3</INVOICE>	
								<INVOICE xlink:href="http://thomas-bayer.com/sqlrest/INVOICE/0/">4</INVOICE>    */


		public void testUsingXpath2() {
			
			//given()
			
			
			//.when()
			//		.get("http://www.thomas-buyer.com/sqlrest/INVOICE/")
					
			//.then()
			//.body(hasXPath("INVOICEList/INVOICE[text()='2']"));
	
		
	}
}