import {IGenre} from '../genre/genre.model';
import {IAuthor} from '../author/author.model';

export interface IBook{
  id: string;
  title: string;
  genre?: IGenre;
  author?: IAuthor;
}
