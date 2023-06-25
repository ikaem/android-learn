package xyz.imkaem.thehungryjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartersActivity extends AppCompatActivity {
    ListView listViewStarters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // probably should not be here
        // ListView listViewStarters;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        listViewStarters = findViewById(R.id.list_view_starters);

//        Dish starterOne = new Dish("Bruschetta", "This is some fancy Italian food", 600);
/*        String[] starterDishes = {
                "Bruschetta",
                "Caprese Salad",
                "Garlic Bread",
                "Soup of the Day",
                "Spinach and Artichoke Dip",
                "Crispy Calamari",
                "Stuffed Mushrooms",
                "Chicken Satay Skewers",
                "Shrimp Cocktail",
                "Vegetable Spring Rolls",
                "Ceviche",
                "Chicken Wings",
                "Fried Mozzarella Sticks",
                "Crab Cakes",
                "Antipasto Platter",
                "Nachos",
                "Fried Pickles",
                "Potato Skins",
                "Cheese and Charcuterie Board",
                "Coconut Shrimp"
        };*/
        Dish[] dishes = {
                new Dish("Bruschetta", "This is Bruschetta", 60440),
                new Dish("Caprese Salad", "This is Caprese Salad", 800),
                new Dish("Garlic Bread", "This is Garlic Bread", 600),
                new Dish("Soup of the Day", "This is some fancy Italian food 4", 6080),
                new Dish("Spinach and Artichoke Dip", "This is some fancy Italian food5", 600),
                new Dish("Crispy Calamari", "This is some fancy Italian food6", 6300),
                new Dish("Stuffed Mushrooms", "This is some fancy Italian food7", 600),
                new Dish("Chicken Satay Skewers", "This is some fancy Italian food8", 6040),
                new Dish("Shrimp Cocktail", "This is some fancy Italian food9", 600),
                new Dish("Vegetable Spring Rolls", "This is some fancy Italian food10", 600),
                new Dish("Ceviche", "This is some fancy Italian food11", 600),
                new Dish("Chicken Wings", "This is some fancy Italian food12", 600),
                new Dish("Fried Mozzarella Sticks", "This is some fancy Italian food13", 6200),
                new Dish("Crab Cakes", "This is some fancy Italian food14", 10),
                new Dish("Antipasto Platter", "This is some fancy Italian food15", 450),
                new Dish("Nachos", "This is some fancy Italian food16", 6300),
                new Dish("Fried Pickles", "This is some fancy Italian food17", 6100),
                new Dish("Potato Skins", "This is some fancy Italian food18", 200),
                new Dish("Cheese and Charcuterie Board", "This is some fancy Italian food19", 600),
                new Dish("Coconut Shrimp", "This is some fancy Italian food20", 60)
        };


        ArrayAdapter<Dish> startersAdapter = new ArrayAdapter<Dish>(
                this,
                android.R.layout.simple_list_item_1,
                dishes
        );

        listViewStarters.setAdapter(startersAdapter);
    }
}