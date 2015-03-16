package arsp.com.helloworld;

import android.widget.TextView;

import java.lang.reflect.Method;

/**
 * Created by alonch on 16/03/15.
 */
public class FieldMapper {

    private final TextView textView;
    private final Method getter;

    public FieldMapper(TextView textView, Method getter){
        this.textView = textView;
        this.getter = getter;
    }

    public void set(Agent agent) {
        textView.setText(get(agent));
    }

    public String get(Object obj) {
        try {
            return getter.invoke(obj).toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }
}
