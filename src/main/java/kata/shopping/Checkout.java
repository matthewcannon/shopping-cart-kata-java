package kata.shopping;

public class Checkout {

    private int priceOfOneA;

    private int totalPrice;

    public Checkout(int priceOfOneA) {
        this.priceOfOneA = priceOfOneA;
    }

    /*

        Note:   The parameter name ('a') is now inaccurate.

     */
    public void scan(char a) {
        if (a == 'A') {
            totalPrice += priceOfOneA;
        } else {
            totalPrice = 30;
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
