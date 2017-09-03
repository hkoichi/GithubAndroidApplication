package com.app.koichihasegawa.githubsearchapp.presentation.search;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.koichihasegawa.githubsearchapp.BR;
import com.app.koichihasegawa.githubsearchapp.R;
import com.app.koichihasegawa.githubsearchapp.domain.entity.Item;

import java.util.List;

/**
 * Created by koichihasegawa on 2017/09/03.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ItemViewHolder> {
    private List<Item> _itemList;

    public SearchListAdapter(List<Item> itemList) {
        _itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchlist_sub, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = _itemList.get(position);
        holder.getHolderBinding().setVariable(BR.item, item);
        holder.getHolderBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return _itemList.size();
    }

    // ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding holderBinding;

        public ItemViewHolder(View itemView) {
            super(itemView);
            holderBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getHolderBinding() {
            return holderBinding;
        }
    }
}
