package com.example.tablelayout2recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RowViewHolder extends RecyclerView.ViewHolder {
    public RowViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBind(@Nullable RowDescriptor row) {
        // none
    }

    public interface Factory {
        @NonNull
        RowViewHolder newInstance(@NonNull View itemView);
    }
}
