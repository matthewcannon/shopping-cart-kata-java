package kata.shopping;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/*

    Concern
    Context
    Observation

 */
public class ScanningItems {

    private int priceOfA = 50;

    private int priceOfB = 30;

    private int totalPrice;

    private int count = 0;

    @Before
    public void setUp() {
        totalPrice = 0;
    }

    @Test
    public void scanningOneAGivesATotalPriceOfA() {
        totalPrice = scan('A');

        assertThat(totalPrice).isEqualTo(priceOfA);
    }

    @Test
    public void scanningOneBGivesAtotalPriceOfB(){
        totalPrice = scan('B');

        assertThat(totalPrice).isEqualTo(priceOfB);

    }

    @Test
    public void scanningTwoAGivesATotalPriceOfTwoA() {
        scanMultipleItems('A', 'A');

        assertThat(totalPrice).isEqualTo(100);
    }

    @Test
    public void scanningTwoBGivesATotalPriceOfTwoB() {
        scanMultipleItems('B', 'B');

        assertThat(totalPrice).isEqualTo(60);
    }

    @Test
    public void scanningOneAAndOneBGivesASumOfOneAAndOneB() {
        scanMultipleItems('A', 'B');

        assertThat(totalPrice).isEqualTo(80);
    }

    @Test
    public void scanningThreeAGivesTotalPriceOf120() {
        scanMultipleItems('A', 'A', 'A');

        assertThat(totalPrice).isEqualTo(120);
    }


//    private int scanMultipleItems(char... itemCodes) {
//        int total = 0;
//        for (char itemCode: itemCodes) {
//            total += scan(itemCode);
//        }
//        return total;
//    }

    private void scanMultipleItems(char... itemCodes) {
        for (char itemCode: itemCodes) {
            totalPrice += scan(itemCode);

            if (itemCode == 'A') {
                count+= 1;

                if(count % 3 == 0) {
                    totalPrice = totalPrice - 30;
                }
            }
        }
    }

    private int scan(char itemCode) {
        switch(itemCode){
            case 'A' :
                return priceOfA;
            case 'B' :
                return priceOfB;
            default:
                return 0;
        }
    }
}
