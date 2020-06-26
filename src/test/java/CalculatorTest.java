import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    String testsum1;
    String testsum2;
    String testsub1;
    String testsub2;
    String testmult1;
    String testmult2;
    String testdiv1;
    String testdiv2;
    String testmulti1;
    String testinvalid1;

    Facade calc;

    @BeforeMethod
    public void setup() throws Exception {

        testsum1 = "25+30";
        testsum2 = "4+963";
        testsub1 = "420-69";
        testsub2 = "96-785";
        testmult1 = "666*1234";
        testmult2 = "55*8564";
        testdiv1 = "40/20";
        testdiv2 = "128/2";
        testmulti1 = "25+30*20-50/2";
        testinvalid1 = "a+25*10";

    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testSum1() throws Exception{
        calc = new Facade(testsum1);
        double output = calc.eval();
        Assert.assertEquals(25+30, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testSum2() throws Exception{
        calc = new Facade(testsum2);
        double output = calc.eval();
        Assert.assertEquals(4+963, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testSub1() throws Exception{
        calc = new Facade(testsub1);
        double output = calc.eval();
        Assert.assertEquals(420-69, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testSub2() throws Exception{
        calc = new Facade(testsub2);
        double output = calc.eval();
        Assert.assertEquals(96-785, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testMult1() throws Exception{
        calc = new Facade(testmult1);
        double output = calc.eval();
        Assert.assertEquals(666*1234, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testMult2() throws Exception{
        calc = new Facade(testmult2);
        double output = calc.eval();
        Assert.assertEquals(55*8564, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testDiv1() throws Exception{
        calc = new Facade(testdiv1);
        double output = calc.eval();
        Assert.assertEquals(40/20, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testDiv2() throws Exception{
        calc = new Facade(testdiv2);
        double output = calc.eval();
        Assert.assertEquals(128/2, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testMultiv1() throws Exception{
        calc = new Facade(testmulti1);
        double output = calc.eval();
        Assert.assertEquals(25+30*20-50/2, output);
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testInvalid1() throws Exception{
        try{
            calc = new Facade(testinvalid1);
            float output = calc.eval();
        }
        catch (NumberFormatException e){
            Assert.assertEquals(e instanceof NumberFormatException, true);
        }

    }
}