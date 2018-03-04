webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/adicionais-clone/adicionais-clone.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/adicionais-clone/adicionais-clone.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ibox-content\">\n  <button class=\"btn btn-primary\" type=\"button\" (click)=\"voltar()\">Voltar</button>\n  <table class=\"table\">\n    <thead>\n    <tr>\n      <th>Nome</th>\n      <th>Idade</th>\n      <th>Dada de Criação</th>\n    </tr>\n    </thead>\n    <tbody>\n    <tr>\n      <td><a href=\"javascript:;\" (click)=\"editarClone(clone)\">{{clone.nome}}</a></td>\n      <td>{{clone.idade}}</td>\n      <td>{{clone.dataCriacao | date:\"dd/MM/yyyy\"}}</td>\n    </tr>\n    </tbody>\n  </table>\n\n  <div class=\"text-center\">\n    <h2>Adicionais</h2>\n    <div class=\"hr-line-solid\"></div>\n    <span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>\n    <span class=\"sr-only\">(aria)</span>\n    <div *ngFor=\"let a of adicionais\" class=\"alert alert-info\" role=\"alert\">\n      {{ a }}\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/adicionais-clone/adicionais-clone.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AdicionaisCloneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__clone_service__ = __webpack_require__("./src/app/clone.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AdicionaisCloneComponent = /** @class */ (function () {
    function AdicionaisCloneComponent(router, service) {
        this.router = router;
        this.service = service;
        this.adicionais = new Array();
    }
    AdicionaisCloneComponent.prototype.ngOnInit = function () {
        this.clone = this.service.getClone();
        var a = this.clone.adicionais;
        if (a.bracoMecanico) {
            this.adicionais.push('Braço Mecânico');
        }
        if (a.esqueletoReforcado) {
            this.adicionais.push('Esqueleto Reforçado');
        }
        if (a.peleAdaptativa) {
            this.adicionais.push('Pele Adaptativa');
        }
        if (a.raioLaser) {
            this.adicionais.push('Raio Laser');
        }
        if (a.sentidosAgucados) {
            this.adicionais.push('Sentidos Aguçados');
        }
    };
    AdicionaisCloneComponent.prototype.editarClone = function (clone) {
        this.router.navigate(['/clones', clone.id]);
    };
    AdicionaisCloneComponent.prototype.voltar = function () {
        this.router.navigate(['/clones']);
    };
    AdicionaisCloneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-adicionais-clone',
            template: __webpack_require__("./src/app/adicionais-clone/adicionais-clone.component.html"),
            styles: [__webpack_require__("./src/app/adicionais-clone/adicionais-clone.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__clone_service__["a" /* CloneService */]])
    ], AdicionaisCloneComponent);
    return AdicionaisCloneComponent;
}());



/***/ }),

