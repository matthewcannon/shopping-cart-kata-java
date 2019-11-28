package kata.shopping;

import org.junit.Test;

public class ScanningItems {

    @Test
    public void scanningOneAGivesATotalPriceOf50() {
        scanner.scan('A');

        assertThat(scanner.getTotalPrice()).isEqualTo(50);
    }
}
