package belajar.app.sunshine.Controllers.Adapter;

import android.content.Context;
<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
=======
import android.content.Intent;
import android.support.v7.widget.CardView;
>>>>>>> baru
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
=======
import belajar.app.sunshine.DetailActivity;
>>>>>>> baru
import belajar.app.sunshine.ItemObject;
import belajar.app.sunshine.R;

/**
 * Created by isfaaghyth on 12/11/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    Context context;
<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
    List<ItemObject.ListWeather> itemObjects;

    public ListAdapter(Context context, List<ItemObject.ListWeather> itemObjects) {
=======
    List<ItemObject.ListWeather.Test> itemObjects;

    public ListAdapter(Context context, List<ItemObject.ListWeather.Test> itemObjects) {
>>>>>>> baru
        this.context = context;
        this.itemObjects = itemObjects;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_sunshine_item, null);
        return new ListHolder(view);
    }

    @Override
<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.txtDay.setText(itemObjects.get(position).getJudul());
=======
    public void onBindViewHolder(ListHolder holder, final int position) {
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
>>>>>>> baru
    }

    @Override
    public int getItemCount() {
        return itemObjects.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {

        TextView txtDay;
<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
=======
        CardView cardItem;
>>>>>>> baru

        public ListHolder(View itemView) {
            super(itemView);
            txtDay = (TextView) itemView.findViewById(R.id.txt_day);
<<<<<<< f763e1927128bcdc842b22bb5b4d5b45c85617f1
        }
    }

}
=======
            cardItem = (CardView) itemView.findViewById(R.id.cardview_item);
        }
    }

}
>>>>>>> baru
