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
public class AgentsAdapter extends ArrayAdapter<Agent>{

    private int selected = -1;

    public AgentsAdapter(Context context) {
        super(context, R.layout.agent_item, R.id.name);
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
        view.setBackgroundResource(color);
        return view;
    }
}
