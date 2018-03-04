export enum Adicional {
  BRACO_MECANICO = 'Braço Mecânico',
  ESQUELETO_REFORCADO = 'Esqueleto Reforçado',
  SENTIDOS_AGUCADOS = 'Sentidos Aguçados',
  PELE_ADAPTATIVA = 'Pele Adaptativa',
  RAIO_LASER = 'Raio Laser'
}

export const todosOsAdicionais = Object.keys(Adicional)
  .map(key => {
      return { key, val: Adicional[key] };
  });

export const getAdicional = (key) => Adicional[key];
