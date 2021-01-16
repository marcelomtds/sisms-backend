(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-pacote-pacote-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/form/pacote-form.component.html":
/*!*********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/form/pacote-form.component.html ***!
  \*********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>{{ form.value.id ? 'Editar' : 'Cadastar' }} Pacote</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <div class=\"row\">\r\n    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Dados do Pacote</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <div class=\"row\">\r\n            <form [formGroup]=\"form\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"categoriaAtendimento\">Categoria de Atendimento</label>\r\n                  <ng-select id=\"categoriaAtendimento\" placeholder=\"Selecione\" formControlName=\"categoriaAtendimentoId\"\r\n                    [items]=\"categoriasAtendimento\" bindLabel=\"descricao\" bindValue=\"id\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('categoriaAtendimentoId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"paciente\">Paciente</label>\r\n                  <ng-select id=\"paciente\" placeholder=\"Selecione\" formControlName=\"pacienteId\" [items]=\"pacientes\"\r\n                    bindLabel=\"nomeCompleto\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('pacienteId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"quantidadeSessao\">Quantidade de Sessão</label>\r\n                  <input id=\"quantidadeSessao\" type=\"text\" formControlName=\"quantidadeSessao\" class=\"form-control\"\r\n                    [validation]=\"false\" mask=\"0{2}\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"valor\">Valor</label>\r\n                  <input id=\"valor\" currencyMask\r\n                    [options]=\"{ align: 'left', suffix: '', prefix: '', thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                    type=\"text\" formControlName=\"valor\" maxlength=\"10\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n            </form>\r\n          </div>\r\n        </div>\r\n        <div class=\"box-footer\">\r\n          <button class=\"btn btn-primary pull-right\" (click)=\"onClickFormSubmit()\" style=\"margin-left: 15px;\"><em\r\n              class=\"fa fa-save\"></em>&nbsp;Salvar</button>\r\n          <button class=\"btn btn-danger pull-right\" (click)=\"onClickCancelar()\"><em\r\n              class=\"fa fa-ban\"></em>&nbsp;Cancelar</button>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</section>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/list/pacote-list.component.html":
/*!*********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/list/pacote-list.component.html ***!
  \*********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Buscar Pacotes</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Filtros</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"categoriaAtendimento\">Categoria de Atendimento</label>\r\n                  <ng-select id=\"categoriaAtendimento\" maxlength=\"50\" formControlName=\"categoriaAtendimentoId\"\r\n                    [items]=\"categoriasAtendimento\" bindLabel=\"descricao\" bindValue=\"id\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"dataInicio\">Data Início</label>\r\n                  <input id=\"dataInicio\" type=\"text\" [validation]=\"false\" mask=\"00/00/0000\" formControlName=\"dataInicio\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"dataFim\">Data Fim</label>\r\n                  <input id=\"dataFim\" type=\"text\" [validation]=\"false\" mask=\"00/00/0000\" formControlName=\"dataFim\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"aberto\">Status do Pacote</label>\r\n                  <ng-select id=\"aberto\" maxlength=\"50\" formControlName=\"aberto\">\r\n                    <ng-option [value]=true>Em Aberto</ng-option>\r\n                    <ng-option [value]=false>Encerrado</ng-option>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"paciente\">Paciente</label>\r\n                  <ng-select id=\"paciente\" maxlength=\"50\" formControlName=\"pacienteId\" [items]=\"pacientes\"\r\n                    bindLabel=\"nomeCompleto\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div *ngIf=\"authGuardService.isPermitido(permissaoAdministrador)\"\r\n                class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"usuario\">Usuário</label>\r\n                  <ng-select id=\"usuario\" maxlength=\"50\" formControlName=\"usuarioId\" [items]=\"usuarios\"\r\n                    bindLabel=\"nomeCompleto\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-footer\">\r\n            <button (click)=\"onClickFormSubmit()\" class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\"><em\r\n                class=\"fa fa-search\"></em>&nbsp;Buscar</button>\r\n            <button class=\"btn btn-warning pull-right\" (click)=\"onClickLimparCampos()\"><em\r\n                class=\"fa fa-eraser\"></em>&nbsp;Limpar</button>\r\n          </div>\r\n        </div>\r\n        <div *ngIf=\"dados?.content?.length > 0\" class=\"col-md-12\" style=\"padding: 0px\">\r\n          <div class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-8\">\r\n                  <h3 class=\"box-title\">Resultado</h3>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"table-roll\">\r\n                <table id=\"example2\" class=\"table table-bordered table-hover\">\r\n                  <thead>\r\n                    <tr>\r\n                      <th>Opções</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('valor')\"><em\r\n                          [class]=\"getIconOrderBy('valor')\"></em>&nbsp;Valor do Pacote</th>\r\n                      <th style=\"cursor: pointer\" xxxx (click)=\"onClickOrderBy('totalPago')\"><em\r\n                          [class]=\"getIconOrderBy('totalPago')\"></em>&nbsp;Total Pago</th>\r\n                      <th>Total à Pagar</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('paciente.nomeCompleto')\"><em\r\n                          [class]=\"getIconOrderBy('paciente.nomeCompleto')\"></em>&nbsp;Paciente</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('usuario.nomeCompleto')\"><em\r\n                          [class]=\"getIconOrderBy('usuario.nomeCompleto')\"></em>&nbsp;Usuário</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('dataCriacao')\"><em\r\n                          [class]=\"getIconOrderBy('dataCriacao')\"></em>&nbsp;Data de Criação</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('categoriaAtendimento.descricao')\"><em\r\n                          [class]=\"getIconOrderBy('categoriaAtendimento.descricao')\"></em>&nbsp;Categoria\r\n                        de Atendimento</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('valor')\"><em\r\n                          [class]=\"getIconOrderBy('valor')\"></em>&nbsp;Valor</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('numero')\"><em\r\n                          [class]=\"getIconOrderBy('numero')\"></em>&nbsp;Número</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('aberto')\"><em\r\n                          [class]=\"getIconOrderBy('aberto')\"></em>&nbsp;Status</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('quantidadeAtendimentos')\"><em\r\n                          [class]=\"getIconOrderBy('quantidadeAtendimentos')\"></em>&nbsp;Quantidade de\r\n                        Atendimento Realizado</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('quantidadeSessao')\"><em\r\n                          [class]=\"getIconOrderBy('quantidadeSessao')\"></em>&nbsp;Quantidade de\r\n                        Sessão do Pacote</th>\r\n                    </tr>\r\n                  </thead>\r\n                  <tbody>\r\n                    <tr *ngFor=\"let pacote of dados?.content\">\r\n                      <td>\r\n                        <button title=\"Encerrar\" *ngIf=\"pacote?.aberto\" (click)=\"onClickClosePacote(pacote.id)\"\r\n                          class=\"btn btn-danger\"><em class=\"fa fa-ban\"></em></button>\r\n                        <button *ngIf=\"pacote?.aberto\" title=\"Editar\" [routerLink]=\"['/pacote/alterar', pacote.id]\"\r\n                          class=\"btn btn-primary {{ pacote?.aberto ? 'btn-left' : '' }}\"><em\r\n                            class=\"fa fa-pencil\"></em></button>\r\n                        <button title=\"Visualizar\" (click)=\"onClickOpenModalVisualizar(pacote)\"\r\n                          class=\"btn btn-primary {{ pacote?.aberto ? 'btn-left' : '' }}\"><em\r\n                            class=\"fa fa-eye\"></em></button>\r\n                        <button title=\"Gerenciar Lançamentos\" (click)=\"onClickOpenModalGerenciarLancamentos(pacote.id)\"\r\n                          class=\"btn btn-success btn-left\"><em class=\"fa fa-usd\"></em></button>\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.valor || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td\r\n                        [ngStyle]=\"{'color': !pacote.totalPago || pacote.totalPago < pacote.valor ? 'red' : 'green', 'font-weight': 'bold'}\">\r\n                        {{ pacote.totalPago || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.valor - pacote.totalPago || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.pacienteNomeCompleto }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.usuarioNomeCompleto }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.dataCriacao | date: 'dd/MM/yyyy' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.categoriaAtendimentoDescricao }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.valor | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.numero }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.aberto ? 'Em Aberto' : 'Encerrado' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.quantidadeAtendimentos }}\r\n                      </td>\r\n                      <td>\r\n                        {{ pacote.quantidadeSessao || '-' }}\r\n                      </td>\r\n                    </tr>\r\n                  </tbody>\r\n                </table>\r\n              </div>\r\n            </div>\r\n            <div class=\"box-footer\">\r\n              <app-page-action [dados]=\"dados\" [filtro]=\"filtro\" (searchByFilter)=\"searchByFilter()\">\r\n              </app-page-action>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <app-no-records *ngIf=\"showNoRecords && !dados.content?.length\"></app-no-records>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>");

/***/ }),

