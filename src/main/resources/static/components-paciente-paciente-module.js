(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-paciente-paciente-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/form/paciente-form.component.html":
/*!*************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/form/paciente-form.component.html ***!
  \*************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>{{ form.controls.id.value ? 'Editar' : 'Cadastar' }} Paciente</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados Pessoais</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"nomeCompleto\">Nome Completo</label>\r\n                  <input id=\"nomeCompleto\" trim=\"blur\" maxlength=\"200\" type=\"text\" formControlName=\"nomeCompleto\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('nomeCompleto')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"dataNascimento\">Data de Nascimento</label>\r\n                  <input id=\"dataNascimento\" [validation]=\"false\" mask=\"00/00/0000\" type=\"text\"\r\n                    formControlName=\"dataNascimento\" class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('dataNascimento')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"sexo\">Sexo</label>\r\n                  <ng-select id=\"sexo\" maxlength=\"50\" formControlName=\"sexoId\" [items]=\"sexos\" bindLabel=\"descricao\"\r\n                    bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('sexoId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cpf\">CPF</label>\r\n                  <input id=\"cpf\" [validation]=\"false\" mask=\"000.000.000-00\" type=\"text\" formControlName=\"cpf\"\r\n                    class=\"form-control\" [readonly]=\"isCpfReadonly\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"rg\">RG</label>\r\n                  <input id=\"rg\" [validation]=\"false\" upperCase mask=\"A{15}\" type=\"text\" formControlName=\"rg\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"profissao\">Profissão</label>\r\n                  <ng-select id=\"profissao\" maxlength=\"50\" formControlName=\"profissaoId\" [items]=\"profissoes\"\r\n                    bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados do Endereço</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cep\">CEP</label>\r\n                  <input id=\"cep\" type=\"text\" [validation]=\"false\" mask=\"00.000-000\" formControlName=\"enderecoCep\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoCep')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"logradouro\">Logradouro</label>\r\n                  <input id=\"logradouro\" trim=\"blur\" type=\"text\" maxlength=\"200\" formControlName=\"enderecoLogradouro\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLogradouro')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"numero\">Número</label>\r\n                  <input id=\"numero\" type=\"text\" mask=\"0{10}\" [validation]=\"false\" formControlName=\"enderecoNumero\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoNumero')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"complemento\">Complemento</label>\r\n                  <input id=\"complemento\" trim=\"blur\" type=\"text\" maxlength=\"200\" formControlName=\"enderecoComplemento\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"bairro\">Bairro</label>\r\n                  <input id=\"bairro\" trim=\"blur\" type=\"text\" maxlength=\"100\" formControlName=\"enderecoBairro\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoBairro')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"pontoReferencia\">Ponto de Referência</label>\r\n                  <input id=\"pontoReferencia\" trim=\"blur\" type=\"text\" maxlength=\"200\"\r\n                    formControlName=\"enderecoPontoReferencia\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"uf\">Estado</label>\r\n                  <ng-select id=\"uf\" maxlength=\"50\" formControlName=\"enderecoLocalidadeUFId\" (change)=\"onChangeUf(true)\"\r\n                    [items]=\"ufs\" bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLocalidadeUFId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"localidade\">Cidade</label>\r\n                  <ng-select id=\"localidade\" (click)=\"onClickLocalidade()\" maxlength=\"50\"\r\n                    formControlName=\"enderecoLocalidadeId\" [items]=\"localidades\" bindLabel=\"descricao\" bindValue=\"id\"\r\n                    placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLocalidadeId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados do Contato</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celular\">Nº Tel. Celular</label>\r\n                  <input id=\"celular\" [validation]=\"false\" mask=\"(00) 00000-0000\" type=\"text\"\r\n                    formControlName=\"contatoCelular\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celularRecado\">Nº Tel. Cel. Recado</label>\r\n                  <input id=\"celularRecado\" [validation]=\"false\" mask=\"(00) 00000-0000\" type=\"text\"\r\n                    formControlName=\"contatoCelularRecado\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"residencial\">Nº Tel. Residencial</label>\r\n                  <input id=\"residencial\" [validation]=\"false\" mask=\"(00) 0000-0000\" type=\"text\"\r\n                    formControlName=\"contatoResidencial\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"comercial\">Nº Tel. Comercial</label>\r\n                  <input id=\"comercial\" [validation]=\"false\" mask=\"(00) 0000-0000\" type=\"text\"\r\n                    formControlName=\"contatoComercial\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"email\">E-mail</label>\r\n                  <input id=\"email\" trim=\"blur\" type=\"text\" maxlength=\"100\" formControlName=\"contatoEmail\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-footer\">\r\n            <button class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\" (click)=\"onClickFormSubmit()\"><em\r\n                class=\"fa fa-save\"></em>&nbsp;Salvar</button>\r\n            <button class=\"btn btn-danger pull-right\" (click)=\"onClickCancelar()\"><em\r\n                class=\"fa fa-ban\"></em>&nbsp;Cancelar</button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/list/paciente-list.component.html":
/*!*************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/list/paciente-list.component.html ***!
  \*************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Buscar Pacientes</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <div class=\"row\">\r\n    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Filtros</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <form [formGroup]=\"form\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cpf\">CPF</label>\r\n                  <input type=\"text\" [validation]=\"false\" class=\"form-control\" formControlName=\"cpf\" id=\"cpf\"\r\n                    mask=\"000.000.000-00\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"nome\">Nome Completo</label>\r\n                  <input type=\"text\" trim=\"blur\" class=\"form-control\" maxlength=\"200\" id=\"nome\"\r\n                    formControlName=\"nomeCompleto\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"sexo\">Sexo</label>\r\n                  <ng-select id=\"sexo\" maxlength=\"50\" formControlName=\"sexoId\" [items]=\"sexos\" bindLabel=\"descricao\"\r\n                    bindValue=\"id\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"status\">Status</label>\r\n                  <ng-select id=\"status\" maxlength=\"50\" formControlName=\"ativo\">\r\n                    <ng-option [value]=true>Ativo</ng-option>\r\n                    <ng-option [value]=false>Inativo</ng-option>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celular\">Nº Tel. Celular</label>\r\n                  <input type=\"text\" [validation]=\"false\" class=\"form-control\" id=\"celular\" formControlName=\"celular\"\r\n                    mask=\"(00) 00000-0000\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celularRecado\">Nº Tel. Celular Recado</label>\r\n                  <input type=\"text\" [validation]=\"false\" class=\"form-control\" id=\"celularRecado\"\r\n                    formControlName=\"celularRecado\" mask=\"(00) 00000-0000\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"residencial\">Nº Tel. Residencial</label>\r\n                  <input type=\"text\" [validation]=\"false\" class=\"form-control\" id=\"residencial\"\r\n                    formControlName=\"residencial\" mask=\"(00) 0000-0000\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"comercial\">Nº Tel. Comercial</label>\r\n                  <input type=\"text\" [validation]=\"false\" class=\"form-control\" id=\"comercial\"\r\n                    formControlName=\"comercial\" mask=\"(00) 0000-0000\">\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"uf\">Estado</label>\r\n                  <ng-select id=\"uf\" maxlength=\"50\" (change)=\"onChangeUf(true)\" formControlName=\"ufId\" [items]=\"ufs\"\r\n                    bindLabel=\"descricao\" bindValue=\"id\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"localidade\">Cidade</label>\r\n                  <ng-select id=\"localidade\" maxlength=\"50\" formControlName=\"localidadeId\" [items]=\"localidades\"\r\n                    bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Todas\" (click)=\"onClickLocalidade()\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n        <div class=\"box-footer\">\r\n          <button (click)=\"onClickFormSubmit()\" class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\"><em\r\n              class=\"fa fa-search\"></em>&nbsp;Buscar</button>\r\n          <button class=\"btn btn-warning pull-right\" (click)=\"onClickLimparCampos()\"><em\r\n              class=\"fa fa-eraser\"></em>&nbsp;Limpar</button>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"dados?.content?.length > 0\" class=\"col-md-12\" style=\"padding: 0px\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                <h3 class=\"box-title\">Resultado</h3>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"table-roll\">\r\n              <table id=\"example2\" class=\"table table-bordered table-hover\">\r\n                <thead>\r\n                  <tr>\r\n                    <th>Opções</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('nomeCompleto')\"><em\r\n                        [class]=\"getIconOrderBy('nomeCompleto')\"></em>&nbsp;Nome Completo</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('cpf')\"><em\r\n                        [class]=\"getIconOrderBy('cpf')\"></em>&nbsp;CPF</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('dataNascimento')\"><em\r\n                        [class]=\"getIconOrderBy('dataNascimento')\"></em>&nbsp;Data de Nascimento</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('dataNascimento')\"><em\r\n                        [class]=\"getIconOrderBy('dataNascimento')\"></em>&nbsp;Idade</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('sexo.descricao')\"><em\r\n                        [class]=\"getIconOrderBy('sexo.descricao')\"></em>&nbsp;Sexo</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('ativo')\"><em\r\n                        [class]=\"getIconOrderBy('ativo')\"></em>&nbsp;Status</th>\r\n                  </tr>\r\n                </thead>\r\n                <tbody>\r\n                  <tr *ngFor=\"let paciente of dados.content\">\r\n                    <td>\r\n                      <button title=\"{{ paciente.ativo ? 'Inativar' : 'Ativar' }}\"\r\n                        (click)=\"onClickUpdateStatus(paciente)\"\r\n                        class=\"btn btn-{{ paciente.ativo ? 'danger' : 'success' }}\"><em\r\n                          class=\"fa fa-{{ paciente.ativo ? 'ban' : 'check' }}\"></em></button>\r\n                      <button title=\"Visualizar\" (click)=\"onClickOpenModalVisualizar(paciente)\"\r\n                        class=\"btn btn-primary btn-left\"><em class=\"fa fa-eye\"></em></button>\r\n                      <button title=\"Editar\" [routerLink]=\"['/paciente/alterar', paciente.id]\"\r\n                        class=\"btn btn-primary btn-left\"><em class=\"fa fa-pencil\"></em></button>\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.nomeCompleto }}\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.cpf | cpf }}\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.dataNascimento | date: 'dd/MM/yyyy' }}\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.dataNascimento | idade }}\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.sexoDescricao }}\r\n                    </td>\r\n                    <td>\r\n                      {{ paciente.ativo ? 'Ativo' : 'Inativo' }}\r\n                    </td>\r\n                  </tr>\r\n                </tbody>\r\n              </table>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-footer\">\r\n            <app-page-action [dados]=\"dados\" [filtro]=\"filtro\" (searchByFilter)=\"searchByFilter()\">\r\n            </app-page-action>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <app-no-records *ngIf=\"showNoRecords && !dados.content?.length\"></app-no-records>\r\n    </div>\r\n  </div>\r\n</section>");

/***/ }),

