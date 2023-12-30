CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sender_id INT(10) NOT NULL,
    receiver_id INT(10) NOT NULL,
    account_number VARCHAR(20) NOT NULL,
    transaction_type ENUM('Deposit', 'Withdrawal', 'Transfer', 'QtellaCode') NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES accounts(account_number),
    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id)
);