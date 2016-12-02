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
      ('Carlos', 'Fuentes', 0, '801082118', 'jkdoe740pkstekdu271h', 'carlos.fuentes1@upr.edu', 'password'),
      ('Maria', 'Jimenez', 0, '840103836', 'jkdoe740pkstekdu271i', 'maria.jimenez21@upr.edu', 'password'),
      ('Michael', 'Mercado', 0, '844104968', 'jkdoe740pkstekdu271j', 'michael.mercado5@upr.edu', 'password'),
      ('Jaime', 'Gonzalez', 0, '801081111', 'jkdoe740pkstekdu271l', 'jaime.gonzalez5@upr.edu', 'password'),
      ('Charlie', 'Castro', 0, '802101111', 'jkdoe740pkstekdu271n', 'charlie.castro@upr.edu', 'password'),
      ('Jean', 'Jordan', 0, '802101114', 'jkdoe740pkstekdu271o', 'jean.yordan@upr.edu', 'password'),
      ('Jean', 'Rodriguez', 0, '802101115', 'jkdoe740pkstekdu271p', 'jean.rodriguez@upr.edu', 'password'),
      ('Armando', 'Ortiz', 0, '802101116', 'jkdoe740pkstekdu271q', 'armando.ortiz1@upr.edu', 'password'),
      ('Javier', 'Colon', 0, '802101117', 'jkdoe740pkstekdu271r', 'javier.colon15@upr.edu', 'password'),
      ('Carlos', 'Bernal', 1, '802141234', 'cdjkiuelow90375jckdm', 'carlosjulio.bernal@upr.edu', 'password');

# --- !Downs

DROP TABLE person;

















