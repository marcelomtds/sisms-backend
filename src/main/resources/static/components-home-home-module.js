(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-home-home-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/home/home.component.html":
/*!*******************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/home/home.component.html ***!
  \*******************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Página Principal</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <div class=\"row\">\r\n    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n      <div *ngIf=\"dadosAgenda.length\" class=\"col-md-12\" style=\"padding: 0px\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-8 col-md-8 col-lg-8\">\r\n                <h3 class=\"box-title\">{{ getWeekDay }}</h3>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"table-roll\">\r\n              <table id=\"example2\" class=\"table table-bordered table-hover\">\r\n                <thead>\r\n                  <tr>\r\n                    <th>Status</th>\r\n                    <th>Horário Inicial</th>\r\n                    <th>Horário Final</th>\r\n                    <th>Paciente</th>\r\n                    <th>Tipo de Atendimento</th>\r\n                    <th>Categoria de Atendimento</th>\r\n                  </tr>\r\n                </thead>\r\n                <tbody>\r\n                  <tr [ngStyle]=\"{'color': getColor(row.horarioInicio, row.horarioFim) }\" style=\"font-weight: bold;\"\r\n                    *ngFor=\"let row of dadosAgenda\">\r\n                    <td>\r\n                      {{ getStatus(row.horarioInicio, row.horarioFim) }}\r\n                    </td>\r\n                    <td>\r\n                      {{ row.horarioInicio | horario }}\r\n                    </td>\r\n                    <td>\r\n                      {{ row.horarioFim | horario }}\r\n                    </td>\r\n                    <td>\r\n                      {{ row.pacienteNomeCompleto }}\r\n                    </td>\r\n                    <td>\r\n                      {{ row.tipoAtendimentoDescricao }}\r\n                    </td>\r\n                    <td>\r\n                      {{ row.categoriaAtendimentoDescricao }}\r\n                    </td>\r\n                  </tr>\r\n                </tbody>\r\n              </table>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <app-no-records [title]=\"getWeekDay\" *ngIf=\"!dadosAgenda?.length\"></app-no-records>\r\n    </div>\r\n    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-6\">\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Aniversariantes do Mês de {{ mes }} - Pacientes</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <div *ngFor=\"let paciente of pacientes\" class=\"callout callout-success\">\r\n            <h4>{{ paciente.nomeCompleto }} - {{ paciente.dataNascimento | idade }}</h4>\r\n            <strong>{{ paciente.dataNascimento | date : 'dd/MM/yyyy' }}</strong>\r\n          </div>\r\n          <p *ngIf=\"!pacientes.length\">Nenhum registro encontrado.</p>\r\n        </div>\r\n      </div>\r\n    </div>\r\n    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-6\">\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Aniversariantes do Mês de {{ mes }} - Usuários</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <div *ngFor=\"let usuario of usuarios\" class=\"callout callout-success\">\r\n            <h4>{{ usuario.nomeCompleto }} - {{ usuario.dataNascimento | idade }}</h4>\r\n            <strong>{{ usuario.dataNascimento | date : 'dd/MM/yyyy' }}</strong>\r\n          </div>\r\n          <p *ngIf=\"!usuarios.length\">Nenhum registro encontrado.</p>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</section>");

/***/ }),

/***/ "./src/app/components/home/home-routing.module.ts":
/*!********************************************************!*\
  !*** ./src/app/components/home/home-routing.module.ts ***!
  \********************************************************/
/*! exports provided: HomeRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeRoutingModule", function() { return HomeRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _home_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./home.component */ "./src/app/components/home/home.component.ts");
/* harmony import */ var _home_resolver__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./home.resolver */ "./src/app/components/home/home.resolver.ts");





var routes = [
    {
        path: '',
        component: _home_component__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"],
        resolve: {
            resolve: _home_resolver__WEBPACK_IMPORTED_MODULE_4__["HomeResolver"]
        },
    }
];
var HomeRoutingModule = /** @class */ (function () {
    function HomeRoutingModule() {
    }
    HomeRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
            providers: [
                _home_resolver__WEBPACK_IMPORTED_MODULE_4__["HomeResolver"]
            ]
        })
    ], HomeRoutingModule);
    return HomeRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/home/home.component.ts":
/*!***************************************************!*\
  !*** ./src/app/components/home/home.component.ts ***!
  \***************************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! moment */ "./node_modules/moment/moment.js");
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _shared_util_util__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../shared/util/util */ "./src/app/shared/util/util.ts");





