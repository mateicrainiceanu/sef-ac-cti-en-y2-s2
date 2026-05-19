public class S implements X {

    private T objT;

    public S(T x) {
        this.objT = x;
    }


    @Override
    public int m() {
        if (objT == null) return 1;
        return 1 + this.objT.m();
    }
}
