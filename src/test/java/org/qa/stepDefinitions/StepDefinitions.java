package org.qa.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.qa.pojo.AddPlace;
import org.qa.pojo.Location;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
    String place_id;
    String key;
    String content_type;
    AddPlace addPlace;
    List<String> types;
    Location location;

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Given("AddPlace API Payload")
    public void add_place_api_payload() {

        key = "qaclick123";
        content_type = "application/json";
        addPlace = new AddPlace();
        types = new ArrayList<>();
        types.add("First types");
        types.add("Second types");
        types.add("Third Types");
        location = new Location();
        location.setLat(-50.2369974);
        location.setLng(100.24455445);
        addPlace.setAccuracy(5);
        addPlace.setAddress("Bangladesh,dhaka");
        addPlace.setLanguage("Bangla");
        addPlace.setName("Shahjhanpur");
        addPlace.setPhone_number("1236588789865");
        addPlace.setTypes(types);
        addPlace.setLocation(location);
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", key)
                .setContentType(ContentType.JSON).build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();


       /* responseJson = HelperMethod.stringToJson(response.asString());
        place_id = responseJson.getString("place_id");
        System.out.println(place_id);*/
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String ApiName) {
        RequestSpecification request = given().spec(requestSpecification).body(addPlace);
        response = request.when().post("maps/api/place/add/json").then().spec(responseSpecification).extract().response();
    }
    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(int statusCode) {

        Assert.assertEquals(response.getStatusCode(),statusCode);

    }
    @Then("{string} is in response body is {string}")
    public void is_in_response_body_is(String key, String value) {
        JsonPath responseJson;
        responseJson = new JsonPath(response.asString());
        Assert.assertEquals(responseJson.get(key).toString(),value);
    }
}
