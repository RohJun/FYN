
-- Find Your NFT 
-- 회원 테이블
-- NFT 테이블
-- 장바구니 테이블
-- 댓글 테이블
-- 공지사항 테이블

-- 테이블 조회
select * from member;
select * from nft;
select * from cart;
select * from reply;
select * from notice;

-- 테이블 삭제
drop table member;
drop table nft;
drop table cart;
drop table reply;
drop table notice;

-- 회원정보 테이블 생성
create table member(
	memId varchar(50) primary key,
	memPassword varchar(50),
	memName varchar(50),
	memEmail varchar(50),
	memPhone varchar(50),
	memMoney int default 50000,
	memRank int default 0

);
-- 회원 데이터 삽입
 insert into member (memId,memPassword,memName,memEmail,memPhone,memRank)
 values ('adminroh','jr960823','Jun Roh','junroh@naver.com','01050051954',1); 
 insert into member (memId,memPassword,memName,memEmail,memPhone,memRank)
 values ('test04','1234','test','junroh@naver.com','01050051954',0); 

 
insert into member (memId,memPw,memName,memEmail,memAddress,memPic,memRank)
 values ('cltjs','qwer1234!','인치선','cltjs@naver.com','서울시 관악구','/img/testmonial/profile05.png',0);
 
-- 회원 데이터 수정(회원권한)
update member set memPw='1234',memEmail='muscle@gmail.com',memPhone='010-1111-2222',memAddress='경기도 안산시 상록구',memPic='' where memId='muscleboy';
-- 회원 데이터 수정(관리자권한)
update member set memEmail='muscle@gmail.com',memRank='1',memPoint=memPoint+100,memPhone='010-1111-2222',memAddress='경기도 안산시 상록구',memPic='' where memId='muscleboy';
-- 회원 데이터 삭제
delete from member where memId=junroh;
update member set memPic='/img/testmonial/profile03.png' where memId='junroh';

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --


-- NFT 테이블 생성
create table nft(
	nftId int primary key,
	nftTitle varchar(500) not null,
	nftDate date DEFAULT SYSDATE,
	nftPrice int,
	nftPic varchar(500),
	nftStatus int DEFAULT 0
);

update nft set nftStatus=1 where nftId=1001;
update nft set nftStatus=nftStatus+1 where nftId=1002;
select * from nft; where nftTitle like '%'||'Crypto'||'%' order by nftTitle DESC;

insert into nft (nftId,nftTitle,nftPrice,nftPic) values((select nvl(max(nftId),1000)+1 from nft),'CryptoPunk 2234',5000,'/img/sample01.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values(3,'test',5000,'/test/testimg.png');

insert into nft (nftId,nftTitle,nftPic) values (1000,"CryptoPunk #2234","sample01.png");
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1050,'CryptoPunk1231',5000,'sample20.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1001,'CryptoPunk2234',6000,'sample02.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1002,'CryptoPunk6576',7000,'sample03.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1003,'CryptoPunk9966',10000,'sample04.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1004,'CryptoPunk3264',50000,'sample05.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1005,'CryptoPunk0098',25000,'sample06.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1006,'CryptoPunk7388',55000,'sample07.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1007,'CryptoPunk5426',15000,'sample08.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1008,'CryptoPunk8666',5000,'sample09.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1009,'CryptoPunk3333',5000,'sample10.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1010,'CryptoPunk1689',5000,'sample11.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1011,'CryptoPunk5100',5000,'sample12.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1012,'CryptoPunk5100',5000,'sample13.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1013,'CryptoPunk000',5000,'sample02.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1014,'CryptoPunk111',5000,'sample01.png');
insert into nft (nftId,nftTitle,nftPrice,nftPic) values (1012,'roh #5100',5000,'sample12.png');
-- 기준 데이터 삽입(아이디 정리용)
-- 식당 데이터 수정
update nft set nftPic='sample01.png' where nftId=1000;
-- 식당 데이터 삭제
delete from nft where nftId=100;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

create table cart(
	cartId int primary key,
	memId varchar(50),
    constraint memFkey foreign key (memId) references member (memId) on delete cascade,
    memName varchar(20) not null,
	nftId int,
    constraint nftFk foreign key (nftId) references nft (nftId) on delete cascade,
    nftTitle varchar(50),
    nftPrice int
);
-- 기준 데이터 삽입(아이디 정리용)
insert into review (revId,memId,memName,resId,revTitle,revCont,revScore) values ((select nvl(max(revId),2000)+1 from review),'admin','기준작성자',1002,'기준제목','기준글','5');
-- 리뷰 데이터 삽입
insert into review (revId,memId,memName,resId,revTitle,revCont,revScore,revPic) values ((select nvl(max(revId),2000)+1 from review),'muscleboy','근육남',101,'울지마','근손실온다',3.5,'/images/review/ksj.jpeg');
-- 리뷰 데이터 수정
update review set revTitle='화내지마',revCont='근손실온다',revScore=1.5,revPic='' where revId=101;
-- 리뷰 데이터 삭제
delete from review where revId=101;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 공지 테이블 생성
create table notice(
	notId int primary key,
	notTitle varchar(100) not null,
	notContent varchar(900) not null,
	notDate date DEFAULT SYSDATE
);
-- 기준 데이터 삽입(아이디 정리용)
insert into notice (notId,notTitle,notContent) values (100,'기준제목','기준내용');
-- 공지 데이터 삽입
insert into notice (notId,notTitle,notContent)
 values ((select nvl(max(notId),3000)+1 from notice),'보라','연보라진보라');
-- 공지 데이터 수정
update notice set notTitle='안녕하새우',notContent='곰방와',notShow=1 where notId=101;
-- 공지 데이터 삭제
delete from notice where notId=3004;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 댓글 테이블 생성
create table reply(
	repId int primary key,
	memId varchar(50),
    constraint membFk foreign key (memId) references member (memId) on delete cascade,
    memName varchar(20) not null,
	nftId int,
    constraint nftFkforrep foreign key (nftId) references nft (nftId) on delete cascade,
    repTitle varchar(200) not null,
    repContent varchar(1000) not null,
    repDate date DEFAULT SYSDATE
);
-- 기준 데이터 삽입(아이디 정리용)

 insert into menu (menuId,resId,menuName,menuPrice,menuCategory)
 values ((select nvl(max(menuId),4000)+1 from menu),1003,'기준메뉴',3500,'한식');
-- 메뉴 데이터 삽입
insert into menu (menuId,resId,menuName,menuPrice,menuCategory,menuPic)
 values ((select nvl(max(menuId),4000)+1 from menu),101,'불탄볶음밥',10000,'분식','/images/coupon/ksj.jpeg');
-- 메뉴 데이터 수정
update menu set menuName='파멸의짬뽕',menuPrice=4000,menuCategory='중식',menuPic='' where menuId=101;
-- 메뉴 데이터 삭제
delete from menu where menuId=101;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
