package com.example.studyfriendapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import com.example.studyfriendapp.Adapters.ProfesorAdapter;
import com.example.studyfriendapp.Models.Profesor;
import com.example.studyfriendapp.R;

import java.util.ArrayList;

public class activity_profesores extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navegationView;
    private ArrayList<Profesor> lista = new ArrayList<Profesor>();
    private RecyclerView recycler;
    private ProfesorAdapter adapter;
    private FloatingActionButton floatingActionButton;
    private  int spanCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_profsores);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navegationView = (NavigationView) findViewById(R.id.naview);
        recycler = (RecyclerView) findViewById(R.id.reciclador_profesores);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        lista = new ArrayList<>();
        adapter = new ProfesorAdapter(this, lista);
        adapter.notifyDataSetChanged();

        if (esLandscape(this) && esTablet(this)==false){
            spanCount = 3;
        } else if (esTablet(this) && esLandscape(this)==false){
            spanCount = 3;
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recycler.setLayoutManager(mLayoutManager);
        recycler.addItemDecoration(new activity_profesores.GridSpacingItemDecoration(1, dpToPx(0), true));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_profesores.this, add_Profesor.class);
                view.getContext().startActivity(i);
            }
        });


        fillEvent();
    }



    private void fillEvent (){
        int[] covers = new int[]{
                R.drawable.perfil,
                R.drawable.perrfil_1
        };

        lista.add(new Profesor ("Pepito", "Quimica", "3112222222", covers[0]));


    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.transition.left_in,R.transition.left_out);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

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
