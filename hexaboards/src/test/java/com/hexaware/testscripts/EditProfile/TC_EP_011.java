package com.hexaware.testscripts.EditProfile;

import com.hexaware.frameworks.api.ApiFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;


public class TC_EP_011 {
    String filepath = "DataFile.xlsx";
    String jsonpath = "file.json";
    ApiFramework r = new ApiFramework();
    String Name;
    String Username;
    String ExpectedCode;
    String request;
    String parameter;
    Response response = null;
    ArrayList<String> user;
    ArrayList<Object> list = new ArrayList<Object>();


    @BeforeTest(groups = {"names"})
    public void getDataListName() throws IOException {
        user = r.readExcel(filepath, 4);
        RestAssured.baseURI = "http://192.168.0.116:3000";
    }

  /*  @BeforeTest(groups = {"email"})
    public void getDataListEmail() throws IOException {
        user = r.readExcel(filepath, 5);
        RestAssured.baseURI = "http://192.168.0.116:3000";
    }

    @BeforeTest(groups = {"pwd"})
    public void getDataListPwd() throws IOException {
        user = r.readExcel(filepath, 6);
        RestAssured.baseURI = "http://192.168.0.116:3000";
    }
*/
    @Test(groups = {"names"})
    public void scenario1(){
        String[] parts = user.get(1).split(",");
        Name = parts[0];
        Username = parts[1];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        System.out.println(Name);
        System.out.println(Username);
        System.out.println(parameter);
        System.out.println(ExpectedCode);
        request = "{\"name\":\""+Name+"\" ,\"username\":\"" + Username + "\"}";
        try {

            response = RestAssured.given().contentType(ContentType.JSON).body(request).put(parameter);

          list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test(groups = {"names"})
    public void scenario2(){
        String[] parts = user.get(2).split(",");
        Name = parts[0];
        Username = parts[1];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        System.out.println(Name);
        System.out.println(Username);
        System.out.println(parameter);
        System.out.println(ExpectedCode);
        request = "{\"name\":\""+Name+"\" ,\"username\":\"" + Username + "\"}";
        try {

            response = RestAssured.given().contentType(ContentType.JSON).body(request).put(parameter);

            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @AfterTest(groups = {"names"})
    public void finish(){
        r.convertToJSON(list,jsonpath);
    }





}
