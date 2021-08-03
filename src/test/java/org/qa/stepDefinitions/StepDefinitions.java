package org.qa.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.qa.dataBuilder.APIUri;
import org.qa.dataBuilder.TestDataBuilder;
import org.qa.utils.ApiHelperMethod;
import org.testng.Assert;


import static io.restassured.RestAssured.given;

public class StepDefinitions extends ApiHelperMethod {
    static String place_id;
    TestDataBuilder dataBuilder = new TestDataBuilder();
    Response response;
    RequestSpecification requestData;

    @Given("AddPlace API Payload with {string} {string} {string}")
    public void addplaceAPIPayloadWith(String name, String language, String address) {
        requestData = given().spec(requestSpecificationBuilder()).body(dataBuilder.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String ApiName, String httpMethod) {
        String apiUri = APIUri.valueOf(ApiName).getUri();

        if (httpMethod.equalsIgnoreCase("POST")) {
            response = requestData.when().post(apiUri);
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            response = requestData.when().get(apiUri);
        }

    }

    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("{string} is in response body is {string}")
    public void is_in_response_body_is(String key, String value) {

        Assert.assertEquals(getValueFromJson(response, key), value);
    }


    @And("verify Place_id created maps to {string} using {string}")
    public void verifyPlace_idCreatedMapsToUsing(String name, String ApiName) {
        place_id = getValueFromJson(response, "place_id");
        requestData = given().spec(requestSpecificationBuilder()).queryParam("place_id", place_id);
        userCallsWithHttpRequest(ApiName, "GET");
        Assert.assertEquals(getValueFromJson(response, "name"), name);

    }

    @Given("deletePlace Payload")
    public void deletePlacePayloadSet() {

        String deletePlacePayload = dataBuilder.deletePlacePayload(place_id);
        requestData = given().spec(requestSpecificationBuilder()).body(deletePlacePayload);

    }
}
