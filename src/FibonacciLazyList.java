public class FibonacciLazyList implements ILazyList<Integer>{

    private int n;
    private int fibonacci;
    private int prevFib;
    private int prevPrevFib;

    FibonacciLazyList(){
        this.n = 0;
        this.fibonacci = 0;
        this.prevFib = 1;
        this.prevPrevFib = 0;
    }

    @Override
    public Integer next() {
        if(this.n == 0){
            return 0;
        }
        else if(this.n == 1){
            return 1;
        }
        this.fibonacci = prevPrevFib + prevFib;
        this.prevPrevFib = this.prevFib;
        this. prevFib = this.fibonacci;
        this.n++;
        return this.fibonacci;
    }
}
