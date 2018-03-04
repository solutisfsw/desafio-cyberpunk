import { Clone } from '../clone/clone.model';

export interface Page {
  content: Clone[],
  totalPages: number,
  totalElements: number,
  last: boolean,
  numberOfElements: number,
  first: boolean,
  size: number,
  number: number
}