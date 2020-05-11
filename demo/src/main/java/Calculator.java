import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> history = new ArrayList<>();

    public int add(int a, int b) {
        int result = a+b;
        addToHistory(result);
        return result;
    }

    public int minus(int a, int b) {
        int result = a-b;
        addToHistory(result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a*b;
        addToHistory(result);
        return result;
    }

    public int divide(int divident, int divisor) throws DivideByZeroException {
        if(divisor == 0)
            throw new DivideByZeroException();
        int result = divident/divisor;
        addToHistory(result);
        return result;
    }

    private void addToHistory(int result) {
        history.add(result);
    }

    public List<Integer> getHistory() {
        return history;
    }
}
