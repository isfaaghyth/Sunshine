package belajar.app.sunshine.Controllers.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import belajar.app.sunshine.DetailActivity;
import belajar.app.sunshine.ItemObject;
import belajar.app.sunshine.R;

/**
 * Created by isfaaghyth on 12/11/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    Context context;
    List<ItemObject.ListWeather.Test> itemObjects;

    public ListAdapter(Context context, List < ItemObject.ListWeather.Test > itemObjects) {
        this.context = context;
        this.itemObjects = itemObjects;
    }

    @Override
    public ListHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_sunshine_item, null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder (ListHolder holder,int position){

        final String main = itemObjects.get(position).getWeather().get(0).getMain();
        holder.txtDay.setText(main);

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                i.putExtra("judul", main);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount () {
        return itemObjects.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {
        TextView txtDay;
        CardView cardItem;

        public ListHolder(View itemView) {
            super(itemView);
            txtDay = (TextView) itemView.findViewById(R.id.txt_day);
        }
    }
}