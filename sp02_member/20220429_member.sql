SELECT * FROM member
WHERE email = 'hong@gmail.com';

SELECT * FROM member;

UPDATE member
SET passwd = '',
name = ''
WHERE email = 'hong@gmail.com';

DELETE FROM member
WHERE email = 'hong@gmail.com';
rollback;