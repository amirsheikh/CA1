import dramaplays.FactorPrinter;
import dramaplays.model.Invoice;
import dramaplays.model.Performance;
import dramaplays.model.Play;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorPrinterTest {

    Map<String, Play> plays;

    @Test
    void testEmptyPerformance() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));
        Invoice invoice = new Invoice("amirhossein", new ArrayList<>());
        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                Amount owed is $0.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceEq0() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 0)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $300.00 (0 seats)
                Amount owed is $300.00
                You earned 0 credits
                """);

    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceBt0And20NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 4)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $312.00 (4 seats)
                Amount owed is $312.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceEq20() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 20)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $360.00 (20 seats)
                Amount owed is $360.00
                You earned 4 credits
                """);
    }


    @Test
    void testPerformanceWithComedyPlayAndAudienceBt20And30NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 23)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $484.00 (23 seats)
                Amount owed is $484.00
                You earned 4 credits
                """);
    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceEq30() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 30)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $540.00 (30 seats)
                Amount owed is $540.00
                You earned 6 credits
                """);
    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceMt30NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 33)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $564.00 (33 seats)
                Amount owed is $564.00
                You earned 9 credits
                """);
    }


    @Test
    void testPerformanceWithTragedyPlayAndAudienceEq0() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 0)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (0 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceBt0And20NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 3)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (3 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceEq20() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 20)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (20 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceBt20And30NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 23)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (23 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceEq30() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 30)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (30 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceMt30NotDivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 33)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $430.00 (33 seats)
                Amount owed is $430.00
                You earned 3 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceEq0() {
        plays = new HashMap<>();
        int audienceValue = 0;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (0 seats)
                  1: $300.00 (0 seats)
                Amount owed is $700.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceBt0And20NotDivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 3;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
            Factor for amirhossein
              0: $400.00 (3 seats)
              1: $309.00 (3 seats)
            Amount owed is $709.00
            You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceEq20() {
        plays = new HashMap<>();
        int audienceValue = 20;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (20 seats)
                  1: $360.00 (20 seats)
                Amount owed is $760.00
                You earned 4 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceBt20And30NotDivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 23;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (23 seats)
                  1: $484.00 (23 seats)
                Amount owed is $884.00
                You earned 4 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceEq30() {
        plays = new HashMap<>();
        int audienceValue = 30;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (30 seats)
                  1: $540.00 (30 seats)
                Amount owed is $940.00
                You earned 6 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceMt30NotDivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 33;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $430.00 (33 seats)
                  1: $564.00 (33 seats)
                Amount owed is $994.00
                You earned 12 credits
                """);
    }


    @Test
    void testPerformanceWithComedyPlayAndAudienceBt0And20DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 15)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $345.00 (15 seats)
                Amount owed is $345.00
                You earned 3 credits
                """);
    }


    @Test
    void testPerformanceWithComedyPlayAndAudienceBt20And30DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 25)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $500.00 (25 seats)
                Amount owed is $500.00
                You earned 5 credits
                """);
    }

    @Test
    void testPerformanceWithComedyPlayAndAudienceMt30DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("comedyPlay", 35)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  1: $580.00 (35 seats)
                Amount owed is $580.00
                You earned 12 credits
                """);

    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceBt0And20DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 15)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (15 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }

    @Test
    void testPerformanceWithTragedyPlayAndAudienceBt20And30DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 25)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (25 seats)
                Amount owed is $400.00
                You earned 0 credits
                """);
    }


    @Test
    void testPerformanceWithTragedyPlayAndAudienceMt30DivideBy5() {
        plays = new HashMap<>();
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", 35)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $450.00 (35 seats)
                Amount owed is $450.00
                You earned 5 credits
                """);
    }


    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceBt0And20DivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 15;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (15 seats)
                  1: $345.00 (15 seats)
                Amount owed is $745.00
                You earned 3 credits
                """);
    }

    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceBt20And30DivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 25;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $400.00 (25 seats)
                  1: $500.00 (25 seats)
                Amount owed is $900.00
                You earned 5 credits
                """);
    }


    @Test
    void testPerformanceWithComedyAndTragedyPlayAndAudienceMt30DivideBy5() {
        plays = new HashMap<>();
        int audienceValue = 35;
        plays.put("tragedyPlay", new Play("0", "tragedy"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertEquals(factorPrinter.print(invoice, plays), """
                Factor for amirhossein
                  0: $450.00 (35 seats)
                  1: $580.00 (35 seats)
                Amount owed is $1,030.00
                You earned 17 credits
                """);
    }


    @Test
    void testBadType() {
        plays = new HashMap<>();
        int audienceValue = 35;
        plays.put("tragedyPlay", new Play("0", "t"));
        plays.put("comedyPlay", new Play("1", "comedy"));

        Invoice invoice = new Invoice("amirhossein", Arrays.asList(
                new Performance("tragedyPlay", audienceValue),
                new Performance("comedyPlay", audienceValue)));
        FactorPrinter factorPrinter = new FactorPrinter();
        assertThrows(Error.class, () -> factorPrinter.print(invoice, plays));
    }



}
