package ru.sorokinkv.HomeWorks.service;

public interface MessageList {
    String ENTER_BOOK_TITLE = "Название книги:";
    String BOOK_SAVE = "Книга добавлена";
    String BOOK_UPDATE = "Книга обновлена";
    String ENTER_BOOK_TO_DELETE = "Удаление книги.";
    String ENTER_BOOK_TO_UPDATE = "Изменение книги.";
    String BOOK_DELETED_SUCCESS = "Книга удалена";
    String BOOK_NOT_FOUND = "Книга не найдена";

    String GENRE_SAVE_TITLE = "Добавление жанра";
    String ENTER_GENRE_NAME = "Название жанра:";
    String GENRE_UPDATE = "Изменение жанра";
    String ENTER_NEW_GENRE_NAME = "Введите новое название жанра";
    String GENRE_SAVE = "Жанр добавлен";
    String GENRE_UPDATED = "Название жанра изменено";
    String GENRE_DELETED_SUCCESS = "Жанр удален вместе с книгами";
    String GENRE_NOT_FOUND = "Жанр не найден";

    String ENTER_AUTHOR_NAME = "Введите имя автора:";
    String AUTHOR_DELETE = "Удаление автора";
    String AUTHOR_SAVE = "Автор добавлен";
    String AUTHOR_SAVE_TITLE = "Добавление автора";
    String AUTHOR_NOT_FOUND = "Автор не найден";
    String AUTHOR_UPDATE = "Изменение автора";
    String AUTHOR_UPDATED = "Имя автора изменено";
    String AUTHOR_DELETED_SUCCESS = "Автор удален вместе с книгами";
    String ENTER_NEW_AUTHOR_NAME = "Введите новое имя автора";

}
