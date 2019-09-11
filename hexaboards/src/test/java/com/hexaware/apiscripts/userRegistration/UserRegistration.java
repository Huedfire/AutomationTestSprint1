package com.hexaware.apiscripts.userRegistration;

import com.hexaware.frameworks.api.ApiFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class UserRegistration {
    String filepath ;
    String jsonpath ;
    Properties prop=new Properties();
    InputStream input ;
    String uri;
    ApiFramework r = new ApiFramework();
    String Name;
    String Username;
    String Email;
    String Password;
    String Action;
    String ExpectedCode;
    String request;
    String parameter;
    Response response = null;
    ArrayList<String> dataList;
    ArrayList<Object> list = new ArrayList<Object>();
    String[] parts;

    @BeforeMethod(groups = {"functest"})
    public void getDataListName() throws IOException {
        input = new FileInputStream("C:\\Users\\Training\\HexaboardAutomationTest\\hexaboards\\conf.txt");
        prop.load(input);
        filepath = prop.getProperty("DataFile");
        jsonpath = prop.getProperty("JsonPath");
        uri = prop.getProperty("URI");
        RestAssured.baseURI = uri;
        dataList = r.readExcel(filepath, 1);
    }

    //scenario1 description: The request is sent with the correct user data
    @Test(groups = {"functest"})
    public void scenario1(){
        parts = r.turnArray(dataList,1);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario2 description: The request is sent with the name wrong
    @Test(groups = {"functest"})
    public void scenario2(){
        parts = r.turnArray(dataList,2);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario3 description: the request is sent with an existing username

    @Test(groups = {"functest"})
    public void scenario3(){
        parts = r.turnArray(dataList,3);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";

        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario4 description: the request is sent with an existing e-mail

    @Test(groups = {"functest"})
    public void scenario4(){
        parts = r.turnArray(dataList,4);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario5 description: the request was sent without a body

    @Test(groups = {"functest"})
    public void scenario5(){
        parts = r.turnArray(dataList,5);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 6 description : the request is sent with a wrong format email
    @Test(groups = {"functest"})
    public void scenario6(){
        parts = r.turnArray(dataList,6);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 7 description : the request is sent with a wrong password
    @Test(groups = {"functest"})
    public void scenario7(){
        parts = r.turnArray(dataList,7);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 8 description: the request is sent with a name that has 256 characters
    @Test(groups = {"functest"})
    public void scenario8(){
        parts = r.turnArray(dataList,8);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";

        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 9 description :
    @Test(groups = {"functest"})
    public void scenario9(){
        parts = r.turnArray(dataList,9);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 10 description :
    @Test(groups = {"functest"})
    public void scenario10(){
        parts = r.turnArray(dataList,10);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 11 description :
    @Test(groups = {"functest"})
    public void scenario11(){
        parts = r.turnArray(dataList,11);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 12 description :
    @Test(groups = {"functest"})
    public void scenario12(){
        parts = r.turnArray(dataList,12);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 13 description :
    @Test(groups = {"functest"})
    public void scenario13(){
        parts = r.turnArray(dataList,13);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 14 description :
    @Test(groups = {"functest"})
    public void scenario14(){
        parts = r.turnArray(dataList,14);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 15 description :
    @Test(groups = {"functest"})
    public void scenario15(){
        parts = r.turnArray(dataList,15);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 16 description :
    @Test(groups = {"functest"})
    public void scenario16(){
        parts = r.turnArray(dataList,16);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 17 description :
    @Test(groups = {"functest"})
    public void scenario17(){
        parts = r.turnArray(dataList,17);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 18 description :
    @Test(groups = {"functest"})
    public void scenario18(){
        parts = r.turnArray(dataList,18);
        Name = parts[0];
        Email = parts[1];
        Username = parts[2];
        Password = parts[3];
        Action = parts[4];
        parameter = parts[parts.length-2];
        ExpectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+Name+"\" ,\"e_mail\":\""+Email+"\",\"username\":\"" + Username + "\",\"password\":\""+Password+"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @AfterMethod(groups = {"functest"})
    public void finish(){
        r.convertToJSON(list,jsonpath);
    }
}