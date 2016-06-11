package org.pma.nutrifami.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pma.nutrifami.R;
import org.pma.nutrifami.view.container.PairDataContainer;
import org.pma.nutrifami.view.listener.PairClickListener;
import org.pma.nutrifami.view.viewholder.PairViewHolder;

/**
 * Created by juras on 11-Jun-16.
 */

public class PairDataAdapter extends RecyclerView.Adapter<PairViewHolder> {
    private final PairClickListener mOnClickListener;
    private final PairDataContainer[] mPairDataContainers;

    public PairDataAdapter(String[] pairParts, PairClickListener onClickListener) {
        this.mPairDataContainers = new PairDataContainer[pairParts.length];
        for (int i = 0; i < pairParts.length; i++) {
            this.mPairDataContainers[i] = new PairDataContainer(pairParts[i]);
        }

        this.mOnClickListener = onClickListener;
    }

    @Override
    public PairViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final CardView cardView = (CardView) LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.quiz_pair, parent, false);

        final TextView textView = (TextView) cardView.findViewById(R.id.pair_text);
        return new PairViewHolder(cardView, textView, this.mOnClickListener);
    }

    @Override
    public void onBindViewHolder(PairViewHolder holder, int position) {
        holder.update(this.mPairDataContainers[position]);
    }

    @Override
    public int getItemCount() {
        return this.mPairDataContainers.length;
    }

    public PairDataContainer[] getDataContainers() {
        return this.mPairDataContainers;
    }
}
