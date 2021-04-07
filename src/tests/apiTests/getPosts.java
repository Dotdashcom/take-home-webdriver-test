package apiTests;

import com.google.sitebricks.headless.Request;
import org.openqa.selenium.remote.Response;
import java.util.HashMap;
import java.util.Map;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.http.Header;
//import io.restassured.http.Headers;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class getPosts {

    public boolean getPosts(){
        String body = "";
        HttpResponse<String> response = Unirest.get("https://jsonplaceholder.typicode.com/posts")
                .header("Content-Type", "text/plain")
                .header("User-Agent", "PostmanRuntime/7.22.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "d13f4dbe-8d68-4fc8-8200-968271d60e08,5bb1f3ce-a858-4cbf-99b8-8e2eaa010d25")
                .header("Host", "jsonplaceholder.typicode.com")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();

        if (response != null && "200".equals(Integer.toString(response.getStatus())))
            return true;
        else
            return false;

    }

}