/***/ "./src/app/adicionais.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Adicionais; });
var Adicionais = /** @class */ (function () {
    function Adicionais() {
    }
    return Adicionais;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div id=\"wrapper\">\n\n  <nav class=\"navbar-default navbar-static-side\" role=\"navigation\">\n    <div class=\"sidebar-collapse\">\n      <ul class=\"nav metismenu\" id=\"side-menu\">\n        <li class=\"nav-header\">\n          <div class=\"dropdown profile-element\">\n            <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">\n                            <span class=\"clear\"> <span class=\"block m-t-xs\"> <strong class=\"font-bold\">Solutis Tecnologia</strong>\n                             </span> <span class=\"text-muted text-xs block\">Nickname <b class=\"caret\"></b></span> </span> </a>\n            <ul class=\"dropdown-menu animated fadeInRight m-t-xs\">\n              <li><a href=\"#\">Sair</a></li>\n            </ul>\n          </div>\n          <div class=\"logo-element\">\n            A2+\n          </div>\n        </li>\n        <li class=\"active\">\n          <a routerLink=\"/clones\"><i class=\"fa fa-th-large\"></i> <span class=\"nav-label\">Seus Clones</span></a>\n        </li>\n      </ul>\n\n    </div>\n  </nav>\n\n  <div id=\"page-wrapper\" class=\"gray-bg\">\n    <div class=\"row border-bottom\">\n      <nav class=\"navbar navbar-static-top white-bg\" role=\"navigation\" style=\"margin-bottom: 0\">\n        <div class=\"navbar-header\">\n          <a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary \" href=\"#\"><i class=\"fa fa-bars\"></i> </a>\n          <form role=\"search\" #f=\"ngForm\" class=\"navbar-form-custom\" method=\"post\" action=\"#\">\n            <div class=\"form-group\">\n              <input type=\"text\" (change)=\"pesquisarClone(f)\" [(ngModel)]=\"search\" placeholder=\"Buscar clones...\" class=\"form-control\" name=\"search\" id=\"search\">\n            </div>\n          </form>\n        </div>\n        <ul class=\"nav navbar-top-links navbar-right\">\n          <li>\n            <a href=\"#\">\n              <i class=\"fa fa-sign-out\"></i> Sair\n            </a>\n          </li>\n        </ul>\n\n      </nav>\n    </div>\n    <div class=\"wrapper wrapper-content animated fadeInRight\">\n      <router-outlet (activateEvents)=\"true\"></router-outlet>\n    </div>\n    <div class=\"footer\">\n      <div class=\"pull-right\">\n\n      </div>\n      <div>\n        CyberPunk - 2018\n      </div>\n    </div>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__clone_service__ = __webpack_require__("./src/app/clone.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = /** @class */ (function () {
    function AppComponent(service, router) {
        this.service = service;
        this.router = router;
        this.title = 'app';
        this.search = '';
    }
    AppComponent.prototype.pesquisarClone = function (campo) {
        var _this = this;
        console.log(campo.value);
        var s = campo.value.search.toUpperCase();
        this.service.pesquisarClone(s).subscribe(function (data) {
            _this.service.setClone(data);
            _this.router.navigate(['/clones/adicionais', s]);
            console.log(JSON.stringify(data));
        }, function (err) {
            console.error(err);
        });
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__clone_service__["a" /* CloneService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__listar_clones_listar_clones_component__ = __webpack_require__("./src/app/listar-clones/listar-clones.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__editar_clone_editar_clone_component__ = __webpack_require__("./src/app/editar-clone/editar-clone.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__adicionais_clone_adicionais_clone_component__ = __webpack_require__("./src/app/adicionais-clone/adicionais-clone.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__clone_service__ = __webpack_require__("./src/app/clone.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__campo_control_erro_campo_control_erro_component__ = __webpack_require__("./src/app/campo-control-erro/campo-control-erro.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var appRoutes = [
    { path: 'clones', component: __WEBPACK_IMPORTED_MODULE_6__listar_clones_listar_clones_component__["a" /* ListarClonesComponent */] },
    { path: 'clones/:id', component: __WEBPACK_IMPORTED_MODULE_7__editar_clone_editar_clone_component__["a" /* EditarCloneComponent */] },
    { path: 'clones/adicionais/:id', component: __WEBPACK_IMPORTED_MODULE_8__adicionais_clone_adicionais_clone_component__["a" /* AdicionaisCloneComponent */] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_6__listar_clones_listar_clones_component__["a" /* ListarClonesComponent */],
                __WEBPACK_IMPORTED_MODULE_7__editar_clone_editar_clone_component__["a" /* EditarCloneComponent */],
                __WEBPACK_IMPORTED_MODULE_8__adicionais_clone_adicionais_clone_component__["a" /* AdicionaisCloneComponent */],
                __WEBPACK_IMPORTED_MODULE_10__campo_control_erro_campo_control_erro_component__["a" /* CampoControlErroComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* RouterModule */].forRoot(appRoutes)
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_9__clone_service__["a" /* CloneService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/campo-control-erro/campo-control-erro.component.css":
/***/ (function(module, exports) {

module.exports = ".errorDiv {\n    margin-bottom: 0px;\n}"

/***/ }),

/***/ "./src/app/campo-control-erro/campo-control-erro.component.html":
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"mostrarErro\" >\n  <span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>\n  <span class=\"sr-only\">(error)</span>\n  <div class=\"alert alert-danger errorDiv\" role=\"alert\">\n    {{ msgErro }}\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/campo-control-erro/campo-control-erro.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CampoControlErroComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var CampoControlErroComponent = /** @class */ (function () {
    function CampoControlErroComponent() {
    }
    CampoControlErroComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["D" /* Input */])(),
        __metadata("design:type", String)
    ], CampoControlErroComponent.prototype, "msgErro", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["D" /* Input */])(),
        __metadata("design:type", Boolean)
    ], CampoControlErroComponent.prototype, "mostrarErro", void 0);
    CampoControlErroComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-campo-control-erro',
            template: __webpack_require__("./src/app/campo-control-erro/campo-control-erro.component.html"),
            styles: [__webpack_require__("./src/app/campo-control-erro/campo-control-erro.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], CampoControlErroComponent);
    return CampoControlErroComponent;
}());



/***/ }),

