--상품마스터
drop table product;
CREATE TABLE product(
pcode char(4) NOT NULL,
pname varchar(50) NOT NULL,
price number(6) NOT NULL,
regidate DATE DEFAULT sysdate,
PRIMARY KEY(pcode)
);

INSERT INTO product(pcode, pname, price) VALUES('8801', '사이다',1200 );
SELECT * FROM product;

--상품리스트
SELECT * FROM product
WHERE pname like '%' || '사이' || '%';


--판매테이블
drop table sales;
CREATE TABLE sales(
seq number(5) not null,
sdate char(10) not null,
pcode char(4) not null,
qty number(5) not null,
amount number(10) not null,
regidate DATE DEFAULT sysdate,
PRIMARY KEY(seq),
FOREIGN KEY(pcode) REFERENCES product(pcode)
);
drop sequence s_seq;
create SEQUENCE s_seq ;
insert into sales(seq,sdate, pcode, qty, amount) values(s_seq.nextval,'2022-03-17', '8801', 2 , 2400);

select s.pcode, p.pname, p.price, s.qty, s.amount
from sales s join product p on(s.pcode=p.pcode)
where s.sdate = '2022-03-17';


commit;
rollback;