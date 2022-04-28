
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



-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 공지 테이블 생성
create table notice(
	notId int primary key,
	notTitle varchar(100) not null,
	notContent varchar(900) not null,
	notDate date DEFAULT SYSDATE
);


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

