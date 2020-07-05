package ru.sorokinkv.HomeWorks.service;

public interface MessageList {
    String ENTER_BOOK_TITLE = "Название книги:";
    String BOOK_SAVE = "Книга добавлена";
    String BOOK_UPDATE = "Книга обновлена";
    String BOOK_DELETED_SUCCESS = "Книга удалена";
    String ENTER_DELETE_BOOK_TITLE = "Введите название книги, которую хотите удалить:";
    String BOOK_NOT_FOUND = "Книга не найдена";

    String ENTER_GENRE_NAME = "Название жанра:";
    String GENRE_DELETED_SUCCESS = "Жанр удален вместе с книгами";
    String GENRE_NOT_FOUND = "Жанр не найден";

    String ENTER_AUTHOR_NAME = "Введите имя автора:";
    String AUTHOR_SAVE = "Автор добавлен";
    String AUTHOR_NOT_FOUND = "Автор не найден";
    String AUTHOR_UPDATE = "Имя автора изменено";
    String AUTHOR_DELETED_SUCCESS = "Автор удален вместе с книгами";
    String ENTER_NEW_AUTHOR_NAME = "Введите новое имя автора";

}
