import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LazyListTakeTest {

    @Test
    public void test() {

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
}
