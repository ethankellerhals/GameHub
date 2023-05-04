
package com.gamehub.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.SearchResultViewHolder> {

    private List<SearchResult> searchResults;
    private OnItemClickListener listener;

    public SearchResultsAdapter(List<SearchResult> searchResults/*, OnItemClickListener listener*/) {
        this.searchResults = searchResults;
        this.listener = listener;
    }
    public void setData(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }
    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new SearchResultViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
        SearchResult searchResult = searchResults.get(position);
        holder.titleTextView.setText(searchResult.getTitle());
        holder.usernameTextView.setText(searchResult.getUsername());

    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public class SearchResultViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView usernameTextView;



        public SearchResultViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_textview);
            usernameTextView = itemView.findViewById(R.id.username_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        SearchResult result = searchResults.get(position);
                        listener.onItemClick(result);
                    } else {
                        Log.i("aaaaa", "asdasdasdasdas");
                    }
                }
            });

        }
    }




}

