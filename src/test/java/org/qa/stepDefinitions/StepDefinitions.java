package org.qa.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.qa.dataBuilder.APIUri;
import org.qa.dataBuilder.TestDataBuilder;
import org.qa.utils.ApiHelperMethod;
import org.testng.Assert;


import static io.restassured.RestAssured.given;

public class StepDefinitions extends ApiHelperMethod {
    TestDataBuilder dataBuilder = new TestDataBuilder();
    Response response;
    RequestSpecification requestData;

    @Given("AddPlace API Payload with {string} {string} {string}")
    public void addplaceAPIPayloadWith(String name, String language, String address) {
        requestData = given().spec(requestSpecificationBuilder()).body(dataBuilder.addPlacePayload(name,language,address));
    }

    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String ApiName) {
        response = requestData.when().post(APIUri.valueOf(ApiName).getUri()).then().spec(responseSpecificationBuilder()).extract().response();
    }

    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("{string} is in response body is {string}")
    public void is_in_response_body_is(String key, String value) {
        JsonPath responseJson;
        responseJson = new JsonPath(response.asString());
        Assert.assertEquals(responseJson.get(key).toString(), value);
    }

}
