package com.gamehub.myapplication;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;
public class SearchResultViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView usernameTextView;

    public SearchResultViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_textview);
        usernameTextView = itemView.findViewById(R.id.username_textview);
    }
}
