import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CyclicLazyList <T> implements ILazyList<T>{

    List<T> cyclicList = new ArrayList<>();
    int currentIndex;
    int nextIndex;

    @SafeVarargs
    public CyclicLazyList(T... values){
        currentIndex = 0;
        nextIndex = 1;
        Collections.addAll(cyclicList, values);
    }

    @Override
    public T next() {
        int tmpIndex = currentIndex;
        if(currentIndex == cyclicList.size() - 1){
            currentIndex = 0;
            nextIndex = 1;
            return cyclicList.get(tmpIndex);
        }
        currentIndex++;
        nextIndex++;
        return cyclicList.get(tmpIndex);
    }
}
