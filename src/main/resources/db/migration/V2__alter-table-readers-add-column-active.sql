alter table readers add active tinyint;
update readers set active = 1;