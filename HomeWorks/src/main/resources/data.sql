/*CREATE TABLE BOOK(ID UUID PRIMARY KEY, TITLE VARCHAR(255), AUTHOR UUID, GENRE UUID);
CREATE TABLE AUTHOR(ID UUID PRIMARY KEY, NAME VARCHAR(255));
CREATE TABLE GENRE(ID UUID PRIMARY KEY, NAME VARCHAR(255));*/
insert into book (id,`title`,`author`, `genre`) values ('a5c9d006-b32c-400f-9183-236ba5557eb8', 'Favorite Sherlock Holmes Detective Stories','e9ef83e0-3058-4763-a7e8-ce55a40b79a7', '444bd145-1fd2-40ff-b810-1ca459d0d1d7');
insert into book (id,`title`,`author`, `genre`) values ('2dd184ae-8ec0-44f3-8875-f5391ea93248', 'The Hound of the Baskervilles','e9ef83e0-3058-4763-a7e8-ce55a40b79a7', '444bd145-1fd2-40ff-b810-1ca459d0d1d7');
insert into author (id,`name`) values ('e9ef83e0-3058-4763-a7e8-ce55a40b79a7', 'Sir Arthur Conan Doyle');
insert into genre (id,`name`) values ('444bd145-1fd2-40ff-b810-1ca459d0d1d7', 'detective');

