package ProfileInformation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class TC_PI_01 {

//Test Data
    public String request1 = "{\"username\":\"ivonne\"}";
    public String request2 = "{\"username\":\"\"}";
    public String request3 = "{\"username\":\"jacox\"}";
    public String request4 = "{\"username\":\"-ivonne\"}";
    public String request5 = "{\"username\":\"_maria\"}";
    public String request6 = "{\"username\":\"@\"}";
    public String request7 = "{\"username\":\"#\"}";
    public String request8 = "{\"username\":\"$\"}";
    public String request9 = "{\"username\":\"*\"}";
    public String request10 = "{\"username\":\"&\"}";



    @Test
    public  void TS_PI_01() {
        //Submit request with a correct username to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request1).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(200,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_02(){
        //Send request without information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request2).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_03(){
        // Send request with an incorrect user name
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request3).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_04(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request4).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(200,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TS_PI_05(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request5).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(200,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_06(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request6).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_07(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request7).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_08(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request8).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_09(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request9).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TS_PI_10(){
        // Send request with valid character to view user information
        try {

            RestAssured.baseURI = "http://192.168.0.108:3000";
            Response response = null;
            response = RestAssured.given().contentType(ContentType.JSON).body(request10).post("/api/user");
            response.body().prettyPrint();

            System.out.println("StatusCode: " + response.getStatusCode());
            int code = response.getStatusCode();

            assertEquals(404,response.getStatusCode());
            switch (code){

                case 200:
                    System.out.println("Succesfull query");
                    break;
                case 404:
                    System.out.println("User not found");
                    break;
                case 500:
                    System.out.println("Database error");
                    break;
                default:
                    System.out.println(code);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
