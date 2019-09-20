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
    String filepath,jsonpath, name, username, email, password, action, expectedCode,request,parameter, uri ;
    Properties prop=new Properties();
    InputStream input ;
    ApiFramework r = new ApiFramework();
    Response response = null;
    ArrayList<String> dataList;
    ArrayList<Object> list = new ArrayList<Object>();
    String[] parts;

    @BeforeTest(groups = {"functest","positive","negative"})
    public void getDataListName() throws IOException {
        input = new FileInputStream("C:\\Users\\Training\\HexaboardAutomationTest\\hexaboards\\conf.txt");
        prop.load(input);
        filepath = prop.getProperty("DataFile");
        jsonpath = prop.getProperty("JsonUR");
        uri = prop.getProperty("URI");
        RestAssured.baseURI = uri;
        dataList = r.readExcel(filepath, 1);
    }

    //scenario1 description: The request is sent with the correct user data
    @Test(groups = {"functest","positive"},priority = 1)
    public void scenario1(){
        parts = r.turnArray(dataList,1);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];
        //Name E-mail Username   Password   Action Parameters Expected Code
        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario2 description: The request is sent with the name wrong
    @Test(groups = {"functest","negative"},priority = 2)
    public void scenario2(){
        parts = r.turnArray(dataList,2);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario3 description: the request is sent with an existing username

    @Test(groups = {"functest","negative"},priority = 3)
    public void scenario3(){
        parts = r.turnArray(dataList,3);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";

        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario4 description: the request is sent with an existing e-mail

    @Test(groups = {"functest","negative"},priority = 4)
    public void scenario4(){
        parts = r.turnArray(dataList,4);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario5 description: the request was sent without a body

    @Test(groups = {"functest","negative"},priority = 5)
    public void scenario5(){
        parts = r.turnArray(dataList,5);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 6 description : the request is sent with a wrong format email
    @Test(groups = {"functest","negative"},priority = 6)
    public void scenario6(){
        parts = r.turnArray(dataList,6);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 7 description : the request is sent with a wrong password
    @Test(groups = {"functest","negative"},priority = 7)
    public void scenario7(){
        parts = r.turnArray(dataList,7);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 8 description: the request is sent with a name that has 256 characters
    @Test(groups = {"functest","positive"},priority = 8)
    public void scenario8(){
        parts = r.turnArray(dataList,8);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";

        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 9 description :
    @Test(groups = {"functest","negative"},priority = 9)
    public void scenario9(){
        parts = r.turnArray(dataList,9);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 10 description :
    @Test(groups = {"functest","negative"},priority = 10)
    public void scenario10(){
        parts = r.turnArray(dataList,10);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 11 description :
    @Test(groups = {"functest","negative"},priority = 11)
    public void scenario11(){
        parts = r.turnArray(dataList,11);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 12 description :
    @Test(groups = {"functest","positive"},priority = 12)
    public void scenario12(){
        parts = r.turnArray(dataList,12);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 13 description :
    @Test(groups = {"functest","negative"},priority =13)
    public void scenario13(){
        parts = r.turnArray(dataList,13);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 14 description :
    @Test(groups = {"functest","negative"},priority = 14)
    public void scenario14(){
        parts = r.turnArray(dataList,14);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 15 description :
    @Test(groups = {"functest","negative"},priority = 15)
    public void scenario15(){
        parts = r.turnArray(dataList,15);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 16 description :
    @Test(groups = {"functest","negative"},priority = 16)
    public void scenario16(){
        parts = r.turnArray(dataList,16);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 17 description :
    @Test(groups = {"functest","negative"},priority = 17)
    public void scenario17(){
        parts = r.turnArray(dataList,17);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //scenario 18 description :
    @Test(groups = {"functest","negative"},priority = 18)
    public void scenario18(){
        parts = r.turnArray(dataList,18);
        name = parts[0];
        email = parts[1];
        username = parts[2];
        password = parts[3];
        action = parts[4];
        parameter = parts[parts.length-2];
        expectedCode = parts[parts.length - 1];

        request = "{\"name\":\""+ name +"\" ,\"email\":\""+ email +"\",\"username\":\"" + username + "\",\"password\":\""+ password +"\"}";
        //Name E-mail Username   Password   Action Parameters Expected Code
        try {
            response = RestAssured.given().contentType(ContentType.JSON).body(request).post(parameter);
            list.add(r.getDataReport(request,response.getBody().asString(),response.getStatusCode(),parts,parameter));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @AfterTest(groups = {"functest","negative","positive"})
    public void finish(){
        r.convertToJSON(list,jsonpath);
    }
}