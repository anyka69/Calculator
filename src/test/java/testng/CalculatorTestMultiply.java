package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.Calculator;

public class CalculatorTestMultiply {
    private Calculator calculator;
    @BeforeClass
    public void createCalculator(){
        calculator =new Calculator();
    }
    @DataProvider(name = "Данные для суммирования")
    public Object[][] dataForMinus() {
        return new Object[][]{
                {1,2,2},
                {-1,-2,2},
                {0,1,0},
                {1.2,0.2,0.24}
        };
    }
    @Test(dataProvider = "Данные для суммирования")
    public void testMul(double a, double b, double expectedResult){
        double multiply =calculator.multiply(a,b);
        Assert.assertEquals(multiply,expectedResult,"Ошибка при умножении");
    }
}
