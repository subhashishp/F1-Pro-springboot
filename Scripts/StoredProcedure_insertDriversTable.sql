DELIMITER $$

DROP PROCEDURE IF EXISTS insertDriversTable $$

CREATE PROCEDURE insertDriversTable()
BEGIN

    -- =========================
    -- Red Bull Racing
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (1, 'Max Verstappen', 'Netherlands', '1997-09-30', 4);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (11, 'Sergio Perez', 'Mexico', '1990-01-26', 4);


    -- =========================
    -- Ferrari
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (16, 'Charles Leclerc', 'Monaco', '1997-10-16', 3);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (55, 'Carlos Sainz', 'Spain', '1994-09-01', 3);


    -- =========================
    -- Mercedes
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (63, 'George Russell', 'United Kingdom', '1998-02-15', 2);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (31, 'Esteban Ocon', 'France', '1996-09-17', 2);


    -- =========================
    -- McLaren
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (4, 'Lando Norris', 'United Kingdom', '1999-11-13', 1);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (81, 'Oscar Piastri', 'Australia', '2001-04-06', 1);


    -- =========================
    -- Aston Martin
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (14, 'Fernando Alonso', 'Spain', '1981-07-29', 7);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (18, 'Lance Stroll', 'Canada', '1998-10-29', 7);


    -- =========================
    -- Alpine
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (10, 'Pierre Gasly', 'France', '1996-02-07', 10);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (19, 'Jack Doohan', 'Australia', '2003-01-20', 10);


    -- =========================
    -- Williams
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (23, 'Alexander Albon', 'Thailand', '1996-03-23', 5);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (2, 'Logan Sargeant', 'United States', '2000-12-31', 5);


    -- =========================
    -- RB (Visa Cash App RB)
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (22, 'Yuki Tsunoda', 'Japan', '2000-05-11', 6);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (3, 'Liam Lawson', 'New Zealand', '2002-02-11', 6);


    -- =========================
    -- Audi (formerly Sauber/Stake F1)
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (77, 'Valtteri Bottas', 'Finland', '1989-08-28', 8);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (24, 'Zhou Guanyu', 'China', '1999-05-30', 8);


    -- =========================
    -- Haas
    -- =========================
    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (20, 'Kevin Magnussen', 'Denmark', '1992-10-05', 9);

    INSERT INTO drivers (driver_number, driver_name, driver_country, driver_dob, constructor_id)
        VALUES (27, 'Nico Hulkenberg', 'Germany', '1987-08-19', 9);


END $$

DELIMITER ;