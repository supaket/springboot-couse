package com.example.demo.user.controller;

import com.example.demo.user.gateway.PostGateway;
import com.example.demo.user.gateway.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest
@AutoConfigureWireMock(port = 8999)
public class PostGatewayTest {

    @Autowired
    PostGateway postGateway;

    @Test
    public void shouldGetPostFromPostGatewayResponse(){
        stubFor(get(urlEqualTo("/todos/10"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody("{\n" +
                                "  \"userId\": 10,\n" +
                                "  \"id\": 10,\n" +
                                "  \"title\": \"10 delectus aut autem\",\n" +
                                "  \"completed\": false\n" +
                                "}")
                        )
        );

        Optional<PostResponse> postResponse = postGateway.getPostById(10);
        assertEquals(postResponse.get().getId(),10);
    }
}
