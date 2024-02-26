package mx.com.uncertaincompany.salespriceinquiries.repository;

import lombok.extern.slf4j.Slf4j;
import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class PricesRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String usuario;
    @Value("${spring.datasource.password}")
    private String password;


    public List<SalesPrice> getPricesByBrandIdProductIdDate(Timestamp date, String productId, String brandId) {
        log.info("Repository getPricesByBrandIdProductIdDate...");
        List<SalesPrice> prices = new ArrayList<>();
        String query = "SELECT * FROM PRICES WHERE BRAND_ID = ? AND PRODUCT_ID = ? AND ? BETWEEN START_DATE AND END_DATE";
        try (Connection connection = DriverManager.getConnection(url, usuario, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            log.info("Connection to bd H2 succesfull!! query: " + query);

            statement.setString(1, brandId);
            statement.setString(2, productId);
            statement.setTimestamp(3, date);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    SalesPrice price = new SalesPrice();
                    price.setProductId(resultSet.getString("PRODUCT_ID"));
                    price.setBrandId(resultSet.getString("BRAND_ID"));
                    price.setPriceList(resultSet.getString("PRICE_LIST"));
                    price.setStartDate(resultSet.getTimestamp("START_DATE"));
                    price.setEndDate(resultSet.getTimestamp("END_DATE"));
                    price.setPrice(resultSet.getDouble("PRICE"));
                    price.setLast_update(resultSet.getTimestamp("LAST_UPDATE"));
                    price.setLast_update_by(resultSet.getString("LAST_UPDATE_BY"));
                    prices.add(price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prices;
    }

}
