insert into member(userid,name,pwd,hp1,hp2,hp3,post,addr1,addr2,indate,mileage,mstate)
values('hong','ȫ�浿','111','010','2222','3333','12345','���� ������ ��ȭ��','1����'
,sysdate,1000,0);

commit;
select * from member;

desc upcategory;
insert into upcategory
values(1,'������ǰ');
insert into upcategory
values(2,'��Ȱ��ǰ');
insert into upcategory
values(3,'�Ƿ�');

select * from upcategory;
commit;

desc downcategory;

insert into downcategory
values(1,1,'��Ʈ��');
insert into downcategory
values(1,2,'�����');

insert into downcategory
values(2,3,'�ֹ漼��');
insert into downcategory
values(2,4,'����');

insert into downcategory
values(3,5,'�����Ƿ�');
insert into downcategory
values(3,6,'�����Ƿ�');

select * from downcategory;

commit;





