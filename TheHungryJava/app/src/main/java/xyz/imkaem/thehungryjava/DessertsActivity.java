package xyz.imkaem.thehungryjava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DessertsActivity extends AppCompatActivity {
    ListView dessertsListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        dessertsListView = findViewById(R.id.list_view_desserts);
        Dish[] desserts = {
                new Dish("Chocolate Lava Cake", "Warm and gooey chocolate cake with a molten center, served with a scoop of vanilla ice cream", 500),
                new Dish("New York Cheesecake", "Classic creamy cheesecake with a graham cracker crust, topped with fresh berries", 550),
                new Dish("Tiramisu", "Layers of espresso-soaked ladyfingers and mascarpone cream, dusted with cocoa powder", 450),
                new Dish("Apple Pie", "Homemade apple pie with a flaky crust, served warm with a scoop of cinnamon ice cream", 600),
                new Dish("Crème Brûlée", "Silky smooth vanilla custard topped with a caramelized sugar crust", 400),
                new Dish("Strawberry Shortcake", "Fresh strawberries and sweetened whipped cream layered between tender shortcake biscuits", 450),
                new Dish("Molten Caramel Brownie", "Decadent fudgy brownie with a gooey caramel center, served with a drizzle of chocolate sauce", 550),
                new Dish("Panna Cotta", "Italian dessert made with sweetened cream and flavored with vanilla, topped with a berry compote", 350),
                new Dish("Key Lime Pie", "Tangy and refreshing key lime pie with a buttery graham cracker crust, garnished with whipped cream", 500),
                new Dish("Banana Split", "A classic dessert featuring scoops of ice cream, sliced bananas, chocolate sauce, whipped cream, and nuts", 600),
                new Dish("Red Velvet Cake", "Moist and velvety red velvet cake with layers of cream cheese frosting, beautifully decorated", 550),
                new Dish("Fruit Tart", "Buttery tart shell filled with a smooth pastry cream and topped with a colorful assortment of fresh fruits", 400),
                new Dish("Chocolate Mousse", "Light and airy chocolate mousse topped with a dollop of whipped cream and chocolate shavings", 350),
                new Dish("Pecan Pie", "Rich and gooey pecan pie with a flaky crust, filled with a sweet and nutty filling", 600),
                new Dish("Lemon Bars", "Tangy and sweet lemon bars with a buttery shortbread crust, dusted with powdered sugar", 400),
                new Dish("Bread Pudding", "Warm and comforting bread pudding made with custard-soaked bread, raisins, and a caramel drizzle", 500),
                new Dish("Mango Sorbet", "Refreshing mango sorbet made with ripe mangoes, perfect for a light and fruity dessert", 300),
                new Dish("Black Forest Cake", "Classic German cake with layers of chocolate cake, whipped cream, and cherries, garnished with chocolate shavings", 550),
                new Dish("Raspberry Swirl Cheesecake", "Creamy cheesecake swirled with raspberry sauce and topped with fresh raspberries", 500),
                new Dish("Ice Cream Sundae", "A delightful combination of ice cream, hot fudge, whipped cream, and a cherry on top", 450)
        };

        ArrayAdapter<Dish> dessertsAdapter = new ArrayAdapter<Dish>(
                this,
                android.R.layout.simple_list_item_1,
                desserts
        );

        dessertsListView.setAdapter(dessertsAdapter);

    }
}
