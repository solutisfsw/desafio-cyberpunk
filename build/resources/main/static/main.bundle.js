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

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\n\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        })
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__clone_clone_component__ = __webpack_require__("./src/app/clone/clone.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__clone_detail_clone_detail_component__ = __webpack_require__("./src/app/clone-detail/clone-detail.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__clone_create_clone_create_component__ = __webpack_require__("./src/app/clone-create/clone-create.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__clone_edit_clone_edit_component__ = __webpack_require__("./src/app/clone-edit/clone-edit.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var appRoutes = [
    {
        path: 'clone',
        component: __WEBPACK_IMPORTED_MODULE_4__clone_clone_component__["a" /* CloneComponent */],
        data: { title: 'Lista de Clones' }
    },
    {
        path: 'clone-detail/:id',
        component: __WEBPACK_IMPORTED_MODULE_7__clone_detail_clone_detail_component__["a" /* CloneDetailComponent */],
        data: { title: 'Detalhes do Clone' }
    },
    {
        path: 'clone-create',
        component: __WEBPACK_IMPORTED_MODULE_8__clone_create_clone_create_component__["a" /* CloneCreateComponent */],
        data: { title: 'Criar Clone' }
    },
    {
        path: 'clone-edit/:id',
        component: __WEBPACK_IMPORTED_MODULE_9__clone_edit_clone_edit_component__["a" /* CloneEditComponent */],
        data: { title: 'Editar Clone' }
    },
    { path: '',
        redirectTo: '/clone',
        pathMatch: 'full'
    }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_4__clone_clone_component__["a" /* CloneComponent */],
                __WEBPACK_IMPORTED_MODULE_7__clone_detail_clone_detail_component__["a" /* CloneDetailComponent */],
                __WEBPACK_IMPORTED_MODULE_8__clone_create_clone_create_component__["a" /* CloneCreateComponent */],
                __WEBPACK_IMPORTED_MODULE_9__clone_edit_clone_edit_component__["a" /* CloneEditComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* RouterModule */].forRoot(appRoutes, { enableTracing: true })
            ],
            providers: [],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/clone-create/clone-create.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/clone-create/clone-create.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <h1>Adicionar novo clone</h1>\n  <div class=\"row\">\n    <div class=\"col-md-6\">\n      <form (ngSubmit)=\"saveClone()\" #cloneForm=\"ngForm\">\n        <div class=\"form-group\">\n          <label for=\"name\">Nome</label>\n          <input type=\"text\" class=\"form-control\" [(ngModel)]=\"clone.name\" name=\"name\" required>\n        </div>\n        <div class=\"form-group\">\n          <label for=\"name\">Idade</label>\n          <input type=\"phone\" class=\"form-control\" [(ngModel)]=\"clone.idade\" name=\"idade\" required>\n        </div>\n        <div class=\"form-group\">\n          <label for=\"name\">Adicional</label>\n          <select  ng-model=\"selectedAdicional\">\n            <option value=\"option-1\">braço mecânico </option>\n            <option value=\"option-2\">esqueleto reforçado</option>\n            <option value=\"option-3\">sentidos aguçados</option>\n            <option value=\"option-4\">pele adaptativa</option>\n            <option value=\"option-5\">raio laser</option>\n          </select>\n        </div>\n        <div class=\"form-group\">\n          <button type=\"submit\" class=\"btn btn-success\" [disabled]=\"!cloneForm.form.valid\">Save</button>\n        </div>\n      </form>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/clone-create/clone-create.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CloneCreateComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CloneCreateComponent = /** @class */ (function () {
    function CloneCreateComponent(http, router) {
        this.http = http;
        this.router = router;
        this.clone = {};
    }
    CloneCreateComponent.prototype.ngOnInit = function () {
    };
    CloneCreateComponent.prototype.saveClone = function () {
        var _this = this;
        this.http.post('/clones', this.clone).subscribe(function (res) {
            _this.router.navigate(['/clone']);
        }, function (err) {
            console.log(err);
        });
    };
    CloneCreateComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-clone-create',
            template: __webpack_require__("./src/app/clone-create/clone-create.component.html"),
            styles: [__webpack_require__("./src/app/clone-create/clone-create.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], CloneCreateComponent);
    return CloneCreateComponent;
}());



/***/ }),

