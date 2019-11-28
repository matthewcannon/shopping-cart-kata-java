package kata.shopping;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ScanningItems {

    private int priceOfOneA;

    private Checkout checkout;

    @Before
    public void setUp() {
        priceOfOneA = 50;

        checkout = new Checkout(priceOfOneA);
    }

    /*

        Note:   We've removed the duplication ("50") that existed between the test and
                the production code, but the test name still mentions "50".

     */
    @Test
    public void scanningOneAGivesATotalPriceOf50() {
        checkout.scan('A');

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfOneA);
    }

    @Test
    public void scanningTwoAsGivesATotalPriceOf100() {
        checkout.scan('A');
        checkout.scan('A');

        assertThat(checkout.getTotalPrice()).isEqualTo(100);
    }

    @Test
    public void scanningOneBGivesATotalPriceOf30() {
        checkout.scan('B');

        assertThat(checkout.getTotalPrice()).isEqualTo(30);
    }
}
