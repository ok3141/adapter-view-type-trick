package com.example.tablelayout2recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondRowViewHolder extends RowViewHolder {
    @Nullable
    private final TextView anotherValueView;

    @Nullable
    private final TextView descriptionView;

    public SecondRowViewHolder(@NonNull View itemView) {
        super(itemView);

        anotherValueView = itemView.findViewById(R.id.another_value);
        descriptionView = itemView.findViewById(R.id.description);
    }

    @Override
    public void onBind(@Nullable RowDescriptor row) {
        if (row == null) {
            if (anotherValueView != null) {
                anotherValueView.setText(null);
            }

            if (descriptionView != null) {
                descriptionView.setText(null);
            }
        } else {
            if (anotherValueView != null) {
                Integer someValue = row.getValue("another_value");
                anotherValueView.setText(String.valueOf(someValue));
            }

            if (descriptionView != null) {
                String label = row.getValue("description");
                descriptionView.setText(label);
            }
        }
    }
}
