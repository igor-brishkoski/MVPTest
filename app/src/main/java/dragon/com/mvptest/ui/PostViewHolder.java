package dragon.com.mvptest.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dragon.com.mvptest.R;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 12/16/16.
 */
class PostViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.post_list_item_text_title)
    TextView titleTextView;
    @BindView(R.id.post_list_item_text_body)
    TextView bodyTextView;

    interface PostInteractions {
        void goToPost();
    }


    PostViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void setup(Post post) {
        titleTextView.setText(post.getTitle());
        bodyTextView.setText(post.getBody());
    }
}