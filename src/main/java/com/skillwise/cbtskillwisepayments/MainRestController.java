package com.skillwise.cbtskillwisepayments;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/1.1")
public class MainRestController
{
     @GetMapping("getall/order")
     public String getAllOrders()
    {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8092/api/1.1/getall/order";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        return response.getBody();

    }

}
