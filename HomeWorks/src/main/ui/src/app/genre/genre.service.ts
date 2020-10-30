import {Injectable, isDevMode} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {IAuthor} from '../author/author.model';
import {IGenre} from './genre.model';

@Injectable({
  providedIn: 'root'
})
export class GenreService {
  private SERVER_URL = '';
  private API_URL: string;

  constructor(private http: HttpClient) {
    if (isDevMode()) {
      this.SERVER_URL = environment.serverUrl;
    }

    this.API_URL = this.SERVER_URL + environment.prefix;
  }

  public getAllGenres(): Observable<Array<IGenre>> {
    return this.http.get<Array<IGenre>>(this.API_URL + `/genres`);
  }

  public getGenre(id: string): Observable<IGenre> {
    return this.http.get<IGenre>(this.API_URL + `/genres/${id}`);
  }

  public updateGenre(genre: IGenre): Observable<any> {
    console.log(genre);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.put<any>(this.API_URL + `/genres`, genre, options);
  }

  public saveGenre(genre: string): Observable<any> {
    console.log(genre);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.post<any>(this.API_URL + `/genres`, genre, options);
  }

  public deleteGenre(genre: IGenre): Observable<any> {
    console.log(genre);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {headers};
    return this.http.delete<any>(this.API_URL + `/genres/` + genre.id,  options);
  }
}
