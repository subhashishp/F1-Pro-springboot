DELIMITER $$

DROP PROCEDURE IF EXISTS createF1DriversTable $$

CREATE PROCEDURE createF1DriversTable()
BEGIN
    CREATE TABLE IF NOT EXISTS drivers(
        driver_id INT AUTO_INCREMENT PRIMARY KEY, 
        driver_number INT,
        driver_name VARCHAR(100),
        driver_country VARCHAR(100),
        driver_dob DATE,
        constructor_id INT,
        FOREIGN KEY (constructor_id) REFERENCES constructors(constructor_id)
    );
END $$

DELIMITER ;