/***/ "./src/app/clone.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CloneService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_do__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/do.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_observable_ErrorObservable__ = __webpack_require__("./node_modules/rxjs/_esm5/observable/ErrorObservable.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var CloneService = /** @class */ (function () {
    function CloneService(_http) {
        this._http = _http;
        this.baseUrl = 'localhost:8080/cyberpunk/clones';
        this.mensagemErro = null;
    }
    CloneService.prototype.obterClones = function () {
        return this._http
            .get('http://' + this.baseUrl)
            .catch(this.handleError);
    };
    CloneService.prototype.obterClone = function (id) {
        return this.getClone();
    };
    CloneService.prototype.pesquisarClone = function (nome) {
        return this._http
            .get('http://' + this.baseUrl + '/' + nome)
            .catch(this.handleError);
    };
    CloneService.prototype.salvarClone = function (clone) {
        return this._http
            .post('http://' + this.baseUrl, clone)
            .catch(this.handleError);
    };
    CloneService.prototype.atualizarClone = function (nome, clone) {
        return this._http
            .put('http://' + this.baseUrl + '/' + nome, clone)
            .catch(this.handleError);
    };
    CloneService.prototype.deletarClone = function (nome) {
        return this._http
            .delete('http://' + this.baseUrl + '/' + nome)
            .catch(this.handleError);
    };
    CloneService.prototype.handleError = function (error) {
        if (error.error instanceof ErrorEvent) {
            console.error('Ocorreu um error:', error.error.message);
        }
        else {
            this.mensagemErro = error.error;
            // console.error(
            //   `Status ${error.status}, ` +
            //   `mensagem: ${JSON.stringify(error.error.errors)} \n` +
            //   `ERROR>>> ${error}`);
        }
        return new __WEBPACK_IMPORTED_MODULE_5_rxjs_observable_ErrorObservable__["a" /* ErrorObservable */](error.error.errors);
    };
    CloneService.prototype.setClone = function (clone) {
        this._clone = clone;
    };
    CloneService.prototype.getClone = function () {
        return this._clone;
    };
    CloneService.prototype.getMensage = function () {
        return this.mensagemErro;
    };
    CloneService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], CloneService);
    return CloneService;
}());



/***/ }),

/***/ "./src/app/clone.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Clone; });
var Clone = /** @class */ (function () {
    function Clone() {
    }
    return Clone;
}());



/***/ }),