/***/ "./src/app/components/pacote/form/pacote-form.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/components/pacote/form/pacote-form.component.ts ***!
  \*****************************************************************/
/*! exports provided: PacoteFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacoteFormComponent", function() { return PacoteFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var _shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../shared/modais/modal-confirmacao/modal-confirmacao.component */ "./src/app/shared/modais/modal-confirmacao/modal-confirmacao.component.ts");
/* harmony import */ var _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/services/categoria-atendimento.service */ "./src/app/core/services/categoria-atendimento.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../core/services/pacote.service */ "./src/app/core/services/pacote.service.ts");











var PacoteFormComponent = /** @class */ (function () {
    function PacoteFormComponent(formBuilder, service, router, modalService, route, messageService, pacienteService, categoriaAtendimentoService) {
        this.formBuilder = formBuilder;
        this.service = service;
        this.router = router;
        this.modalService = modalService;
        this.route = route;
        this.messageService = messageService;
        this.pacienteService = pacienteService;
        this.categoriaAtendimentoService = categoriaAtendimentoService;
        this.pacientes = new Array();
        this.categoriasAtendimento = new Array();
        this.isInvalidForm = false;
    }
    PacoteFormComponent.prototype.ngOnInit = function () {
        var id = +this.route.snapshot.params['id'];
        if (id) {
            this.findById(id);
        }
        this.onCreateForm();
        this.onLoadCombos();
    };
    PacoteFormComponent.prototype.findById = function (id) {
        var _this = this;
        this.service.findById(id).subscribe(function (response) {
            _this.form.patchValue(response.result);
            _this.form.controls.categoriaAtendimentoId.disable();
            _this.form.controls.categoriaAtendimentoId.updateValueAndValidity();
            _this.form.controls.pacienteId.disable();
            _this.form.controls.pacienteId.updateValueAndValidity();
        });
    };
    PacoteFormComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            id: [null],
            categoriaAtendimentoId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            pacienteId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            valor: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            quantidadeSessao: [null]
        });
    };
    PacoteFormComponent.prototype.onLoadCombos = function () {
        var _this = this;
        this.pacienteService.findAllActive().subscribe(function (response) {
            _this.pacientes = response.result;
        });
        this.categoriaAtendimentoService.findAll().subscribe(function (response) {
            _this.categoriasAtendimento = response.result;
        });
    };
    PacoteFormComponent.prototype.onClickFormSubmit = function () {
        var _this = this;
        this.messageService.clearAllMessages();
        if (this.form.valid) {
            var formValue_1 = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { pacienteId: this.form.controls.pacienteId.value, categoriaAtendimentoId: this.form.controls.categoriaAtendimentoId.value });
            if (formValue_1.id) {
                this.service.update(formValue_1.id, formValue_1).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.onCreateForm();
                    _this.router.navigate(['/pacote']);
                });
            }
            else {
                var modalRef = this.modalService.show(_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_7__["ModalConfirmacaoComponent"], { backdrop: 'static' });
                modalRef.content.titulo = 'Confirmação de Criação de Pacote';
                modalRef.content.corpo = 'Ao criar um novo pacote o anterior será encerrado automaticamente. Deseja continuar?';
                modalRef.content.onClose.subscribe(function (result) {
                    if (result) {
                        _this.service.create(formValue_1).subscribe(function (response) {
                            _this.messageService.sendMessageSuccess(response.message);
                            _this.onCreateForm();
                            _this.router.navigate(['/pacote']);
                        });
                    }
                });
            }
        }
        else {
            this.isInvalidForm = true;
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_6__["Messages"].MSG0004);
        }
    };
    PacoteFormComponent.prototype.onClickCancelar = function () {
        this.messageService.clearAllMessages();
        window.history.back();
    };
    PacoteFormComponent.ctorParameters = function () { return [
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_10__["PacoteService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__["BsModalService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__["MessageService"] },
        { type: _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_5__["PacienteService"] },
        { type: _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoService"] }
    ]; };
    PacoteFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-pacote-form',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./pacote-form.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/form/pacote-form.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_10__["PacoteService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__["BsModalService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__["MessageService"],
            _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_5__["PacienteService"],
            _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoService"]])
    ], PacoteFormComponent);
    return PacoteFormComponent;
}());



