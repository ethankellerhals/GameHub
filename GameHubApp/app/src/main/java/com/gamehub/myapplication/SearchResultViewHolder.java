package com.gamehub.myapplication;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;
import java.util.List;
public class SearchResultViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView usernameTextView;
    private OnItemClickListener listener;
    private List<SearchResult> searchResults;
    public SearchResultViewHolder(View itemView/*, OnItemClickListener listener*/) {
        super(itemView);
        //this.searchResults = searchResults;
        this.listener = listener;
        titleTextView = itemView.findViewById(R.id.title_textview);
        usernameTextView = itemView.findViewById(R.id.username_textview);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    SearchResult result = searchResults.get(position);
                    listener.onItemClick(result);
                }
            }
        });
    }
    public void bind(SearchResult result) {
        titleTextView.setText(result.getTitle());

    }
}