/***/ "./src/app/editar-clone/editar-clone.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/editar-clone/editar-clone.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ibox float-e-margins\">\n  <div class=\"ibox-title\">\n      <h5>Editar Clone</h5>\n      <div class=\"ibox-tools\">\n          <a class=\"collapse-link\">\n              <i class=\"fa fa-chevron-up\"></i>\n          </a>\n          <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n              <i class=\"fa fa-wrench\"></i>\n          </a>\n          <ul class=\"dropdown-menu dropdown-user\">\n              <li><a href=\"#\"></a>\n              </li>\n              <li><a href=\"#\"></a>\n              </li>\n          </ul>\n      </div>\n  </div>\n<div class=\"ibox-content\">\n  <div *ngIf=\"mostrarErro\" >\n    <span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>\n    <span class=\"sr-only\">(error)</span>\n    <div *ngFor=\"let m of msgErro\" class=\"alert alert-danger errorDiv\" role=\"alert\">\n      {{ m }}\n    </div>\n  </div>\n  <form #f=\"ngForm\" (ngSubmit)=\"salvar(f)\" class=\"form-horizontal\">\n      <div class=\"form-group\" [ngClass]=\"aplicaCssErro(nome)\"><label class=\"col-sm-2 control-label\">Nome*</label>\n          <div class=\"col-sm-10\">\n            <input id=\"nome\" name=\"nome\" [ngModel]=\"_clone.nome\" type=\"text\" class=\"form-control\" required #nome=\"ngModel\">\n            <app-campo-control-erro\n              [mostrarErro]=\"verificaValidTouched(nome)\"\n              [msgErro]=\"mensagemErro(nome)\">\n            </app-campo-control-erro>\n          </div>\n      </div>\n    <div class=\"hr-line-dashed\"></div>\n    <div class=\"form-group\" [ngClass]=\"aplicaCssErro(idade)\"><label class=\"col-sm-2 control-label\">Idade*</label>\n      <div class=\"col-sm-10\">\n        <input id=\"idade\" name=\"idade\" [ngModel]=\"_clone.idade\" type=\"text\" class=\"form-control\" required #idade=\"ngModel\">\n        <app-campo-control-erro\n          [mostrarErro]=\"verificaValidTouched(idade)\"\n          [msgErro]=\"mensagemErro(dataCriacao)\">\n        </app-campo-control-erro>\n      </div>\n    </div>\n    <div class=\"hr-line-dashed\"></div>\n    <div class=\"form-group\" [ngClass]=\"aplicaCssErro(dataCriacao)\"><label class=\"col-sm-2 control-label\">Data de Criação*</label>\n        <div class=\"col-sm-10\">\n            <input id=\"dataCriacao\" name=\"dataCriacao\" [ngModel]=\"_clone.dataCriacao\" type=\"date\" required class=\"form-control\" #dataCriacao=\"ngModel\">\n          <app-campo-control-erro\n            [mostrarErro]=\"verificaValidTouched(dataCriacao)\"\n            [msgErro]=\"mensagemErro(dataCriacao)\">\n          </app-campo-control-erro>\n        </div>\n      </div>\n    <div class=\"hr-line-dashed\"></div>\n    <div class=\"form-group\">\n      <div class=\"col-sm-2\"></div>\n      <div class=\"col-sm-10\">\n        <label class=\"checkbox-inline\"><input type=\"checkbox\" id=\"bracoMecanico\" name=\"bracoMecanico\" [checked]=\"adicionais.bracoMecanico\" (change)=\"adicionais.bracoMecanico = !adicionais.bracoMecanico\">Braço Mecânico</label>\n        <label class=\"checkbox-inline\"><input type=\"checkbox\" id=\"esqueletoReforcado\" name=\"esqueletoReforcado\" [checked]=\"adicionais.esqueletoReforcado\" (change)=\"adicionais.esqueletoReforcado = !adicionais.esqueletoReforcado\">Esqueleto Reforçado</label>\n        <label class=\"checkbox-inline\"><input type=\"checkbox\" id=\"peleAdaptativa\" name=\"peleAdaptativa\" [checked]=\"adicionais.peleAdaptativa\" (change)=\"adicionais.peleAdaptativa = !adicionais.peleAdaptativa\">Pele Adaptativa</label>\n        <label class=\"checkbox-inline\"><input type=\"checkbox\" id=\"raioLaser\" name=\"raioLaser\" [checked]=\"adicionais.raioLaser\" (change)=\"adicionais.raioLaser = !adicionais.raioLaser\">Raio Laser</label>\n        <label class=\"checkbox-inline\"><input type=\"checkbox\" id=\"sentidosAgucados\" name=\"sentidosAgucados\" [checked]=\"adicionais.sentidosAgucados\" (change)=\"adicionais.sentidosAgucados = !adicionais.sentidosAgucados\">Sentidos Aguçados</label>\n      </div>\n    </div>\n\n    <div class=\"hr-line-dashed\"></div>\n      <button *ngIf=\"novo\" [disabled]=\"!f.valid\" class=\"btn btn-primary\" type=\"submit\">Criar</button>\n      <button *ngIf=\"!novo\" [disabled]=\"!f.valid\" class=\"btn btn-primary\" type=\"submit\">Atualizar</button>\n      <button *ngIf=\"!novo\" (click)=\"deletar(_clone.nome)\" class=\"btn btn-danger\" type=\"button\">Excluir</button>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/editar-clone/editar-clone.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EditarCloneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__clone_service__ = __webpack_require__("./src/app/clone.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__clone__ = __webpack_require__("./src/app/clone.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__adicionais__ = __webpack_require__("./src/app/adicionais.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var EditarCloneComponent = /** @class */ (function () {
    function EditarCloneComponent(service, route, router) {
        this.service = service;
        this.route = route;
        this.router = router;
        this._clone = new __WEBPACK_IMPORTED_MODULE_3__clone__["a" /* Clone */]();
        this.adicionais = new __WEBPACK_IMPORTED_MODULE_4__adicionais__["a" /* Adicionais */]();
        this.novo = false;
        this.mostrarErro = false;
        this.msgErro = {};
    }
    EditarCloneComponent.prototype.ngOnInit = function () {
        var id = +this.route.snapshot.params['id'];
        if (id) {
            this._clone = this.service.obterClone(id);
            this.oldClone = this._clone.nome;
            this.adicionais = this._clone.adicionais;
        }
        else {
            this.novo = true;
        }
    };
    EditarCloneComponent.prototype.salvar = function (form) {
        var _this = this;
        var clone = form.value;
        clone.adicionais = this.adicionais;
        if (this.novo) {
            this.service.salvarClone(clone).subscribe(function (data) {
                _this.router.navigate(['/clones']);
            }, function (err) {
                _this.mostrarErro = true;
                _this.msgErro = _this.setErros(err);
                // console.log(err);
            });
        }
        else {
            this.service.atualizarClone(this.oldClone, clone).subscribe(function (data) {
                // console.log(JSON.stringify(data));
                _this.router.navigate(['/clones']);
            }, function (err) {
                _this.mostrarErro = true;
                _this.msgErro = _this.setErros(err);
            });
        }
    };
    EditarCloneComponent.prototype.deletar = function (nome) {
        var _this = this;
        this.service.deletarClone(nome).subscribe(function (data) {
            _this.router.navigate(['/clones']);
        });
    };
    EditarCloneComponent.prototype.verificaValidTouched = function (campo) {
        return !campo.valid && campo.touched;
    };
    EditarCloneComponent.prototype.aplicaCssErro = function (campo) {
        return {
            'has-error': this.verificaValidTouched(campo),
            'has-feedback': this.verificaValidTouched(campo)
        };
    };
    EditarCloneComponent.prototype.mensagemErro = function (campo) {
        var m = this.service.getMensage();
        return this.tratarMensagem(campo, m);
    };
    EditarCloneComponent.prototype.tratarMensagem = function (campo, err) {
        if (err != null) {
            err.forEach(function (e) {
                if (e.field.equals(campo)) {
                    return e.defaultMessage.toString();
                }
                else {
                    return 'Este campo não é valido';
                }
            });
        }
        else {
            return 'Este campo é obrigatorio';
        }
    };
    EditarCloneComponent.prototype.setErros = function (err) {
        var array = new Array();
        if (err != null) {
            for (var _i = 0, err_1 = err; _i < err_1.length; _i++) {
                var e = err_1[_i];
                if (e.tipo === false) {
                    array.push("O valor '" + e.rejectedValue + "' n\u00E3o \u00E9 v\u00E1lido!  " + e.defaultMessage + ".");
                }
                else {
                    array.push(e.defaultMessage + '.');
                }
            }
        }
        else {
            array.push(this.service.getMensage());
        }
        return array;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["D" /* Input */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_3__clone__["a" /* Clone */])
    ], EditarCloneComponent.prototype, "_clone", void 0);
    EditarCloneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-editar-clone',
            template: __webpack_require__("./src/app/editar-clone/editar-clone.component.html"),
            styles: [__webpack_require__("./src/app/editar-clone/editar-clone.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__clone_service__["a" /* CloneService */],
            __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], EditarCloneComponent);
    return EditarCloneComponent;
}());