/***/ "./src/app/components/paciente/form/paciente-form.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/components/paciente/form/paciente-form.component.ts ***!
  \*********************************************************************/
/*! exports provided: PacienteFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteFormComponent", function() { return PacienteFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../core/services/localidade.service */ "./src/app/core/services/localidade.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../core/services/profissao.service */ "./src/app/core/services/profissao.service.ts");
/* harmony import */ var _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/services/sexo.service */ "./src/app/core/services/sexo.service.ts");
/* harmony import */ var _core_services_uf_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/services/uf.service */ "./src/app/core/services/uf.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var _shared_util_util__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../shared/util/util */ "./src/app/shared/util/util.ts");












var PacienteFormComponent = /** @class */ (function () {
    function PacienteFormComponent(router, route, localidadeService, ufService, service, profissaoService, sexoService, formBuilder, messageService) {
        var _this = this;
        this.router = router;
        this.route = route;
        this.localidadeService = localidadeService;
        this.ufService = ufService;
        this.service = service;
        this.profissaoService = profissaoService;
        this.sexoService = sexoService;
        this.formBuilder = formBuilder;
        this.messageService = messageService;
        this.sexos = new Array();
        this.profissoes = new Array();
        this.localidades = new Array();
        this.ufs = new Array();
        this.isInvalidForm = false;
        this.isCpfReadonly = false;
        this.subscription = this.profissaoService.getProfissao().subscribe(function () {
            _this.profissaoService.findAll().subscribe(function (response) {
                _this.profissoes = response.result;
            });
        });
        this.subscription = this.ufService.getUF().subscribe(function () {
            _this.ufService.findAll().subscribe(function (response) {
                _this.ufs = response.result;
            });
        });
        this.subscription = this.localidadeService.getLocalidade().subscribe(function () {
            _this.onChangeUf();
        });
    }
    PacienteFormComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCombos();
        this.loadDataPage();
    };
    PacienteFormComponent.prototype.ngOnDestroy = function () {
        this.subscription.unsubscribe();
    };
    PacienteFormComponent.prototype.onLoadCombos = function () {
        this.onLoadComboProfissao();
        this.onLoadComboUF();
        this.onLoadComboSexo();
    };
    PacienteFormComponent.prototype.onLoadComboProfissao = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.profissoes = response.resolve.profissoes.result;
        });
    };
    PacienteFormComponent.prototype.onLoadComboSexo = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.sexos = response.resolve.sexos.result;
        });
    };
    PacienteFormComponent.prototype.onLoadComboUF = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.ufs = response.resolve.ufs.result;
        });
    };
    PacienteFormComponent.prototype.onLoadComboLocalidade = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.localidades = response.resolve.localidades.result;
        });
    };
    PacienteFormComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            id: [null],
            nomeCompleto: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            dataNascimento: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            rg: [null],
            cpf: [null],
            sexoId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            profissaoId: [null],
            enderecoId: [null],
            enderecoCep: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            enderecoLogradouro: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            enderecoNumero: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            enderecoComplemento: [null],
            enderecoBairro: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            enderecoPontoReferencia: [null],
            enderecoLocalidadeId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            enderecoLocalidadeUFId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            contatoId: [null],
            contatoCelular: [null],
            contatoCelularRecado: [null],
            contatoResidencial: [null],
            contatoComercial: [null],
            contatoEmail: [null],
        });
    };
    PacienteFormComponent.prototype.onClickLocalidade = function () {
        this.messageService.clearAllMessages();
        if (!this.form.controls.enderecoLocalidadeUFId.value) {
            this.messageService.sendMessageWarning(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__["Messages"].MSG0010);
        }
    };
    PacienteFormComponent.prototype.onChangeUf = function (isClearAllMessages) {
        var _this = this;
        if (isClearAllMessages) {
            this.messageService.clearAllMessages();
        }
        var id = this.form.controls.enderecoLocalidadeUFId.value;
        if (id) {
            this.localidadeService.findByUfId(id).subscribe(function (response) {
                _this.localidades = response.result;
                if (_this.form.value.enderecoLocalidadeId && !_this.localidades.find(function (x) { return x.id === _this.form.value.enderecoLocalidadeId; })) {
                    _this.form.controls.enderecoLocalidadeId.setValue(null);
                }
            });
        }
        else {
            this.localidades = new Array();
            this.form.controls.enderecoLocalidadeId.setValue(null);
        }
    };
    PacienteFormComponent.prototype.onClickFormSubmit = function () {
        var _this = this;
        this.messageService.clearAllMessages();
        if (this.form.valid) {
            var dataNascimento = this.form.value.dataNascimento;
            if (dataNascimento && !_shared_util_util__WEBPACK_IMPORTED_MODULE_11__["default"].isDataValida(dataNascimento)) {
                this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__["Messages"].MSG0018);
                return;
            }
            var formValue = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { dataNascimento: _shared_util_util__WEBPACK_IMPORTED_MODULE_11__["default"].convertStringToDate(this.form.value.dataNascimento) });
            if (formValue.id) {
                this.service.update(formValue.id, formValue).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.router.navigate(['/paciente']);
                });
            }
            else {
                this.service.create(formValue).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.router.navigate(['/paciente']);
                });
            }
        }
        else {
            this.isInvalidForm = true;
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__["Messages"].MSG0004);
        }
    };
    PacienteFormComponent.prototype.loadDataPage = function () {
        var _this = this;
        this.route.data.subscribe(function (dados) {
            var response = dados.resolve.paciente;
            if (!response.result) {
                return;
            }
            _this.form.setValue({
                id: response.result.id,
                nomeCompleto: response.result.nomeCompleto,
                dataNascimento: _shared_util_util__WEBPACK_IMPORTED_MODULE_11__["default"].convertDateToString(response.result.dataNascimento),
                rg: response.result.rg || null,
                cpf: response.result.cpf || null,
                sexoId: response.result.sexoId,
                profissaoId: response.result.profissaoId || null,
                enderecoId: response.result.enderecoId,
                enderecoCep: response.result.enderecoCep,
                enderecoLogradouro: response.result.enderecoLogradouro,
                enderecoNumero: response.result.enderecoNumero,
                enderecoComplemento: response.result.enderecoComplemento || null,
                enderecoBairro: response.result.enderecoBairro,
                enderecoPontoReferencia: response.result.enderecoPontoReferencia || null,
                enderecoLocalidadeId: response.result.enderecoLocalidadeId,
                enderecoLocalidadeUFId: response.result.enderecoLocalidadeUFId,
                contatoId: response.result.contatoId || null,
                contatoCelular: response.result.contatoCelular || null,
                contatoCelularRecado: response.result.contatoCelularRecado || null,
                contatoResidencial: response.result.contatoResidencial || null,
                contatoComercial: response.result.contatoComercial || null,
                contatoEmail: response.result.contatoEmail || null,
            });
            _this.onLoadComboLocalidade();
            _this.isCpfReadonly = response.result.cpf ? true : false;
        });
    };
    PacienteFormComponent.prototype.onClickCancelar = function () {
        this.messageService.clearAllMessages();
        window.history.back();
    };
    PacienteFormComponent.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] },
        { type: _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_4__["LocalidadeService"] },
        { type: _core_services_uf_service__WEBPACK_IMPORTED_MODULE_9__["UfService"] },
        { type: _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_6__["PacienteService"] },
        { type: _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_7__["ProfissaoService"] },
        { type: _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_8__["SexoService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_5__["MessageService"] }
    ]; };
    PacienteFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-paciente-form',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./paciente-form.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/form/paciente-form.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_4__["LocalidadeService"],
            _core_services_uf_service__WEBPACK_IMPORTED_MODULE_9__["UfService"],
            _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_6__["PacienteService"],
            _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_7__["ProfissaoService"],
            _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_8__["SexoService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_5__["MessageService"]])
    ], PacienteFormComponent);
    return PacienteFormComponent;
}());



