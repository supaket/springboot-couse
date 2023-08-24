package com.example.demo.user.gateway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {
    private final RestTemplate restTemplate;
    private final String postApiUrl;

    public PostGateway(RestTemplate restTemplate, @Value("${post.api.url}") String postApiUrl) {
        this.restTemplate = restTemplate;
        this.postApiUrl = postApiUrl;
    }

    public Optional<PostResponse> getPostById(int id) {
        String url = String.format("%s/%d", postApiUrl, id);

        try {
            return Optional.ofNullable(
                    restTemplate.getForObject(url, PostResponse.class));
        } catch (RestClientException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

        public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String getPostApiUrl() {
        return postApiUrl;
    }

}
