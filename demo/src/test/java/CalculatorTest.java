import org.junit.jupiter.api.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static Calculator calc;

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @Test
    void addTest() {
        int result = calc.add(3, 2);

        assertThat(result, is(5));
    }

    @Test
    @Disabled
    void addTestWithNegativeNumbers() {
        int result = calc.add(-4, 1);

        assertThat(result, is(-3));
    }

    @Test
    void minusTest() {
        int result = calc.minus(10, 7);

        assertThat(result, is(3));
    }

    @RepeatedTest(10)
    void minusTest2() {
        int result = calc.minus(10, 7);

        assertThat(result, is(3));
    }

    @Test
    void multiplyTest() {
        int result = calc.multiply(10, 7);

        assertThat(result, is(70));
    }

    @Disabled
    @Test
    @Timeout(value = 1)
    void multiplyTestWithTimeout() {
        int result = calc.multiply(10, 7);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(result, is(70));
    }

    @Test
    void divideTest() throws DivideByZeroException {
        int result = calc.divide(20, 4);

        assertThat(result, is(5));
    }

    @Test
    void divideZeroTest() throws DivideByZeroException {

        assertThrows(DivideByZeroException.class, () -> calc.divide(20, 0));
    }

    @Test
    void historyTest() {
        calc.add(5, 5);
        calc.minus(10, 8);
        calc.multiply(2, 4);

        List<Integer> result = calc.getHistory();

        assertThat(result, contains(10, 2, 8));
    }

}
