package xyz.imkaem.thehungryjava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCoursesActivity extends AppCompatActivity {
    ListView mainCoursesListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);

        mainCoursesListView = findViewById(R.id.list_view_main_courses);

        Dish[] mainCourses = {
                new Dish("Grilled Steak", "Juicy grilled steak served with mashed potatoes and roasted vegetables", 850),
                new Dish("Lemon Herb Roasted Chicken", "Tender roasted chicken seasoned with lemon and herbs, served with wild rice and steamed broccoli", 700),
                new Dish("Pasta Primavera", "Fresh mixed vegetables sautéed with garlic and tossed with pasta in a light cream sauce", 600),
                new Dish("Salmon with Dill Sauce", "Pan-seared salmon fillet topped with creamy dill sauce, accompanied by roasted potatoes and grilled asparagus", 800),
                new Dish("Beef Stir-Fry", "Sliced beef stir-fried with colorful bell peppers and onions, served over steamed rice", 750),
                new Dish("Eggplant Parmesan", "Breaded and baked eggplant slices layered with marinara sauce and melted cheese, served with spaghetti", 650),
                new Dish("Mushroom Risotto", "Creamy risotto cooked with a medley of mushrooms and finished with grated Parmesan cheese", 700),
                new Dish("Honey Glazed Ham", "Succulent honey glazed ham served with sweet potato casserole and green beans", 900),
                new Dish("Shrimp Scampi", "Sautéed shrimp in a garlic and butter sauce, served over linguine pasta", 800),
                new Dish("Vegetable Curry", "Assorted vegetables simmered in a fragrant curry sauce, served with basmati rice", 650),
                new Dish("Teriyaki Salmon", "Grilled salmon fillet glazed with teriyaki sauce, accompanied by jasmine rice and steamed bok choy", 750),
                new Dish("Chicken Parmesan", "Breaded chicken breast topped with marinara sauce and melted mozzarella cheese, served with spaghetti", 700),
                new Dish("Beef Bourguignon", "Slow-cooked beef stew with red wine, mushrooms, and pearl onions, served with buttered noodles", 850),
                new Dish("Stuffed Bell Peppers", "Bell peppers stuffed with a mixture of ground beef, rice, and vegetables, baked to perfection", 700),
                new Dish("Lobster Linguine", "Lobster tail sautéed in garlic butter and tossed with linguine pasta and fresh herbs", 900),
                new Dish("Vegetable Lasagna", "Layers of pasta, ricotta cheese, and mixed vegetables, baked with marinara sauce and melted mozzarella cheese", 650),
                new Dish("Roasted Pork Tenderloin", "Herb-marinated pork tenderloin roasted to perfection, served with roasted potatoes and steamed asparagus", 800),
                new Dish("Lamb Chops", "Grilled lamb chops seasoned with herbs and served with mint jelly, roasted potatoes, and grilled vegetables", 850),
                new Dish("Miso Glazed Cod", "Flaky cod fillet marinated in a savory miso glaze, accompanied by jasmine rice and stir-fried bok choy", 750),
                new Dish("Stuffed Portobello Mushrooms", "Portobello mushrooms stuffed with a mixture of breadcrumbs, cheese, and herbs, baked until golden", 650)
        };

        ArrayAdapter<Dish> mainCoursesAdapter = new ArrayAdapter<Dish>(
                this,
                android.R.layout.simple_list_item_1,
                mainCourses
        );

        // now pass adapter to the list view
        mainCoursesListView.setAdapter(mainCoursesAdapter);
    }
}
