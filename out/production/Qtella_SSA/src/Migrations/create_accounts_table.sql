
CREATE TABLE IF NOT EXISTS accounts (
    account_number VARCHAR(20) NOT NULL PRIMARY KEY,
    user_id INT(10) NOT NULL,
    account_type ENUM('Savings', 'Checking') NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0,
    opened_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);