import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalLazyListTest {

    @Test
    public void test() {
        multiplesOfThreeTest();
        powersOfThreeTest();
        divideByTwoTest();
    }

    @Test
    public void multiplesOfThreeTest(){
        ILazyList<Integer> mtll = new FunctionalLazyList<>( x -> (int) x + 3, 0);
        assertAll(
                () -> assertEquals(0, mtll.next()),
                () -> assertEquals(3, mtll.next()),
                () -> assertEquals(6, mtll.next()),
                () -> assertEquals(9, mtll.next()),
                () -> assertEquals(12, mtll.next())
        );
    }

    @Test
    public void powersOfThreeTest(){
        ILazyList<Integer> mtll = new FunctionalLazyList<>( x -> (int) x * 3, 1);
        assertAll(
                () -> assertEquals(1, mtll.next()),
                () -> assertEquals(3, mtll.next()),
                () -> assertEquals(9, mtll.next()),
                () -> assertEquals(27, mtll.next()),
                () -> assertEquals(81, mtll.next())
        );
    }

    @Test
    public void divideByTwoTest(){
        ILazyList<Integer> mtll = new FunctionalLazyList<>( x -> (int) x / 2, 100);
        assertAll(
                () -> assertEquals(100, mtll.next()),
                () -> assertEquals(50, mtll.next()),
                () -> assertEquals(25, mtll.next())
        );
    }
}
