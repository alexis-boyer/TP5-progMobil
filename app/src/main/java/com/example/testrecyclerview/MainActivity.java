package com.example.testrecyclerview;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, R.drawable.divider);
        //mRecyclerView.addItemDecoration(itemDecoration);

        ((GridLayoutManager)mLayoutManager) .setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {

                    @Override
                    public int getSpanSize(int arg0) {
                        return (arg0 % 3) == 0 ? 2 : 1;
                    }
                });
    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        results.add(new Donnee("Mercure","Planette la plus proche du soleil ", R.drawable.mercure));
        results.add(new Donnee("Venus","Planette gazeuse la plus proche du soleil ", R.drawable.venus));
        results.add(new Donnee("Terre","Meilleur planette pour passer ses vacances", R.drawable.terre));
        results.add(new Donnee("Mars","Planette avec le plus de rover", R.drawable.mars));
        results.add(new Donnee("Jupiter","Planette sur laquelle il y'a des volcans de mercure ", R.drawable.jupiter));
        results.add(new Donnee("Saturne","Planette célébre pour ses anneaux ", R.drawable.saturne));
        results.add(new Donnee("Uranus","Planette avec le plus de mauvais jeux de mots ", R.drawable.uranus));
        results.add(new Donnee("Neptune","Planette la plus eloigné du soleil", R.drawable.neptune));

        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    @Override
    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }
}