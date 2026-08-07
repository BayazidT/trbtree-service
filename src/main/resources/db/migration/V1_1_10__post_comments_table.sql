CREATE TABLE post_comments(
                          id SERIAL PRIMARY KEY,
                          parent_id INTEGER REFERENCES post_comments(id) ON DELETE CASCADE,
                          post_id UUID NOT NULL REFERENCES posts(id) ON DELETE CASCADE,
                          user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                          comment TEXT,
                          created_at          TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
                          updated_at          TIMESTAMPTZ     DEFAULT NOW(),
                          deleted_at          TIMESTAMPTZ
);