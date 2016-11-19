package belajar.app.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import belajar.app.sunshine.Controllers.Adapter.ListAdapter;
import belajar.app.sunshine.Controllers.CloudConnecting;
import belajar.app.sunshine.Controllers.CloudResult;
import belajar.app.sunshine.Controllers.CloudURL;

public class MainActivity extends AppCompatActivity {

    CloudConnecting cloudConnecting;
    CloudURL url;

    TextView txtTime, txtCelcius, txtLocation;
    ImageView imgSunshine;

    RecyclerView lstSunshineItem;
    LinearLayoutManager linearLayoutManager;
    ListAdapter listAdapter;
    ItemObject.ListWeather listWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0); //menghilangkan shadow di actionbar

        linearLayoutManager = new LinearLayoutManager(this);

        //casting
        txtTime = (TextView) findViewById(R.id.txt_time);
        txtCelcius = (TextView) findViewById(R.id.txt_celcius);
        txtLocation = (TextView) findViewById(R.id.txt_location);
        imgSunshine = (ImageView) findViewById(R.id.img_sunshine);
        lstSunshineItem = (RecyclerView) findViewById(R.id.lst_sunshine_item);
        lstSunshineItem.setLayoutManager(linearLayoutManager);
        getCurrentWeather(); //parsing data dari openweathermap.org
        getListWeather();
    }

    private void getListWeather() {
        cloudConnecting = new CloudConnecting();
        cloudConnecting.getData(getApplicationContext(),
                url.getListWeather(), new CloudResult() {
                    @Override
                    public void resultData(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        listWeather = gson.fromJson(response, ItemObject.ListWeather.class);
                        listAdapter = new ListAdapter(getApplicationContext(), listWeather.getList());
                        lstSunshineItem.setAdapter(listAdapter);
                    }

                    @Override
                    public void errorResultData(String errorResponse) {

                    }
                });
    }

    private void getCurrentWeather() {
        cloudConnecting = new CloudConnecting();
        cloudConnecting.getData(getApplicationContext(),
                url.getCurrentWeather(), new CloudResult() {
                    @Override
                    public void resultData(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        ItemObject.CurrentWeather currentWeather = gson.fromJson(
                                response, ItemObject.CurrentWeather.class);

                        txtLocation.setText(currentWeather.getName());
                        txtCelcius.setText(currentWeather.getMain().getTemp() + "\u2103");

                        Glide.with(getApplicationContext())
                                .load("http://openweathermap.org/img/w/" +
                                        currentWeather.weather.get(0).getIcon() + ".png")
                                .centerCrop()
                                .placeholder(R.drawable.no_image)
                                .crossFade()
                                .into(imgSunshine);
                    }

                    @Override
                    public void errorResultData(String errorResponse) {
                        Log.d("Error", errorResponse);
                    }
                });
    }
}
