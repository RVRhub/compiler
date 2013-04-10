CREATE TABLE GenericAccountInfo (
user_id number(20),
fname varchar2(20),
lname varchar2(20),
email varchar2(20),
pass varchar2(20),
CONSTRAINT pk_GenericAccountInfo PRIMARY KEY (user_id)
);
CREATE SEQUENCE userid_seq;
INSERT INTO GenericAccountInfo (user_id) VALUES (userid_seq.nextval);
------------------------------------------------------------------------------------------------------


CREATE TABLE GenericProjectInfo 
(
project_id number(20),
user_id number(20),
proglang varchar2(20),
langplatform varchar2(20),
projtemplate varchar2(20),
constraint pk_GenericProjectInfo primary key (project_id),
constraint fk_user_id foreign key (user_id)
  references GenericAccountInfo (user_id)
);
CREATE SEQUENCE projectid_seq;
INSERT INTO GenericProjectInfo (project_id) VALUES (projectid_seq.nextval);
--------------------------------------------------------------------------------------------------------


create table ProjectDetails
(
project_id number(20),
projname varchar2(20),
projtype char(1) CHECK (projtype in ('Private','Public')),
projcategory varchar2(30),
constraint pk_ProjectDetails primary key (project_id)
);
---------------------------------------------------------------------------------------------------------


create table FullAccountInfo
(
user_id number(20),
birthday date,
workplace varchar2(30),
city varchar2(20),
state varchar2(20),
knowproglang varchar2(20),
country varchar2(20),
constraint pk_FullAccountInfo primary key (user_id)
);
----------------------------------------------------------------------------------------------------------



create table typeDir
(
type_id number(20),
typeDir_name varchar2(20),
constraints pk_typeDir primary key (type_id)
);
CREATE SEQUENCE typeDir_seq;
INSERT INTO typeDir (type_id) VALUES (typeDir_seq.nextval);


-----------------------------------------------------------------------------------------------------------
create table Dir
(
dir_id number(20),
type_id number(20),
Dir_name varchar2(20),
constraints pk_Dir primary key (dir_id),
constraints fk_type_id foreign key (type_id)
  references typeDir (type_id)
);
CREATE SEQUENCE Dir_seq;
INSERT INTO Dir (dir_id) VALUES (Dir_seq.nextval);