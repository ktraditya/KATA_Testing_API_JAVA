package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.ibm.icu.impl.Assert;

import dto.Speciality;
import dto.Vet;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import support.MyConfig;
import support.SupportFunctions;

public class VetsStepDef {
	ResponseBody body;
	String jsonData = "";

	@Given("A json vet  file {string}")
	public void a_json_vet_file(String jsonFile) throws IOException {

		jsonData = SupportFunctions.readJsonFromFile(jsonFile);
		System.out.println("Read data: " + jsonData);

	}

	@When("a request to create a new vet is made with valid request payload in {string}")
	public void a_request_to_create_a_new_vet_is_made_with_valid_request_payload_in(String jsonFile)
			throws IOException {
		jsonData = SupportFunctions.readJsonFromFile(jsonFile);
		System.out.println("Read data: " + jsonData);
		body = SupportFunctions.post(MyConfig.Endpoint + "api/vets", jsonData);
		System.out.println("Made api : " + body.print() + " status code:" + SupportFunctions.getResponseCode());
	}

	@Then("verify the response {int} is returned and vetid is created")
	public void verify_the_response_is_returned_and_vetid_is_created(Integer expectedStatusCode) throws IOException {
		assertEquals(SupportFunctions.getResponseCode(), (int) expectedStatusCode);
		Vet vet = SupportFunctions.convertResponse(Vet.class);
		assertTrue(vet.getId() != 0);
	}
}
