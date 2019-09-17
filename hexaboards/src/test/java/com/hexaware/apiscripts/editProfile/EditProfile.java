package com.hexaware.apiscripts.editProfile;

import com.hexaware.frameworks.api.ApiFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class EditProfile {
    String filepath ;
    String jsonpath ;
    Properties prop=new Properties();
    InputStream input ;
    String uri;
    ApiFramework r = new ApiFramework();
    String Username;
    String Action;
    String ExpectedCode;
    String request;
    String  parameter = "/api/user";
    Response response = null;
    ArrayList<String> dataList;
    ArrayList<Object> list = new ArrayList<Object>();
    String[] parts;

    @BeforeTest(groups = {"functest"})
    public void getDataListName() throws IOException {
        input = new FileInputStream("C:\\Users\\Training\\HexaboardAutomationTest\\hexaboards\\conf.txt");
        prop.load(input);
        filepath = prop.getProperty("DataFile");
        jsonpath = prop.getProperty("JsonPath");
        uri = prop.getProperty("URI");
        RestAssured.baseURI = uri;
        dataList = r.readExcel(filepath, 2);
    }

    //scenario1 description: The request is sent with the correct user data
    @Test(groups = {"functest"})
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

}
