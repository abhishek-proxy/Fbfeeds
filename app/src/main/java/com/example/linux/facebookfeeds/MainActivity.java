package com.example.linux.facebookfeeds;

import android.hardware.camera2.params.Face;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {
    ListView feeds;
    TextView dummy;
    FacebookAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feeds = (ListView) findViewById(R.id.feeds);
        dummy = (TextView) findViewById(R.id.dummy);
        api = initializeRetrofit();
        getDataFromFacebookAPI();
    }

    private void getDataFromFacebookAPI() {
            api.getFacebookfeeds(Constants.PAGE_ID, Constants.APP_TOKEN, new Callback<FacebookFeeds>() {
                @Override
                public void success(FacebookFeeds facebookFeeds, Response response) {
                    displayFeeds(facebookFeeds);


                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

    }

    private void displayFeeds(FacebookFeeds facebookFeeds) {
        List<Event> events = new ArrayList<Event>(facebookFeeds.getData());
        dummy.setText(events.toString());
        ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(this,
                android.R.layout.simple_list_item_1, events);
        feeds.setAdapter(adapter);
    }

    private FacebookAPI initializeRetrofit() {
        FacebookAPI iwagService = restAdapterBuilder().setEndpoint(Constants.BASE_URL).setLogLevel(RestAdapter.LogLevel.FULL).build().create(
                FacebookAPI.class);
        return iwagService;
    }

    private RestAdapter.Builder restAdapterBuilder() {
        return new RestAdapter.Builder().setConverter(new GsonConverter(new GsonBuilder().create()));
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
}
