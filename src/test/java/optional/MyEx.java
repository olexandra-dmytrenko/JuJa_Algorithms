package optional;

/**
 * Created by olexandra on 10/15/19.
 */
public class MyEx extends RuntimeException {
    public MyEx(Throwable e) {
        super("I'm a wrapper over Exception", e);
    }

}
