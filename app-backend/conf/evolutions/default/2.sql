# --- Sections schema

# --- !Ups

CREATE TABLE course (
  course_id SERIAL NOT NULL PRIMARY KEY,
  course_code VARCHAR(9) NOT NULL,
  course_name VARCHAR(100) NOT NULL
);

INSERT INTO course (course_code, course_name)
VALUES( 'MATE3005', 'PRE CALCULO'),
  ('QUIM3001', 'Quimica General I'),
  ('INGE3011', 'Graficas de Ingenieria'),
  ('ESPA3101', 'Curso Basico de Espanol'),
  ('EDFI3245', 'Natacion Elemental'),
  ('INGL3101', 'Curso Basico Ingles'),
  ('QUIM3132', 'Quimica General II'),
  ('INGL3102', 'Curso Basico Ingles'),
  ('ESPA3102', 'Curso Basico de Espanol'),
  ('EDFI3596', 'Fundamentos de Balonpie'),
  ('MATE3152', 'Calculo II'),
  ('ICOM4215', 'Arquitectura y Organizacion'),
  ('INEL4301', 'Teoria de Comunicacion'),
  ('INEL4225', 'Lab Electronica Digital'),
  ('INME4045', 'Termodinamica General Para Ingenieros'),
  ('HIST3222', 'Historia de Las Antillas'),
  ('ICOM5007', 'Programacion de Sistemas Operativos'),
  ('ININ4015', 'Analisis Economico para Ingenieros'),
  ('CISO3121', 'Intro a Ciencias Sociales'),
  ('ICOM4217', 'Diseno de sistemas embebidos');

CREATE TABLE sections (
  section_id SERIAL NOT NULL PRIMARY KEY,
  section_name VARCHAR(255) NOT NULL,
  course_id BIGINT NOT NULL REFERENCES course(course_id),
  section_term VARCHAR(255) NOT NULL,
  professor_id BIGINT NOT NULL references person(person_id));

INSERT INTO sections(section_name, course_id, section_term, professor_id)
VALUES('020', 5, 'A2016', 12),
  ('020', 20, 'A2016', 12),
  ('040', 5, 'A2016', 1),
  ('040', 10, 'A2016', 12),
  ('060', 5, 'A2016', 12);
# --- !Downs

DROP TABLE sections;

DROP TABLE course;