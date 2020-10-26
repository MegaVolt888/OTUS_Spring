import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {IAuthor} from '../author/author.model';
import {IBook} from './book.model';
import {DataService} from '../services/data.services';
import {IGenre} from '../genre/genre.model';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  books: Observable<Array<IBook>>;
  authors: Observable<Array<IAuthor>>;
  genres: Observable<Array<IGenre>>;
  additionBook: IBook = {id: '', title: ''};
  selectedBook: IBook = {id: '', title: ''};
  selectedAuthor: IAuthor = null;
  selectedGenre: IGenre = null;
  changeBook: IBook =  {id: '', title: ''};

  constructor(private  dataService: DataService) { }

  ngOnInit(): void {
    this.books = this.dataService.books$;
    this.authors = this.dataService.authors$;
    this.genres = this.dataService.genres$;
    this.dataService.getAllBooks();
  }
  public selectBook(book: IBook): void {
    this.getAuthorsAndGenres();
    this.selectedBook = Object.assign({}, book);
    this.selectedAuthor = this.selectedBook.author;
    console.log(this.selectedBook);
  }

  public saveBook(): void {
    this.additionBook.author = this.selectedAuthor;
    // this.additionBook.author.books = null;
    this.additionBook.genre = this.selectedGenre;
    // this.additionBook.genre.books = null;
    console.log(this.additionBook);
    this.dataService.saveBook(this.additionBook);
  }

  public updateBook(): void {
    // this.getAuthorsAndGenres();
    console.log(this.selectedAuthor.name);
    // this.changeBook.id = this.selectedBook.id;
    // this.changeBook.title = this.selectedBook.title;
    // this.changeBook.author = this.selectedAuthor;
    // // this.changeBook.author.books = null;
    // this.changeBook.genre = this.selectedBook.genre;
    // // this.changeBook.genre.books = null;
    this.dataService.updateBook(this.selectedBook);
  }

  public deleteBook(): void {
    this.dataService.deleteBook(this.selectedBook);
  }
  public getAuthorsAndGenres(): void{
    this.dataService.getAllAuthors();
    this.dataService.getAllGenres();
  }

  public checkSelected(author: IAuthor): boolean {
    console.log(author);
    console.log(this.selectedBook.author);
    const result = this.selectedBook.author.id === author.id;
    console.log(result);
    return result;
  }

  selectAuthor(e) {
    console.log(e);
  }
}
