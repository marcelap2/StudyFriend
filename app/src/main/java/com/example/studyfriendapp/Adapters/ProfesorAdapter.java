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
import com.example.studyfriendapp.Models.Profesor;
import com.example.studyfriendapp.R;

import java.util.List;

public class ProfesorAdapter  extends RecyclerView.Adapter<ProfesorAdapter.MyViewHolder> {

    private Context mContext;
    private List<Profesor> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, materia, telefono;
        public ImageView imageView;
        private CardView elementView;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name_profesor);
            materia = (TextView) view.findViewById(R.id.text_profesor);
            imageView = (ImageView) view.findViewById(R.id.image_profesor);
            telefono = (TextView) view.findViewById(R.id.telefono_profesor);
            elementView = (CardView) view.findViewById(R.id.card_viewprofesor) ;

        }
    }

    public ProfesorAdapter(Context mContext, List<Profesor> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public List<Profesor> getItems(){
        return this.list;
    }

    @Override
    public ProfesorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_profesores, parent, false);

        return new ProfesorAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Profesor item = list.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Click seleccionando: "+ item.getName(),Toast.LENGTH_SHORT).show();
                ((Activity)  mContext).overridePendingTransition(R.transition.zoom_back_in,R.transition.zoom_back_out);
            }
        });

        holder.name.setText(item.getName());
        holder.materia.setText(item.getMateria());
        holder.telefono.setText(item.getTelefono());
        Glide.with(mContext).load(item.getImage()).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}
