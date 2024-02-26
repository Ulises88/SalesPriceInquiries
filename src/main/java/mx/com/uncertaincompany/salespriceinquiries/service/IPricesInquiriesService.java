package mx.com.uncertaincompany.salespriceinquiries.service;

import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;

import java.util.List;

public interface IPricesInquiriesService {

    List<SalesPrice> getPricesInquiriesResponse(String date, String product_id, String brand_id);
}
