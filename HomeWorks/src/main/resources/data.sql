insert into authors (id, name) values (nextval('author_id'), 'Sir Arthur Conan Doyle');
insert into genres (id, name) values (nextval('genre_id'), 'Detective');

insert into books (id, title) values (nextval('book_id'), 'Favorite Sherlock Holmes Detective Stories');
-- insert into books (id, title,author_id,genre_id) values (nextval('book_id'), 'Favorite Sherlock Holmes Detective Stories',1,1);
insert into authors_books (author_id,book_id) values (1,1);
insert into genres_books (genre_id,book_id) values (1,1);
insert into books (id, title) values (nextval('book_id'), 'The Hound of the Baskervilles');
-- insert into books (id, title,author_id,genre_id) values (nextval('book_id'), 'The Hound of the Baskervilles',1,1);
insert into authors_books (author_id,book_id) values (1,2);
insert into genres_books (genre_id,book_id) values (1,2);