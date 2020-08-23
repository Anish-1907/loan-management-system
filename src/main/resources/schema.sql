DROP TABLE IF EXISTS loans;
CREATE TABLE IF NOT EXISTS loans(loanId SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, userId SMALLINT UNSIGNED NOT NULL REFERENCES customer_registration(userId), loan_type VARCHAR(50), loan_amount int(20), loan_date DATE, rate_of_interest int(2), loan_duration int(2), PRIMARY KEY loans(loanId))