/***/ }),

/***/ "./src/app/components/paciente/list/paciente-list.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/components/paciente/list/paciente-list.component.ts ***!
  \*********************************************************************/
/*! exports provided: PacienteListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteListComponent", function() { return PacienteListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/components/pagination/pagination */ "./src/app/shared/components/pagination/pagination.ts");
/* harmony import */ var _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../core/model/filter/filter.filter */ "./src/app/core/model/filter/filter.filter.ts");
/* harmony import */ var _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../core/model/model/page.model */ "./src/app/core/model/model/page.model.ts");
/* harmony import */ var _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../core/services/localidade.service */ "./src/app/core/services/localidade.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../core/services/sexo.service */ "./src/app/core/services/sexo.service.ts");
/* harmony import */ var _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../core/services/uf.service */ "./src/app/core/services/uf.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var _shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../shared/modais/modal-confirmacao/modal-confirmacao.component */ "./src/app/shared/modais/modal-confirmacao/modal-confirmacao.component.ts");
/* harmony import */ var _shared_modais_modal_visualizar_paciente_usuario_modal_visualizar_paciente_usuario_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../shared/modais/modal-visualizar-paciente-usuario/modal-visualizar-paciente-usuario.component */ "./src/app/shared/modais/modal-visualizar-paciente-usuario/modal-visualizar-paciente-usuario.component.ts");















var PacienteListComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PacienteListComponent, _super);
    function PacienteListComponent(modalService, service, sexoService, localidadeService, ufService, formBuilder, messageService) {
        var _this = _super.call(this, messageService) || this;
        _this.modalService = modalService;
        _this.service = service;
        _this.sexoService = sexoService;
        _this.localidadeService = localidadeService;
        _this.ufService = ufService;
        _this.formBuilder = formBuilder;
        _this.sexos = new Array();
        _this.localidades = new Array();
        _this.ufs = new Array();
        _this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_6__["default"]();
        _this.showNoRecords = false;
        _this.subscription = _this.ufService.getUF().subscribe(function () {
            _this.onLoadComboUF();
        });
        _this.subscription = _this.localidadeService.getLocalidade().subscribe(function () {
            _this.onChangeUf();
        });
        return _this;
    }
    PacienteListComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCombos();
    };
    PacienteListComponent.prototype.ngOnDestroy = function () {
        this.subscription.unsubscribe();
    };
    PacienteListComponent.prototype.onLoadCombos = function () {
        this.onLoadSexo();
        this.onLoadComboUF();
    };
    PacienteListComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            cpf: [null],
            nomeCompleto: [null],
            sexoId: [null],
            localidadeId: [null],
            ufId: [null],
            celular: [null],
            celularRecado: [null],
            residencial: [null],
            comercial: [null],
            ativo: [null],
        });
    };
    PacienteListComponent.prototype.onLoadSexo = function () {
        var _this = this;
        this.sexoService.findAll().subscribe(function (response) {
            _this.sexos = response.result;
        });
    };
    PacienteListComponent.prototype.onLoadComboUF = function () {
        var _this = this;
        this.ufService.findAll().subscribe(function (response) {
            _this.ufs = response.result;
        });
    };
    PacienteListComponent.prototype.onClickLocalidade = function () {
        this.messageService.clearAllMessages();
        if (!this.form.controls.ufId.value) {
            this.messageService.sendMessageWarning(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_12__["Messages"].MSG0010);
        }
    };
    PacienteListComponent.prototype.onChangeUf = function (isclearAllMessages) {
        var _this = this;
        if (isclearAllMessages) {
            this.messageService.clearAllMessages();
        }
        var id = this.form.controls.ufId.value;
        if (id) {
            this.localidadeService.findByUfId(id).subscribe(function (response) {
                _this.localidades = response.result;
                if (_this.form.value.localidadeId && !_this.localidades.find(function (x) { return x.id === _this.form.value.localidadeId; })) {
                    _this.form.controls.localidadeId.setValue(null);
                }
            });
        }
        else {
            this.localidades = new Array();
            this.form.controls.localidadeId.setValue(null);
        }
    };
    PacienteListComponent.prototype.onClickFormSubmit = function () {
        this.messageService.clearAllMessages();
        this.filtro = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.filtro, { orderBy: 'nomeCompleto', direction: 'ASC', filter: tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value) });
        this.searchByFilter();
    };
    PacienteListComponent.prototype.searchByFilter = function () {
        var _this = this;
        this.service.findByFilter(this.filtro).subscribe(function (response) {
            _this.showNoRecords = true;
            _this.dados = response.result;
        });
    };
    PacienteListComponent.prototype.onClickLimparCampos = function () {
        this.messageService.clearAllMessages();
        this.onCreateForm();
        this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_6__["default"]();
        this.filtro = new _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_5__["PageableFilter"]();
        this.showNoRecords = false;
    };
    PacienteListComponent.prototype.onClickUpdateStatus = function (paciente) {
        var _this = this;
        this.messageService.clearAllMessages();
        var modalRef = this.modalService.show(_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_13__["ModalConfirmacaoComponent"], { backdrop: 'static' });
        var status = paciente.ativo ? 'desativar' : 'ativar';
        var sexo = paciente.sexoId === 1 ? 'o' : 'a';
        modalRef.content.titulo = 'Confirmação de Alteração de Status';
        modalRef.content.corpo = "Deseja " + status + " " + sexo + " paciente " + paciente.nomeCompleto + "?";
        modalRef.content.onClose.subscribe(function (result) {
            if (result) {
                _this.service.activeOrInative(paciente.id).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.searchByFilter();
                });
            }
        });
    };
    PacienteListComponent.prototype.onClickOpenModalVisualizar = function (paciente) {
        this.messageService.clearAllMessages();
        var initialState = {
            dados: paciente
        };
        this.modalService.show(_shared_modais_modal_visualizar_paciente_usuario_modal_visualizar_paciente_usuario_component__WEBPACK_IMPORTED_MODULE_14__["ModalVisualizarPacienteUsuarioComponent"], { initialState: initialState, backdrop: 'static', class: 'gray modal-lg' });
    };
    PacienteListComponent.ctorParameters = function () { return [
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"] },
        { type: _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_9__["PacienteService"] },
        { type: _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_10__["SexoService"] },
        { type: _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_7__["LocalidadeService"] },
        { type: _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__["UfService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_8__["MessageService"] }
    ]; };
    PacienteListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-paciente-list',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./paciente-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/paciente/list/paciente-list.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"],
            _core_services_paciente_service__WEBPACK_IMPORTED_MODULE_9__["PacienteService"],
            _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_10__["SexoService"],
            _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_7__["LocalidadeService"],
            _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__["UfService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_8__["MessageService"]])
    ], PacienteListComponent);
    return PacienteListComponent;
}(src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_4__["Pagination"]));



