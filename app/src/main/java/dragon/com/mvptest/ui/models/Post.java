package dragon.com.mvptest.ui.models;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class Post {
    String title;
    String body;

    private Post(Builder builder) {
        this.title = checkNotNull(builder.title);
        this.body = checkNotNull(builder.body);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    public static class Builder {
        private String title;
        private String body;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder fromPrototype(Post prototype) {
            title = prototype.title;
            body = prototype.body;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}