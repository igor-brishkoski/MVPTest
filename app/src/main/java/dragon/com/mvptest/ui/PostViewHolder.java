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

    private Post post;

    interface PostInteractions {
        void goToPost(final Post post);
    }


    PostViewHolder(final View itemView, final PostInteractions listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        bodyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                listener.goToPost(post);
            }
        });
    }

    void setup(Post post) {
        this.post = post;
        titleTextView.setText(post.getTitle());
        bodyTextView.setText(post.getBody());


    }
}