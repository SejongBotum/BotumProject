
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

Drop table members;
create table members (
	member_id VARCHAR(50) not null, 
	member_pwd VARCHAR(50) not null, 
	member_name VARCHAR(50) not null, 
	is_professor TINYINT(1) not null default 0, 
	PRIMARY KEY(member_id)
);



drop table lectures;
create table lectures (
	lect_id INT(11) not null auto_increment, 
	member_id VARCHAR(50) not null, 
	lect_name VARCHAR(50) not null, 
	dir_name VARCHAR(50) not null,
	FOREIGN KEY (member_id) REFERENCES members(member_id),
	PRIMARY KEY(lect_id)
);
insert into lectures(member_id, lect_name, dir_name) values("p10001", "Unix프로그래밍(001)", "201720202922005617001");
insert into lectures(member_id, lect_name, dir_name) values("p10002", "소프트웨어특강2(001)", "201720202922009973001");
insert into lectures(member_id, lect_name, dir_name) values("p10003", "고급프로그래밍입문-P(013)", "201720209005009790013");
insert into lectures(member_id, lect_name, dir_name) values("p10004", "모바일프로그래밍(001)", "201720202922008066001");
insert into lectures(member_id, lect_name, dir_name) values("p10004", "JAVA프로그래밍(004)", "201620202922005130004");

select count(*) from lectures where member_id = 'p10004';

insert into members(member_id, member_pwd, member_name, is_professor) values("p10001", "1031", "박태순", 1);
insert into members(member_id, member_pwd, member_name, is_professor) values("p10002", "1031", "공성곤", 1);
insert into members(member_id, member_pwd, member_name, is_professor) values("p10003", "1031", "조승철", 1);
insert into members(member_id, member_pwd, member_name, is_professor) values("p10004", "1031", "안용학", 1);
insert into members(member_id, member_pwd, member_name, is_professor) values("p10004", "1031", "안용학", 1);
insert into members(member_id, member_pwd, member_name, is_professor) values("p10004", "1031", "안용학", 1);

		select count(*) from members where member_id='p10001' and member_pwd='1031';
