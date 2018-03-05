import { browser, element, by, ElementFinder,  } from 'protractor';
 
   var HomePage = function() { 
      this.addButton = element(by.css(".add"));
   };

   var AddPage = function() { 
      this.saveButton = element(by.css("#BtSaveClone"));

      this.nameField = element(by.css('input'));
      this.ageField = element(by.css('#Age'));
      this.additionalField = element(by.css('#Additional'));            
   };  
    

describe('Teste de Estrutura da Pagina: Home Page Clone', function() {
    var homePage = new HomePage();
    var addPage = new AddPage(); 

    beforeEach(function() {
       browser.get('');
    });

    it('O Button cadastrar clone e exibido por padrão !', function() {
       expect(homePage.addButton.isDisplayed()).toBe(true);
    });

    it('O Button cadastrar clone chama o formulario de salvar clone', function() {
       expect(homePage.addButton.isDisplayed()).toBe(true);
       homePage.addButton.click();
       expect(addPage.saveButton.isDisplayed()).toBe(true);
    });    

  });

  describe('Teste de Estrutura da Pagina: Salvar Clone', function() {
    var addPage = new AddPage();    

      beforeEach(function() {
          browser.get('./#/add');
      });

    it('O Button salvar clone e exibido por padrao !', function() {
       expect(addPage.saveButton.isDisplayed()).toBe(true);
    });
    it('O Button salvar clone e desabilitado por padrao !', function() {
       expect(addPage.saveButton.getAttribute('disabled')).toEqual('true');
    }); 
    it('O input Name e exibido por padrao !', function() {
       expect(addPage.nameField.isDisplayed()).toBe(true);
    });     
    it('O input Age e exibido por padrao !', function() {
       expect(addPage.ageField.isDisplayed()).toBe(true);
    }); 
    it('O input Additional e exibido por padrao !', function() {
       expect(addPage.additionalField.isDisplayed()).toBe(true);
    });           
  });   

  describe('Teste do input Name, deve estar em acordo com expressao regular: [A-Z]{3}[0-9]{4}', function() {  
    var addPage = new AddPage();    

      beforeEach(function() {
          browser.get('./#/add');
      });

    it('O input Name com expressao regular correta deve desbloquear o botao de Salvar Clone !', function() {
       addPage.nameField.click();
       addPage.nameField.sendKeys('AAA1234');
       expect(addPage.saveButton.getAttribute('disabled')).toBe(null);
    });

    it('O input Name com expressao regular incorreta deve manter bloqueado o botao de Salvar Clone !', function() {
       addPage.nameField.click();
       addPage.nameField.sendKeys('BBBB1234');
       expect(addPage.saveButton.getAttribute('disabled')).toEqual('true');
    });   

    it('O input Name com Nome repetido deve manter bloqueado o botao de Salvar Clone !', function() {
       addPage.nameField.click();
       addPage.nameField.sendKeys('danilo');
       expect(addPage.saveButton.getAttribute('disabled')).toEqual('true');
    });     
  });    