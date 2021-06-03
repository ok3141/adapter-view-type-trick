package com.example.tablelayout2recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirstRowViewHolder extends RowViewHolder {
    @Nullable
    private final TextView someValueView;

    @Nullable
    private final TextView labelView;

    public FirstRowViewHolder(@NonNull View itemView) {
        super(itemView);

        someValueView = itemView.findViewById(R.id.some_value);
        labelView = itemView.findViewById(R.id.label);
    }

    @Override
    public void onBind(@Nullable RowDescriptor row) {
        if (row == null) {
            if (someValueView != null) {
                someValueView.setText(null);
            }

            if (labelView != null) {
                labelView.setText(null);
            }
        } else {
            if (someValueView != null) {
                Integer someValue = row.getValue("some_value");
                someValueView.setText(String.valueOf(someValue));
            }

            if (labelView != null) {
                String label = row.getValue("label");
                labelView.setText(label);
            }
        }
    }
}
