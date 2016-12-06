# --- Enrollment and Attendance schema

# --- !Ups
CREATE TABLE enrollment (
  enrollment_id SERIAL NOT NULL PRIMARY KEY,
  enrollment_student_id BIGINT,
  enrollment_section_id BIGINT
);

CREATE TABLE attendance (
  attendance_id SERIAL NOT NULL PRIMARY KEY,
  attendance_status BOOLEAN NOT NULL DEFAULT FALSE,
  attendance_date TIMESTAMP WITH TIME ZONE DEFAULT now(),
  attendance_student_id BIGINT NOT NULL REFERENCES person(person_id), -- Student ID
  attendance_section_session BIGINT NOT NULL, -- The nth session of a x credit course.
  attendance_comment TEXT,
  attendance_section_id BIGINT NOT NULL
);

INSERT INTO enrollment(enrollment_student_id, enrollment_section_id)VALUES(2,1),
  (2,4),
  (3,3),
  (3,1),
  (3,6),
  (4,5),
  (4,2),
  (5,1),
  (5,3),
  (6,5),
  (6,1),
  (7,2),
  (7,3),
  (8,4),
  (8,5),
  (9,1),
  (9,2),
  (10,3),
  (10,4),
  (11,5),
  (11,1),
  (2,3),
  (3,4),
  (4,1),
  (4,3);

INSERT INTO attendance(attendance_status,
                       attendance_date, attendance_student_id,
                       attendance_section_session, attendance_section_id)
VALUES
      (TRUE,DATE '2016-08-16' ,2,1,1),
      (TRUE,DATE '2016-08-18',2,2,1),
      (FALSE,DATE '2016-08-23',2,3,1),
      (TRUE,DATE '2016-08-25',2,4,1),
      (TRUE,DATE '2016-08-16',2,1,4),
      (FALSE,DATE '2016-08-18',2,2,4),
      (FALSE,DATE '2016-08-23',2,3,4),
      (TRUE,DATE '2016-08-25',2,4,4),
      (TRUE,DATE '2016-08-16',3,1,3),
      (FALSE,DATE '2016-08-18',3,2,3),
      (FALSE,DATE '2016-08-23',3,3,3),
      (TRUE,DATE '2016-08-25',3,4,3),
      (TRUE,DATE '2016-08-16',3,1,1),
      (TRUE,DATE '2016-08-18',3,2,1),
      (FALSE,DATE '2016-08-23',3,3,1),
      (TRUE,DATE '2016-08-25',3,4,1),
      (TRUE,DATE '2016-08-16',4,1,5),
      (TRUE,DATE '2016-08-18',4,2,5),
      (FALSE,DATE '2016-08-23',4,3,5),
      (FALSE,DATE '2016-08-25',4,4,5),
      (TRUE,DATE '2016-08-16',4,1,2),
      (TRUE,DATE '2016-08-18',4,2,2),
      (FALSE,DATE '2016-08-23',4,3,2),
      (TRUE,DATE '2016-08-25',4,4,2),
      (TRUE,DATE '2016-08-16',5,1,1),
      (TRUE,DATE '2016-08-18',5,2,1),
      (TRUE,DATE '2016-08-23',5,3,1),
      (TRUE,DATE '2016-08-25',5,4,1),
      (TRUE,DATE '2016-08-16',5,1,3),
      (TRUE,DATE '2016-08-18',5,2,3),
      (FALSE,DATE '2016-08-23',5,3,3),
      (TRUE,DATE '2016-08-25',5,4,3),
      (TRUE,DATE '2016-08-16',6,1,1),
      (TRUE,DATE '2016-08-18',6,2,1),
      (FALSE,DATE '2016-08-23',6,3,1),
      (TRUE,DATE '2016-08-25',6,4,1),
      (FALSE,DATE '2016-08-16',6,1,5),
      (FALSE,DATE '2016-08-18',6,2,5),
      (FALSE,DATE '2016-08-23',6,3,5),
      (FALSE,DATE '2016-08-25',6,4,5),
      (TRUE,DATE '2016-08-16',7,1,2),
      (TRUE,DATE '2016-08-18',7,2,2),
      (FALSE,DATE '2016-08-23',7,3,2),
      (TRUE,DATE '2016-08-25',7,4,2),
      (TRUE,DATE '2016-08-16',7,1,3),
      (TRUE,DATE '2016-08-18',7,2,3),
      (FALSE,DATE '2016-08-23',7,3,3),
      (TRUE,DATE '2016-08-25',7,4,3);


# --- !Downs

DROP TABLE attendance;

DROP TABLE enrollment;