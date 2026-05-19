import java.util.ArrayList;
import java.util.List;

public class T implements X {

    private List<X> obj = new ArrayList<>();

    void add(X a) {
        obj.add(a);
    }

    @Override
    public int m() {
        if  (obj.isEmpty()) {
            return 0;
        };

        return obj.stream().mapToInt(X::m).sum();
    }
}