/***/ }),

/***/ "./src/app/components/pacote/list/pacote-list.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/components/pacote/list/pacote-list.component.ts ***!
  \*****************************************************************/
/*! exports provided: PacoteListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacoteListComponent", function() { return PacoteListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/lancamento.service */ "./src/app/core/services/lancamento.service.ts");
/* harmony import */ var src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/components/pagination/pagination */ "./src/app/shared/components/pagination/pagination.ts");
/* harmony import */ var _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../core/guards/auth.guard */ "./src/app/core/guards/auth.guard.ts");
/* harmony import */ var _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../core/model/enum/perfil.enum */ "./src/app/core/model/enum/perfil.enum.ts");
/* harmony import */ var _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/model/filter/filter.filter */ "./src/app/core/model/filter/filter.filter.ts");
/* harmony import */ var _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/model/model/page.model */ "./src/app/core/model/model/page.model.ts");
/* harmony import */ var _core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../core/model/model/usuario.model */ "./src/app/core/model/model/usuario.model.ts");
/* harmony import */ var _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../core/services/categoria-atendimento.service */ "./src/app/core/services/categoria-atendimento.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../core/services/pacote.service */ "./src/app/core/services/pacote.service.ts");
/* harmony import */ var _core_services_shared_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var _shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../shared/modais/modal-confirmacao/modal-confirmacao.component */ "./src/app/shared/modais/modal-confirmacao/modal-confirmacao.component.ts");
/* harmony import */ var _shared_modais_modal_visualizar_pacote_modal_visualizar_pacote_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../../shared/modais/modal-visualizar-pacote/modal-visualizar-pacote.component */ "./src/app/shared/modais/modal-visualizar-pacote/modal-visualizar-pacote.component.ts");
/* harmony import */ var _shared_util_util__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ../../../shared/util/util */ "./src/app/shared/util/util.ts");
/* harmony import */ var _controle_caixa_modal_gerenciar_lancamento_pacote_modal_gerenciar_lancamento_pacote_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ../../controle-caixa/modal/gerenciar-lancamento-pacote/modal-gerenciar-lancamento-pacote.component */ "./src/app/components/controle-caixa/modal/gerenciar-lancamento-pacote/modal-gerenciar-lancamento-pacote.component.ts");






















var PacoteListComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PacoteListComponent, _super);
    function PacoteListComponent(formBuilder, service, messageService, pacienteService, modalService, categoriaAtendimentoService, usuarioService, sharedService, authGuardService, lancamentoService) {
        var _this = _super.call(this, messageService) || this;
        _this.formBuilder = formBuilder;
        _this.service = service;
        _this.pacienteService = pacienteService;
        _this.modalService = modalService;
        _this.categoriaAtendimentoService = categoriaAtendimentoService;
        _this.usuarioService = usuarioService;
        _this.sharedService = sharedService;
        _this.authGuardService = authGuardService;
        _this.lancamentoService = lancamentoService;
        _this.pacientes = new Array();
        _this.usuarios = new Array();
        _this.categoriasAtendimento = new Array();
        _this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__["default"]();
        _this.currentUser = new _core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__["Usuario"]();
        _this.permissaoAdministrador = _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_7__["PerfilEnum"].ADMINISTRADOR;
        _this.showNoRecords = false;
        _this.subscription = _this.lancamentoService.getLancamento().subscribe(function () {
            _this.searchByFilter();
        });
        return _this;
    }
    PacoteListComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.getCurrentUser();
        this.onLoadCombos();
    };
    PacoteListComponent.prototype.getCurrentUser = function () {
        this.currentUser = this.sharedService.getUserSession();
    };
    PacoteListComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            categoriaAtendimentoId: [null],
            pacienteId: [null],
            usuarioId: [null],
            aberto: [null],
            dataInicio: [null],
            dataFim: [null]
        });
    };
    PacoteListComponent.prototype.onLoadCombos = function () {
        var _this = this;
        this.pacienteService.findAll().subscribe(function (response) {
            _this.pacientes = response.result;
        });
        this.categoriaAtendimentoService.findAll().subscribe(function (response) {
            _this.categoriasAtendimento = response.result;
        });
        if (this.currentUser.perfilRole === this.permissaoAdministrador) {
            this.usuarioService.findAll().subscribe(function (response) {
                _this.usuarios = response.result;
            });
        }
    };
    PacoteListComponent.prototype.onClickClosePacote = function (id) {
        var _this = this;
        this.messageService.clearAllMessages();
        var modalRef = this.modalService.show(_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_18__["ModalConfirmacaoComponent"], { backdrop: 'static' });
        modalRef.content.titulo = 'Confirmação de Encerramento de Pacote';
        modalRef.content.corpo = 'Ao encerrar o pacote não será possível cadastrar atendimento ao mesmo. Deseja continuar?';
        modalRef.content.onClose.subscribe(function (ressult) {
            if (ressult) {
                _this.service.closePackage(id).subscribe(function (response) {
                    _this.searchByFilter();
                    _this.messageService.sendMessageSuccess(response.message);
                });
            }
        });
    };
    PacoteListComponent.prototype.onClickFormSubmit = function () {
        this.messageService.clearAllMessages();
        var dataInicio = this.form.value.dataInicio;
        var dataFim = this.form.value.dataFim;
        if (dataInicio && !_shared_util_util__WEBPACK_IMPORTED_MODULE_20__["default"].isDataValida(dataInicio)) {
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_17__["Messages"].MSG0013);
            return;
        }
        if (dataFim && !_shared_util_util__WEBPACK_IMPORTED_MODULE_20__["default"].isDataValida(dataFim)) {
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_17__["Messages"].MSG0014);
            return;
        }
        this.filtro = new _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.filtro = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.filtro, { orderBy: 'dataCriacao', direction: 'DESC', filter: tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { dataInicio: _shared_util_util__WEBPACK_IMPORTED_MODULE_20__["default"].convertStringToDate(dataInicio), dataFim: _shared_util_util__WEBPACK_IMPORTED_MODULE_20__["default"].convertStringToDate(dataFim) }) });
        this.searchByFilter();
    };
    PacoteListComponent.prototype.searchByFilter = function () {
        var _this = this;
        this.service.findByFilter(this.filtro).subscribe(function (response) {
            _this.showNoRecords = true;
            _this.dados = response.result;
        });
    };
    PacoteListComponent.prototype.onClickLimparCampos = function () {
        this.messageService.clearAllMessages();
        this.onCreateForm();
        this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__["default"]();
        this.filtro = new _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.showNoRecords = false;
    };
    PacoteListComponent.prototype.onClickOpenModalVisualizar = function (pacote) {
        this.messageService.clearAllMessages();
        var initialState = {
            dados: pacote
        };
        this.modalService.show(_shared_modais_modal_visualizar_pacote_modal_visualizar_pacote_component__WEBPACK_IMPORTED_MODULE_19__["ModalVisualizarPacoteComponent"], { initialState: initialState, backdrop: 'static', class: 'gray modal-lg' });
    };
    PacoteListComponent.prototype.onClickOpenModalGerenciarLancamentos = function (id) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var initialState, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        _a = {};
                        return [4 /*yield*/, this.service.findById(id).toPromise()];
                    case 1:
                        initialState = (_a.pacote = (_b.sent()).result,
                            _a);
                        this.modalService.show(_controle_caixa_modal_gerenciar_lancamento_pacote_modal_gerenciar_lancamento_pacote_component__WEBPACK_IMPORTED_MODULE_21__["ModalGerenciarLancamentoPacoteComponent"], { initialState: initialState, class: 'gray modal-lg', backdrop: 'static' });
                        return [2 /*return*/];
                }
            });
        });
    };
    PacoteListComponent.ctorParameters = function () { return [
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__["PacoteService"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"] },
        { type: _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_13__["PacienteService"] },
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"] },
        { type: _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_11__["CategoriaAtendimentoService"] },
        { type: _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_16__["UsuarioService"] },
        { type: _core_services_shared_service__WEBPACK_IMPORTED_MODULE_15__["SharedService"] },
        { type: _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_6__["AuthGuard"] },
        { type: src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_4__["LancamentoService"] }
    ]; };
    PacoteListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-pacote-list',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./pacote-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/pacote/list/pacote-list.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__["PacoteService"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"],
            _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_13__["PacienteService"],
            ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"],
            _core_services_categoria_atendimento_service__WEBPACK_IMPORTED_MODULE_11__["CategoriaAtendimentoService"],
            _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_16__["UsuarioService"],
            _core_services_shared_service__WEBPACK_IMPORTED_MODULE_15__["SharedService"],
            _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_6__["AuthGuard"],
            src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_4__["LancamentoService"]])
    ], PacoteListComponent);
    return PacoteListComponent;
}(src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_5__["Pagination"]));



