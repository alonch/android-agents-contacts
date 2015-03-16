package arsp.com.helloworld;

import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * Created by alonch on 16/03/15.
 */
public class AgentFields extends Hashtable<String, FieldMapper>{
    private View view;
    private final String[] names = new String[]{
            "id",
            "first",
            "last",
            "phone",
            "mail",
            "address"
    };

    public AgentFields(View view) {
        this.view = view;
        try {
            initFields();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void initFields() throws Exception{
        for (int i = 0; i < names.length; i++) {
            initField(names[i]);
        }
    }

    private void initField(String name) throws Exception{
        final TextView textView = findTextView(name);
        final Method getter = findGetter(name);
        put(name, new FieldMapper(textView, getter));
    }

    private TextView findTextView(String name) throws Exception {
        Field generatedFieldId= R.id.class.getField(name);
        int viewId = generatedFieldId.getInt(null);
        return (TextView) view.findViewById(viewId);
    }

    private Method findGetter(String name) throws NoSuchMethodException {
        String fieldName = "get";
        fieldName += name.substring(0, 1).toUpperCase();
        fieldName += name.substring(1);
        return Agent.class.getMethod(fieldName);
    }

    public String[] getFieldNames(){
        return names;
    }

}
