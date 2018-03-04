import { DesafioPage } from './app.po';

describe('desafio App', () => {
  let page: DesafioPage;

  beforeEach(() => {
    page = new DesafioPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
