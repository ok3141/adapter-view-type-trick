package com.example.tablelayout2recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle state) {
        super.onCreate(state);

        List<RowDescriptor> rows = new ArrayList<>();

        rows.add(new RowDescriptor(R.layout.row1, FirstRowViewHolder::new)
                .putValue("some_value", 42)
                .putValue("label", "hello"));

        rows.add(new RowDescriptor(R.layout.row2, SecondRowViewHolder::new)
                .putValue("another_value", 24)
                .putValue("description", "world"));

        RowsAdapter adapter = new RowsAdapter();
        adapter.setData(rows);

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        setContentView(recyclerView);
    }
}