/***/ }),

/***/ "./src/app/components/paciente/paciente-routing.module.ts":
/*!****************************************************************!*\
  !*** ./src/app/components/paciente/paciente-routing.module.ts ***!
  \****************************************************************/
/*! exports provided: PacienteRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteRoutingModule", function() { return PacienteRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _form_paciente_form_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./form/paciente-form.component */ "./src/app/components/paciente/form/paciente-form.component.ts");
/* harmony import */ var _list_paciente_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./list/paciente-list.component */ "./src/app/components/paciente/list/paciente-list.component.ts");
/* harmony import */ var _resolver_paciente_form_resolver__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./resolver/paciente-form.resolver */ "./src/app/components/paciente/resolver/paciente-form.resolver.ts");






var routes = [
    {
        path: '',
        component: _list_paciente_list_component__WEBPACK_IMPORTED_MODULE_4__["PacienteListComponent"]
    },
    {
        path: 'incluir',
        component: _form_paciente_form_component__WEBPACK_IMPORTED_MODULE_3__["PacienteFormComponent"],
        resolve: {
            resolve: _resolver_paciente_form_resolver__WEBPACK_IMPORTED_MODULE_5__["PacienteFormResolver"]
        }
    },
    {
        path: 'alterar/:id',
        component: _form_paciente_form_component__WEBPACK_IMPORTED_MODULE_3__["PacienteFormComponent"],
        resolve: {
            resolve: _resolver_paciente_form_resolver__WEBPACK_IMPORTED_MODULE_5__["PacienteFormResolver"]
        }
    }
];
var PacienteRoutingModule = /** @class */ (function () {
    function PacienteRoutingModule() {
    }
    PacienteRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
            providers: [_resolver_paciente_form_resolver__WEBPACK_IMPORTED_MODULE_5__["PacienteFormResolver"]]
        })
    ], PacienteRoutingModule);
    return PacienteRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/paciente/paciente.module.ts":
