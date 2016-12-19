package dragon.com.mvptest.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dragon.com.mvptest.R;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 12/16/16.
 */

class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts;

    PostsAdapter(final List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new PostViewHolder(View.inflate(parent.getContext(), R.layout.post_list_item,
                null));
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, final int position) {
        holder.setup(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


}