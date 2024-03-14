insert into member(userid,name,pwd,hp1,hp2,hp3,post,addr1,addr2,indate,mileage,mstate)
values('hong','홍길동','111','010','2222','3333','12345','서울 마포구 도화동','1번지'
,sysdate,1000,0);

commit;
select * from member;

desc upcategory;
insert into upcategory
values(1,'전자제품');
insert into upcategory
values(2,'생활용품');
insert into upcategory
values(3,'의류');

select * from upcategory;
commit;

desc downcategory;

insert into downcategory
values(1,1,'노트북');
insert into downcategory
values(1,2,'냉장고');

insert into downcategory
values(2,3,'주방세제');
insert into downcategory
values(2,4,'휴지');

insert into downcategory
values(3,5,'여성의류');
insert into downcategory
values(3,6,'남성의류');

select * from downcategory;

commit;





