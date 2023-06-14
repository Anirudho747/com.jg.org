package restAssured;

import io.restassured.http.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Jun14_Direct {

    @Test
    public void get_UserDetailWithoutQueryPath()
    {
        RequestSpecification reqspec = RestAssured
                                       .given()
                                       .baseUri("http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/")
                                       .basePath("user-detail?userId=1");

        reqspec.header("Authorization","Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6NzQ5LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDgwMDAwMDAwNzAiLCJpYXQiOjE2ODE0ODQyMTZ9.woPowT66EMyBbs3BchAqLKC9I-ejEDDj8dkPRHuEaPQTb5-VTJNBvYSRS2Ar_25f9obb5iKirNxqucaAALPJ-A");

        Response rspns = reqspec.request(Method.GET,"");
        Assert.assertEquals(rspns.getStatusCode(),"201");
        Assert.assertEquals(rspns.prettyPrint().contains("Success"),true);
    }

    @Test
    public void get_UserDetailWithQueryPath()
    {
        RequestSpecification reqspec = RestAssured
                                       .given()
                                       .baseUri("http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/")
                                       .basePath("user-detail");
        reqspec.header("Authorization","Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6NzQ5LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDgwMDAwMDAwNzAiLCJpYXQiOjE2ODE0ODQyMTZ9.woPowT66EMyBbs3BchAqLKC9I-ejEDDj8dkPRHuEaPQTb5-VTJNBvYSRS2Ar_25f9obb5iKirNxqucaAALPJ-A");

        Response rspns = reqspec.request(Method.GET,"?userId=1");

        Assert.assertEquals(rspns.getStatusCode(),"201");
        Assert.assertEquals(rspns.prettyPrint().contains("Success"),true);
    }

    @Test
    public void post_CreateUser_withParam()
    {
        RequestSpecification reqspec = RestAssured
                                       .given()
                                       .baseUri("http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/")
                                       .basePath("users");

        reqspec.header("Content-Type", "application/json");
        reqspec.header("User-Agent", "PostmanRuntime/7.26.8");
        reqspec.header("Connection", "keep-alive");
        reqspec.header("Accept-Encoding", "gzip, deflate, br");
        reqspec.header("devicetoken", "fv1_9EtgcUGYgBxyWm4jCi:APA91bGgcPClIiTLBuAHBvO5KePxO0GIzIPNBCXhtaXO3B0xEgkOS-LylRlem933cd4OKRAYMH_Xc8UesND-hKdjW257umpXy3_53E7UCM73w6UnVDbNHb42zCV2xQvg4D3877V2R1S6 ");

        //Create a JSON Object
        JSONObject jo = new JSONObject();

        jo.put("date_of_birth", "1980-10-24");
        jo.put("mobile_number", "+91 8139779453");
        jo.put("referred_by", "7c99hbf5");

        reqspec.body(jo.toJSONString());

        Response rspns =reqspec.request(Method.POST);

        Assert.assertEquals(rspns.getStatusCode(),201,"Code Mismatch");

        Assert.assertEquals(rspns.prettyPrint().contains("User created successfully."),true,"Text not present");
    }

}
