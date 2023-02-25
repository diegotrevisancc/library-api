alter table books add active tinyint;
update books set active = 1;