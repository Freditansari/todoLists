package com.packt.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;

@SpringBootApplication
public class RestClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner {

        @Override
        public void run(String...args) throws Exception {
            RestTemplate restTemplate= new RestTemplate();
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("grant_type", "password");
            formData.add("username", "jadams");
            formData.add("password", "johnadams123");

            String credentials = "client:secret";
            String encoded = new String(Base64.getEncoder().encode(credentials.getBytes()));

            HttpHeaders httpHeader = new HttpHeaders();
            httpHeader.add("Authorization", "Basic "+ encoded);

            String url = "http://206.189.35.230:8080/oauth/token";

            RequestEntity<MultiValueMap<String, String>> requestEntity= new RequestEntity<>(
              formData,httpHeader, HttpMethod.POST, URI.create("http://206.189.35.230:8080/oauth/token")
            );

            ResponseEntity<OAuth2Token> responseEntity= restTemplate.exchange(requestEntity,OAuth2Token.class);

            logger.info(responseEntity.toString());

        }
    }
}
