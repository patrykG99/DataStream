package integration;



import com.fasterxml.jackson.databind.ObjectMapper;
import dataGeneration.DataGenerator;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;

public class ApiClient {
    private final String apiUrl;

    public ApiClient(String apiUrl){
        this.apiUrl = apiUrl;
    }

    public ApiResponse getData() {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                throw new IOException("Non-OK HTTP response code: " + status);
            }

            // Use try-with-resources for automatic resource management
            try (InputStream in = ApiClient.class.getResourceAsStream("/test.json")) {
                assert in != null;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }

                    String jsonResponse = DataGenerator.convertToJson();
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(jsonResponse, ApiResponse.class);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Error fetching data: " + e.getMessage(), e);
        }
    }



}
