create database jpa;

use jpa;

drop table if exists Movie;
drop table if exists Auditorium;
drop table if exists Seat;
drop table if exists User;
drop table if exists Ticket;

create table Movie (
       MOVIE_ID bigint not null auto_increment,
        MOVIE_NAME varchar(255),
        MOVIE_PRICE integer,
        primary key (MOVIE_ID)
    ) engine=MyISAM;

create table Auditorium (
       AUDITORIUM_ID bigint not null auto_increment,
        MAX_SEAT_COUNT integer,
        MOVIE_ID bigint,
        primary key (AUDITORIUM_ID)
    ) engine=MyISAM;

create table Seat (
       SEAT_ID bigint not null auto_increment,
        SEAT_NAME varchar(255),
        AUDITORIUM_ID bigint,
        primary key (SEAT_ID)
    ) engine=MyISAM;
    
create table Ticket (
       TIME_STAMP datetime,
        seat_SEAT_ID bigint not null,
        USER_ID varchar(100),
        primary key (seat_SEAT_ID)
    ) engine=MyISAM;    

create table User (
       USER_ID varchar(100) not null,
        USER_PASSWORD varchar(255),
        primary key (USER_ID)
    ) engine=MyISAM;
    
    
alter table Auditorium 
       add constraint FKs4e2cqjvs91n96lx7802kau78 
       foreign key (MOVIE_ID) 
       references Movie (MOVIE_ID);

alter table Seat 
       add constraint FKavpkfwm0ue4hbjpayyukela1h 
       foreign key (AUDITORIUM_ID) 
       references Auditorium (AUDITORIUM_ID);
       
alter table Ticket 
       add constraint FKfwwx8qv8wp91ux3uhwcnm8myu 
       foreign key (seat_SEAT_ID) 
       references Seat (SEAT_ID);
       
alter table Ticket 
       add constraint FKppxv52rf2e1rvl0934bu47qc8 
       foreign key (USER_ID) 
       references User (USER_ID);

insert into Movie (MOVIE_NAME, MOVIE_PRICE) 
values ('미션 임파서블', 15000);
insert into Movie (MOVIE_NAME, MOVIE_PRICE) 
values ('어벤져스', 20000);
insert into Movie (MOVIE_NAME, MOVIE_PRICE) 
values ('스파이더맨', 18000);
commit;

insert into Auditorium (MAX_SEAT_COUNT, MOVIE_ID) 
values (6, 1);
insert into Auditorium (MAX_SEAT_COUNT, MOVIE_ID) 
values (6, 2);
insert into Auditorium (MAX_SEAT_COUNT, MOVIE_ID) 
values (6, 2);
insert into Auditorium (MAX_SEAT_COUNT, MOVIE_ID) 
values (6, 3);
commit;

insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A1', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A2', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A3', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B1', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B2', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B3', 1);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A1', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A2', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A3', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B1', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B2', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B3', 2);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A1', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A2', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A3', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B1', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B2', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B3', 3);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A1', 4);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A2', 4);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('A3', 4);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B1', 4);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B2', 4);
insert into Seat (SEAT_NAME, AUDITORIUM_ID) 
values ('B3', 4);
commit;

  
  