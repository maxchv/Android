package com.example.max.usinglists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by max on 16.05.2017.
 */

public class UsertItemAdapter extends RecyclerView.Adapter<UsertItemAdapter.ViewHolder> {
    List<User> mUserList;
    Context mContext;

    public UsertItemAdapter(List<User> userList, Context context) {
        mUserList = userList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mUserList.get(position);

        holder.mTextViewHome.setText(user.hometown);
        holder.mTextViewName.setText(user.name);
        holder.mImageView.setImageResource(R.mipmap.clock);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, user.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextViewName;
        TextView mTextViewHome;
        View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.imageViewUser);
            mTextViewName = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewHome = (TextView) itemView.findViewById(R.id.tvHome);
            mView = itemView;

        }


    }
}
