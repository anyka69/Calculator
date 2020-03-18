package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestDivision {
    private Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator();
    }

    @DataProvider(name = "Данные для прои")
    public Object[][] dataForMinus() {
        return new Object[][]{
                {1, 2, 0.5},
                {4, -2, -2},
                {0, 1, 0},
                {1.2, 0.2, 0.24}
        };
    }

    @Test(dataProvider = "Данные для прои")
    public void testMul(double a, double b, double expectedResult) {
        double multiply = calculator.multiply(a, b);
        Assert.assertEquals(multiply, expectedResult, "Ошибка при произведении");
    }

    @DataProvider(name = "Данные при дел на 0")
    public Object[][] divisionby0() {
        return new Object[][]{
                {1, 0, 0.5}
        };
    }

    @Test(dataProvider = "Данные при делении на 0", enabled = false)
    public void testPros(double a, double b, double expectedResult) {
        double multiply = calculator.multiply(a, b);
        Assert.assertEquals(multiply, expectedResult, "Ошибка при произведении");
    }
}
