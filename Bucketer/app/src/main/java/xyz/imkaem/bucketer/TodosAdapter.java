package xyz.imkaem.bucketer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    Todo[] todos;

    TodosAdapter(Todo[] todos) {
        this.todos = todos;

    }

    @Override
    public int getItemCount() {
        return todos.length;
    }

    @NonNull
    @Override
    public TodosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new TodosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodosViewHolder holder, int position) {
        holder.bind(todos[position]);

    }


    static class TodosViewHolder extends RecyclerView.ViewHolder {
        //        ok, so this has few fields from itemTodo
        private ImageView imageViewImage;
        private TextView textViewTitle;
        private TextView textViewDescription;
        private RatingBar ratingBarRating;

        public TodosViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewImage = itemView.findViewById(R.id.image_view_todo_image);
            textViewTitle = itemView.findViewById(R.id.text_view_todo_title);
            textViewDescription = itemView.findViewById(R.id.text_view_todo_description);
            ratingBarRating = itemView.findViewById(R.id.rating_bar_rating);
        }

        public void bind(Todo todo) {

            float rating = 3.7f;

            textViewTitle.setText(todo.name);
            textViewDescription.setText(todo.description);
            imageViewImage.setImageResource(todo.image);
            ratingBarRating.setRating(rating);
        }

//        constructor


//        binder


    }
}
