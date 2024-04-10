import java.util.ArrayList;
import java.util.List;

public class  LazyListTake <T> implements ILazyList {

    int numElements;
    ILazyList<T> intakeList;

    public LazyListTake(ILazyList<T> list, int n){
        this.numElements = n;
        this.intakeList = list;
    }

    public List<T> getList(){
        List<T> returnList = new ArrayList<>();
        for(int i = 0; i < numElements; i++){
            returnList.add(intakeList.next());
        }
        return returnList;
    }

    @Override
    public Object next() {
        return null;
    }
}
