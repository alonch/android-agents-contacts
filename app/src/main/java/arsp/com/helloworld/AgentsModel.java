package arsp.com.helloworld;

import android.app.DownloadManager;
import android.app.Notification;
import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alonch on 12/03/15.
 */
public class AgentsModel {
    private static AgentsModel INSTANCE;
    private final RequestQueue queue;
    private Context context;

    public static AgentsModel getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new AgentsModel(context);
        }
        return INSTANCE;
    }

    private AgentsModel(Context context){
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public void getAllAsync(Async<Agent[]> agents){
        String url = "http://10.163.101.154:1111/agents";
        GsonRequest request = new GsonRequest(url, agents);
        queue.add(request);
    }


}

