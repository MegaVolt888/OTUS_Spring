PGDMP     "                	    x            library #   12.4 (Ubuntu 12.4-0ubuntu0.20.04.1) #   12.4 (Ubuntu 12.4-0ubuntu0.20.04.1) !    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16463    library    DATABASE     y   CREATE DATABASE library WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'ru_RU.UTF-8' LC_CTYPE = 'ru_RU.UTF-8';
    DROP DATABASE library;
                library    false                        2615    16464    library    SCHEMA        CREATE SCHEMA library;
    DROP SCHEMA library;
                library    false            �            1259    16465 	   author_id    SEQUENCE     s   CREATE SEQUENCE library.author_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE library.author_id;
       library          library    false    6            �            1259    16471    authors    TABLE     �   CREATE TABLE library.authors (
    id bigint DEFAULT nextval('library.author_id'::regclass) NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE library.authors;
       library         heap    library    false    203    6            �            1259    16508    authors_books    TABLE     c   CREATE TABLE library.authors_books (
    author_id bigint NOT NULL,
    book_id bigint NOT NULL
);
 "   DROP TABLE library.authors_books;
       library         heap    library    false    6            �            1259    16469    book_id    SEQUENCE     q   CREATE SEQUENCE library.book_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE library.book_id;
       library          library    false    6            �            1259    16487    books    TABLE     �   CREATE TABLE library.books (
    id bigint DEFAULT nextval('library.book_id'::regclass) NOT NULL,
    title character varying(1000) NOT NULL,
    author_id bigint,
    genre_id bigint
);
    DROP TABLE library.books;
       library         heap    library    false    205    6            �            1259    16467    genre_id    SEQUENCE     r   CREATE SEQUENCE library.genre_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE library.genre_id;
       library          library    false    6            �            1259    16479    genres    TABLE     �   CREATE TABLE library.genres (
    id bigint DEFAULT nextval('library.genre_id'::regclass) NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE library.genres;
       library         heap    library    false    204    6            �            1259    16521    genres_books    TABLE     a   CREATE TABLE library.genres_books (
    genre_id bigint NOT NULL,
    book_id bigint NOT NULL
);
 !   DROP TABLE library.genres_books;
       library         heap    library    false    6            �          0    16471    authors 
   TABLE DATA           ,   COPY library.authors (id, name) FROM stdin;
    library          library    false    206   )$       �          0    16508    authors_books 
   TABLE DATA           <   COPY library.authors_books (author_id, book_id) FROM stdin;
    library          library    false    209   h$       �          0    16487    books 
   TABLE DATA           @   COPY library.books (id, title, author_id, genre_id) FROM stdin;
    library          library    false    208   �$       �          0    16479    genres 
   TABLE DATA           +   COPY library.genres (id, name) FROM stdin;
    library          library    false    207   %       �          0    16521    genres_books 
   TABLE DATA           :   COPY library.genres_books (genre_id, book_id) FROM stdin;
    library          library    false    210   8%       �           0    0 	   author_id    SEQUENCE SET     8   SELECT pg_catalog.setval('library.author_id', 2, true);
          library          library    false    203            �           0    0    book_id    SEQUENCE SET     6   SELECT pg_catalog.setval('library.book_id', 3, true);
          library          library    false    205            �           0    0    genre_id    SEQUENCE SET     7   SELECT pg_catalog.setval('library.genre_id', 2, true);
          library          library    false    204            ,           2606    16478    authors authors_name_key 
   CONSTRAINT     T   ALTER TABLE ONLY library.authors
    ADD CONSTRAINT authors_name_key UNIQUE (name);
 C   ALTER TABLE ONLY library.authors DROP CONSTRAINT authors_name_key;
       library            library    false    206            .           2606    16476    authors authors_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY library.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (id);
 ?   ALTER TABLE ONLY library.authors DROP CONSTRAINT authors_pkey;
       library            library    false    206            4           2606    16495    books books_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);
 ;   ALTER TABLE ONLY library.books DROP CONSTRAINT books_pkey;
       library            library    false    208            6           2606    16497    books books_title_key 
   CONSTRAINT     R   ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_title_key UNIQUE (title);
 @   ALTER TABLE ONLY library.books DROP CONSTRAINT books_title_key;
       library            library    false    208            0           2606    16486    genres genres_name_key 
   CONSTRAINT     R   ALTER TABLE ONLY library.genres
    ADD CONSTRAINT genres_name_key UNIQUE (name);
 A   ALTER TABLE ONLY library.genres DROP CONSTRAINT genres_name_key;
       library            library    false    207            2           2606    16484    genres genres_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY library.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (id);
 =   ALTER TABLE ONLY library.genres DROP CONSTRAINT genres_pkey;
       library            library    false    207            9           2606    16511 *   authors_books authors_books_author_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.authors_books
    ADD CONSTRAINT authors_books_author_id_fkey FOREIGN KEY (author_id) REFERENCES library.authors(id);
 U   ALTER TABLE ONLY library.authors_books DROP CONSTRAINT authors_books_author_id_fkey;
       library          library    false    206    209    2862            :           2606    16516 (   authors_books authors_books_book_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.authors_books
    ADD CONSTRAINT authors_books_book_id_fkey FOREIGN KEY (book_id) REFERENCES library.books(id);
 S   ALTER TABLE ONLY library.authors_books DROP CONSTRAINT authors_books_book_id_fkey;
       library          library    false    209    208    2868            7           2606    16498    books books_author_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_author_id_fkey FOREIGN KEY (author_id) REFERENCES library.authors(id) ON DELETE CASCADE;
 E   ALTER TABLE ONLY library.books DROP CONSTRAINT books_author_id_fkey;
       library          library    false    2862    206    208            8           2606    16503    books books_genre_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_genre_id_fkey FOREIGN KEY (genre_id) REFERENCES library.genres(id) ON DELETE CASCADE;
 D   ALTER TABLE ONLY library.books DROP CONSTRAINT books_genre_id_fkey;
       library          library    false    208    207    2866            <           2606    16529 &   genres_books genres_books_book_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.genres_books
    ADD CONSTRAINT genres_books_book_id_fkey FOREIGN KEY (book_id) REFERENCES library.books(id);
 Q   ALTER TABLE ONLY library.genres_books DROP CONSTRAINT genres_books_book_id_fkey;
       library          library    false    210    2868    208            ;           2606    16524 '   genres_books genres_books_genre_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY library.genres_books
    ADD CONSTRAINT genres_books_genre_id_fkey FOREIGN KEY (genre_id) REFERENCES library.genres(id);
 R   ALTER TABLE ONLY library.genres_books DROP CONSTRAINT genres_books_genre_id_fkey;
       library          library    false    207    210    2866            �   /   x�3��,Rp,*�(-Rp��K�Spɯ�I�2�I-.I-����� ���      �      x�3�4�2�4�2�4����� +      �   d   x�3�tK,�/�,IU�H-��O�V����M-VpI-IM.�,ʔ U�s���gHF*PQi^�B~�B	��X��ZT���We��Z\������qqq F#      �   #   x�3�tI-IM.�,K�2�,I-.��K����� vt�      �      x�3�4�2�4�2�4����� +     