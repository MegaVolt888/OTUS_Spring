import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IAuthor} from '../author/author.model';
import {AuthorService} from '../author/author.service';
import {IGenre} from '../genre/genre.model';
import {GenreService} from '../genre/genre.service';
import {IBook} from '../book/book.model';
import {BookService} from '../book/book.service';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  authors: BehaviorSubject<Array<IAuthor>> = new BehaviorSubject<Array<IAuthor>>([]);
  authors$: Observable<Array<IAuthor>> = this.authors.asObservable();
  genres: BehaviorSubject<Array<IGenre>> = new BehaviorSubject<Array<IGenre>>([]);
  genres$: Observable<Array<IGenre>> = this.genres.asObservable();
  books: BehaviorSubject<Array<IBook>> = new BehaviorSubject<Array<IBook>>([]);
  books$: Observable<Array<IBook>> = this.books.asObservable();

  constructor(private authorService: AuthorService, private genreService: GenreService, private bookService: BookService) {
  }


  public getAllAuthors(): void {
    this.authorService.getAllAuthors().subscribe(resp => {
        this.authors.next(resp);
      }
    );
  }

  public saveAuthor(saveAuthor: string): void {
    this.authorService.saveAuthor(saveAuthor).subscribe(response => {
        console.log(response);
        this.getAllAuthors();
      }
    );
  }

  public updateAuthor(changeAuthor: IAuthor): void {
    this.authorService.updateAuthor(changeAuthor).subscribe(response => {
        console.log(response);
        this.getAllAuthors();
      }
    );
  }

  public deleteAuthor(delAuthor: IAuthor): void{
    this.authorService.deleteAuthor(delAuthor).subscribe(response => {
        console.log(response);
        this.getAllAuthors();
      }
    );
  }

  public getAllGenres(): void {
    this.genreService.getAllGenres().subscribe(resp => {
        this.genres.next(resp);
      }
    );
  }

  public saveGenre(saveGenre: string): void {
    this.genreService.saveGenre(saveGenre).subscribe(response => {
        console.log(response);
        this.getAllGenres();
      }
    );
  }

  public updateGenre(changeGenre: IGenre): void {
    this.genreService.updateGenre(changeGenre).subscribe(response => {
        console.log(response);
        this.getAllGenres();
      }
    );
  }

  public deleteGenre(delGenre: IGenre): void{
    this.genreService.deleteGenre(delGenre).subscribe(response => {
        console.log(response);
        this.getAllGenres();
      }
    );
  }

  public getAllBooks(): void {
    this.bookService.getAllBooks().subscribe(response => {
        console.log(response);
        this.books.next(response);
      }
    );
  }

  public saveBook(saveBook: IBook): void {
    this.bookService.saveBook(saveBook).subscribe(resp => {
      console.log(resp);
      this.getAllBooks();
      }
    );
  }

  public updateBook(changeBook: IBook): void {
    this.bookService.updateBook(changeBook).subscribe(response => {
        console.log(response);
        this.getAllBooks();
      }
    );
  }

  public deleteBook(delBook: IBook): void{
    this.bookService.deleteBook(delBook).subscribe(response => {
        console.log(response);
        this.getAllBooks();
      }
    );
  }
}
