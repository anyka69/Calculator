package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.Calculator;

public class CalculatorTestMinus {
    private Calculator calculator;
    @BeforeClass
    public void createCalculator(){
        calculator =new Calculator();
    }
    @DataProvider(name = "Данные для вычитания")
    public Object[][] dataForMinus() {
        return new Object[][]{
                {1,2,-1},
                {-1,-2,1},
                {0,1,-1},
                {5.4,5.2,0.2}
        };
    }
    @Test(dataProvider = "Данные для вычитания")
    public void testMinus(double a, double b, double expectedResult){
        double minus =calculator.minus(a,b);
        Assert.assertEquals(minus,expectedResult,"Ошибка при вычитании");
    }
}
