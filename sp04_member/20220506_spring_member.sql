--회원테이블(member)
--이메일(email), 비밀번호(passwd), 이름(username)
--우편번호(zipcode), 도로명주소(addrload), 상세주소(addrdetail)
--프로필사진(filename), 이메일인증(emailauth), simplejoin(간편가입)
--등록일자(regidate), 수정일자(modidate)
DROP TABLE member;
CREATE TABLE member(
email VARCHAR2(50), --이메일
passwd VARCHAR2(60), --패스워드암호화(bcrypt)
username VARCHAR2(20), --이름
zipcode CHAR(5), --우편번호
addrload VARCHAR2(100), --도로명주소
addrdetail VARCHAR2(100), --상세주소
filename VARCHAR2(100), --프로필사진
emailauth CHAR(1) DEFAULT '0', --0:미인증, 1:인증
simplejoin CHAR(1) DEFAULT '0', --0:일반가입, 1:네이버, 2:카카오,3:구글
regidate DATE DEFAULT sysdate, --등록일자
modidate DATE DEFAULT sysdate, --수정일자
PRIMARY KEY (email)
);
--추가
insert into member(email,passwd,username,zipcode,addrload,addrdetail,filename)
values('park@gmail.com', '1111', '박자바', '11111', '신림로','6층', 'a.png');

--수정
update member
set 
passwd ='2222',
username='박보검',
zipcode='22222',
addrload='신림로',
addrdetail='르네상스 7층',
filename='b.png',
modidate=sysdate
where email = 'hong@gmail.com';

--삭제
delete from member
where email = 'hong@gmail.com';

--한건조회
select *  from member
where email = 'hong@gmail.com';

--전체조회
select * from member
where username like '%' || '홍' || '%';


rollback;