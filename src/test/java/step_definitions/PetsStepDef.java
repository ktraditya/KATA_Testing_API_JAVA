package step_definitions;

import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.http.ContentType;
import cucumber.api.PendingException;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dto.Pet;
import dto.Pets;
import dto.Speciality;
import dto.Vet;

import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetsStepDef {

    private static ResponseBody body;
    public static final String Endpoint = "http://localhost:9966/petclinic/";

    public static final String CONTENT_TYPE = "application/json; utf-8";

    @When("^I want to know all the pets in the clinic")
    public void i_want_to_know_all_the_pets_in_the_clinic() throws Throwable {
       // body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
       // System.out.println(body.asString());
    	System.out.println("Hello world!");

    }


    @Then("^I should receive 13 pets")
    public void i_should_receive_pets() throws Throwable {
    	
    	
    	
       // Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
       // int amountOfPets = petsDTO.length;
      //  Assert.assertEquals("the amount of pets is 13 | ",13,amountOfPets);
    }

}
