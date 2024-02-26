package mx.com.uncertaincompany.salespriceinquiries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude={DataSourceAutoConfiguration.class})
public class SalesPriceInquiriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesPriceInquiriesApplication.class, args);
	}

}
