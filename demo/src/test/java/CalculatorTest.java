import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculatorTest {
    @Test
    void test() {
        Calculator calc = new Calculator();

        int result = calc.add(3, 2);

        assertThat(result, is(5));
    }

}
