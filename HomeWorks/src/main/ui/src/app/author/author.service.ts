import {Injectable, isDevMode} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, BehaviorSubject} from 'rxjs';
import {IAuthor} from './author.model';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  private SERVER_URL = '';
  private API_URL: string;


  constructor(private http: HttpClient) {
    if (isDevMode()) {
      this.SERVER_URL = environment.serverUrl;
    }

    this.API_URL = this.SERVER_URL + environment.prefix;

  }

  public getAllAuthors(): Observable<Array<IAuthor>> {
    return this.http.get<Array<IAuthor>>(this.API_URL + `/authors`);
  }

  public getAuthor(id: string): Observable<IAuthor> {
    return this.http.get<IAuthor>(this.API_URL + `/authors/${id}`);
  }

  public updateAuthor(author: IAuthor): Observable<any> {
    console.log(author);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.put<any>(this.API_URL + `/authors`, author, options);
  }

  public saveAuthor(author: string): Observable<any> {
    console.log(author);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.post<any>(this.API_URL + `/authors`, author, options);
  }

  public deleteAuthor(author: IAuthor): Observable<any> {
    console.log(author);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.delete<any>(this.API_URL + `/authors/` + author.id,  options);
  }
}

