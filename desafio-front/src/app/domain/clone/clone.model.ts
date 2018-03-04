import { Adicional } from './adicional.enum';

export interface Clone {
  id: number,
  nome: string,
  idade: number,
  adicionais: Set<Adicional>
}
