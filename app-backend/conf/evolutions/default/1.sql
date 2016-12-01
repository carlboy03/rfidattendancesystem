# --- Person Schema

# --- !Ups
CREATE TABLE person (
  person_id SERIAL NOT NULL PRIMARY KEY,
  person_name VARCHAR(255) NOT NULL,
  person_last_name VARCHAR(50) NOT NULL,
  person_type INT NOT NULL DEFAULT 0,
  person_uprm_id VARCHAR(255) NOT NULL,
  person_rfid VARCHAR(255) NOT NULL,
  person_email VARCHAR(255) NOT NULL,
  person_password VARCHAR(255) NOT NULL
);

INSERT INTO person(person_name, person_last_name, person_type, person_uprm_id, person_rfid, person_email, person_password)
    VALUES ('Manuel', 'Jimenez', 1, '802669090', 'cdjkiuelow90375jckdl', 'manuel.jimenez@upr.edu', 'password'),
      ('Jan', 'Vega', 0, '802119390', 'jkldoeu73892mch3849k', 'jan.vega1@upr.edu', 'password'),
      ('Carlos', 'Fuentes', 0, '801082118', 'jkdoe740pkstekdu271h', 'carlos.fuentes1@upr.edu', 'password');

# --- !Downs

DROP TABLE person;

















