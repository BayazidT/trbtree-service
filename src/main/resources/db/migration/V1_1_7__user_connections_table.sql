CREATE TABLE user_connections (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                                  requester_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                                  addressee_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                  status VARCHAR(20) NOT NULL,
    -- PENDING | ACCEPTED | REJECTED | BLOCKED

                                  created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                                  responded_at TIMESTAMPTZ,

                                  CONSTRAINT chk_connection_status
                                      CHECK (status IN ('PENDING', 'ACCEPTED', 'REJECTED', 'BLOCKED')),

                                  CONSTRAINT chk_no_self_connection
                                      CHECK (requester_id <> addressee_id),

                                  CONSTRAINT unique_connection UNIQUE (requester_id, addressee_id)
);

CREATE INDEX idx_uc_requester ON user_connections(requester_id);
CREATE INDEX idx_uc_addressee ON user_connections(addressee_id);
CREATE INDEX idx_uc_status ON user_connections(status);