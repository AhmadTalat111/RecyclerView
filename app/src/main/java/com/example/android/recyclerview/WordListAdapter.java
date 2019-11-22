package com.example.android.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LinkedList<String> mWordList = new LinkedList<>();

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View mItemView = inflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    void setData(LinkedList<String> newData) {
        this.mWordList = newData;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView wordItemView;
        final WordListAdapter madapter;

        WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.madapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked! " + element);
            madapter.notifyDataSetChanged();
        }
    }


}
