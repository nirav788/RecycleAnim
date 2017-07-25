package com.nirav.recycleanim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nirav.recycleanim.Beans.List_Beans;
import com.squareup.picasso.Picasso;
import com.zach.salman.springylib.springyRecyclerView.SpringyAdapterAnimationType;
import com.zach.salman.springylib.springyRecyclerView.SpringyAdapterAnimator;

import java.util.List;

/**
 * Created by Developers on 25-07-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<List_Beans> listItems;
    Context context;
    private SpringyAdapterAnimator mAnimator;

    public MyAdapter(List<List_Beans> listItems, Context context , RecyclerView recyclerView) {
        this.listItems = listItems;
        this.context = context;
        mAnimator = new SpringyAdapterAnimator(recyclerView);
        mAnimator.setSpringAnimationType(SpringyAdapterAnimationType.SLIDE_FROM_RIGHT);
        mAnimator.addConfig(85,15);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        mAnimator.onSpringItemCreate(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final List_Beans bean = listItems.get(position);
        mAnimator.onSpringItemBind(holder.itemView, position);
        holder.title.setText(bean.getWebTitle());
        holder.body.setText(bean.getType());
        holder.body1.setText(bean.getSectionId());
        holder.body2.setText(bean.getSectionName());


        // Picasso.with(context).load(bean.getImage()).into(holder.imageView);


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked" + bean.getWebTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, body, body1, body2;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtheading);
            body = (TextView) itemView.findViewById(R.id.txtbody);
            body1 = (TextView) itemView.findViewById(R.id.txtbody1);
            body2 = (TextView) itemView.findViewById(R.id.txtbody2);
            //imageView = (ImageView) itemView.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.RelativeLayout);
        }

    }
}