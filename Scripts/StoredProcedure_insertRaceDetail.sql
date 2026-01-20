DELIMITER $$

CREATE PROCEDURE insertRaceDetails()
BEGIN

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (1, 'Australian Grand Prix', '2025-03-16', 'Australia');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (2, 'Chinese Grand Prix', '2025-03-23', 'China');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (3, 'Japanese Grand Prix', '2025-04-06', 'Japan');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (4, 'Bahrain Grand Prix', '2025-04-13', 'Bahrain');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (5, 'Saudi Arabian Grand Prix', '2025-04-20', 'Saudi Arabia');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (6, 'Miami Grand Prix', '2025-05-04', 'United States');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (7, 'Emilia Romagna Grand Prix', '2025-05-18', 'Italy');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (8, 'Monaco Grand Prix', '2025-05-25', 'Monaco');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (9, 'Spanish Grand Prix', '2025-06-01', 'Spain');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (10, 'Canadian Grand Prix', '2025-06-15', 'Canada');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (11, 'Austrian Grand Prix', '2025-06-29', 'Austria');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (12, 'British Grand Prix', '2025-07-06', 'United Kingdom');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (13, 'Hungarian Grand Prix', '2025-07-20', 'Hungary');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (14, 'Belgian Grand Prix', '2025-08-03', 'Belgium');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (15, 'Dutch Grand Prix', '2025-08-31', 'Netherlands');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (16, 'Italian Grand Prix', '2025-09-07', 'Italy');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (17, 'Azerbaijan Grand Prix', '2025-09-21', 'Azerbaijan');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (18, 'Singapore Grand Prix', '2025-10-05', 'Singapore');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (19, 'United States Grand Prix', '2025-10-19', 'United States');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (20, 'Mexican Grand Prix', '2025-10-26', 'Mexico');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (21, 'Brazilian Grand Prix', '2025-11-09', 'Brazil');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (22, 'Las Vegas Grand Prix', '2025-11-22', 'United States');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (23, 'Qatar Grand Prix', '2025-11-30', 'Qatar');

INSERT INTO race_detail (race_number, race_name, race_date, race_country)
VALUES (24, 'Abu Dhabi Grand Prix', '2025-12-07', 'United Arab Emirates');

END $$

DELIMITER ;