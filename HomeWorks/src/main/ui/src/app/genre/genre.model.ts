import {IBook} from '../book/book.model';

export interface IGenre{
  id?: string;
  name?: string;
  books?: Array<IBook>;
}
