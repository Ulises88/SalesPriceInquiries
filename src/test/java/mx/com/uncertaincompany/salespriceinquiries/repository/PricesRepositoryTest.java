package mx.com.uncertaincompany.salespriceinquiries.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.uncertaincompany.salespriceinquiries.model.SalesPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@Slf4j
@RequiredArgsConstructor
class PricesRepositoryTest {

    @InjectMocks
    private PricesRepository myClass;

    @Test
    public void testGetPricesByBrandIdProductIdDate() throws Exception {

        String urlStr = "jdbc:h2:mem:pricesdb";
        String usrStr = "sa";
        String passStr = "p455w0rD.";

        Field url = PricesRepository.class.getDeclaredField("url");
        url.setAccessible(true);
        url.set(null, urlStr);
        Field usuario = PricesRepository.class.getDeclaredField("usuario");
        usuario.setAccessible(true);
        usuario.set(null, usrStr);
        Field password = PricesRepository.class.getDeclaredField("password");
        password.setAccessible(true);
        password.set(null, passStr);

        // Llama al método que se está probando
        List<SalesPrice> result = myClass.getPricesByBrandIdProductIdDate(new Timestamp(System.currentTimeMillis()), "product_id", "brand_id");

        assertEquals(0, result.size());
    }

}