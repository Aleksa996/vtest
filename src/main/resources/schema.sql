CREATE TABLE IF NOT EXISTS card_holder (
    id int PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS card (
    id int PRIMARY KEY,
    card_number VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES card_holder(id)
);

CREATE TABLE IF NOT EXISTS merchant (
    id int PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS transaction (
    id int PRIMARY KEY,
    timestamp TIMESTAMP NOT NULL,
    amount DOUBLE NOT NULL,
    card_id BIGINT,
    merchant_id BIGINT,
    success BOOLEAN NOT NULL,
    FOREIGN KEY (card_id) REFERENCES card(id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);