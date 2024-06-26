import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class LazyListTakeTest {

    @Test
    public void test() {
        fibonacciUpTo5Test();
        fibonacciUpTo20Test();
    }

    @Test
    public void fibonacciUpTo5Test(){
        ILazyList<Integer> fib = new FibonacciLazyList();
        LazyListTake<Integer> take = new LazyListTake<>(fib, 6);
        List<Integer> testList = new ArrayList<>();
        testList = take.getList();

        List<Integer> finalTestList = testList;
        assertAll(
                () -> assertEquals(0, finalTestList.get(0)),
                () -> assertEquals(1, finalTestList.get(1)),
                () -> assertEquals(1, finalTestList.get(2)),
                () -> assertEquals(2, finalTestList.get(3)),
                () -> assertEquals(3, finalTestList.get(4)),
                () -> assertEquals(5, finalTestList.get(5))
        );
    }

    @Test
    public void fibonacciUpTo20Test(){
        ILazyList<Integer> fib = new FibonacciLazyList();
        LazyListTake<Integer> take = new LazyListTake<>(fib, 21);
        List<Integer> testList = new ArrayList<>();
        testList = take.getList();

        List<Integer> finalTestList = testList;
        try{
            assertEquals(6765, finalTestList.get(20));
        }
        catch (Exception e){
            fail(e.toString());
        }
    }
}
