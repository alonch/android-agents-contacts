package arsp.com.helloworld;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by alonch on 16/03/15.
 */
public class AgentsListFragment extends ListFragment{

    private MainActivity mainActivity;
    private AgentsAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        adapter = new AgentsAdapter(activity);
        setListAdapter(adapter);
        AgentsModel.getInstance(activity).getAllAsync(new Async<Agent[]>() {
            @Override
            public void onSuccess(Agent[] data) {
                adapter.addAll(data);
                adapter.setSelected(0);
                mainActivity.setDetails(data[0]);
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        adapter.setSelected(position);
        mainActivity.setDetails((Agent) l.getItemAtPosition(position));
    }

}
