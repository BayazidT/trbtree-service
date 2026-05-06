CREATE TABLE posts (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                       user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                       content TEXT NOT NULL,

                       visibility VARCHAR(20) NOT NULL DEFAULT 'PUBLIC',
    -- PUBLIC | CONNECTIONS | PRIVATE
                       like_count INT DEFAULT 0,
                       comment_count INT DEFAULT 0,

                       created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                       updated_at TIMESTAMPTZ,
                       deleted_at TIMESTAMPTZ
);

CREATE INDEX idx_posts_user_id ON posts(user_id);
CREATE INDEX idx_posts_created_at ON posts(created_at DESC);
CREATE INDEX idx_posts_visibility ON posts(visibility);