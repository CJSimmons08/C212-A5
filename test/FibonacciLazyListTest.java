import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciLazyListTest {

    @Test
    public void test() {
        fibonacciUpTo5Test();
        fibonacciUpTo20Test();
    }

    @Test
    public void fibonacciUpTo5Test(){
        ILazyList<Integer> fib = new FibonacciLazyList();
        assertAll(
                () -> assertEquals(0, fib.next()),
                () -> assertEquals(1, fib.next()),
                () -> assertEquals(1, fib.next()),
                () -> assertEquals(2, fib.next()),
                () -> assertEquals(3, fib.next()),
                () -> assertEquals(5, fib.next())
        );
    }

    @Test
    public void fibonacciUpTo20Test(){
        String testDescription = "testing fib.next() up to 20";
        ILazyList<Integer> fib = new FibonacciLazyList();
        for(int i = 0; i < 20; i++){
            fib.next();
        }
        try{
            assertEquals(6765, fib.next());
        }
        catch (Exception e){
            fail(testDescription + e.toString());
        }
    }


}
