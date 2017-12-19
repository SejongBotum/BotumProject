
drop table test1;
create table test1(
	id INT,
	val varchar(30),
	CONSTRAINT PK_test1 PRIMARY KEY (id)
);

drop table member;
create table member(
	id varchar(30),
	pw varchar(30),
	name varchar(30),
	is_professor INT,
	constraint PK_member primary key (id)
);

select * from member;
insert into member(id, pw, name, is_professor) values("admin", "1031", "관리자", 1);