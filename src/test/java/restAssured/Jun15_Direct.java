package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jun15_Direct {

    @Test
    public void get_UserDetailWithoutQueryPath()
    {
        RequestSpecification reqspec = RestAssured
                                        .given()
                                        .baseUri("http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/")
                                        .basePath("user-detail?userId=1");

        reqspec.header("Authorization","Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6NzQ5LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDgwMDAwMDAwNzAiLCJpYXQiOjE2ODE0ODQyMTZ9.woPowT66EMyBbs3BchAqLKC9I-ejEDDj8dkPRHuEaPQTb5-VTJNBvYSRS2Ar_25f9obb5iKirNxqucaAALPJ-A");

        Response rspns = reqspec.request(Method.GET,"");

        Assert.assertEquals(rspns.getStatusCode(),201);
        Assert.assertEquals(rspns.prettyPrint().contains("Success"),true);
    }

    public void get_UserDetailWithQueryPath()
    {
        RequestSpecification reqspec = RestAssured.
                                       given().
                                       baseUri("").
                                       basePath("");

        reqspec.header("","");
        reqspec.header("","");

        Response rspns = reqspec.request(Method.GET,"");

        Assert.assertEquals("","");
    }

    public void post_UserDetailWithSimpleParam()
    {
        RequestSpecification reqspec = RestAssured.given()
                                       .baseUri("")
                                        .basePath("");

        reqspec.header("","");
        reqspec.header("","");

        JSONObject jo = new JSONObject();

        jo.put("","");
        jo.put("","");
        jo.put("","");
        jo.put("","");

        reqspec.body(jo.toJSONString());

        Response rspns = reqspec.request(Method.POST);

        Assert.assertEquals("","");
    }

    @Test
    public void post_UserDetailWithComplexParam()
    {
        RequestSpecification reqspec = RestAssured.
                                       given().
                                       baseUri("").
                                       basePath("");

        reqspec.header("","");
        reqspec.header("","");
        reqspec.header("","");
        reqspec.header("","");

        String jstrng = "{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";


        reqspec.body(jstrng);

        Response rspns = reqspec.request(Method.POST);

        Assert.assertEquals("","");
    }


}
