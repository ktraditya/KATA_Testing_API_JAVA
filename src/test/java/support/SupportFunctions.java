package support;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SupportFunctions {
    private static Response response;
    private static ObjectMapper mapper = new ObjectMapper();

    public static String createFileLocationPath(String Json){
        return "src/test/resources/" + Json + ".json";
    }

    public static ResponseBody post(String url, String json) {
        response = RestAssured.given()
                .header("content-type", MyConfig.CONTENT_TYPE)
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.getBody();
    }
    
    public static  <T> ResponseBody post(String url, Class<T>  json) {
        response = RestAssured.given()
                .header("content-type", MyConfig.CONTENT_TYPE)
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.getBody();
    }

    public static ResponseBody put(String url, String json) {
        response = RestAssured.given()
                .header("content-type", MyConfig.CONTENT_TYPE)
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .put(url);

        return response.getBody();
    }

    public static ResponseBody delete(String url) {
        response = RestAssured.given()
                .header("content-type", MyConfig.CONTENT_TYPE)
                .contentType(ContentType.JSON)
                .when()
                .delete(url);

        return response.getBody();
    }

    public static ResponseBody get(String url){
        response = RestAssured.given()
                .when()
                .get(url);
        return response.getBody();
    }

    public static <T> T convertResponse(Class<T> classObj) throws IOException {
        JSONObject jsonObject = new JSONObject(response.asString());
        return mapper.readValue(jsonObject.toString(), classObj);
    }

    public static <T> T[] convertResponseArray(Class<T[]> classObj) throws IOException {
        JSONArray jsonArray = new JSONArray(response.asString());
        System.out.println(jsonArray);
        return mapper.readValue(jsonArray.toString(), classObj);
    }
    public static int getResponseCode(){
        return response.getStatusCode();
    }
    public static String readJsonFromFile(String fileLocation) throws IOException {
    	String loc = new String(fileLocation);
        File file = new File(loc);
      
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
       JSONObject json = new JSONObject(content);
            return json.toString();
        
    }
}
