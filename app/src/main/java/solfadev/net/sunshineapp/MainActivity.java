package solfadev.net.sunshineapp;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container, HomeFragment.newInstance("INI HOME")).commit();
//        isParrentView = true;

    }

    public static class HomeFragment extends android.support.v4.app.Fragment{
        private String message;
        private ArrayAdapter<String> mForecastAdapter;

        public HomeFragment (){

        }

//        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.home_fragment, container, false);
//            Adapter mForecastAdapter;
            String [] forecastArray = {
                    "Today - Sunny - 88/63 ",
                    "Tomorrow - Foggy - 70/40",
                    "Weds - Cloudy - 72/63",
                    "Fri - Heavy Rain - 65/56",
                    "Sat - HELP TRAPPED IN WEATHERSTATION - 60/51",
                    "Sun - Sunny - 80/68"
            };
            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray)
            );

            mForecastAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast
            );
            ListView listView = (ListView) v.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return v;

        }

        public static HomeFragment newInstance(String message) {
            HomeFragment fragment = new HomeFragment();
            fragment.message = message;
            return fragment;
        }
    }
}
