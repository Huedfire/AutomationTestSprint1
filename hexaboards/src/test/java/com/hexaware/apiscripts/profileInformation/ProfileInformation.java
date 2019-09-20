package com.hexaware.apiscripts.profileInformation;

import com.hexaware.frameworks.api.ApiFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ProfileInformation {
    Properties prop=new Properties();
    InputStream input ;
    ApiFramework r = new ApiFramework();
    String Username,Action,ExpectedCode,request,uri,filepath,jsonpath;
    String  parameter = "/api/user";
    Response response = null;
    ArrayList<String> dataList;
    ArrayList<Object> list = new ArrayList<Object>();
    String[] parts;

    @BeforeTest(groups = {"functest","positive","negative"})
    public void getDataListName() throws IOException {
        input = new FileInputStream("C:\\Users\\Training\\HexaboardAutomationTest\\hexaboards\\conf.txt");
        prop.load(input);
        filepath = prop.getProperty("DataFile");
        jsonpath = prop.getProperty("JsonPI");
        uri = prop.getProperty("URI");
        RestAssured.baseURI = uri;
        dataList = r.readExcel(filepath, 2);
    }

    //scenario1 description: The request is sent with the correct user data
    @Test(groups = {"functest","positive"},priority = 1)
    public void scenario1(){
        parts = r.turnArray(dataList,1);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario2 description: The request is sent without information
    @Test(groups = {"functest","negative"},priority = 2)
    public void scenario2(){
        parts = r.turnArray(dataList,2);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario3 description: The request is sent with an incorrect user name
    @Test(groups = {"functest","negative"},priority = 3)
    public void scenario3(){
        parts = r.turnArray(dataList,3);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario4 description: The request is sent request with valid character to view user information
    @Test(groups = {"functest","positive"},priority = 4)
    public void scenario4(){
        parts = r.turnArray(dataList,4);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario5 description: The request is sent with valid character to view user information
    @Test(groups = {"functest","positive"},priority = 5)
    public void scenario5(){
        parts = r.turnArray(dataList,5);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario6 description: The request is sent with invalid character to view user information
    @Test(groups = {"functest","negative"},priority = 6)
    public void scenario6(){
        parts = r.turnArray(dataList,6);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario7 description: The request is sent with invalid character to view user information
    @Test(groups = {"functest","negative"},priority = 7)
    public void scenario7(){
        parts = r.turnArray(dataList,7);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //scenario8 description: The request is sent with invalid character to view user information
    @Test(groups = {"functest","negative"},priority = 8)
    public void scenario8(){
        parts = r.turnArray(dataList,8);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //scenario9 description: The request is sent with invalid character to view user information
    @Test(groups = {"functest","negative"},priority = 9)
    public void scenario9(){
        parts = r.turnArray(dataList,9);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //scenario10 description: The request is sent with invalid character to view user information
    @Test(groups = {"functest","negative"},priority = 10)
    public void scenario10(){
        parts = r.turnArray
                (dataList,10);
        Username = parts[0];
        Action = parts[1];

        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"username\":\"" + Username + "\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @AfterTest(groups = {"functest","positive","negative"})
    public void finish(){
        r.convertToJSON(list,jsonpath);
    }
}
