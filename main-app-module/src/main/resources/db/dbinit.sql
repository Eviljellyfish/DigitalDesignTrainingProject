create table "Users"
(
    id          serial
        constraint users_pk
            primary key,
    first_name  varchar(50) not null,
    second_name varchar(50) not null,
    role_id     integer     not null,
    org_id      integer     not null,
    position    varchar(100)
);

alter table "Users"
    owner to postgres;

create unique index users_id_uindex
    on "Users" (id);

create table "Org"
(
    id            serial
        constraint org_pk
            primary key,
    name          varchar(200) not null,
    parent_org_id integer      not null,
    head_user_id  integer      not null
);

alter table "Org"
    owner to postgres;

create unique index org_id_uindex
    on "Org" (id);

create table "Roles"
(
    id   serial
        constraint roles_pk
            primary key,
    name varchar(20) not null
);

alter table "Roles"
    owner to postgres;

create unique index roles_id_uindex
    on "Roles" (id);

