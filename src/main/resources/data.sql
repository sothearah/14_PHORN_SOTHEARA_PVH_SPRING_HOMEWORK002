SELECT * FROM instructors;
SELECT * FROM courses;
SELECT * FROM students;
SELECT * FROM student_course;


select * from student_course sc
    inner join courses c
        on sc.course_id  = c.course_id
         where sc.student_id = c.instructor_id;

select  from students;

INSERT INTO instructors (instructor_name, email)
VALUES ('Nayeon', 'nayeon@twice.com'),
       ('Jeongyeon', 'jeongyeon@twice.com'),
       ('Momo', 'momo@twice.com'),
       ('Sana', 'sana@twice.com'),
       ('Jihyo', 'jihyo@twice.com'),
       ('Mina', 'mina@twice.com');

INSERT INTO instructors (instructor_name, email)
VALUES ('Nayeon', 'nayeon@twice.com'),
       ('Jeongyeon', 'jeongyeon@twice.com'),
       ('Momo', 'momo@twice.com'),
       ('Sana', 'sana@twice.com'),
       ('Jihyo', 'jihyo@twice.com'),
       ('Mina', 'mina@twice.com'),
       ('Dahyun', 'dahyun@twice.com'),
       ('Chaeyoung', 'chaeyoung@twice.com'),
       ('Tzuyu', 'tzuyu@twice.com'),
       ('Minji', 'minji@newjeans.com'),
       ('Hanni', 'hanni@newjeans.com'),
       ('Danielle', 'danielle@newjeans.com'),
       ('Haerin', 'haerin@newjeans.com'),
       ('Hyein', 'hyein@newjeans.com'),
       ('Rosie', 'rosie@blackpink.com'),
       ('Jennie', 'jennie@blackpink.com'),
       ('Jisoo', 'jisoo@blackpink.com');



INSERT INTO courses (course_name, description, instructor_id)
VALUES ('K-Pop Dance Fundamentals', 'Learn basic K-pop dance moves and choreography', 1),
       ('Vocal Training 101', 'Master singing techniques for beginners', 2),
       ('Stage Presence Masterclass', 'How to command the stage like a pro', 3),
       ('Songwriting Workshop', 'Write your own K-pop style songs', 4),
       ('Music Production Basics', 'Introduction to digital music production', 5),
       ('Korean Language for Idols', 'Essential Korean phrases for K-pop', 6),
       ('Choreography Creation', 'Learn to create your own dance routines', 7),
       ('Performance Psychology', 'Mental preparation for stage performances', 8),
       ('Fashion & Styling', 'K-pop fashion and personal styling tips', 9),
       ('Group Harmony Training', 'Learn to sing in perfect harmony', 10);


INSERT INTO students (student_name, email, phone_number)
VALUES ('Kim Min-jun', 'minjun.kim@email.com', '010-1234-5678'),
       ('Lee Soo-jin', 'soojin.lee@email.com', '010-2345-6789'),
       ('Park Ji-hoon', 'jihoon.park@email.com', '010-3456-7890'),
       ('Choi Ye-na', 'yena.choi@email.com', '010-4567-8901'),
       ('Jung Seung-min', 'seungmin.jung@email.com', '010-5678-9012'),
       ('Kang Da-hyun', 'dahyun.kang@email.com', '010-6789-0123'),
       ('Yoon Seo-young', 'seoyoung.yoon@email.com', '010-7890-1234'),
       ('Im Na-yeon', 'nayeon.im@email.com', '010-8901-2345'),
       ('Han Ji-won', 'jiwon.han@email.com', '010-9012-3456'),
       ('Song Min-ah', 'minah.song@email.com', '010-0123-4567');



INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (2, 5),
       (3, 4),
       (3, 7),
       (4, 6),
       (4, 9),
       (5, 8),
       (5, 10),
       (6, 1),
       (7, 2),
       (8, 3),
       (9, 4),
       (10, 5);



