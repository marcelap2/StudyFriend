package com.example.studyfriendapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import com.example.studyfriendapp.Adapters.ItemMenuAdapter;
import com.example.studyfriendapp.Models.ItemMenu;
import com.example.studyfriendapp.R;

import java.util.ArrayList;

public class menu_items extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navegationView;
    private ArrayList<ItemMenu> lista = new ArrayList<ItemMenu>();
    private RecyclerView recycler;
    private ItemMenuAdapter adapter;
    private  int spanCount = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navegationView = (NavigationView) findViewById(R.id.naview);
        recycler = (RecyclerView) findViewById(R.id.reciclador);

        lista = new ArrayList<>();
        adapter = new ItemMenuAdapter(this, lista);
        adapter.notifyDataSetChanged();

        if (this.getResources().getConfiguration().orientation ==
                this.getResources().getConfiguration()
                        .ORIENTATION_LANDSCAPE){
            spanCount = 3;
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, spanCount);
        recycler.setLayoutManager(mLayoutManager);
        recycler.addItemDecoration(new menu_items.GridSpacingItemDecoration(spanCount, dpToPx(0), true));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        navegationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                boolean actitransaction = false;
                Intent intent = null;

                switch (menuItem.getItemId()){
                    case R.id.addClass:
                        actitransaction = true;
                        intent = new Intent(menu_items.this, activity_add_class.class);
                        break;
                    case R.id.addEvent:
                        actitransaction = true;
                        intent = new Intent(menu_items.this, activity_add_event.class);
                        break;
                    case R.id.addGroup:
                        actitransaction = true;
                        intent = new Intent(menu_items.this, activity_add_groupclass.class);
                        break;
                    case R.id.addRecordatory:
                        actitransaction = true;
                        intent = new Intent(menu_items.this, activity_add_recordatory.class);
                        break;
                }

                if (actitransaction){
                    startActivity(intent);
                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });

        //   lista.add(new Event ("Menu", "Mi Menu"));

        fillEvent();
    }


    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void fillEvent (){
        int[] covers = new int[]{
                R.drawable.icons8_menu,
                R.drawable.icons8_libro_filled,
                R.drawable.icons8_clase,
                R.drawable.icons8_evento_aceptado,
                R.drawable.icons8_tarea,
        };

        lista.add(new ItemMenu ("Agenda", "Mi Menu", covers[0]));
        lista.add(new ItemMenu("Profesores", "No Event", covers[1]));
        lista.add(new ItemMenu("Horarios", "No class Todat", covers[2]));
        lista.add(new ItemMenu("Clases", "No Event", covers[3]));
        lista.add(new ItemMenu("Mis notas", "No hay tareas", covers[4]));
        lista.add(new ItemMenu("Fallas", "No hay tareas", covers[4]));
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
}