/***/ }),

/***/ "./src/app/components/pacote/pacote-routing.module.ts":
/*!************************************************************!*\
  !*** ./src/app/components/pacote/pacote-routing.module.ts ***!
  \************************************************************/
/*! exports provided: PacoteRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacoteRoutingModule", function() { return PacoteRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _form_pacote_form_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./form/pacote-form.component */ "./src/app/components/pacote/form/pacote-form.component.ts");
/* harmony import */ var _list_pacote_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./list/pacote-list.component */ "./src/app/components/pacote/list/pacote-list.component.ts");





var routes = [
    {
        path: '',
        component: _list_pacote_list_component__WEBPACK_IMPORTED_MODULE_4__["PacoteListComponent"]
    },
    {
        path: 'incluir',
        component: _form_pacote_form_component__WEBPACK_IMPORTED_MODULE_3__["PacoteFormComponent"]
    },
    {
        path: 'alterar/:id',
        component: _form_pacote_form_component__WEBPACK_IMPORTED_MODULE_3__["PacoteFormComponent"]
    }
];
var PacoteRoutingModule = /** @class */ (function () {
    function PacoteRoutingModule() {
    }
    PacoteRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], PacoteRoutingModule);
    return PacoteRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/pacote/pacote.module.ts":
/*!****************************************************!*\
  !*** ./src/app/components/pacote/pacote.module.ts ***!
  \****************************************************/
/*! exports provided: PacoteModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacoteModule", function() { return PacoteModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _form_pacote_form_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./form/pacote-form.component */ "./src/app/components/pacote/form/pacote-form.component.ts");
/* harmony import */ var _list_pacote_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./list/pacote-list.component */ "./src/app/components/pacote/list/pacote-list.component.ts");
/* harmony import */ var _pacote_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pacote-routing.module */ "./src/app/components/pacote/pacote-routing.module.ts");








var PacoteModule = /** @class */ (function () {
    function PacoteModule() {
    }
    PacoteModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _list_pacote_list_component__WEBPACK_IMPORTED_MODULE_6__["PacoteListComponent"],
                _form_pacote_form_component__WEBPACK_IMPORTED_MODULE_5__["PacoteFormComponent"]
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"],
                _pacote_routing_module__WEBPACK_IMPORTED_MODULE_7__["PacoteRoutingModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"]
            ]
        })
    ], PacoteModule);
    return PacoteModule;
}());



/***/ })

}]);
//# sourceMappingURL=components-pacote-pacote-module.js.map