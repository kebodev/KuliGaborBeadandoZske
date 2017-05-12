/*
Kuli Gábor beadandó feladat
 */

package com.kebodev.kulig;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ListFragment mListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            startDownload();
        }

    }

    private void showListFragment(ArrayList<Matches> repositories) {
        System.out.println("called...");
        mListFragment = ListFragment.newInstance(repositories);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mListFragment).
                commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }


    private void startDownload() {

        getMatchDataAsync("http://api.football-data.org/alpha/fixtures");

    }


    public void downloadComplete(ArrayList<Matches> matches) {
        showListFragment(matches);

    }


    private void getMatchDataAsync(String url) {
        System.out.println("called...");
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url + "?X-Auth-Token=8f4ae4575423487a8c11f2e39fca7851",
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            downloadComplete(Util.retrieveRepositoriesFromResponse(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);

    }


}
