package kata.shopping;
//  Item   Unit      Special
//         Price     Price
//  --------------------------
//   A     50       3 for 130
//   B     30       2 for 45
//   C     20
//   D     15
//   all others will be zero price.
//
public class Checkout {

    private int priceOfOneA, priceOfOneB, priceOfOneC, priceOfOneD;
    private int tallyA, tallyB, tallyC, tallyD;
    private int discountA, discountB, discountC, discountD;
    private int discountMultiplierA, discountMultiplierB, discountMultiplierC, discountMultiplierD;

    private int totalPrice;

    public Checkout(int priceOfOneA, int priceOfOneB, int priceOfOneC, int priceOfOneD,
                    int discountA, int discountB, int discountC, int discountD,
                    int discountMultiplierA, int discountMultiplierB, int discountMultiplierC, int discountMultiplierD) {
        this.priceOfOneA = priceOfOneA;
        this.priceOfOneB = priceOfOneB;
        this.priceOfOneC = priceOfOneC;
        this.priceOfOneD = priceOfOneD;
        this.discountA = discountA;
        this.discountB = discountB;
        this.discountC = discountC;
        this.discountD = discountD;
        this.discountMultiplierA = discountMultiplierA;
        this.discountMultiplierB = discountMultiplierB;
        this.discountMultiplierC = discountMultiplierC;
        this.discountMultiplierD = discountMultiplierD;
    }

    public void scan(String itemCodesString) {
        // convert String of item codes to char[] array
        char[] items = itemCodesString.toCharArray();

        // iterate over items array using loop
        for (char nextItem : items) {
        // test in which nextItem category (A, B, C, D) it falls?
            switch (nextItem) {
                case 'A':
                    tallyA += 1;
                    break;
                case 'B':
                    tallyB += 1;
                    break;
                case 'C':
                    tallyC += 1;
                    break;
                case 'D':
                    tallyD += 1;
                    break;
            }
        }
    }

    /*
    Cycle through the item-types (A, B, C, D), adding to total as we go...
     */
    public int getTotalPrice() {
        totalPrice += workOutDiscountsAndTotalPriceForItemTally(tallyA, discountMultiplierA, priceOfOneA, discountA);
        totalPrice += workOutDiscountsAndTotalPriceForItemTally(tallyB, discountMultiplierB, priceOfOneB, discountB);
        totalPrice += workOutDiscountsAndTotalPriceForItemTally(tallyC, discountMultiplierC, priceOfOneC, discountC);
        totalPrice += workOutDiscountsAndTotalPriceForItemTally(tallyD, discountMultiplierD, priceOfOneD, discountD);
        System.out.println ("Total price: " + totalPrice);
        return totalPrice;
    }

    /*
    This is the gubbins of the routine that works everything out based on the tally of each item-type (A, B, C, D) then multiplies
    it by the price, taking into consideration any discounts offered.
    If no Discount is specified, then we avoid 'divide by zero' errors by skipping that.
     */
    public int workOutDiscountsAndTotalPriceForItemTally(int tally, int discountMultiplier, int price, int discountPrice) {
        int totalPriceForItemTally = 0;
        if (discountPrice != 0) {
            totalPriceForItemTally = (tally / discountMultiplier) * discountPrice;
            totalPriceForItemTally += (tally % discountMultiplier) * price;
        } else {
            totalPriceForItemTally += tally * price;
        }
        return totalPriceForItemTally;
    }
}
