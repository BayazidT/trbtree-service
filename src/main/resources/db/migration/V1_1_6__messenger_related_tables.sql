CREATE TABLE conversations (
                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                               type VARCHAR(20) NOT NULL DEFAULT 'DIRECT',
                               last_message_id UUID,

    -- DIRECT | GROUP (future-safe)

                               created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                               updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE conversation_participants (
                                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                                           conversation_id UUID NOT NULL REFERENCES conversations(id) ON DELETE CASCADE,
                                           user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                           joined_at       TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                                           last_read_at    TIMESTAMPTZ,

                                           is_muted        BOOLEAN NOT NULL DEFAULT FALSE,

                                           UNIQUE (conversation_id, user_id)
);

CREATE TABLE messages (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                          conversation_id UUID NOT NULL REFERENCES conversations(id) ON DELETE CASCADE,
                          sender_id       UUID NOT NULL REFERENCES users(id),

                          content         TEXT NOT NULL,
    -- later: encrypted_content

                          message_type    VARCHAR(20) NOT NULL DEFAULT 'TEXT',
    -- TEXT | IMAGE | FILE

                          created_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                          edited_at       TIMESTAMPTZ,
                          deleted_at      TIMESTAMPTZ
);

CREATE INDEX idx_messages_conversation
    ON messages(conversation_id, created_at DESC);

CREATE INDEX idx_messages_sender
    ON messages(sender_id);

CREATE INDEX idx_cp_user
    ON conversation_participants(user_id);

CREATE INDEX idx_cp_conversation
    ON conversation_participants(conversation_id);