var HomeComponent = /** @class */ (function () {
    function HomeComponent(route) {
        this.route = route;
        this.pacientes = new Array();
        this.usuarios = new Array();
        this.dadosAgenda = new Array();
        this.interval = setInterval(function () {
        }, 1000);
    }
    HomeComponent.prototype.ngOnInit = function () {
        this.getMes();
        this.onLoadData();
    };
    HomeComponent.prototype.ngOnDestroy = function () {
        this.interval = null;
    };
    HomeComponent.prototype.getColor = function (horarioInicial, horarioFinal) {
        if (this.isAfter(horarioInicial, horarioFinal)) {
            return 'blue';
        }
        else if (this.isBetween(horarioInicial, horarioFinal)) {
            return 'green';
        }
        else {
            return '#ff8115';
        }
    };
    HomeComponent.prototype.getStatus = function (horarioInicial, horarioFinal) {
        if (this.isAfter(horarioInicial, horarioFinal)) {
            return 'Encerrado';
        }
        else if (this.isBetween(horarioInicial, horarioFinal)) {
            return 'Em Atedimento';
        }
        else {
            return 'Não Iniciado';
        }
    };
    Object.defineProperty(HomeComponent.prototype, "getWeekDay", {
        get: function () {
            return "Agenda para " + _shared_util_util__WEBPACK_IMPORTED_MODULE_4__["default"].diaSemana(new Date().getDay());
        },
        enumerable: true,
        configurable: true
    });
    HomeComponent.prototype.onLoadData = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.pacientes = response.resolve[0].result;
            _this.usuarios = response.resolve[1].result;
            _this.dadosAgenda = response.resolve[2].result;
        });
    };
    HomeComponent.prototype.isBetween = function (horarioInicial, horarioFinal) {
        return moment__WEBPACK_IMPORTED_MODULE_3__().isBetween(moment__WEBPACK_IMPORTED_MODULE_3__(new Date()).format('YYYY-MM-DD') + "T" + horarioInicial, moment__WEBPACK_IMPORTED_MODULE_3__(new Date()).format('YYYY-MM-DD') + "T" + horarioFinal);
    };
    HomeComponent.prototype.isAfter = function (horarioInicial, horarioFinal) {
        return moment__WEBPACK_IMPORTED_MODULE_3__().isAfter(moment__WEBPACK_IMPORTED_MODULE_3__(new Date()).format('YYYY-MM-DD') + "T" + horarioInicial)
            && moment__WEBPACK_IMPORTED_MODULE_3__().isAfter(moment__WEBPACK_IMPORTED_MODULE_3__(new Date()).format('YYYY-MM-DD') + "T" + horarioFinal);
    };
    HomeComponent.prototype.getMes = function () {
        this.mes = _shared_util_util__WEBPACK_IMPORTED_MODULE_4__["default"].mesesAno(new Date().getMonth() + 1);
    };
    HomeComponent.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] }
    ]; };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./home.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/home/home.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/components/home/home.module.ts":
/*!************************************************!*\
  !*** ./src/app/components/home/home.module.ts ***!
  \************************************************/
/*! exports provided: HomeModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeModule", function() { return HomeModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _home_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./home-routing.module */ "./src/app/components/home/home-routing.module.ts");
/* harmony import */ var _home_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./home.component */ "./src/app/components/home/home.component.ts");







var HomeModule = /** @class */ (function () {
    function HomeModule() {
    }
    HomeModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _home_component__WEBPACK_IMPORTED_MODULE_6__["HomeComponent"],
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _home_routing_module__WEBPACK_IMPORTED_MODULE_5__["HomeRoutingModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"]
            ]
        })
    ], HomeModule);
    return HomeModule;
}());



/***/ }),

/***/ "./src/app/components/home/home.resolver.ts":
/*!**************************************************!*\
  !*** ./src/app/components/home/home.resolver.ts ***!
  \**************************************************/
/*! exports provided: HomeResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeResolver", function() { return HomeResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_core_services_agenda_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/agenda.service */ "./src/app/core/services/agenda.service.ts");
/* harmony import */ var src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");






var HomeResolver = /** @class */ (function () {
    function HomeResolver(pacienteService, agendaService, usuarioService) {
        this.pacienteService = pacienteService;
        this.agendaService = agendaService;
        this.usuarioService = usuarioService;
    }
    HomeResolver.prototype.resolve = function () {
        return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["forkJoin"])([
            this.pacienteService.findAllBirthdaysMonth(),
            this.usuarioService.findAllBirthdaysMonth(),
            this.agendaService.findAll()
        ]);
    };
    HomeResolver.ctorParameters = function () { return [
        { type: src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"] },
        { type: src_app_core_services_agenda_service__WEBPACK_IMPORTED_MODULE_3__["AgendaService"] },
        { type: src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_5__["UsuarioService"] }
    ]; };
    HomeResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"],
            src_app_core_services_agenda_service__WEBPACK_IMPORTED_MODULE_3__["AgendaService"],
            src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_5__["UsuarioService"]])
    ], HomeResolver);
    return HomeResolver;
}());



/***/ })

}]);
//# sourceMappingURL=components-home-home-module.js.map