/***/ }),

/***/ "./src/app/listar-clones/listar-clones.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/listar-clones/listar-clones.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ibox-content\">\n  <button class=\"btn btn-primary\" type=\"button\" (click)=\"novo()\">Novo</button>\n  <table class=\"table\">\n    <thead>\n      <tr>\n        <th>Nome</th>\n        <th>Idade</th>\n        <th>Dada de Criação</th>\n        <th>Adicionais</th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let clone of clones\">\n        <td><a href=\"javascript:;\" (click)=\"editarClone(clone)\">{{clone.nome}}</a></td>\n        <td>{{clone.idade}}</td>\n        <td>{{clone.dataCriacao | date:\"dd/MM/yyyy\"}}</td>\n        <td><a href=\"javascript:;\" (click)=\"listarAdicionais(clone)\">[+]</a>\n        </td>\n      </tr>\n    </tbody>\n  </table>\n</div>\n"

/***/ }),

/***/ "./src/app/listar-clones/listar-clones.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ListarClonesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__clone_service__ = __webpack_require__("./src/app/clone.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ListarClonesComponent = /** @class */ (function () {
    function ListarClonesComponent(router, service) {
        this.router = router;
        this.service = service;
        this.clones = [];
        this.exibir = false;
        this.clones = [];
    }
    ListarClonesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.obterClones().subscribe(function (data) {
            _this.clones = data;
        }, function (err) {
            console.error(err);
        });
    };
    ListarClonesComponent.prototype.editarClone = function (clone) {
        this.service.setClone(clone);
        this.router.navigate(['/clones', clone.id]);
    };
    ListarClonesComponent.prototype.novo = function () {
        this.router.navigate(['/clones/novo']);
    };
    ListarClonesComponent.prototype.listarAdicionais = function (clone) {
        this.service.setClone(clone);
        this.exibir = true;
        this.router.navigate(['/clones/adicionais', clone.nome]);
    };
    ListarClonesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-listar-clones',
            template: __webpack_require__("./src/app/listar-clones/listar-clones.component.html"),
            styles: [__webpack_require__("./src/app/listar-clones/listar-clones.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__clone_service__["a" /* CloneService */]])
    ], ListarClonesComponent);
    return ListarClonesComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map