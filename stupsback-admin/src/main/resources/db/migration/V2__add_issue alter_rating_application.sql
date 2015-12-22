create table issue (
  id int not null,
  description text,
  gh_issue_number int,
  title       text,
  primary key (id)
);

alter table rating add column issue_id int;
alter table application add column repo text;

alter table rating add constraint fk_rating_issue foreign key (issue_id) references issue;