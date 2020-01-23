create table question
(
	id int,
	title VARCHAR(50),
	description TEXT,
	gmt_create BIGINT,
	gmt_modified BIGINT,
	creator int,
	comment_count int default 0,
	view_count int default 0,
	like_count int default 0,
	tags VARCHAR(256),
	constraint question_pk
		primary key (id)
);
