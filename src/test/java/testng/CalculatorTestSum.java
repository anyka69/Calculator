package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.Calculator;

public class CalculatorTestSum {
    private Calculator calculator;
    @BeforeClass
    public void createCalculator(){
        calculator =new Calculator();
    }
    @DataProvider(name = "Данные для суммирования")
    public Object[][] dataForSum() {
        return new Object[][]{
                {1,2,3},
                {-1,-2,-3},
                {0,1,1},
                {5.2,5.3,10.5}
        };
    }
    @Test(dataProvider = "Данные для суммирования")
    public void testSum(double a, double b, double expectedResult){
        double sum =calculator.sum(a,b);
        Assert.assertEquals(sum,expectedResult,"Суммирование");
    }
}
