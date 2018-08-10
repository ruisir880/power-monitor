create table SEC_ROLE
(
    ID BIGINT AUTO_INCREMENT primary key,
    ROLE_NAME VARCHAR(30),
    DESCRIPTION varchar(250),
    GEN_TIME datetime
);

create table SEC_USER(
  ID BIGINT AUTO_INCREMENT primary key,
  ROLE_ID BIGINT ,
  LOGIN_NAME varchar(64) not null,
  LOGIN_PASSWORD varchar(64) not null,
  REALNAME varchar(64) not null,
  MOBILE varchar(20) not null,
  EMAIL varchar(64),
  GEN_TIME DATETIME not null,
  LAST_LOGIN_TIME DATETIME ,
  foreign key(ROLE_ID) references SEC_ROLE(id)
);


insert into SEC_ROLE(ROLE_NAME,GEN_TIME) values('ADMIN',CURTIME());

INSERT INTO SEC_USER
  (
    ROLE_ID,
    LOGIN_NAME,
    LOGIN_PASSWORD,
    REALNAME,
    MOBILE,
    EMAIL,
    GEN_TIME
    
  )
  VALUES
  (
    1,
    'test',
    'password',
    '??',
    '123456789',
    'test@xx.com',
    CURTIME()
  );