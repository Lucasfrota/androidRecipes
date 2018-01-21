package com.fae.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();

        items.add(new Item("Adele", "Send my love"));
        items.add(new Item("Lady Gaga","Bad romance"));
        items.add(new Item("David Bowie","Space Oddity"));
        items.add(new Item("woodkid","wasteland"));
        items.add(new Item("hozier","angel of small death"));
        items.add(new Item("lorde","yellow flicker beat"));
        items.add(new Item("marina and the diamonds","primadonna"));
        items.add(new Item("tove lo","influence"));
        items.add(new Item("of monsters and men","mountain sound"));
        items.add(new Item("pink martini","sympathique"));

        adapter = new CustomAdapter(items, this);

        recyclerView.setAdapter(adapter);
    }
}
