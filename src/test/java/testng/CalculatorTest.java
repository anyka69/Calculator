package testng;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeClass
    public void createCalculator(){
        calculator =new Calculator();
    }
    @DataProvider(name = "Данные для суммирования")
    public Object[][] dataForSum() {
        return new Object[][]{
                {1,2,3},
                {-1,-2,-3}
        };
    }
    @Test(dataProvider = "Данные для суммирования")
    public void testSum(double a, double b, double expectedResult){
        double sum =calculator.sum(a,b);
        Assert.assertEquals(sum,expectedResult,"Суммирование");
    }
    @Parameters({"a","b"})
    @Test(expectedExceptions = {ArithmeticException.class})
    public void division(@Optional("0") double a, @Optional("0") double b){
        calculator.division(a,b);
    }
    @Test(retryAnalyzer = Retry.class)
    public void flackyTest(){
        if(new Random().nextBoolean()){
            throw new ArithmeticException();
        }

    }
}
