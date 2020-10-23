CREATE TABLE cars
(
    id         SERIAL primary key,
    model       VARCHAR(255),
    color      VARCHAR(10),

    horse_power BIGINT
);

INSERT into cars (model, color, horse_power)
VALUES ('FORD Mustang', 'Blue', 350);

INSERT into cars (model, color, horse_power)
VALUES ('Opel Mokka', 'Orange', 116);

INSERT into cars (model, color, horse_power)
VALUES ('Lada Vesta', 'Green', 95);

INSERT into cars (model, color, horse_power)
VALUES ('BMW X5', 'Dark Blue', 278);