package com.vamsi.recyclerview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private GridLayoutManager layoutManager;
    private String tag="Hello";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView= new RecyclerView(this);
      /*  RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRecyclerView.setLayoutParams(lp);*/
        layoutManager=new GridLayoutManager(this,1, GridLayoutManager.HORIZONTAL, false);

        setContentView(mRecyclerView);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter.MyClickListener myClickListener= new RecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d(tag,"position is "+position);
            }
        };
         mAdapter=new RecyclerViewAdapter(myClickListener);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, GridLayoutManager.HORIZONTAL);
        mRecyclerView.addItemDecoration(itemDecoration);
       mRecyclerView.setAdapter(mAdapter);


    }



}
