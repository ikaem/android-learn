package xyz.imkaem.kaemslog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Project[] projects = {
                new Project("Mobile App Development", "Develop a feature-rich mobile application", R.drawable.p1),
                new Project("Website Redesign", "Revamp the company website with modern design and enhanced user experience", R.drawable.p2),
                new Project("Data Analysis", "Analyze large datasets to extract valuable insights for business decisions", R.drawable.p3),
                new Project("E-commerce Integration", "Integrate an online store into the existing website platform", R.drawable.p4),
                new Project("Cloud Migration", "Migrate on-premises infrastructure to a cloud environment", R.drawable.p5)
        };

        // find the recycler view
        RecyclerView recyclerViewProjects = findViewById(R.id.recycler_view_projects);

        // create adapter
        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projects);

        // set adapter on the recycler view
        recyclerViewProjects.setAdapter(projectsAdapter);
    }
}