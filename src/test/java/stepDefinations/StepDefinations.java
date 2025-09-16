import io.cucumber.core.resource.Resource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.ApiResourcesEnum;
import resources.TestData;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class StepDefinations extends Utils
{
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	Response res;
	TestData td=new TestData();

	@Given("Add Place API payload with {string} {string}")
	public void add_place_api_payload_with(String language, String address) {

		reqSpec=given().spec(getRequestSpecification())
				.body(td.addPlacePayLoad(language, address));
	}
	


@When("{string} API is called with {string} HTTP request")
public void api_is_called_with_http_request(String resourceName, String httpMethod) {
    
	ApiResourcesEnum apiResourceObj=ApiResourcesEnum.valueOf(resourceName);
	
	resSpec=new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.build();
	
	if(httpMethod.equalsIgnoreCase("POST"))
		res=reqSpec.when().post(apiResourceObj.getResource());
	else
		if(httpMethod.equalsIgnoreCase("GET"))
			res=reqSpec.when().get(apiResourceObj.getResource());
	
}

@Then("API is Success with status code {int}")
public void api_is_success_with_status_code(Integer int1) {
	assertEquals(res.getStatusCode(),200);


}

@Then("{string} in Response body is {string}")
public void in_response_body_is(String key, String expectedValue) {
	
	 assertEquals(getJsonPath(res,key),expectedValue);

	
}



private Object getJsonPath(Response res2, String key) {
	// TODO Auto-generated method stub
	return null;
}

}