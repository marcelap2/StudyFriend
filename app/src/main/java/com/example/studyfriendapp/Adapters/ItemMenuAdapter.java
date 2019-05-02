package com.example.studyfriendapp.Adapters;

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
import com.example.studyfriendapp.Activities.Agenda;
import com.example.studyfriendapp.Activities.activity_profesores;
import com.example.studyfriendapp.Models.ItemMenu;
import com.example.studyfriendapp.R;

import java.util.List;

public class ItemMenuAdapter extends RecyclerView.Adapter<ItemMenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemMenu> eventList;

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

    public ItemMenuAdapter(Context mContext, List<ItemMenu> eventList) {
        this.mContext = mContext;
        this.eventList = eventList;
    }

    public List<ItemMenu> getItems(){
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
        final ItemMenu item = eventList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Click seleccionando: "+ item.getName(),Toast.LENGTH_SHORT).show();

                if (item.getName().equalsIgnoreCase("agenda")){
                    Intent i = new Intent(view.getContext(), Agenda.class);
                    view.getContext().startActivity(i);

                }else if (item.getName().equalsIgnoreCase("profesores")){
                    Intent i = new Intent(view.getContext(), activity_profesores.class);
                    view.getContext().startActivity(i);

                }else if (item.getName().equalsIgnoreCase("horarios")){

                }else if (item.getName().equalsIgnoreCase("clases")){

                }else if (item.getName().equalsIgnoreCase("Mis Notas")){

                }else if (item.getName().equalsIgnoreCase(("Fallas"))){

                }


            }
        });

        holder.name.setText(item.getName());
        holder.text.setText(item.getDescription());
        Glide.with(mContext).load(item.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }


}


