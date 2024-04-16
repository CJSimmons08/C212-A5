import java.util.ArrayList;
import java.util.List;

public class BigNat {

    List<Integer> list = new ArrayList<>();

    public BigNat(String s){
        for(int i = s.length() - 1; i >= 0; i--){
            list.add((int) s.charAt(i));
        }
    }


    @Override
    public Object clone(){
        return new BigNat(list.toString());
    }

    @Override
    public String toString(){
        return String.valueOf(this);
    }
}
