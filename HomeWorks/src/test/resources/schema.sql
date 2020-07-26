drop table if exists books;
drop table if exists authors;
drop table if exists genres;

drop sequence if exists author_id;
create sequence author_id;

drop sequence if exists genre_id;
create sequence genre_id;

drop sequence if exists book_id;
create sequence book_id;

create table authors(
    id bigint not null default nextval('author_id'),
    name varchar(255) not null unique,
    primary key (id)
);

create table genres(
    id bigint default nextval('genre_id'),
    name varchar(255) not null unique,
    primary key (id)
);

create table books (
    id bigint default nextval('book_id'),
    title varchar(1000) not null unique,
    author_id bigint,
    genre_id bigint,
    comment_id bigint,
    foreign key (author_id) references authors(id) on delete cascade,
    foreign key (genre_id) references genres(id) on delete cascade,
    primary key (id)
);
