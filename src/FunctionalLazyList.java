import java.util.function.Function;

public class FunctionalLazyList <T, I, R> implements ILazyList{

    Function<I, R> f;
    T initialValue;

    public FunctionalLazyList(Function<I, R> f, T t){
        this.f = f;
        this.initialValue = t;
    }


    @Override
    public Object next() {
        T previous = initialValue;
        initialValue = (T) f.apply((I) initialValue);
        return previous;
    }
}
