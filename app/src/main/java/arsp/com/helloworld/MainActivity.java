package arsp.com.helloworld;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private List<Agent> agents;
    private Hashtable<String, TextView> fields;
    private final String[] names = new String[]{
            "id",
            "first",
            "last",
            "phone",
            "mail",
            "address"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initFields();
            final ListView agentsList = (ListView) findViewById(R.id.agentsList);
            final AgentsAdapter adapter = new AgentsAdapter(this, this);
            agentsList.setAdapter(adapter);
            agentsList.setOnItemClickListener(adapter);
            AgentsModel.getInstance(this).getAllAsync(new Async<Agent[]>() {
                @Override
                public void onSuccess(Agent[] data) {
                    adapter.addAll(data);
                    adapter.setSelected(0);
                    setAgent(data[0]);
                }
            });
        }catch (Exception ex){
            Log.e("Exploded", ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void initFields() throws Exception {
        fields = new Hashtable<>();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Field field = R.id.class.getField(name);
            int id = field.getInt(null);
            fields.put(name, (TextView) findViewById(id));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        setAgent((Agent) parent.getItemAtPosition(position));
    }

    public void setAgent(Agent agent) {
        try {
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                String fieldName = "get";
                fieldName += name.substring(0, 1).toUpperCase();
                fieldName += name.substring(1);
                Method getter = Agent.class.getMethod(fieldName);
                fields.get(name).setText(getter.invoke(agent).toString());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
