package com.example.studyfriendapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import com.example.studyfriendapp.Adapters.EventAdapter;
import com.example.studyfriendapp.Models.Event;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private ArrayList<Event> lista = new ArrayList<Event>();
    private RecyclerView recycler;
    private EventAdapter adapter;
    private FloatingActionMenu floatingActionmenu;
    private  int spanCount = 2;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.transition.fade_in, R.transition.fade_out);
        setToolbar();

        recycler = (RecyclerView) findViewById(R.id.reciclador);

        lista = new ArrayList<>();
        adapter = new EventAdapter(this, lista);
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
        recycler.addItemDecoration(new MainActivity.GridSpacingItemDecoration(spanCount, dpToPx(0), true));
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
                R.drawable.menu_c,
                R.drawable.examen_c,
                R.drawable.clases_c,
                R.drawable.eventos_c,
                R.drawable.tareas_c,
        };

        lista.add(new Event ("Menu", "Mi Menu", covers[0]));
        lista.add(new Event("Exam", "Examenes", covers[1]));
        lista.add(new Event("Class", "Clases", covers[2]));
        lista.add(new Event("Event", "Eventos", covers[3]));
        lista.add(new Event("Tarea", "Tareas", covers[4]));
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
