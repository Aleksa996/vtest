CREATE TABLE customer_company (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE card_holder (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(50) NOT NULL,
    customer_company_id INT,
    FOREIGN KEY (customer_company_id) REFERENCES customer_company(id)
);

CREATE TABLE card (
    id INT PRIMARY KEY,
    card_number VARCHAR(16) NOT NULL UNIQUE,
    balance DECIMAL(10, 2) NOT NULL,
    card_holder_id INT,
    FOREIGN KEY (card_holder_id) REFERENCES card_holder(id)
);

CREATE TABLE category (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE merchant (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE customer_merchant (
    customer_id INT,
    merchant_id INT,
    discount_amount DECIMAL(5, 2) NOT NULL,
    PRIMARY KEY (customer_id, merchant_id),
    FOREIGN KEY (customer_id) REFERENCES customer_company(id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);

CREATE TABLE customer_category_benefit (
    customer_id INT,
    merchant_id INT,
    PRIMARY KEY (customer_id, merchant_id),
    FOREIGN KEY (customer_id) REFERENCES customer_company(id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);

CREATE TABLE `transaction` (
    id INT PRIMARY KEY,
    timestamp DATETIME NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    card_id INT,
    merchant_id INT,
    success VARCHAR(10) NOT NULL,
    FOREIGN KEY (card_id) REFERENCES card(id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);