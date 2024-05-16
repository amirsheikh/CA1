package dramaplays.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvoiceTest {


    @Test
    void testNullPerformance() {
        assertThrows(Exception.class, () -> new Invoice("amirhossein", null));
    }

    @Test
    void testNullCustomer() {
        assertThrows(Exception.class, () -> new Invoice(null, Arrays.asList(
                new Performance("0", 3),
                new Performance("1", 4))));

    }

    @Test
    void testValues() {
        String customer = "amirhossein";
        List<Performance> performanceList = Arrays.asList(new Performance("0", 3),
                new Performance("1", 4));
        Invoice invoice = new Invoice(customer, performanceList);
        assertEquals(invoice.customer, customer);
        assertEquals(invoice.performances, performanceList);
    }


}
