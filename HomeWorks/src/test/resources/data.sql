insert into authors (id, name) values (nextval('author_id'), 'Sir Arthur Conan Doyle');
insert into authors (id, name) values (nextval('author_id'), 'Stanislav Lem');

insert into genres (id, name) values (nextval('genre_id'), 'detective');
insert into genres (id, name) values (nextval('genre_id'), 'fantastic');

insert into books (id, title, author_id, genre_id) values (nextval('book_id'), 'Favorite Sherlock Holmes Detective Stories', 1, 1);
insert into books (id, title, author_id, genre_id) values (nextval('book_id'), 'The Hound of the Baskervilles', 1, 1);
insert into books (id, title, author_id, genre_id) values (nextval('book_id'), 'THE FUTUROLOGICAL CONGRESS', 2, 2);
insert into books (id, title, author_id, genre_id) values (nextval('book_id'), 'On Patrol', 2, 2);

