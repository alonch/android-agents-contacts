package arsp.com.helloworld;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

/**
 * Created by alonch on 12/03/15.
 */
public class GsonRequest extends StringRequest {

    public GsonRequest(String url, final Async<Agent[]> async) {
        super(url, new Response.Listener<String>(){

            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Agent[] agents = gson.fromJson(s, Agent[].class);
                async.onSuccess(agents);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Request", volleyError.toString());
                volleyError.printStackTrace();
            }
        });

    }

}
