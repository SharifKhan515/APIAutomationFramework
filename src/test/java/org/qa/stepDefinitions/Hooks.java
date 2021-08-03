package org.qa.stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario(){
        if(StepDefinitions.place_id==null){
            StepDefinitions sd = new StepDefinitions();
            sd.addplaceAPIPayloadWith("Test","tets","test");
            sd.userCallsWithHttpRequest("AddPlaceAPI", "POST");
            sd.api_call_is_success_with_status_code(200);
            sd.verifyPlace_idCreatedMapsToUsing("Test","getPlaceAPI");
        }

    }
}
