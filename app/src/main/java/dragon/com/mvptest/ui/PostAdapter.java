package dragon.com.mvptest.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import dragon.com.mvptest.R;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 12/16/16.
 */

class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts;
    private PostViewHolder.PostInteractions listener;

    PostsAdapter(final List<Post> posts, PostViewHolder.PostInteractions listener) {
        this.posts = posts;
        this.listener = listener;
    }

    @Override
    public PostViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new PostViewHolder(inflater.inflate(R.layout.post_list_item, parent, false), listener);
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