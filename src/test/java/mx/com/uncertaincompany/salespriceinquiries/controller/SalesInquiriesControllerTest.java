package mx.com.uncertaincompany.salespriceinquiries.controller;

import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;
import mx.com.uncertaincompany.salespriceinquiries.service.IPricesInquiriesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesInquiriesController.class)
class SalesInquiriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IPricesInquiriesService pricesInquiriesService;

    @Test
    public void testHandleRequest() throws Exception {

        List<SalesPrice> lSalesPrice = new ArrayList<>();

        SalesPrice pricesResponse = new SalesPrice();
        pricesResponse.setProductId("35455");
        pricesResponse.setBrandId("brand1");
        pricesResponse.setPriceList("1");
        pricesResponse.setPrice(35.5);

        lSalesPrice.add(pricesResponse);

        // Mock the behavior of the priceService
        when(pricesInquiriesService.getPricesInquiriesResponse(anyString(), anyString(), anyString()))
                .thenReturn(lSalesPrice);

        // Perform the request to the controller
        mockMvc.perform(MockMvcRequestBuilders.get("/salesinquiries")
                        .param("date", "2024-02-14 10:00:00")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                        .contentType(MediaType.ALL_VALUE)
                        .accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.ALL_VALUE));
    }
}