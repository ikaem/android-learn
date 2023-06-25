package xyz.imkaem.bucketer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlacesActivity extends AppCompatActivity {

    RecyclerView recyclerViewPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        recyclerViewPlaces = findViewById(R.id.recycler_view_bucket_places);

        Todo[] todos = {
                new Todo("Eat Ice Cream", "Indulge in your favorite flavor of ice cream", "thing", R.drawable.t1),
                new Todo("Build Android App", "Develop a new Android application with innovative features", "thing", R.drawable.t2),
                new Todo("Read a Book", "Spend quality time reading a captivating book", "thing", R.drawable.t3),
                new Todo("Go for a Walk", "Take a leisurely walk in the park or nature trail", "thing", R.drawable.t4),
                new Todo("Write a Journal", "Reflect on your thoughts and experiences in a personal journal", "thing", R.drawable.t5),
        };

        TodosAdapter todosAdapter = new TodosAdapter(todos);

        recyclerViewPlaces.setAdapter(todosAdapter);


    }
}