package mx.com.uncertaincompany.salespriceinquiries.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;
import mx.com.uncertaincompany.salespriceinquiries.repository.PricesRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PricesInquiriesService implements IPricesInquiriesService {
    private final PricesRepository pricesRepository;

    /**
     * This method validates whether a string is valid as an integer or not.
     *
     * @param strparam String to validate.
     * @return boolean with result of validation.
     */
    public static boolean isValidInteger(String strparam) {
        try {
            Integer.parseInt(strparam);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method validates whether a string is valid as a timestamp or not.
     *
     * @param strdate String to validate.
     * @return boolean with result of validation.
     */
    public static boolean isValidTimestamp(String strdate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(strdate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * This implementation validates the parameters and queries those parameters.
     *
     * @param date       string with a timestamp to query.
     * @param product_id string with a product_id to query.
     * @param brand_id   string with a brand_id to query.
     * @return SalesPrice list as a response of query.
     */
    @Override
    public List<SalesPrice> getPricesInquiriesResponse(String date, String product_id, String brand_id) {
        log.info("Service star getPricesInquiriesResponse...");

        if (StringUtils.isBlank(date.trim()) ||
                StringUtils.isBlank(product_id.trim()) ||
                StringUtils.isBlank(brand_id.trim())) {
            return null;
        }

        if (!isValidInteger(product_id)) {
            log.error("The product_id is not integer.");
            return null;
        }
        if (!isValidTimestamp(date)) {
            log.error("The date is not have Timestamp format.");
            return null;
        }

        return pricesRepository.getPricesByBrandIdProductIdDate(getTimestampFromString(date), product_id, brand_id);
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