/*!********************************************************!*\
  !*** ./src/app/components/paciente/paciente.module.ts ***!
  \********************************************************/
/*! exports provided: PacienteModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteModule", function() { return PacienteModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _form_paciente_form_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./form/paciente-form.component */ "./src/app/components/paciente/form/paciente-form.component.ts");
/* harmony import */ var _list_paciente_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./list/paciente-list.component */ "./src/app/components/paciente/list/paciente-list.component.ts");
/* harmony import */ var _paciente_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./paciente-routing.module */ "./src/app/components/paciente/paciente-routing.module.ts");








var PacienteModule = /** @class */ (function () {
    function PacienteModule() {
    }
    PacienteModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _list_paciente_list_component__WEBPACK_IMPORTED_MODULE_6__["PacienteListComponent"],
                _form_paciente_form_component__WEBPACK_IMPORTED_MODULE_5__["PacienteFormComponent"]
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"],
                _paciente_routing_module__WEBPACK_IMPORTED_MODULE_7__["PacienteRoutingModule"]
            ]
        })
    ], PacienteModule);
    return PacienteModule;
}());



/***/ }),

/***/ "./src/app/components/paciente/resolver/paciente-form.resolver.ts":
/*!************************************************************************!*\
  !*** ./src/app/components/paciente/resolver/paciente-form.resolver.ts ***!
  \************************************************************************/
