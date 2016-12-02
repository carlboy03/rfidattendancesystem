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


# --- !Downs

DROP TABLE attendance;

DROP TABLE enrollment;