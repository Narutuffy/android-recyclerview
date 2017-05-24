package com.vamsi.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi Rao on 5/24/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataObjectHolder> {

    private static MyClickListener myClickListener;
    private List<Integer> mImageArray=Data.imageArray;

   public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       ImageView imageView;
       public DataObjectHolder(View itemView) {
           super(itemView);
           imageView=(ImageView)itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);
       }

       @Override

       public void onClick(View view) {
            myClickListener.onItemClick(getPosition(),view);
       }
   }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        DataObjectHolder dataObjectHolder= new DataObjectHolder(view);
        return dataObjectHolder;
    }
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.imageView.setImageResource(mImageArray.get(position));
    }
    public void addItem(Integer imageId, int index) {
        mImageArray.add(imageId);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mImageArray.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
      return   mImageArray.size();
    }
    public interface MyClickListener{
        public void onItemClick(int position, View v);
    }
}
