package com.example.tablelayout2recyclerview;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RowsAdapter extends RecyclerView.Adapter<RowViewHolder> {
    @Nullable
    private List<? extends RowDescriptor> rows;

    @NonNull
    private final SparseIntArray layoutIdToViewType = new SparseIntArray();

    @NonNull
    private final SparseIntArray viewTypeToLayoutId = new SparseIntArray();

    @NonNull
    private final SparseArray<RowViewHolder.Factory> viewTypeToFactory = new SparseArray<>();

    public void setData(@Nullable List<RowDescriptor> rows) {
        this.rows = rows;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return rows != null ? rows.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (rows != null && position >= 0 && position < rows.size()) {
            RowDescriptor row = rows.get(position);

            int viewType = layoutIdToViewType.get(row.getLayoutId());
            if (viewType == 0) {
                viewType = layoutIdToViewType.size() + 1;

                layoutIdToViewType.put(row.getLayoutId(), viewType);
                viewTypeToLayoutId.put(viewType, row.getLayoutId());
                viewTypeToFactory.put(viewType, row.getFactory());
            }

            return viewType;
        } else {
            return 0;
        }
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new RowViewHolder(new View(parent.getContext()));
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewTypeToLayoutId.get(viewType), parent, false);

        return viewTypeToFactory.get(viewType).newInstance(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        if (rows != null && position >= 0 && position < rows.size()) {
            holder.onBind(rows.get(position));
        } else {
            holder.onBind(null);
        }
    }
}
