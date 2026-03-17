SELECT * FROM instructors;

INSERT INTO instructors (instructor_name, email) VALUES
                                          ('Nayeon', 'nayeon@twice.com'),
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
UPDATE instructors SET instructor_name = 'add', email = '#{req.email}'
WHERE instructor_id = 1;

SELECT * FROM instructors;