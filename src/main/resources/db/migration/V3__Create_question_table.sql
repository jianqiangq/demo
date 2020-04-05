create table QUESTION
(
	ID int auto_increment,
	TITLE VARCHAR(50),
	DESCRIPTION TEXT,
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	CREATOR int,
	COMMENT_COUNT int default 0,
	VIEW_COUNT int default 0,
	LIKE_COUNT int default 0,
	TAG VARCHAR(256),
	constraint QUESTION_pk
		primary key (ID)
);