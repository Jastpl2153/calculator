import com.example.calculator.controller.UsualController;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsualCalculator {
    private UsualController calculatorController;

    @Before
    public void setUp() {
        calculatorController = new UsualController();
    }

    @Test
    public void testAddition() {
        String result = calculatorController.calculate(5, 3, "+");
        Assert.assertEquals("8.0", result);
    }

    @Test
    public void testSubtraction() {
        String result = calculatorController.calculate(5, 3, "-");
        Assert.assertEquals("2.0", result);
    }

    @Test
    public void testMultiplication() {
        String result = calculatorController.calculate(5, 3, "×");
        Assert.assertEquals("15.0", result);
    }

    @Test
    public void testDivision() {
        String result = calculatorController.calculate(6, 2, "÷");
        Assert.assertEquals("3.0", result);
    }

    @Test
    public void testDivisionByZero() {
        String result = calculatorController.calculate(6, 0, "÷");
        Assert.assertEquals("ERROR", result);
    }

    @Test
    public void testPercentage() {
        String result = calculatorController.calculate(100, 20, "%");
        Assert.assertEquals("20.0", result);
    }
}
