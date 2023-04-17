package com.skillwise.cbtskillwisepayments;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/1.1")
public class MainRestController
{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductOfferRepository productOfferRepository;

    @Autowired
    PaymentrecordRepository paymentrecordRepository;

     @GetMapping("getall/order")
     public String getAllOrders()
    {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8092/api/1.1/getall/order";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        Logger logger = LogManager.getLogger(MainRestController.class);
        logger.info("all order feteched");

        return response.getBody();

    }

    @PostMapping("acceptorder")
    public Order acceptOrder(@RequestParam("offerid") Integer offerid, @RequestParam("orderid") Integer orderid ) throws Exception
    {
        if(  orderRepository.findById(orderid).isPresent() )
        {
            productOfferRepository.updateStatusByIdEquals(offerid, orderid);

            Paymentrecord paymentrecord = new Paymentrecord();

            Integer tempId = (int) (Math.random()*10000);

            paymentrecord.setId(tempId);
            paymentrecord.setOfferid(offerid);
            paymentrecord.setSellername(productOfferRepository.findById(offerid).get().getUsername());
            paymentrecord.setBuyername(orderRepository.findById(orderid).get().getUsername());
            paymentrecord.setAmount(orderRepository.findById(orderid).get().getBid());

            paymentrecordRepository.save(paymentrecord);


            return orderRepository.findById(orderid).get();

        }
        else
        {
            throw new Exception();
        }
    }



}