/*! exports provided: PacienteFormResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteFormResolver", function() { return PacienteFormResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_core_model_model_response_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/core/model/model/response.model */ "./src/app/core/model/model/response.model.ts");
/* harmony import */ var src_app_core_services_localidade_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/localidade.service */ "./src/app/core/services/localidade.service.ts");
/* harmony import */ var src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/profissao.service */ "./src/app/core/services/profissao.service.ts");
/* harmony import */ var src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/services/sexo.service */ "./src/app/core/services/sexo.service.ts");
/* harmony import */ var src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/services/uf.service */ "./src/app/core/services/uf.service.ts");








var PacienteFormResolver = /** @class */ (function () {
    function PacienteFormResolver(pacienteService, sexoService, profissaoService, ufService, localidadeService) {
        this.pacienteService = pacienteService;
        this.sexoService = sexoService;
        this.profissaoService = profissaoService;
        this.ufService = ufService;
        this.localidadeService = localidadeService;
    }
    PacienteFormResolver.prototype.resolve = function (route) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var id, paciente, localidades, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        id = +route.params.id;
                        paciente = new src_app_core_model_model_response_model__WEBPACK_IMPORTED_MODULE_2__["Response"]();
                        localidades = new src_app_core_model_model_response_model__WEBPACK_IMPORTED_MODULE_2__["Response"]();
                        if (!id) return [3 /*break*/, 5];
                        return [4 /*yield*/, this.pacienteService.findById(id).toPromise()];
                    case 1: return [4 /*yield*/, (_b.sent())];
                    case 2:
                        paciente = _b.sent();
                        return [4 /*yield*/, this.localidadeService.findByUfId(paciente.result.enderecoLocalidadeUFId).toPromise()];
                    case 3: return [4 /*yield*/, (_b.sent())];
                    case 4:
                        localidades = _b.sent();
                        _b.label = 5;
                    case 5:
                        _a = {
                            paciente: paciente
                        };
                        return [4 /*yield*/, this.sexoService.findAll().toPromise()];
                    case 6:
                        _a.sexos = _b.sent();
                        return [4 /*yield*/, this.profissaoService.findAll().toPromise()];
                    case 7:
                        _a.profissoes = _b.sent();
                        return [4 /*yield*/, this.ufService.findAll().toPromise()];
                    case 8: return [2 /*return*/, (_a.ufs = _b.sent(),
                            _a.localidades = localidades,
                            _a)];
                }
            });
        });
    };
    PacienteFormResolver.ctorParameters = function () { return [
        { type: src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"] },
        { type: src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_6__["SexoService"] },
        { type: src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_5__["ProfissaoService"] },
        { type: src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_7__["UfService"] },
        { type: src_app_core_services_localidade_service__WEBPACK_IMPORTED_MODULE_3__["LocalidadeService"] }
    ]; };
    PacienteFormResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"],
            src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_6__["SexoService"],
            src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_5__["ProfissaoService"],
            src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_7__["UfService"],
            src_app_core_services_localidade_service__WEBPACK_IMPORTED_MODULE_3__["LocalidadeService"]])
    ], PacienteFormResolver);
    return PacienteFormResolver;
}());



/***/ })

}]);
//# sourceMappingURL=components-paciente-paciente-module.js.map