package org.test1;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Usinghttpclient {
        public static void main(String[] args) throws IOException {
            String jsonPath = "/users/vivekshinde/IdeaProjects/javalearning/sa.json";

            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
                    .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));

            HttpTransport transport = new NetHttpTransport.Builder().build();
            HttpRequestFactory requestFactory = transport.createRequestFactory(new HttpCredentialsAdapter(credentials));

            String urlToFetch = "https://testfusion1-inbound-planet-312719-dot-usw1.datafusion.googleusercontent.com/api/v3/namespaces/default/apps/NewFromDB1toGCS/workflows/DataPipelineWorkflow/runs";
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(urlToFetch));
            HttpResponse response = request.execute();
            System.out.println(response);
    }
}
