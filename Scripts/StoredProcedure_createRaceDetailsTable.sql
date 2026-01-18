DELIMITER $$

CREATE PROCEDURE createF1RaceDetailsTable()
BEGIN

CREATE TABLE IF NOT EXISTS RaceDetails(
    
    race_id INT AUTO_INCREMENT PRIMARY KEY,
    race_number INT UNIQUE,
    race_name VARCHAR(100),
    race_date DATE,
    race_country VARCHAR(50)
);

END $$

DELIMITER ;