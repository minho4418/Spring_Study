--ȸ�����̺�(member)
--�̸���(email), ��й�ȣ(passwd), �̸�(username)
--�����ȣ(zipcode), ���θ��ּ�(addrload), ���ּ�(addrdetail)
--�����ʻ���(filename), �̸�������(emailauth), simplejoin(������)
--�������(regidate), ��������(modidate)
DROP TABLE member;
CREATE TABLE member(
email VARCHAR2(50), --�̸���
passwd VARCHAR2(60), --�н������ȣȭ(bcrypt)
username VARCHAR2(20), --�̸�
zipcode CHAR(5), --�����ȣ
addrload VARCHAR2(100), --���θ��ּ�
addrdetail VARCHAR2(100), --���ּ�
filename VARCHAR2(100), --�����ʻ���
emailauth CHAR(1) DEFAULT '0', --0:������, 1:����
simplejoin CHAR(1) DEFAULT '0', --0:�Ϲݰ���, 1:���̹�, 2:īī��,3:����
regidate DATE DEFAULT sysdate, --�������
modidate DATE DEFAULT sysdate, --��������
PRIMARY KEY (email)
);
--�߰�
insert into member(email,passwd,username,zipcode,addrload,addrdetail,filename)
values('park@gmail.com', '1111', '���ڹ�', '11111', '�Ÿ���','6��', 'a.png');

--����
update member
set 
passwd ='2222',
username='�ں���',
zipcode='22222',
addrload='�Ÿ���',
addrdetail='���׻� 7��',
filename='b.png',
modidate=sysdate
where email = 'hong@gmail.com';

--����
delete from member
where email = 'hong@gmail.com';

--�Ѱ���ȸ
select *  from member
where email = 'hong@gmail.com';

--��ü��ȸ
select * from member
where username like '%' || 'ȫ' || '%';


rollback;