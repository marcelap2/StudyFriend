package com.example.studyfriendapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.studyfriendapp.Activities.menu_items;
import com.example.studyfriendapp.Models.Event;
import com.example.studyfriendapp.R;
import com.example.studyfriendapp.Activities.details_events;
import com.example.studyfriendapp.detalles;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder>{

    private Context mContext;
    private List<Event> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, text;
        public ImageView imageView;
        private CardView elementView;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.namecarditem);
            text = (TextView) view.findViewById(R.id.textcard);
           imageView = (ImageView) view.findViewById(R.id.image_list);
            elementView = (CardView) view.findViewById(R.id.card_viewdetail) ;

        }
    }

    public EventAdapter(Context mContext, List<Event> eventList) {
        this.mContext = mContext;
        this.eventList = eventList;
    }

    public List<Event> getItems(){
        return this.eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Event event = eventList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Click seleccionando: "+ event.getName(),Toast.LENGTH_SHORT).show();

                if (event.getName().equalsIgnoreCase("Menu") == false){
                    Intent i = new Intent(view.getContext(), details_events.class);
                    i.putExtra("texto", event.getText());
                    i.putExtra("imagen", event.getImage());
                    view.getContext().startActivity(i);
                    ((Activity)  mContext).overridePendingTransition(R.transition.zoom_back_in,R.transition.zoom_back_out);
                }else {
                  Intent i = new Intent(view.getContext(), menu_items.class);
                   view.getContext().startActivity(i);
                    ((Activity)  mContext).overridePendingTransition(R.transition.fade_in,R.transition.fade_out);
                }


            }
        });

        holder.name.setText(event.getName());
        holder.text.setText(event.getText());
       Glide.with(mContext).load(event.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

}
