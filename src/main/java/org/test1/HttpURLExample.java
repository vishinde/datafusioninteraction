package org.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.AccessToken;

public class HttpURLExample {
    public static void main(String[] args) throws Exception {

        String jsonPath = "/users/vivekshinde/IdeaProjects/javalearning/sa.json";

        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
                .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));

        credentials.refresh();
        AccessToken token = credentials.getAccessToken();

        // Sending get request
        URL url = new URL("https://testfusion1-inbound-planet-312719-dot-usw1.datafusion.googleusercontent.com/api/v3/namespaces/default/apps/NewFromDB1toGCS/workflows/DataPipelineWorkflow/runs");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization","Bearer "+ token.getTokenValue());
        //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T
        //conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        in.close();
        // printing result from response
        System.out.println("Response:-" + response.toString());

    }
}

