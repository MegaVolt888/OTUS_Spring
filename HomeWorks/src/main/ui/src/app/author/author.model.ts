import {IBook} from '../book/book.model';

export interface IAuthor{
  id?: string;
  name?: string;
  books?: Array<IBook>;
}
