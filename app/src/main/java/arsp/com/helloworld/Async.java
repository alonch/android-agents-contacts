package arsp.com.helloworld;

/**
 * Created by alonch on 12/03/15.
 */
public interface Async<T> {
    void onSuccess(T data);
    //void onFail();
}
