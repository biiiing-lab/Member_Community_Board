/*
DROP TABLE IF EXISTS Member;
create table Member(
                       memberId varchar(50),
                       password varchar(15),
                       memberName varchar(10),
                       email varchar(50),
                       regdate timestamp
);
DROP TABLE IF EXISTS BOARD;

create table BOARD(
                      boardId int generated by default as identity,
                      title varchar(20),
                      content varchar(500),
                      regDate timestamp,
                      modDate timestamp,
                      writer varchar(50)
);

 */
 /*
INSERT INTO BOARD (title, content, regDate, modDate, writer) VALUES ('제목111', '내용111', NOW(), NOW(), '이태석');
INSERT INTO BOARD (title, content, regDate, modDate, writer) VALUES ('제목222', '내용222', NOW(), NOW(), '김정민');
INSERT INTO BOARD (title, content, regDate, modDate, writer) VALUES ('제목333', '내용333', NOW(), NOW(), '장유빈');
INSERT INTO BOARD (title, content, regDate, modDate, writer) VALUES ('제목444', '내용444', NOW(), NOW(), '김태겸');


  */

