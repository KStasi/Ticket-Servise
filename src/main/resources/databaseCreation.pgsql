create table clients (
id serial not null primary key,
discount numeric not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) not null
);

create table performances (
id serial not null primary key,
name varchar(20) not null,
description varchar(200) not null,
type integer not null,
theatre varchar(50) not null
);

create table tickets (
id serial not null primary key,
performance_id integer not null,
seat integer not null
);

create table bookings (
id serial not null primary key,
client_id integer not null,
ticket_id integer not null,
price integer not null
);

alter table if exists tickets
    add constraint performance_id
    foreign key (performance_id)
    references performances (id)
    on update cascade on delete cascade;

alter table if exists bookings
    add constraint client_id
    foreign key (client_id)
    references clients (id)
    on update cascade on delete cascade,
    add constraint ticket_id
    foreign key (ticket_id)
    references tickets (id)
    on update cascade on delete cascade;
