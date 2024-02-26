package mx.com.uncertaincompany.salespriceinquiries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class SalesPrice {
    private String productId;
    private String brandId;
    private String priceList;
    private Timestamp startDate;
    private Timestamp endDate;
    private Double price;
    private Timestamp last_update;
    private String last_update_by;
}
