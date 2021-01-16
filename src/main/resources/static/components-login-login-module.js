(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-login-login-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/login/login.component.html":
/*!*********************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/login/login.component.html ***!
  \*********************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div class=\"row\">\r\n  <div class=\"col-xs-1 col-sm-4 col-md-4 col-lg-4\">\r\n  </div>\r\n  <div class=\"col-xs-10 col-sm-4 col-md-4 col-lg-4\">\r\n    <div class=\"row\" style=\"text-align: center;\">\r\n      <img src=\"../../../../assets/img/login.png\" width=\"120px\" height=\"120px\" alt=\"\">\r\n    </div>\r\n    <div class=\"row\">\r\n      <h1 style=\"text-align: center;\"><strong style=\"color: #3c8dbc;\">Sis</strong>MS</h1>\r\n    </div>\r\n    <div class=\"row\">\r\n      <h4 style=\"text-align: center;\">Sistema Gerenciador de Atendimentos</h4>\r\n    </div>\r\n    <div class=\"row\" style=\"margin-top: 10px;\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <form (ngSubmit)=\"onClickFormSubmit()\" [formGroup]=\"form\">\r\n          <div class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <h3 class=\"box-title\">Credenciais do Acesso</h3>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"cpf\">CPF</label>\r\n                    <input type=\"text\" [validation]=\"false\" class=\"form-control\" id=\"cpf\" formControlName=\"cpf\"\r\n                      mask=\"000.000.000-00\">\r\n                    <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('cpf')\">\r\n                    </app-message-required>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"senha\">Senha</label>\r\n                    <div class=\"input-group\">\r\n                      <input maxlength=\"20\" type=\"{{ isViewPassword ? 'text' : 'password' }}\" class=\"form-control\"\r\n                        id=\"senha\" formControlName=\"senha\">\r\n                      <div style=\"cursor: pointer;\" class=\"input-group-addon\" (click)=\"showHidePassword()\">\r\n                        <em class=\"{{ isViewPassword ? 'fa fa-eye-slash' : 'fa fa-eye' }}\"></em>\r\n                      </div>\r\n                    </div>\r\n                    <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('senha')\">\r\n                    </app-message-required>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"box-footer\">\r\n              <button type=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\"><em\r\n                  class=\"fa fa-check\"></em>&nbsp;Entrar</button>\r\n            </div>\r\n          </div>\r\n        </form>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>");

/***/ }),

/***/ "./src/app/components/login/login-routing.module.ts":
/*!**********************************************************!*\
  !*** ./src/app/components/login/login-routing.module.ts ***!
  \**********************************************************/
/*! exports provided: LoginRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginRoutingModule", function() { return LoginRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./login.component */ "./src/app/components/login/login.component.ts");
/* harmony import */ var _resolver_login_resolver__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./resolver/login.resolver */ "./src/app/components/login/resolver/login.resolver.ts");





var routes = [
    {
        path: '',
        component: _login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"],
        resolve: {
            LoginResolver: _resolver_login_resolver__WEBPACK_IMPORTED_MODULE_4__["LoginResolver"]
        }
    },
];
var LoginRoutingModule = /** @class */ (function () {
    function LoginRoutingModule() {
    }
    LoginRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
            providers: [_resolver_login_resolver__WEBPACK_IMPORTED_MODULE_4__["LoginResolver"]]
        })
    ], LoginRoutingModule);
    return LoginRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/login/login.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/components/login/login.component.ts ***!
  \*****************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/menu.service */ "./src/app/core/services/menu.service.ts");
/* harmony import */ var _core_services_auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../core/services/auth.service */ "./src/app/core/services/auth.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");









var LoginComponent = /** @class */ (function () {
    function LoginComponent(service, router, messageService, formBuilder, sharedService, menuService) {
        this.service = service;
        this.router = router;
        this.messageService = messageService;
        this.formBuilder = formBuilder;
        this.sharedService = sharedService;
        this.menuService = menuService;
        this.isViewPassword = false;
        this.isInvalidForm = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
    };
    LoginComponent.prototype.showHidePassword = function () {
        this.isViewPassword = !this.isViewPassword;
    };
    LoginComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            cpf: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            senha: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]
        });
    };
    LoginComponent.prototype.onClickFormSubmit = function () {
        var _this = this;
        this.messageService.clearAllMessages();
        if (this.form.valid) {
            var formValue = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value);
            this.service.login(formValue).subscribe(function (response) {
                _this.sharedService.setUserSession(response.result.usuario);
                _this.sharedService.setTokenSession(response.result.token);
                _this.sharedService.updateTemplateSet(true);
                _this.router.navigate(['/home']);
                _this.menuService.setMenu();
            });
        }
        else {
            this.isInvalidForm = true;
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_8__["Messages"].MSG0004);
        }
    };
    LoginComponent.ctorParameters = function () { return [
        { type: _core_services_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_6__["MessageService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__["SharedService"] },
        { type: src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_4__["MenuService"] }
    ]; };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-login',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./login.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/login/login.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_core_services_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_6__["MessageService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__["SharedService"],
            src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_4__["MenuService"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/components/login/login.module.ts":
/*!**************************************************!*\
  !*** ./src/app/components/login/login.module.ts ***!
  \**************************************************/
/*! exports provided: LoginModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginModule", function() { return LoginModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _login_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./login-routing.module */ "./src/app/components/login/login-routing.module.ts");
/* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./login.component */ "./src/app/components/login/login.component.ts");







var LoginModule = /** @class */ (function () {
    function LoginModule() {
    }
    LoginModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _login_component__WEBPACK_IMPORTED_MODULE_6__["LoginComponent"]
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"],
                _login_routing_module__WEBPACK_IMPORTED_MODULE_5__["LoginRoutingModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"]
            ]
        })
    ], LoginModule);
    return LoginModule;
}());



/***/ }),

/***/ "./src/app/components/login/resolver/login.resolver.ts":
/*!*************************************************************!*\
  !*** ./src/app/components/login/resolver/login.resolver.ts ***!
  \*************************************************************/
/*! exports provided: LoginResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginResolver", function() { return LoginResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/shared.service */ "./src/app/core/services/shared.service.ts");




var LoginResolver = /** @class */ (function () {
    function LoginResolver(router, sharedService) {
        this.router = router;
        this.sharedService = sharedService;
    }
    LoginResolver.prototype.resolve = function () {
        if (this.sharedService.isLoggedIn()) {
            this.router.navigate(['/home']);
            return;
        }
    };
    LoginResolver.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
        { type: src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_3__["SharedService"] }
    ]; };
    LoginResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_3__["SharedService"]])
    ], LoginResolver);
    return LoginResolver;
}());



/***/ }),

/***/ "./src/app/core/services/auth.service.ts":
/*!***********************************************!*\
  !*** ./src/app/core/services/auth.service.ts ***!
  \***********************************************/
/*! exports provided: AuthService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthService", function() { return AuthService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var AuthService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](AuthService, _super);
    function AuthService(http) {
        return _super.call(this, http, '/api/auth') || this;
    }
    AuthService.prototype.login = function (form) {
        return this.http.post(this.apiBaseUrl, form);
    };
    AuthService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    AuthService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AuthService);
    return AuthService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ })

}]);
//# sourceMappingURL=components-login-login-module.js.map