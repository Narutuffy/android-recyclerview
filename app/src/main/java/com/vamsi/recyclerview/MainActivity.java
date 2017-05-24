package com.vamsi.recyclerview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager layoutManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView= new RecyclerView(this);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRecyclerView.setLayoutParams(lp);
        layoutManager=new GridLayoutManager(this,1, GridLayoutManager.HORIZONTAL, false);
        setContentView(mRecyclerView);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter=new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }


}
