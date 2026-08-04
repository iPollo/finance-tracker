CREATE TABLE category (
                          id          BIGSERIAL PRIMARY KEY,
                          name        VARCHAR(100) NOT NULL,
                          type        VARCHAR(20) NOT NULL CHECK (type IN ('RECEITA', 'DESPESA')),
                          color       VARCHAR(7),
                          created_at  TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at  TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_category_type ON category (type);