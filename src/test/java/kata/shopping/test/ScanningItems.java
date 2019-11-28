package kata.shopping.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import kata.shopping.Checkout;

public class ScanningItems {

    private int priceOfOneA;

    private Checkout checkout;

    @Before
    public void setUp() {
        priceOfOneA = 50;

        checkout = new Checkout(priceOfOneA);
    }

    /*

        Note:   We've removed the duplication ("50") that existed between the test and the
                production code, but the test name still mentions "50". Now there is a lack
                of symmetry between the test name and the body of the test.

                The test below this one (scanning two As) has solved this problem.

     */
    @Test
    public void scanningOneAGivesATotalPriceOf50() {
        checkout.scan('A');

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfOneA);
    }

    /*

        Note:   In this test there is a good symmetry between the test name, the scanning operations,
                the pricing rules, and the assertion.

     */
    @Test
    public void scanningTwoAsGivesATotalPriceOfTwoAs() {
        checkout.scan('A');
        checkout.scan('A');

        /*

            Note:   Although this variable isn't strictly required, it is an effective way of
                    communicating the pricing rules and clarifying the intent of the test.

         */
        int priceOfTwoAs = priceOfOneA * 2;

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfTwoAs);
    }

    @Test
    public void scanningOneBGivesATotalPriceOf30() {
        checkout.scan('B');

        assertThat(checkout.getTotalPrice()).isEqualTo(30);
    }
}
