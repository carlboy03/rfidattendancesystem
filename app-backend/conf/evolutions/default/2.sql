# --- Sections schema

# --- !Ups

CREATE TABLE course (
  course_id SERIAL NOT NULL PRIMARY KEY,
  course_code VARCHAR(9) NOT NULL,
  course_name VARCHAR(100) NOT NULL
);

CREATE TABLE sections (
  section_id SERIAL NOT NULL PRIMARY KEY,
  section_name VARCHAR(255) NOT NULL,
  course_id BIGINT NOT NULL REFERENCES course(course_id),
  section_term VARCHAR(255) NOT NULL,
  professor_id BIGINT NOT NULL references person(person_id),
  section_session BIGINT NOT NULL
);

# --- !Downs

DROP TABLE sections;

DROP TABLE course;