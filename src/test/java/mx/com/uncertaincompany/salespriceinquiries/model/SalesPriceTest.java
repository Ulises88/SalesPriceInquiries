package mx.com.uncertaincompany.salespriceinquiries.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@Slf4j
class SalesPriceTest {

    @Test
    void getterAndSetterAttributesTest() {
        SalesPrice salesPrice = new SalesPrice();
        log.info(salesPrice.toString());
        salesPrice.setPrice(180.5);
        salesPrice.setProductId("1");
        salesPrice.setPriceList("1");
        salesPrice.setBrandId("1");
        salesPrice.setStartDate(getTimestampFromString("2020-06-14 20:00:00"));
        salesPrice.setEndDate(getTimestampFromString("2020-06-14 20:00:00"));
        log.info(salesPrice.toString());
        assertEquals(180.5, salesPrice.getPrice());
        assertEquals("1", salesPrice.getProductId());
        assertEquals("1", salesPrice.getPriceList());
        assertEquals("1", salesPrice.getBrandId());
        assertEquals(getTimestampFromString("2020-06-14 20:00:00"), salesPrice.getStartDate());
        assertEquals(getTimestampFromString("2020-06-14 20:00:00"), salesPrice.getStartDate());

    }

    /**
     * This method return a timestamp from a string.
     *
     * @param strdate string to parse a timestamp.
     * @return a timestamp parse from a string.
     */
    public Timestamp getTimestampFromString(String strdate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strdate, format);
        return Timestamp.valueOf(dateTime);
    }
}