/***/ "./src/app/clone-detail/clone-detail.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/clone-detail/clone-detail.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <h1>{{ clone.name }}</h1>\n  <dl class=\"list\">\n    <dt>Idade</dt>\n    <dd>{{ clone.idade }}</dd>\n  </dl>\n</div>\n<div class=\"row\">\n  <div class=\"col-md-12\">\n    <a [routerLink]=\"['/clone-edit', clone.id]\" class=\"btn btn-success\">EDITAR</a>\n    <button class=\"btn btn-danger\" type=\"button\" (click)=\"deleteClone(clone.id)\">DELETAR\n</button>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/clone-detail/clone-detail.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CloneDetailComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CloneDetailComponent = /** @class */ (function () {
    function CloneDetailComponent(router, route, http) {
        this.router = router;
        this.route = route;
        this.http = http;
        this.clone = {};
    }
    CloneDetailComponent.prototype.ngOnInit = function () {
        this.getCloneDetail(this.route.snapshot.params['id']);
    };
    CloneDetailComponent.prototype.getCloneDetail = function (id) {
        var _this = this;
        this.http.get('/clones/' + id).subscribe(function (data) {
            _this.clone = data;
        });
    };
    CloneDetailComponent.prototype.deleteClone = function (id) {
        var _this = this;
        this.http.delete('/clones/' + id).subscribe(function (res) {
            _this.router.navigate(['/clone']);
        }, function (err) {
            console.log(err);
        });
    };
    CloneDetailComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-clone-detail',
            template: __webpack_require__("./src/app/clone-detail/clone-detail.component.html"),
            styles: [__webpack_require__("./src/app/clone-detail/clone-detail.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */], __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], CloneDetailComponent);
    return CloneDetailComponent;
}());



/***/ }),

/***/ "./src/app/clone-edit/clone-edit.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/clone-edit/clone-edit.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <h1>Editar Clone</h1>\n  <div class=\"row\">\n    <div class=\"col-md-6\">\n      <form (ngSubmit)=\"updateClone(clone.id)\" #cloneForm=\"ngForm\">\n        <div class=\"form-group\">\n          <label for=\"name\">Nome</label>\n          <input type=\"text\" class=\"form-control\" [(ngModel)]=\"clone.name\" name=\"name\" required>\n        </div>\n        <div class=\"form-group\">\n          <label for=\"name\">Idade</label>\n          <input type=\"phone\" class=\"form-control\" [(ngModel)]=\"clone.idade\" name=\"idade\" required>\n        </div>\n        <div class=\"form-group\">\n          <label for=\"name\">Adicional</label>\n          <select  ng-model=\"selectedAdicional\">\n            <option value=\"option-1\">braço mecânico </option>\n            <option value=\"option-2\">esqueleto reforçado</option>\n            <option value=\"option-3\">sentidos aguçados</option>\n            <option value=\"option-4\">pele adaptativa</option>\n            <option value=\"option-5\">raio laser</option>\n          </select>\n        </div>\n        <div class=\"form-group\">\n          <button type=\"submit\" class=\"btn btn-success\" [disabled]=\"!cloneForm.form.valid\">Atualizar</button>\n        </div>\n      </form>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/clone-edit/clone-edit.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CloneEditComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CloneEditComponent = /** @class */ (function () {
    function CloneEditComponent(http, router, route) {
        this.http = http;
        this.router = router;
        this.route = route;
        this.clone = {};
    }
    CloneEditComponent.prototype.ngOnInit = function () {
        this.getClone(this.route.snapshot.params['id']);
    };
    CloneEditComponent.prototype.getClone = function (id) {
        var _this = this;
        this.http.get('/clones/' + id).subscribe(function (data) {
            _this.clone = data;
        });
    };
    CloneEditComponent.prototype.updateClone = function (id) {
        var _this = this;
        this.http.put('/clones/' + id, this.clone).subscribe(function (res) {
            var id = res['id'];
            _this.router.navigate(['/clone']);
        }, function (err) {
            console.log(err);
        });
    };
    CloneEditComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-clone-edit',
            template: __webpack_require__("./src/app/clone-edit/clone-edit.component.html"),
            styles: [__webpack_require__("./src/app/clone-edit/clone-edit.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */]])
    ], CloneEditComponent);
    return CloneEditComponent;
}());



/***/ }),

/***/ "./src/app/clone/clone.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/clone/clone.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <h1>Lista de Clones\n    <a [routerLink]=\"['/clone-create']\" class=\"btn btn-default btn-lg\">\n      <span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\"></span>\n    </a>\n  </h1>\n  <table class=\"table\">\n    <thead>\n      <tr>\n        <th></th>\n        <th>Nome</th>\n        <th>Idade</th>\n        <th>Adicional</th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let clone of clones\">\n        <td>{{ clone.title }}</td>\n        <td>{{ clone.name }}</td>\n        <td>{{ clone.idade }}</td>\n        <td>{{ selectedAdicional }}</td>\n        <td><a [routerLink]=\"['/clone-detail', clone.id]\">Detalhes</a></td>\n      </tr>\n    </tbody>\n  </table>\n</div>\n"

/***/ }),

/***/ "./src/app/clone/clone.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CloneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var CloneComponent = /** @class */ (function () {
    function CloneComponent(http) {
        this.http = http;
    }
    CloneComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.http.get('/clones').subscribe(function (data) {
            _this.clones = data;
        });
    };
    CloneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-clone',
            template: __webpack_require__("./src/app/clone/clone.component.html"),
            styles: [__webpack_require__("./src/app/clone/clone.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], CloneComponent);
    return CloneComponent;
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