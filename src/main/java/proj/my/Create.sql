CREATE TABLE PERSONS
(
    name           text,
    surname        text,
    age            int,
    phone_number   text,
    city_of_living text,
    PRIMARY KEY (name, surname, age)
);