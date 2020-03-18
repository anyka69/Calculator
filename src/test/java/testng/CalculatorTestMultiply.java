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
                {1,2,-1},
                {-1,-2,1},
                {0,1,-1},
                {5.4,5.2,0.2}
        };
    }
    @Test(dataProvider = "Данные для суммирования")
    public void testMul(double a, double b, double expectedResult){
        double multiply =calculator.minus(a,b);
        Assert.assertEquals(multiply,expectedResult,"Ошибка при умножении");
    }
}
