(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-acesso-negado-acesso-negado-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/acesso-negado/acesso-negado.component.html":
/*!*************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/acesso-negado/acesso-negado.component.html ***!
  \*************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content\">\r\n  <div class=\"row\">\r\n    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Acesso Negado</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <div class=\"row\">\r\n            <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n              <div class=\"row\" style=\"text-align: center;\">\r\n                <img src=\"../../../assets/img/acesso-negado.png\" width=\"30%\" height=\"30%\" alt=\"Acesso Negado\">\r\n              </div>\r\n              <div class=\"row\" style=\"text-align: center;\">\r\n                <h4>Você não possui permissão para acessar essa funcionalidade.</h4>\r\n                <h4>Contate o administrador do sistema informando o ocorrido.</h4>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</section>\r\n");

/***/ }),

/***/ "./src/app/components/acesso-negado/acesso-negado-routing.module.ts":
/*!**************************************************************************!*\
  !*** ./src/app/components/acesso-negado/acesso-negado-routing.module.ts ***!
  \**************************************************************************/
/*! exports provided: AcessoNegadoRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AcessoNegadoRoutingModule", function() { return AcessoNegadoRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _acesso_negado_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./acesso-negado.component */ "./src/app/components/acesso-negado/acesso-negado.component.ts");




var routes = [
    {
        path: '',
        component: _acesso_negado_component__WEBPACK_IMPORTED_MODULE_3__["AcessoNegadoComponent"]
    }
];
var AcessoNegadoRoutingModule = /** @class */ (function () {
    function AcessoNegadoRoutingModule() {
    }
    AcessoNegadoRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AcessoNegadoRoutingModule);
    return AcessoNegadoRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/acesso-negado/acesso-negado.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/components/acesso-negado/acesso-negado.component.ts ***!
  \*********************************************************************/
/*! exports provided: AcessoNegadoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AcessoNegadoComponent", function() { return AcessoNegadoComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AcessoNegadoComponent = /** @class */ (function () {
    function AcessoNegadoComponent() {
    }
    AcessoNegadoComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-acesso-negado',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./acesso-negado.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/acesso-negado/acesso-negado.component.html")).default
        })
    ], AcessoNegadoComponent);
    return AcessoNegadoComponent;
}());



/***/ }),

/***/ "./src/app/components/acesso-negado/acesso-negado.module.ts":
/*!******************************************************************!*\
  !*** ./src/app/components/acesso-negado/acesso-negado.module.ts ***!
  \******************************************************************/
/*! exports provided: AcessoNegadoModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AcessoNegadoModule", function() { return AcessoNegadoModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _acesso_negado_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./acesso-negado-routing.module */ "./src/app/components/acesso-negado/acesso-negado-routing.module.ts");
/* harmony import */ var _acesso_negado_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./acesso-negado.component */ "./src/app/components/acesso-negado/acesso-negado.component.ts");





var AcessoNegadoModule = /** @class */ (function () {
    function AcessoNegadoModule() {
    }
    AcessoNegadoModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _acesso_negado_component__WEBPACK_IMPORTED_MODULE_4__["AcessoNegadoComponent"]
            ],
            imports: [
                _acesso_negado_routing_module__WEBPACK_IMPORTED_MODULE_3__["AcessoNegadoRoutingModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_2__["SismsCommonsModule"]
            ]
        })
    ], AcessoNegadoModule);
    return AcessoNegadoModule;
}());



/***/ })

}]);
//# sourceMappingURL=components-acesso-negado-acesso-negado-module.js.map