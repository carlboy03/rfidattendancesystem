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

INSERT INTO enrollment(enrollment_student_id, enrollment_section_id)
VALUES(2,1),
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

INSERT INTO attendance(atendance_status,
                       attendance_date,
                       attendance_student_id,
                       attendance_section_session,
                       attendance_section_id)
    VALUES
      (TRUE,"08/16/2016",2,1,1),
      (TRUE,"08/18/2016",2,2,1),
      (FALSE,"08/23/2016",2,3,1),
      (TRUE,"08/25/2016",2,4,1),

      (TRUE,"08/16/2016",2,1,4),
      (FALSE,"08/18/2016",2,2,4),
      (FALSE,"08/23/2016",2,3,4),
      (TRUE,"08/25/2016",2,4,4),

      (TRUE,"08/16/2016",3,1,3),
      (FALSE,"08/18/2016",3,2,3),
      (FALSE,"08/23/2016",3,3,3),
      (TRUE,"08/25/2016",3,4,3),

      (TRUE,"08/16/2016",3,1,1),
      (TRUE,"08/18/2016",3,2,1),
      (FALSE,"08/23/2016",3,3,1),
      (TRUE,"08/25/2016",3,4,1),

      (TRUE,"08/16/2016",4,1,5),
      (TRUE,"08/18/2016",4,2,5),
      (FALSE,"08/23/2016",4,3,5),
      (FALSE,"08/25/2016",4,4,5),

      (TRUE,"08/16/2016",4,1,2),
      (TRUE,"08/18/2016",4,2,2),
      (FALSE,"08/23/2016",4,3,2),
      (TRUE,"08/25/2016",4,4,2),

      (TRUE,"08/16/2016",5,1,1),
      (TRUE,"08/18/2016",5,2,1),
      (TRUE,"08/23/2016",5,3,1),
      (TRUE,"08/25/2016",5,4,1),

      (TRUE,"08/16/2016",5,1,3),
      (TRUE,"08/18/2016",5,2,3),
      (FALSE,"08/23/2016",5,3,3),
      (TRUE,"08/25/2016",5,4,3),

      (TRUE,"08/16/2016",6,1,1),
      (TRUE,"08/18/2016",6,2,1),
      (FALSE,"08/23/2016",6,3,1),
      (TRUE,"08/25/2016",6,4,1),

      (FALSE,"08/16/2016",6,1,5),
      (FALSE,"08/18/2016",6,2,5),
      (FALSE,"08/23/2016",6,3,5),
      (FALSE,"08/25/2016",6,4,5),

      (TRUE,"08/16/2016",7,1,2),
      (TRUE,"08/18/2016",7,2,2),
      (FALSE,"08/23/2016",7,3,2),
      (TRUE,"08/25/2016",7,4,2),

      (TRUE,"08/16/2016",7,1,3),
      (TRUE,"08/18/2016",7,2,3),
      (FALSE,"08/23/2016",7,3,3),
      (TRUE,"08/25/2016",7,4,3)
     ;


      # --- !Downs

DROP TABLE attendance;

DROP TABLE enrollment;