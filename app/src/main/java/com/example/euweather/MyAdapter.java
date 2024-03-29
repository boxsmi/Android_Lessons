package com.example.euweather;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.euweather.model.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<WeatherInfo> values = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_view, viewGroup, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.cityName.setText("City: " + values.get(i).getName());
        myViewHolder.main.setText("State: " + values.get(i).getWeather().get(0).getMain());
        myViewHolder.description.setText("Description: " + values.get(i).getWeather().get(0).getDescription());
        myViewHolder.temp.setText("Temperature: " + (values.get(i).getMain().getTemp()).intValue() + " 'C");
        myViewHolder.pressure.setText("Pressure: " + values.get(i).getMain().getPressure() + " hpa");
        myViewHolder.humidity.setText("Humidity: " + values.get(i).getMain().getHumidity() + " %");
        myViewHolder.wind.setText("Wind speed: " + values.get(i).getWind().getSpeed() + " m/s");

        switch (values.get(i).getWeather().get(0).getId() / 100) {
            case 2:
                myViewHolder.ico.setImageResource(R.drawable.thunder);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/soylent-red/chance-of-storm-128.png").into(myViewHolder.ico);
                break;
            case 3:
            case 5:
                myViewHolder.ico.setImageResource(R.drawable.rain);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/soylent-red/rain-128.png").into(myViewHolder.ico);

                break;
            case 6:
                myViewHolder.ico.setImageResource(R.drawable.snow);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/soylent-red/snow-storm-128.png").into(myViewHolder.ico);

                break;
            case 7:
                myViewHolder.ico.setImageResource(R.drawable.sun);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/icon-sets/web-2-deep-pink/sun-5-64.png").into(myViewHolder.ico);

                break;
            case 8:
                if (values.get(i).getWeather().get(0).getId() > 800){
                    myViewHolder.ico.setImageResource(R.drawable.cloudandsun);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/soylent-red/cloudy-128.png").into(myViewHolder.ico);}

                else
                    myViewHolder.ico.setImageResource(R.drawable.sun);
                Glide.with(MyApplication.getMyApplicationInstance()).load("https://www.iconsdb.com/icons/download/soylent-red/sun-5-128.png").into(myViewHolder.ico);

                break;
            default:
                myViewHolder.ico.setImageResource(R.drawable.nature);

        }


        myViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void setValues(List<WeatherInfo> values) {
        this.values.clear();
        this.values.addAll(values);
        notifyDataSetChanged();
    }

    public void addValue(WeatherInfo value) {
        this.values.add(value);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TextView cityName;
        public TextView main;
        public TextView description;
        public TextView temp;
        public TextView pressure;
        public TextView humidity;
        public TextView wind;
        public ImageView ico;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            ico = itemView.findViewById(R.id.myItemMenuIcon);
            cityName = itemView.findViewById(R.id.myItemMenuTitleCity);
            main = itemView.findViewById(R.id.myItemMenuTitleMain);
            description = itemView.findViewById(R.id.myItemMenuTitleDescription);
            temp = itemView.findViewById(R.id.myItemMenuTitleTemp);
            pressure = itemView.findViewById(R.id.myItemMenuTitlePressure);
            humidity = itemView.findViewById(R.id.myItemMenuTitleHumidity);
            wind = itemView.findViewById(R.id.myItemMenuTitleWind);

        }
    }
}
