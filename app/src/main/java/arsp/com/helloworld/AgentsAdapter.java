package arsp.com.helloworld;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alonch on 12/03/15.
 */
public class AgentsAdapter extends ArrayAdapter<Agent> implements AdapterView.OnItemClickListener{

    private int selected = -1;
    AdapterView.OnItemClickListener listener;

    public AgentsAdapter(Context context, AdapterView.OnItemClickListener listener) {
        super(context, R.layout.agent_item, R.id.name);
        this.listener = listener;
    }

    public void setSelected(int position) {
        this.selected = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView idField = (TextView) view.findViewById(R.id.id);
        String idText = String.valueOf(getItem(position).getId());
        idField.setText(idText);
        int color;
        if (selected == position){
            color = R.color.background_holo_dark;
        }else{
            color = R.color.background_holo_light;
        }
        //color = Resources.getSystem().getColor(color);
        view.setBackgroundResource(color);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        setSelected(position);
        listener.onItemClick(parent, view, position, id);
    }
}
