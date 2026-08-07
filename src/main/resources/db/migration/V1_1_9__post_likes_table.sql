CREATE TABLE post_likes(
                          id SERIAL PRIMARY KEY,
                          post_id UUID NOT NULL REFERENCES posts(id) ON DELETE CASCADE,
                          user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                          is_liked BOOLEAN NOT NULL DEFAULT TRUE
);