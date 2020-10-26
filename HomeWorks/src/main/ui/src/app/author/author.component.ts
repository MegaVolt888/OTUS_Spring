import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {IAuthor} from './author.model';
import {AuthorService} from './author.service';
import {modalConfigDefaults} from 'ngx-bootstrap/modal/modal-options.class';
import {DataService} from '../services/data.services';

declare var $: any;

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {
  authors: Observable<Array<IAuthor>>;
  additionAuthor: IAuthor = {};
  selectedAuthor: IAuthor = {};
  changeAuthor: IAuthor = {};

  constructor(private  dataService: DataService) {
  }

  ngOnInit(): void {
    this.authors = this.dataService.authors$;
    this.dataService.getAllAuthors();
  }

  public selectAuthor(author: IAuthor): void {
    this.selectedAuthor = Object.assign({}, author);
  }

  public saveAuthor(): void {
    // this.additionAuthor.id = '0';
    this.dataService.saveAuthor(this.additionAuthor.name);
  }

  public updateAuthor(): void {
    this.changeAuthor.id = this.selectedAuthor.id;
    this.changeAuthor.name = this.selectedAuthor.name;
    this.dataService.updateAuthor(this.changeAuthor);
  }

  public deleteAuthor():void {
    this.dataService.deleteAuthor(this.selectedAuthor);
  }

}
