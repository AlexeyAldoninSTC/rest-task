CREATE TABLE data
(
    id    SERIAL primary key,
    title VARCHAR(20),
    text  VARCHAR(255)
);

INSERT INTO data (title, text)
VALUES ('Kinda Article', 'You are reading some Article. Hope you enjoy');

INSERT INTO data (title, text)
VALUES ('Another Article', 'So, this is another one... Seems like you are really fascinated');