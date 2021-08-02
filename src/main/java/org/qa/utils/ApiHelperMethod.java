package org.qa.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.PrintStream;


public class ApiHelperMethod {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static PrintStream logger = ReportHelper.getLogger();

    public RequestSpecification requestSpecificationBuilder() {
        String key = "qaclick123";
        if(responseSpecification==null){
            requestSpecification = new RequestSpecBuilder().setBaseUri(AppConfig.getBaseUrl()).addQueryParam("key", key)
                    .addFilter(RequestLoggingFilter.logRequestTo(logger))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logger))
                    .setContentType(ContentType.JSON).build();
        }

        return requestSpecification;
    }

    public ResponseSpecification responseSpecificationBuilder() {

        if(responseSpecification==null){
            responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        }

        return responseSpecification;
    }

}
