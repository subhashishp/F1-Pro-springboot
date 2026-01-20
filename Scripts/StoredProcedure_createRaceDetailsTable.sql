DELIMITER $$

CREATE PROCEDURE createF1RaceDetailsTable()
BEGIN

CREATE TABLE IF NOT EXISTS race_detail(
    
    race_id INT AUTO_INCREMENT PRIMARY KEY,
    race_number INT,
    race_name VARCHAR(100),
    race_date DATE,
    race_country VARCHAR(50),
    race_winner INT
);

END $$

DELIMITER ;