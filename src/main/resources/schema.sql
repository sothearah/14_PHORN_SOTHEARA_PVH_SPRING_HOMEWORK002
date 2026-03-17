ALTER TABLE instructors
    RENAME COLUMN name TO instructor_name;

CREATE TABLE IF NOT EXISTS instructors(
                                          instructor_id SERIAL PRIMARY KEY,
                                          name VARCHAR(20) NOT NULL,
                                          email VARCHAR(20) NOT NULL
);
