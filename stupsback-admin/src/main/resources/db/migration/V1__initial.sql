create table application (
	id int not null,
	description text,
	name text,
	password text,
	username text,
	primary key (id)
);

create table rating (
	id int not null,
	app_id text,
	comment text,
	email text,
	meta text,
	stars int,
	primary key (id)
);

create table thumbs_up (
	id int not null,
	username text,
	rating_id int,
	primary key (id)
);

alter table thumbs_up add constraint unique_user_rating unique (username, rating_id);

alter table thumbs_up add constraint fk_thumbsup_rating foreign key (rating_id) references rating;

create sequence hibernate_sequence;