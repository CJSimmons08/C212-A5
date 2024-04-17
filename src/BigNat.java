import java.util.ArrayList;
import java.util.List;

public class BigNat implements Comparable<BigNat>{

    List<Integer> list = new ArrayList<>();

    public BigNat(String s){
        for(int i = s.length() - 1; i >= 0; i--){
            list.add((int) s.charAt(i));
        }
    }

    public void add(BigNat bn){
        int smallestSize = Math.min(list.size(), bn.list.size());
        for(int i = 0; i < Math.max(list.size(), bn.list.size()); i++){
            int firstNum = 0;
            int secondNum = 0;
            if(i < list.size()){
                firstNum = list.get(i);
            }
            if(i < bn.list.size()){
                secondNum = bn.list.get(i);
            }
            int remainder = (firstNum + secondNum) % 10;
            int tensPlace = ((firstNum + secondNum) - remainder) /10;
            if(i >= list.size()){
                list.add(remainder);
            }
            else{
                list.set(i, remainder);
                list.set(i + 1, list.get(i + 1) + tensPlace);
            }
            if(i == list.size() - 1){
                list.add(tensPlace);
            }
            else{
                list.set(i, remainder);
                list.set(i + 1, list.get(i + 1) + tensPlace);
            }
        }
        if(list.size() < bn.list.size()){
            for(int i = smallestSize; i < bn.list.size(); i++){
                list.add(bn.list.get(i));
            }
        }
    }

    public void sub(BigNat bn){
        if(this.compareTo(bn) < 0){
            list.clear();
            list.add(0);
        }
    }


    @Override
    public Object clone(){
        List<Integer> newList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            newList.add(list.get(i));
        }
        return new BigNat(String.valueOf(newList));
    }

    @Override
    public String toString(){
        return String.valueOf(this);
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }
        if(list.size() != ((BigNat) obj).list.size()){
            return false;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != ((BigNat) obj).list.get(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(BigNat b) {
        if(list.size() < b.list.size()){
            return -1;
        }
        else if (list.size() > b.list.size()) {
            return 1;
        }
        else {
            for(int i = list.size() - 1; i >= 0; i--){
                if(list.get(i) < b.list.get(i)){
                    return -1;
                }
                else if(list.get(i) > b.list.get(i)){
                    return 1;
                }
            }
        }
        return 0;
    }
}
