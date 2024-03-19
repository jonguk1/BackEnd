-- ȸ��
ALTER TABLE Member
	DROP CONSTRAINT PK_Member; -- ȸ�� �⺻Ű

-- ȸ��
DROP TABLE Member;

-- ȸ��
CREATE TABLE Member (
	userid  VARCHAR2(20)  NOT NULL, -- ���̵�
	name    VARCHAR2(30)  NOT NULL, -- �̸�
	pwd     varchar2(120)  NOT NULL, -- ��й�ȣ
	hp1     char(3)       NOT NULL, -- ����ó1
	hp2     char(4)       NOT NULL, -- ����ó2
	hp3     char(4)       NOT NULL, -- ����ó3
	post    char(5)       NOT NULL, -- �����ȣ
	addr1   varchar2(100) NULL,     -- �ּ�1
	addr2   varchar2(100) NULL,     -- �ּ�2
	indate  DATE          NULL,     -- ������
	mileage number(8)     NULL,     -- ���ϸ���
	mstate  number(1)     NULL      -- ȸ������
);

-- ȸ�� �⺻Ű
CREATE UNIQUE INDEX PK_Member
	ON Member ( -- ȸ��
		userid ASC -- ���̵�
	);

-- ȸ��
ALTER TABLE Member
	ADD
		CONSTRAINT PK_Member -- ȸ�� �⺻Ű
		PRIMARY KEY (
			userid -- ���̵�
		);
        
desc member;

----------------------
-- ���� ī�װ�
ALTER TABLE upCategory
	DROP CONSTRAINT PK_upCategory; -- ���� ī�װ� �⺻Ű

-- ���� ī�װ�
DROP TABLE upCategory;

-- ���� ī�װ�
CREATE TABLE upCategory (
	upcg_code number(8)    NOT NULL, -- ����ī�װ� �ڵ�
	upcg_name varchar2(30) NOT NULL  -- ���� ī�װ���
);

-- ���� ī�װ� �⺻Ű
CREATE UNIQUE INDEX PK_upCategory
	ON upCategory ( -- ���� ī�װ�
		upcg_code ASC -- ����ī�װ� �ڵ�
	);

-- ���� ī�װ�
ALTER TABLE upCategory
	ADD
		CONSTRAINT PK_upCategory -- ���� ī�װ� �⺻Ű
		PRIMARY KEY (
			upcg_code -- ����ī�װ� �ڵ�
		);
----------------------------------
-- ���� ī�װ�
ALTER TABLE downCategory
	DROP CONSTRAINT FK_upCategory_TO_downCategory; -- ���� ī�װ� -> ���� ī�װ�

-- ���� ī�װ�
ALTER TABLE downCategory
	DROP CONSTRAINT PK_downCategory; -- ���� ī�װ� �⺻Ű

-- ���� ī�װ�
DROP TABLE downCategory;

-- ���� ī�װ�
CREATE TABLE downCategory (
	upcg_code   number(8)    NOT NULL, -- ����ī�װ� �ڵ�
	downcg_code number(8)    NOT NULL, -- ���� ī�װ� �ڵ�
	downcg_name varchar2(30) NOT NULL  -- ���� ī�װ���
);

-- ���� ī�װ� �⺻Ű
CREATE UNIQUE INDEX PK_downCategory
	ON downCategory ( -- ���� ī�װ�
		upcg_code   ASC, -- ����ī�װ� �ڵ�
		downcg_code ASC  -- ���� ī�װ� �ڵ�
	);

-- ���� ī�װ�
ALTER TABLE downCategory
	ADD
		CONSTRAINT PK_downCategory -- ���� ī�װ� �⺻Ű
		PRIMARY KEY (
			upcg_code,   -- ����ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		);

-- ���� ī�װ�
ALTER TABLE downCategory
	ADD
		CONSTRAINT FK_upCategory_TO_downCategory -- ���� ī�װ� -> ���� ī�װ�
		FOREIGN KEY (
			upcg_code -- ����ī�װ� �ڵ�
		)
		REFERENCES upCategory ( -- ���� ī�װ�
			upcg_code -- ����ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
-----------------------------------------------
-- ��ǰ
ALTER TABLE Products
	DROP CONSTRAINT FK_downCategory_TO_Products; -- ���� ī�װ� -> ��ǰ

-- ��ǰ
ALTER TABLE Products
	DROP CONSTRAINT FK_upCategory_TO_Products; -- ���� ī�װ� -> ��ǰ

-- ��ǰ
ALTER TABLE Products
	DROP CONSTRAINT PK_Products; -- ��ǰ �⺻Ű

-- ��ǰ
DROP TABLE Products;

-- ��ǰ
CREATE TABLE Products (
	pnum        Number(8)      NOT NULL, -- ��ǰ��ȣ
	pname       varchar2(30)   NOT NULL, -- ��ǰ��
	pimage1     varchar2(100)  NULL,     -- �̹���1
	pimage2     varchar2(100)  NULL,     -- �̹���2
	pimage3     varchar2(100)  NULL,     -- �̹���3
	price       number(8)      NOT NULL, -- ��ǰ ����
	saleprice   number(8)      NOT NULL, -- ��ǰ �ǸŰ�
	pqty        number(8)      NOT NULL, -- ��ǰ ����
	point       number(8)      NULL,     -- ����Ʈ
	pspec       varchar2(20)   NULL,     -- ����
	pcontents   varchar2(1000) NULL,     -- ��ǰ����
	pcompany    varchar2(50)   NULL,     -- ������
	pdate       DATE           NULL,     -- �����
	upcg_code   number(8)      NULL,     -- ����ī�װ� �ڵ�
	downcg_code number(8)      NULL      -- ���� ī�װ� �ڵ�
);

-- ��ǰ �⺻Ű
CREATE UNIQUE INDEX PK_Products
	ON Products ( -- ��ǰ
		pnum ASC -- ��ǰ��ȣ
	);

-- ��ǰ
ALTER TABLE Products
	ADD
		CONSTRAINT PK_Products -- ��ǰ �⺻Ű
		PRIMARY KEY (
			pnum -- ��ǰ��ȣ
		);

-- ��ǰ
ALTER TABLE Products
	ADD
		CONSTRAINT FK_downCategory_TO_Products -- ���� ī�װ� -> ��ǰ
		FOREIGN KEY (
			upcg_code,   -- ����ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		)
		REFERENCES downCategory ( -- ���� ī�װ�
			upcg_code,   -- ����ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- ��ǰ
ALTER TABLE Products
	ADD
		CONSTRAINT FK_upCategory_TO_Products -- ���� ī�װ� -> ��ǰ
		FOREIGN KEY (
			upcg_code -- ����ī�װ� �ڵ�
		)
		REFERENCES upCategory ( -- ���� ī�װ�
			upcg_code -- ����ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
select * from tab;

create sequence product_seq nocache;

--cart
drop table cart;
create table cart(
	cnum number(8) primary key,
	userid varchar2(20) not null references member(userid) on delete cascade,
	pnum number(8) not null references products(pnum) on delete cascade,
	pqty number(8) check (pqty >0 and pqty<51),
	cdate date default sysdate
);

drop sequence cart_seq;
create sequence cart_seq nocache;

-- ��ٱ��� �� ����

create or replace view cartView
as 
select c.*,p.pname,p.pimage1, price,saleprice,point
    ,(c.pqty*p.saleprice) totalPrice
    ,(c.pqty*p.point) totalPoint
from cart c join products p
on c.pnum = p.pnum;












