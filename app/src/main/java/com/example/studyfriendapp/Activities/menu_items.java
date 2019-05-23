package com.example.studyfriendapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import com.example.studyfriendapp.Adapters.ItemMenuAdapter;
import com.example.studyfriendapp.Models.ItemMenu;
import com.example.studyfriendapp.R;

import java.util.ArrayList;

public class menu_items extends AppCompatActivity {

    private ArrayList<ItemMenu> lista = new ArrayList<ItemMenu>();
    private RecyclerView recycler;
    private ItemMenuAdapter adapter;
    private  int spanCount = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        recycler = (RecyclerView) findViewById(R.id.reciclador);

        lista = new ArrayList<>();
        adapter = new ItemMenuAdapter(this, lista);
        adapter.notifyDataSetChanged();

        if (esLandscape(this) && esTablet(this)==false){
            spanCount = 3;
        } else if (esTablet(this) && esLandscape(this)==false){
            spanCount = 3;
        }else if (esTablet(this ) && esLandscape(this)){
            spanCount = 5;
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, spanCount);
        recycler.setLayoutManager(mLayoutManager);
        recycler.addItemDecoration(new menu_items.GridSpacingItemDecoration(spanCount, dpToPx(0), true));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);



        //   lista.add(new Event ("Menu", "Mi Menu"));

        fillEvent();
    }


    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void fillEvent (){
        int[] covers = new int[]{
                R.drawable.agenda,
                R.drawable.profesor1,
                R.drawable.horarios,
                R.drawable.clases,
                R.drawable.notas,
                R.drawable.falla

        };

        lista.add(new ItemMenu ("Agenda", "Mi Menu", covers[0]));
        lista.add(new ItemMenu("Profesores", "No Event", covers[1]));
        lista.add(new ItemMenu("Horarios", "No class Todat", covers[2]));
        lista.add(new ItemMenu("Clases", "No Event", covers[3]));
        lista.add(new ItemMenu("Mis notas", "No hay tareas", covers[4]));
        lista.add(new ItemMenu("Fallas", "No hay tareas", covers[5]));
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.transition.fade_in,R.transition.fade_out);
    }

    public static boolean esTablet (Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public  static boolean esLandscape (Context contex){
        return contex.getResources().getConfiguration().orientation ==
                contex.getResources().getConfiguration()
                        .ORIENTATION_LANDSCAPE;
    }
}
