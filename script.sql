create sequence messageforadvert_date_seq;

alter sequence messageforadvert_date_seq owner to postgres;

create table advert
(
    id      serial not null,
    model   varchar,
    color   varchar,
    yearcar integer,
    price   double precision,
    id_user integer
);

alter table advert
    owner to postgres;

create table messageforadvert
(
    id       serial not null
        constraint messageforadvert_pk
            primary key,
    idadvert integer,
    iduser   integer,
    body     varchar,
    date     varchar
);

alter table messageforadvert
    owner to postgres;

create unique index messageforadvert_id_uindex
    on messageforadvert (id);


