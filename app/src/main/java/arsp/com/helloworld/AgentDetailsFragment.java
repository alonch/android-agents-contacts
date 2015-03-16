package arsp.com.helloworld;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * Created by alonch on 16/03/15.
 */
public class AgentDetailsFragment extends Fragment implements AgentDetailsInterface{
    private AgentFields fields;

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.agent_details, container);
        try {
            fields = new AgentFields(view);
        }catch (Exception ex){
            Log.e("Exploded", ex.getMessage());
            ex.printStackTrace();
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        mainActivity.setDetailsInterface(this);
    }

    @Override
    public void setAgent(Agent agent) {
        String[] names = fields.getFieldNames();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            fields.get(name).set(agent);
        }
    }
}
