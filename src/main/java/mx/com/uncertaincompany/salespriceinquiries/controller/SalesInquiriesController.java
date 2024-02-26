package mx.com.uncertaincompany.salespriceinquiries.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
public class SalesInquiriesController {

    @GetMapping("/salesinquiries")
    public String handleRequest(
            @RequestParam("date") String date,
            @RequestParam("product_id") String product_id,
            @RequestParam("brand_id") String brand_id) {
        String response = "Received Date: " + date + ", product_id: " + product_id + ", brand_id: " + brand_id;
        log.info(response);

        return String.valueOf(new ResponseEntity<>(response, HttpStatus.OK));
    }
}
