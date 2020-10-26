import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {IGenre} from './genre.model';
import {IAuthor} from '../author/author.model';
import {DataService} from '../services/data.services';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.scss']
})
export class GenreComponent implements OnInit {
  genres: Observable<Array<IGenre>>;
  additionGenre: IGenre = {};
  selectedGenre: IGenre = {};
  changeGenre: IGenre = {};

  constructor(private  dataService: DataService) { }

  ngOnInit(): void {
    this.genres = this.dataService.genres$;
    this.dataService.getAllGenres();
  }
  public selectGenre(genre: IGenre): void {
    this.selectedGenre = Object.assign({}, genre);
  }

  public saveGenre(): void {
    this.dataService.saveGenre(this.additionGenre.name);
  }

  public updateGenre(): void {
    this.changeGenre.id = this.selectedGenre.id;
    this.changeGenre.name = this.selectedGenre.name;
    this.dataService.updateGenre(this.changeGenre);
  }

  public deleteGenre(): void {
    this.dataService.deleteGenre(this.selectedGenre);
  }

}
