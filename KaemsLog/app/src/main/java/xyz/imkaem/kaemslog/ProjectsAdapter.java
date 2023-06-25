package xyz.imkaem.kaemslog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private Project[] projects;
    public ProjectsAdapter(Project[] projects) {
        this.projects = projects;
    }
    // called 1st
    @Override
    public int getItemCount() {
        return projects.length;
    }

    // called 2nd
    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    // called 3rd
    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(projects[position]);

    }


    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        // these are views we need to be held by this view holder
        private ImageView imageViewImage;
        private TextView textViewTitle;
        private TextView textViewDescription;


//        note that we annotate it with not null
        public ProjectViewHolder(@NotNull View itemView) {
            super(itemView);
            imageViewImage = itemView.findViewById(R.id.image_view_project_icon);
            textViewTitle = itemView.findViewById(R.id.text_view_project_title);
            textViewDescription = itemView.findViewById(R.id.text_view_project_description);


        }

        public void bind(Project project) {
            textViewTitle.setText(project.name);
            textViewDescription.setText(project.description);
            imageViewImage.setImageResource(project.image);

        }
    }

}
