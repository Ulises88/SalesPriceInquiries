package mx.com.uncertaincompany.salespriceinquiries.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;
import mx.com.uncertaincompany.salespriceinquiries.service.PricesInquiriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SalesInquiriesController {

    private final PricesInquiriesService pricesInquiriesService;

    @GetMapping("/salesinquiries")
    public ResponseEntity<List<SalesPrice>> handleRequest(
            @RequestParam("date") String date,
            @RequestParam("product_id") String product_id,
            @RequestParam("brand_id") String brand_id) {

        String datos = "Controller Received data Date: " + date + ", product_id: " + product_id + ", brand_id: " + brand_id;
        log.info(datos);

        List<SalesPrice> listResponse = pricesInquiriesService.getPricesInquiriesResponse(date, product_id, brand_id);

        return ResponseEntity.ok(listResponse);

    }
}
