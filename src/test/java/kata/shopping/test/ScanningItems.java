package kata.shopping.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import kata.shopping.Checkout;

public class ScanningItems {

    private int priceOfOneA;
    private int priceOfOneB;
    private int priceOfOneC;
    private int priceOfOneD;
    private int discountA, discountB, discountC, discountD;
    private int discountMultiplierA, discountMultiplierB, discountMultiplierC, discountMultiplierD;

    private Checkout checkout;

    @Before
    public void setUp() {
        priceOfOneA = 50;
        priceOfOneB = 30;
        priceOfOneC = 20;
        priceOfOneD = 15;
        discountA = 130; discountB = 45; discountC = 0; discountD = 0;
        discountMultiplierA = 3; discountMultiplierB = 2; discountMultiplierC = 0; discountMultiplierD = 0;

        checkout = new Checkout(priceOfOneA, priceOfOneB, priceOfOneC, priceOfOneD,
                    discountA, discountB, discountC, discountD,
                    discountMultiplierA, discountMultiplierB, discountMultiplierC, discountMultiplierD);
    }

    /*

        Note:   We've removed the duplication ("50") that existed between the test and the
                production code, but the test name still mentions "50". Now there is a lack
                of symmetry between the test name and the body of the test.

                The test below this one (scanning two As) has solved this problem.

     */
    @Test
    public void scanningOneAGivesATotalPriceOf50() {
        checkout.scan("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfOneA);
    }

    /*

        Note:   In this test there is a good symmetry between the test name, the scanning operations,
                the pricing rules, and the assertion.

     */
    @Test
    public void scanningTwoAsGivesATotalPriceOfTwoAs() {
        checkout.scan("A");
        checkout.scan("A");

        /*

            Note:   Although this variable isn't strictly required, it is an effective way of
                    communicating the pricing rules and clarifying the intent of the test.

         */
        int priceOfTwoAs = priceOfOneA * 2;

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfTwoAs);
    }

    @Test
    public void scanningOneBGivesATotalPriceOf30() {
        checkout.scan("B");

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfOneB);
    }

    @Test
    public void scanningTwoBsGivesATotalPriceOf45() {
        //int priceOfTwoBs = priceOfOneB * 2;
        checkout.scan("B");
        checkout.scan("B");

        assertThat(checkout.getTotalPrice()).isEqualTo(45);
    }

    @Test
    public void scanningThreeItemsInTheScanStringProducesSameAsThreeScans() {
        checkout.scan("AAA");

        assertThat(checkout.getTotalPrice()).isEqualTo(130);
    }

    @Test
    public void scanningSomethingOtherThanATOdGivesZero() {
        int priceOfNotAtoD = 0;
        checkout.scan("X");

        assertThat(checkout.getTotalPrice()).isEqualTo(priceOfNotAtoD);
    }

    @Test
    public void scanningSomethingComplex() {
        checkout.scan("XDCBADDADBBCAC");

        assertThat(checkout.getTotalPrice()).isEqualTo(325);
    }
}
