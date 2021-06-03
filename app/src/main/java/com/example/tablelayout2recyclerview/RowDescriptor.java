package com.example.tablelayout2recyclerview;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class RowDescriptor {
    @LayoutRes
    private final int layoutId;

    @NonNull
    private final RowViewHolder.Factory factory;

    @NonNull
    private final Map<String, Object> values = new HashMap<>();

    public int getLayoutId() {
        return layoutId;
    }

    @NonNull
    public RowViewHolder.Factory getFactory() {
        return factory;
    }

    public RowDescriptor(
            @LayoutRes int layoutId,
            @NonNull RowViewHolder.Factory factory
    ) {
        this.layoutId = layoutId;
        this.factory = factory;
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T getValue(@NonNull String key) {
        return (T) values.get(key);
    }

    @NonNull
    public <T> RowDescriptor putValue(@NonNull String key, @Nullable T value) {
        values.put(key, value);
        return this;
    }
}
