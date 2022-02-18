package ForMarina.TestSuiteJunit;


import org.junit.Test;



public class MyTestcase1 {


    @Test(expected = ArithmeticException.class)
    public void testJUnitMessage() {

        System.out.println("Junit Message is printing ");


    }

    @Test
    public void testJUnitHiMessage() {
        System.out.println("19229");
    }
}
