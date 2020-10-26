import {Injectable, isDevMode} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {IGenre} from '../genre/genre.model';
import {IBook} from './book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private SERVER_URL = '';
  private API_URL: string;

  constructor(private http: HttpClient) {
    if (isDevMode()) {
      this.SERVER_URL = environment.serverUrl;
    }

    this.API_URL = this.SERVER_URL + environment.prefix;
  }

  public getAllBooks(): Observable<Array<IBook>> {
    return this.http.get<Array<IBook>>(this.API_URL + `/books`);
  }

  public getBook(id: string): Observable<IBook> {
    return this.http.get<IBook>(this.API_URL + `/books/${id}`);
  }

  public updateBook(book: IBook): Observable<any> {
    console.log(book);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.put<any>(this.API_URL + `/books`, book, options);
  }

  public saveBook(book: IBook): Observable<any> {
    console.log(book);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.post<any>(this.API_URL + `/books`, book, options);
  }

  public deleteBook(book: IBook): Observable<any> {
    console.log(book);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.delete<any>(this.API_URL + `/books/` + book.id,  options);
  }
}
