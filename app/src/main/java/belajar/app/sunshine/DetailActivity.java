package belajar.app.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by isfaaghyth on 12/11/16.
 */

public class DetailActivity extends AppCompatActivity {

    TextView txtJudul, txtDate, txtHumadity, txtPressure, txtWind, txtTemperature;
    ImageView imgSunshine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDate = (TextView) findViewById(R.id.txt_date);
        txtHumadity = (TextView) findViewById(R.id.txt_humadity);
        txtPressure = (TextView) findViewById(R.id.txt_pressure);
        txtWind = (TextView) findViewById(R.id.txt_wind);
        txtTemperature = (TextView) findViewById(R.id.txt_temperature);
        imgSunshine = (ImageView) findViewById(R.id.img_sunshine);
    }
}
