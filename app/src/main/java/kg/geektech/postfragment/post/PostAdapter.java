package kg.geektech.postfragment.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kg.geektech.intreface.ItemClick;
import kg.geektech.postfragment.databinding.ItemPostBinding;
import kg.geektech.postfragment.models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private HashMap<Integer, String> name = new HashMap<>();
    private List<Post> posts=new ArrayList<>();
    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        name.put(1,"Арслан");
        name.put(2,"Шамсуддин");
        name.put(3,"AZIZ");
        name.put(4,"Жаркынай");
        name.put(5,"Нурланбеков");
        name.put(6,"Нурсамад");
        name.put(7,"Кенжебаев");
        name.put(8,"Евгения");
        name.put(9,"Анипа");

        notifyDataSetChanged();
    }

    private ItemPostBinding binding;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void removeItem(int position) {
        posts.remove(position);
        notifyItemRemoved(position);
    }

    public Post getPost(int position) {
        return posts.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;
        public ViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding=binding;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClick.click(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemClick.longClick(getAdapterPosition());
                    return true;
                }
            });
        }

        public void onBind(Post post) {
            binding.tvUserId.setText(name.get(post.getUserId()));
            binding.tvTitle.setText(post.getTitle());
            binding.tvContent.setText(post.getContent());
            binding.tvGroup.setText(String.valueOf(post.getGroupId()));
        }
    }
}
