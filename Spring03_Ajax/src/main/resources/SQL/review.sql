
drop table review;
-- products ���̺��� pnum(PK)�� member���̺��� userid(PK)�� �ܷ�Ű�� ����
-- �ϴ� ajax�� �����ϰ�
create table review(
	no number(8) primary key, --���� �۹�ȣ
	userid varchar(2) not null, --references member(userid) on delete cascade,
	pnum number(8) not null, --references products(pnum) on delete cascade,
	title varchar2(200) not null, --����
	content varchar2(500), --�۳���
	score number(1) constraint score_ck check(score>0 and score<=5),
	filename varchar2(300),
	wdate date default sysdate
);


drop sequence review_seq;

create sequence review_seq nocache;