//package com.gamehub.myapplication;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.support.v7.widget.RecyclerView;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.SearchResultViewHolder> {
//
//    private List<SearchResult> searchResults;
//
//    public SearchResultsAdapter(List<SearchResult> searchResults) {
//        this.searchResults = searchResults;
//    }
//    public void setData(List<SearchResult> searchResults) {
//        this.searchResults = searchResults;
//        notifyDataSetChanged();
//    }
////    @Override
////    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
////        return new SearchResultViewHolder(view);
////    }
//
//    @Override
//    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
//        SearchResult searchResult = searchResults.get(position);
//        holder.titleTextView.setText(searchResult.getTitle());
//        holder.usernameTextView.setText(searchResult.getUsername());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return searchResults.size();
//    }
//
//    public class SearchResultViewHolder extends RecyclerView.ViewHolder {
//        public TextView titleTextView;
//        public TextView usernameTextView;
//
//
//
//        public SearchResultViewHolder(View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.title_textview);
//            usernameTextView = itemView.findViewById(R.id.username_textview);
//        }
//    }
//
//
//}
