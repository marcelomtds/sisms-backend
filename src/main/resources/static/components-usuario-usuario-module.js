(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-usuario-usuario-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/form/usuario-form.component.html":
/*!***********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/form/usuario-form.component.html ***!
  \***********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>{{ isCadastroCompleto ? 'Editar' : 'Completar Cadastro' }}</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Imagem do Perfil</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-6\">\r\n                <div *ngIf=\"form.controls.imagem.value\" class=\"form-group\" style=\"text-align: end;\">\r\n                  <button title=\"Remover Imagem\" class=\"btn btn-danger\" type=\"button\" (click)=\"onClickRemoveImage()\"><em\r\n                      class=\"fa fa-close\"></em></button>\r\n                </div>\r\n                <div class=\"form-group\">\r\n                  <img src=\"{{ form.value.imagem || '../../../../assets/img/sem-foto.jpg' }}\" width=\"100%\" height=\"100%\"\r\n                    class=\"user-image\" alt=\"Foto de Perfil\">\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                <div class=\"form-group fileUpload btn btn-primary\">\r\n                  <span><em class=\"fa fa-search\"></em>&nbsp;Procurar imagem</span>\r\n                  <input title=\"\" #inputImage id=\"imagem\" type=\"file\" class=\"upload\"\r\n                    (change)=\"onChangeImage($event.target.files[0])\" (click)=\"inputImage.value=null\" />\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados Pessoais</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"nomeCompleto\">Nome Completo</label>\r\n                  <input id=\"nomeCompleto\" trim=\"blur\" maxlength=\"200\" type=\"text\" formControlName=\"nomeCompleto\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('nomeCompleto')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"dataNascimento\">Data de Nascimento</label>\r\n                  <input id=\"dataNascimento\" [validation]=\"false\" mask=\"00/00/0000\" type=\"text\"\r\n                    formControlName=\"dataNascimento\" class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('dataNascimento')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"sexo\">Sexo</label>\r\n                  <ng-select id=\"sexo\" maxlength=\"50\" formControlName=\"sexoId\" [items]=\"sexos\" bindLabel=\"descricao\"\r\n                    bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('sexoId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cpf\">CPF</label>\r\n                  <input id=\"cpf\" [validation]=\"false\" mask=\"000.000.000-00\" type=\"text\" formControlName=\"cpf\"\r\n                    class=\"form-control\" [readonly]=\"form.controls.id.value && form.controls.cpf.value\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('cpf')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"rg\">RG</label>\r\n                  <input id=\"rg\" [validation]=\"false\" upperCase mask=\"A{15}\" type=\"text\" formControlName=\"rg\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"profissao\">Profissão</label>\r\n                  <ng-select id=\"profissao\" maxlength=\"50\" formControlName=\"profissaoId\" [items]=\"profissoes\"\r\n                    bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('profissaoId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div *ngIf=\"!isCadastroCompleto\" class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Credenciais do Acesso</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"senha\">Senha</label>\r\n                  <div class=\"input-group\">\r\n                    <input id=\"senha\" maxlength=\"20\" type=\"{{ isShowSenha ? 'text' : 'password' }}\"\r\n                      formControlName=\"senha\" class=\"form-control\" />\r\n                    <div style=\"cursor: pointer;\" class=\"input-group-addon\" (click)=\"showHidePassword('senha')\">\r\n                      <em class=\"{{ isShowSenha ? 'fa fa-eye-slash' : 'fa fa-eye' }}\"></em>\r\n                    </div>\r\n                  </div>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('senha')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"senhaConfirmacao\">Confirmar Senha</label>\r\n                  <div class=\"input-group\">\r\n                    <input id=\"senhaConfirmacao\" maxlength=\"20\"\r\n                      type=\"{{ isShowSenhaConfirmacao ? 'text' : 'password' }}\" formControlName=\"senhaConfirmacao\"\r\n                      class=\"form-control\" />\r\n                    <div style=\"cursor: pointer;\" class=\"input-group-addon\"\r\n                      (click)=\"showHidePassword('senhaConfirmacao')\">\r\n                      <em class=\"{{ isShowSenhaConfirmacao ? 'fa fa-eye-slash' : 'fa fa-eye'}}\"></em>\r\n                    </div>\r\n                  </div>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('senhaConfirmacao')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados do Endereço</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cep\">CEP</label>\r\n                  <input id=\"cep\" type=\"text\" [validation]=\"false\" mask=\"00.000-000\" formControlName=\"enderecoCep\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoCep')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"logradouro\">Logradouro</label>\r\n                  <input id=\"logradouro\" trim=\"blur\" type=\"text\" maxlength=\"200\" formControlName=\"enderecoLogradouro\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLogradouro')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"numero\">Número</label>\r\n                  <input id=\"numero\" type=\"text\" mask=\"0{10}\" [validation]=\"false\" formControlName=\"enderecoNumero\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoNumero')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"complemento\">Complemento</label>\r\n                  <input id=\"complemento\" trim=\"blur\" type=\"text\" maxlength=\"200\" formControlName=\"enderecoComplemento\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"bairro\">Bairro</label>\r\n                  <input id=\"bairro\" trim=\"blur\" type=\"text\" maxlength=\"100\" formControlName=\"enderecoBairro\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('enderecoBairro')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"pontoReferencia\">Ponto de Referência</label>\r\n                  <input id=\"pontoReferencia\" trim=\"blur\" type=\"text\" maxlength=\"200\"\r\n                    formControlName=\"enderecoPontoReferencia\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"uf\">Estado</label>\r\n                  <ng-select id=\"uf\" maxlength=\"50\" formControlName=\"enderecoLocalidadeUFId\" (change)=\"onChangeUf(true)\"\r\n                    [items]=\"ufs\" bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLocalidadeUFId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"localidade\">Cidade</label>\r\n                  <ng-select id=\"localidade\" (click)=\"onClickLocalidade()\" maxlength=\"50\"\r\n                    formControlName=\"enderecoLocalidadeId\" [items]=\"localidades\" bindLabel=\"descricao\" bindValue=\"id\"\r\n                    placeholder=\"Selecione\">\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('enderecoLocalidadeId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados do Contato</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celular\">Nº Tel. Celular</label>\r\n                  <input id=\"celular\" [validation]=\"false\" mask=\"(00) 00000-0000\" type=\"text\"\r\n                    formControlName=\"contatoCelular\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"celularRecado\">Nº Tel. Cel. Recado</label>\r\n                  <input id=\"celularRecado\" [validation]=\"false\" mask=\"(00) 00000-0000\" type=\"text\"\r\n                    formControlName=\"contatoCelularRecado\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"residencial\">Nº Tel. Residencial</label>\r\n                  <input id=\"residencial\" [validation]=\"false\" mask=\"(00) 0000-0000\" type=\"text\"\r\n                    formControlName=\"contatoResidencial\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"comercial\">Nº Tel. Comercial</label>\r\n                  <input id=\"comercial\" [validation]=\"false\" mask=\"(00) 0000-0000\" type=\"text\"\r\n                    formControlName=\"contatoComercial\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"email\">E-mail</label>\r\n                  <input id=\"email\" trim=\"blur\" type=\"text\" maxlength=\"100\" formControlName=\"contatoEmail\"\r\n                    class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-footer\">\r\n            <button class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\" (click)=\"onClickFormSubmit()\"><em\r\n                class=\"fa fa-save\"></em>&nbsp;Salvar</button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/list/usuario-list.component.html":
/*!***********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/list/usuario-list.component.html ***!
  \***********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Buscar Usuários</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <div class=\"row\">\r\n    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n      <div class=\"box box-primary\">\r\n        <div class=\"box-header with-border\">\r\n          <h3 class=\"box-title\">Filtros</h3>\r\n        </div>\r\n        <div class=\"box-body\">\r\n          <form [formGroup]=\"form\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4 form-group\">\r\n                <label for=\"nome\">Nome Completo</label>\r\n                <input type=\"text\" trim=\"blur\" class=\"form-control\" maxlength=\"200\" id=\"nome\"\r\n                  formControlName=\"nomeCompleto\">\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cpf\">CPF</label>\r\n                  <input type=\"text\" class=\"form-control\" [validation]=\"false\" formControlName=\"cpf\" id=\"cpf\"\r\n                    mask=\"000.000.000-00\">\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"sexo\">Sexo</label>\r\n                  <ng-select id=\"sexo\" maxlength=\"50\" formControlName=\"sexoId\" [items]=\"sexos\" bindLabel=\"descricao\"\r\n                    bindValue=\"id\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"status\">Status</label>\r\n                  <ng-select id=\"status\" maxlength=\"50\" formControlName=\"ativo\">\r\n                    <ng-option [value]=true>Ativo</ng-option>\r\n                    <ng-option [value]=false>Inativo</ng-option>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n        <div class=\"box-footer\">\r\n          <button (click)=\"onClickFormSubmit()\" class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\"><em\r\n              class=\"fa fa-search\"></em>&nbsp;Buscar</button>\r\n          <button class=\"btn btn-warning pull-right\" (click)=\"onClickLimparCampos()\"><em\r\n              class=\"fa fa-eraser\"></em>&nbsp;Limpar</button>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"dados?.content?.length > 0\" class=\"col-md-12\" style=\"padding: 0px\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                <h3 class=\"box-title\">Resultado</h3>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"table-roll\">\r\n              <table id=\"example2\" class=\"table table-bordered table-hover\">\r\n                <thead>\r\n                  <tr>\r\n                    <th>Opções</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('nomeCompleto')\"><em\r\n                        [class]=\"getIconOrderBy('nomeCompleto')\"></em>&nbsp;Nome Completo</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('cpf')\"><em\r\n                        [class]=\"getIconOrderBy('cpf')\"></em>&nbsp;CPF</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('dataNascimento')\"><em\r\n                        [class]=\"getIconOrderBy('dataNascimento')\"></em>&nbsp;Data de Nascimetno</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('perfil.descricao')\"><em\r\n                        [class]=\"getIconOrderBy('perfil.descricao')\"></em>&nbsp;Perfil</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('sexo.descricao')\"><em\r\n                        [class]=\"getIconOrderBy('sexo.descricao')\"></em>&nbsp;Sexo</th>\r\n                    <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('ativo')\"><em\r\n                        [class]=\"getIconOrderBy('ativo')\"></em>&nbsp;Status</th>\r\n                  </tr>\r\n                </thead>\r\n                <tbody>\r\n                  <tr *ngFor=\"let usuario of dados.content\">\r\n                    <td>\r\n                      <button title=\"{{ usuario.ativo ? 'Inativar' : 'Ativar' }}\"\r\n                        *ngIf=\"authGuardService.isPermitido(permissaoAdministrador) && usuario.id !== currentUser?.id\"\r\n                        (click)=\"onClickUpdateStatus(usuario)\"\r\n                        class=\"btn btn-{{ usuario.ativo ? 'danger' : 'success' }}\"><em\r\n                          class=\"fa fa-{{ usuario.ativo ? 'ban' : 'check' }}\"></em>\r\n                      </button>\r\n                      <button title=\"Visualizar\" *ngIf=\"authGuardService.isPermitido(permissaoAdministrador)\"\r\n                        (click)=\"onClickOpenModalVisualizar(usuario.id)\"\r\n                        class=\"btn btn-primary {{ usuario.id !== currentUser?.id ? 'btn-left' : '' }}\"><em\r\n                          class=\"fa fa-eye\"></em>\r\n                      </button>\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.nomeCompleto }}\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.cpf | cpf }}\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.dataNascimento | date: 'dd/MM/yyyy' }}\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.perfilDescricao }}\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.sexoDescricao }}\r\n                    </td>\r\n                    <td>\r\n                      {{ usuario.ativo ? 'Ativo' : 'Inativo' }}\r\n                    </td>\r\n                  </tr>\r\n                </tbody>\r\n              </table>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-footer\">\r\n            <app-page-action [dados]=\"dados\" [filtro]=\"filtro\" (searchByFilter)=\"searchByFilter()\">\r\n            </app-page-action>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <app-no-records *ngIf=\"showNoRecords && !dados.content?.length\"></app-no-records>\r\n    </div>\r\n  </div>\r\n</section>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/pre-cadastro/pre-cadastro.component.html":
/*!*******************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/pre-cadastro/pre-cadastro.component.html ***!
  \*******************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Pré-Cadastro</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Credenciais de Acesso</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"cpf\">CPF</label>\r\n                  <input id=\"cpf\" [validation]=\"false\" mask=\"000.000.000-00\" type=\"text\" formControlName=\"cpf\"\r\n                    class=\"form-control\" />\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('cpf')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"senha\">Senha</label>\r\n                  <div class=\"input-group\">\r\n                    <input id=\"senha\" maxlength=\"20\" type=\"{{ isShowSenha ? 'text' : 'password' }}\"\r\n                      formControlName=\"senha\" class=\"form-control\" />\r\n                    <div style=\"cursor: pointer;\" class=\"input-group-addon\" (click)=\"showHidePassword('senha')\">\r\n                      <em class=\"{{ isShowSenha ? 'fa fa-eye-slash' : 'fa fa-eye' }}\"></em>\r\n                    </div>\r\n                  </div>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\" [controlComponent]=\"form.get('senha')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"senhaConfirmacao\">Confirmar Senha</label>\r\n                  <div class=\"input-group\">\r\n                    <input id=\"senhaConfirmacao\" maxlength=\"20\"\r\n                      type=\"{{ isShowSenhaConfirmacao ? 'text' : 'password' }}\" formControlName=\"senhaConfirmacao\"\r\n                      class=\"form-control\" />\r\n                    <div style=\"cursor: pointer;\" class=\"input-group-addon\"\r\n                      (click)=\"showHidePassword('senhaConfirmacao')\">\r\n                      <em class=\"{{ isShowSenhaConfirmacao ? 'fa fa-eye-slash' : 'fa fa-eye' }}\"></em>\r\n                    </div>\r\n                  </div>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                    [controlComponent]=\"form.get('senhaConfirmacao')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-footer\">\r\n            <button class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\" (click)=\"onClickFormSubmit()\"><em\r\n                class=\"fa fa-save\"></em>&nbsp;Salvar</button>\r\n            <button class=\"btn btn-danger pull-right\" (click)=\"onClickCancelar()\"><em\r\n                class=\"fa fa-ban\"></em>&nbsp;Cancelar</button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>");

/***/ }),

/***/ "./src/app/components/usuario/form/usuario-form.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/components/usuario/form/usuario-form.component.ts ***!
  \*******************************************************************/
/*! exports provided: UsuarioFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioFormComponent", function() { return UsuarioFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_spinner__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-spinner */ "./node_modules/ngx-spinner/fesm5/ngx-spinner.js");
/* harmony import */ var resize_base64__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! resize-base64 */ "./node_modules/resize-base64/index.js");
/* harmony import */ var src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/services/menu.service */ "./src/app/core/services/menu.service.ts");
/* harmony import */ var src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/services/localidade.service */ "./src/app/core/services/localidade.service.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../core/services/profissao.service */ "./src/app/core/services/profissao.service.ts");
/* harmony import */ var _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../core/services/uf.service */ "./src/app/core/services/uf.service.ts");
/* harmony import */ var _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");
/* harmony import */ var _shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var _shared_util_util__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../shared/util/util */ "./src/app/shared/util/util.ts");















var UsuarioFormComponent = /** @class */ (function () {
    function UsuarioFormComponent(spinnerService, router, route, localidadeService, ufService, service, profissaoService, sharedService, formBuilder, messageService, menuService) {
        var _this = this;
        this.spinnerService = spinnerService;
        this.router = router;
        this.route = route;
        this.localidadeService = localidadeService;
        this.ufService = ufService;
        this.service = service;
        this.profissaoService = profissaoService;
        this.sharedService = sharedService;
        this.formBuilder = formBuilder;
        this.messageService = messageService;
        this.menuService = menuService;
        this.sexos = new Array();
        this.profissoes = new Array();
        this.localidades = new Array();
        this.ufs = new Array();
        this.isShowSenha = false;
        this.isShowSenhaConfirmacao = false;
        this.isInvalidForm = false;
        this.subscription = this.profissaoService.getProfissao().subscribe(function () {
            _this.onRefreshComboProfissao();
        });
        this.subscription = this.ufService.getUF().subscribe(function () {
            _this.onRefreshComboUF();
        });
        this.subscription = this.localidadeService.getLocalidade().subscribe(function () {
            _this.onChangeUf();
        });
    }
    UsuarioFormComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCombos();
        this.findById();
    };
    UsuarioFormComponent.prototype.ngOnDestroy = function () {
        this.subscription.unsubscribe();
    };
    UsuarioFormComponent.prototype.onLoadCombos = function () {
        this.onLoadComboProfissao();
        this.onLoadComboUF();
        this.onLoadComboSexo();
    };
    UsuarioFormComponent.prototype.onLoadComboProfissao = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.profissoes = response.resolve.profissoes.result;
        });
    };
    UsuarioFormComponent.prototype.onLoadComboUF = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.ufs = response.resolve.ufs.result;
        });
    };
    UsuarioFormComponent.prototype.onLoadComboSexo = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.sexos = response.resolve.sexos.result;
        });
    };
    UsuarioFormComponent.prototype.onRefreshComboUF = function () {
        var _this = this;
        this.ufService.findAll().subscribe(function (response) {
            _this.ufs = response.result;
        });
    };
    UsuarioFormComponent.prototype.onRefreshComboProfissao = function () {
        var _this = this;
        this.profissaoService.findAll().subscribe(function (response) {
            _this.profissoes = response.result;
        });
    };
    UsuarioFormComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            id: [null],
            senha: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            senhaConfirmacao: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            nomeCompleto: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            dataNascimento: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            rg: [null],
            cpf: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            imagem: [null],
            sexoId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            profissaoId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
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
    UsuarioFormComponent.prototype.onClickLocalidade = function () {
        this.messageService.clearAllMessages();
        if (!this.form.controls.enderecoLocalidadeUFId.value) {
            this.messageService.sendMessageWarning(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0010);
        }
    };
    UsuarioFormComponent.prototype.onChangeUf = function (isclearAllMessages) {
        var _this = this;
        if (isclearAllMessages) {
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
    Object.defineProperty(UsuarioFormComponent.prototype, "isCadastroCompleto", {
        get: function () {
            return this.sharedService.getUserSession().cadastroCompleto;
        },
        enumerable: true,
        configurable: true
    });
    UsuarioFormComponent.prototype.removerValidacaoSenhas = function () {
        if (this.isCadastroCompleto) {
            this.form.controls.senha.setValidators([]);
            this.form.controls.senhaConfirmacao.setValidators([]);
            this.form.controls.senha.updateValueAndValidity();
            this.form.controls.senhaConfirmacao.updateValueAndValidity();
        }
    };
    UsuarioFormComponent.prototype.onClickFormSubmit = function () {
        var _this = this;
        this.messageService.clearAllMessages();
        this.removerValidacaoSenhas();
        if (this.form.valid) {
            var dataNascimento = this.form.value.dataNascimento;
            if (dataNascimento && !_shared_util_util__WEBPACK_IMPORTED_MODULE_14__["default"].isDataValida(dataNascimento)) {
                this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0018);
                return;
            }
            var formValue = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { dataNascimento: _shared_util_util__WEBPACK_IMPORTED_MODULE_14__["default"].convertStringToDate(this.form.value.dataNascimento) });
            if (formValue.id) {
                if (this.isCadastroCompleto) {
                    this.service.update(formValue.id, formValue).subscribe(function (response) {
                        _this.messageService.sendMessageSuccess(response.message);
                        _this.service.setUsuario(response.result);
                        window.history.back();
                    });
                }
                else {
                    this.service.completeRegistration(formValue.id, formValue).subscribe(function (response) {
                        _this.messageService.sendMessageSuccess(response.message);
                        _this.service.setUsuario(response.result);
                        _this.sharedService.setUserSession(response.result);
                        _this.sharedService.updateTemplateSet(true);
                        _this.router.navigate(['/home']);
                        _this.menuService.setMenu();
                    });
                }
            }
            else {
                this.service.create(formValue).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.router.navigate(['/usuario-list']);
                });
            }
        }
        else {
            this.isInvalidForm = true;
            this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0004);
        }
    };
    UsuarioFormComponent.prototype.onClickRemoveImage = function () {
        this.messageService.clearAllMessages();
        this.form.controls.imagem.setValue(null);
        this.inputImage.nativeElement.value = null;
    };
    UsuarioFormComponent.prototype.onChangeImage = function (imagem) {
        var _this = this;
        this.messageService.clearAllMessages();
        if (imagem) {
            try {
                if (!_shared_util_util__WEBPACK_IMPORTED_MODULE_14__["default"].isFormatoImagemValido(imagem)) {
                    this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0020);
                    return;
                }
                if (!_shared_util_util__WEBPACK_IMPORTED_MODULE_14__["default"].isTamanhoArquivoValido(imagem)) {
                    this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0022);
                    return;
                }
                var reader_1 = new FileReader();
                reader_1.readAsDataURL(imagem);
                reader_1.onload = function () {
                    _this.spinnerService.show();
                    Object(resize_base64__WEBPACK_IMPORTED_MODULE_5__["resizeBase64ForMaxWidthAndMaxHeight"])(reader_1.result, 1024, 768, function (resizedImage) {
                        _this.form.controls.imagem.setValue(resizedImage);
                        _this.spinnerService.hide();
                    });
                };
            }
            catch (_a) {
                this.messageService.sendMessageError(_shared_messages_messages__WEBPACK_IMPORTED_MODULE_13__["Messages"].MSG0011);
                this.spinnerService.hide();
            }
        }
    };
    UsuarioFormComponent.prototype.findById = function () {
        var _this = this;
        this.route.data.subscribe(function (dados) {
            var response = dados.resolve.usuario;
            if (!response) {
                return;
            }
            _this.form.setValue({
                id: response.result.id,
                senha: null,
                senhaConfirmacao: null,
                nomeCompleto: response.result.nomeCompleto,
                dataNascimento: _shared_util_util__WEBPACK_IMPORTED_MODULE_14__["default"].convertDateToString(response.result.dataNascimento),
                rg: response.result.rg || null,
                cpf: response.result.cpf || null,
                imagem: response.result.imagem || null,
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
                contatoId: response.result.contatoId,
                contatoCelular: response.result.contatoCelular || null,
                contatoCelularRecado: response.result.contatoCelularRecado || null,
                contatoResidencial: response.result.contatoResidencial || null,
                contatoComercial: response.result.contatoComercial || null,
                contatoEmail: response.result.contatoEmail || null,
            });
            _this.onChangeUf();
        });
    };
    UsuarioFormComponent.prototype.showHidePassword = function (param) {
        this.messageService.clearAllMessages();
        if (param === 'senha') {
            this.isShowSenha = !this.isShowSenha;
        }
        else {
            this.isShowSenhaConfirmacao = !this.isShowSenhaConfirmacao;
        }
    };
    UsuarioFormComponent.ctorParameters = function () { return [
        { type: ngx_spinner__WEBPACK_IMPORTED_MODULE_4__["NgxSpinnerService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] },
        { type: _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_8__["LocalidadeService"] },
        { type: _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__["UfService"] },
        { type: _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_12__["UsuarioService"] },
        { type: _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_10__["ProfissaoService"] },
        { type: src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__["SharedService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__["MessageService"] },
        { type: src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_6__["MenuService"] }
    ]; };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('inputImage', { static: false }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], UsuarioFormComponent.prototype, "inputImage", void 0);
    UsuarioFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-usuario-form',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./usuario-form.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/form/usuario-form.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_spinner__WEBPACK_IMPORTED_MODULE_4__["NgxSpinnerService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            _core_services_localidade_service__WEBPACK_IMPORTED_MODULE_8__["LocalidadeService"],
            _core_services_uf_service__WEBPACK_IMPORTED_MODULE_11__["UfService"],
            _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_12__["UsuarioService"],
            _core_services_profissao_service__WEBPACK_IMPORTED_MODULE_10__["ProfissaoService"],
            src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_7__["SharedService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_9__["MessageService"],
            src_app_core_services_menu_service__WEBPACK_IMPORTED_MODULE_6__["MenuService"]])
    ], UsuarioFormComponent);
    return UsuarioFormComponent;
}());



/***/ }),

/***/ "./src/app/components/usuario/list/usuario-list.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/components/usuario/list/usuario-list.component.ts ***!
  \*******************************************************************/
/*! exports provided: UsuarioListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioListComponent", function() { return UsuarioListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/components/pagination/pagination */ "./src/app/shared/components/pagination/pagination.ts");
/* harmony import */ var _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../core/guards/auth.guard */ "./src/app/core/guards/auth.guard.ts");
/* harmony import */ var _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../core/model/enum/perfil.enum */ "./src/app/core/model/enum/perfil.enum.ts");
/* harmony import */ var _core_model_enum_sexo_enum__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../core/model/enum/sexo.enum */ "./src/app/core/model/enum/sexo.enum.ts");
/* harmony import */ var _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../core/model/filter/filter.filter */ "./src/app/core/model/filter/filter.filter.ts");
/* harmony import */ var _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../core/model/model/page.model */ "./src/app/core/model/model/page.model.ts");
/* harmony import */ var _core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../core/model/model/usuario.model */ "./src/app/core/model/model/usuario.model.ts");
/* harmony import */ var _core_services_message_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../core/services/sexo.service */ "./src/app/core/services/sexo.service.ts");
/* harmony import */ var _core_services_shared_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");
/* harmony import */ var _shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../shared/modais/modal-confirmacao/modal-confirmacao.component */ "./src/app/shared/modais/modal-confirmacao/modal-confirmacao.component.ts");
/* harmony import */ var _shared_modais_modal_visualizar_paciente_usuario_modal_visualizar_paciente_usuario_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../shared/modais/modal-visualizar-paciente-usuario/modal-visualizar-paciente-usuario.component */ "./src/app/shared/modais/modal-visualizar-paciente-usuario/modal-visualizar-paciente-usuario.component.ts");

















var UsuarioListComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](UsuarioListComponent, _super);
    function UsuarioListComponent(modalService, service, sharedService, sexoService, formBuilder, messageService, authGuardService) {
        var _this = _super.call(this, messageService) || this;
        _this.modalService = modalService;
        _this.service = service;
        _this.sharedService = sharedService;
        _this.sexoService = sexoService;
        _this.formBuilder = formBuilder;
        _this.authGuardService = authGuardService;
        _this.sexos = new Array();
        _this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__["default"]();
        _this.currentUser = new _core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__["Usuario"]();
        _this.permissaoAdministrador = _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_6__["PerfilEnum"].ADMINISTRADOR;
        _this.showNoRecords = false;
        return _this;
    }
    UsuarioListComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCombos();
        this.getUserSession();
    };
    UsuarioListComponent.prototype.getUserSession = function () {
        this.currentUser = this.sharedService.getUserSession();
    };
    UsuarioListComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            cpf: [null],
            nomeCompleto: [null],
            sexoId: [null],
            ativo: [null],
        });
    };
    UsuarioListComponent.prototype.onLoadCombos = function () {
        var _this = this;
        this.sexoService.findAll().subscribe(function (response) {
            _this.sexos = response.result;
        });
    };
    UsuarioListComponent.prototype.onClickFormSubmit = function () {
        this.messageService.clearAllMessages();
        this.filtro = new _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.filtro = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.filtro, { orderBy: 'nomeCompleto', direction: 'ASC', filter: tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value) });
        this.searchByFilter();
    };
    UsuarioListComponent.prototype.searchByFilter = function () {
        var _this = this;
        this.service.findByFilter(this.filtro).subscribe(function (response) {
            _this.showNoRecords = true;
            _this.dados = response.result;
        });
    };
    UsuarioListComponent.prototype.onClickLimparCampos = function () {
        this.onCreateForm();
        this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_9__["default"]();
        this.filtro = new _core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.showNoRecords = false;
    };
    UsuarioListComponent.prototype.onClickUpdateStatus = function (usuario) {
        var _this = this;
        this.messageService.clearAllMessages();
        var modalRef = this.modalService.show(_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_15__["ModalConfirmacaoComponent"], { backdrop: 'static' });
        var status = usuario.ativo ? 'desativar' : 'ativar';
        var sexo = usuario.sexoId === _core_model_enum_sexo_enum__WEBPACK_IMPORTED_MODULE_7__["SexoEnum"].MASCULINO ? 'o' : 'a';
        modalRef.content.titulo = 'Confirmação de Ativação/Inativação de Usuário';
        modalRef.content.corpo = "Deseja " + status + " " + sexo + " usu\u00E1ri" + sexo + " " + usuario.nomeCompleto + "?";
        modalRef.content.onClose.subscribe(function (result) {
            if (result) {
                _this.service.activeOrInative(usuario.id).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.searchByFilter();
                });
            }
        });
    };
    UsuarioListComponent.prototype.onClickOpenModalVisualizar = function (id) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var initialState, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        _a = {};
                        return [4 /*yield*/, this.service.findById(id).toPromise()];
                    case 1:
                        initialState = (_a.dados = (_b.sent()).result,
                            _a);
                        this.modalService.show(_shared_modais_modal_visualizar_paciente_usuario_modal_visualizar_paciente_usuario_component__WEBPACK_IMPORTED_MODULE_16__["ModalVisualizarPacienteUsuarioComponent"], { initialState: initialState, backdrop: 'static', class: 'gray modal-lg' });
                        return [2 /*return*/];
                }
            });
        });
    };
    UsuarioListComponent.ctorParameters = function () { return [
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"] },
        { type: _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_14__["UsuarioService"] },
        { type: _core_services_shared_service__WEBPACK_IMPORTED_MODULE_13__["SharedService"] },
        { type: _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_12__["SexoService"] },
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_message_service__WEBPACK_IMPORTED_MODULE_11__["MessageService"] },
        { type: _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"] }
    ]; };
    UsuarioListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-usuario-list',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./usuario-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/list/usuario-list.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_bootstrap__WEBPACK_IMPORTED_MODULE_3__["BsModalService"],
            _core_services_usuario_service__WEBPACK_IMPORTED_MODULE_14__["UsuarioService"],
            _core_services_shared_service__WEBPACK_IMPORTED_MODULE_13__["SharedService"],
            _core_services_sexo_service__WEBPACK_IMPORTED_MODULE_12__["SexoService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_message_service__WEBPACK_IMPORTED_MODULE_11__["MessageService"],
            _core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"]])
    ], UsuarioListComponent);
    return UsuarioListComponent;
}(src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_4__["Pagination"]));



/***/ }),

/***/ "./src/app/components/usuario/pre-cadastro/pre-cadastro.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/components/usuario/pre-cadastro/pre-cadastro.component.ts ***!
  \***************************************************************************/
/*! exports provided: PreCadastroComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PreCadastroComponent", function() { return PreCadastroComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");
/* harmony import */ var src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/messages/messages */ "./src/app/shared/messages/messages.ts");






var PreCadastroComponent = /** @class */ (function () {
    function PreCadastroComponent(formBuilder, messageService, usuarioService) {
        this.formBuilder = formBuilder;
        this.messageService = messageService;
        this.usuarioService = usuarioService;
        this.isShowSenha = false;
        this.isShowSenhaConfirmacao = false;
        this.isInvalidForm = false;
    }
    PreCadastroComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
    };
    PreCadastroComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            id: [null],
            cpf: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            senha: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            senhaConfirmacao: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
        });
    };
    PreCadastroComponent.prototype.onClickFormSubmit = function () {
        var _this = this;
        this.messageService.clearAllMessages();
        if (this.form.valid) {
            var formValue = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value);
            this.usuarioService.create(formValue).subscribe(function (response) {
                _this.messageService.sendMessageSuccess(response.message);
                window.history.back();
            });
        }
        else {
            this.isInvalidForm = true;
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_5__["Messages"].MSG0004);
        }
    };
    PreCadastroComponent.prototype.showHidePassword = function (param) {
        this.messageService.clearAllMessages();
        if (param === 'senha') {
            this.isShowSenha = !this.isShowSenha;
        }
        else if (param === 'senhaConfirmacao') {
            this.isShowSenhaConfirmacao = !this.isShowSenhaConfirmacao;
        }
    };
    PreCadastroComponent.prototype.onClickCancelar = function () {
        this.messageService.clearAllMessages();
        window.history.back();
    };
    PreCadastroComponent.ctorParameters = function () { return [
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_3__["MessageService"] },
        { type: src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_4__["UsuarioService"] }
    ]; };
    PreCadastroComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-pre-cadastro',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./pre-cadastro.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/usuario/pre-cadastro/pre-cadastro.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_3__["MessageService"],
            src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_4__["UsuarioService"]])
    ], PreCadastroComponent);
    return PreCadastroComponent;
}());



/***/ }),

/***/ "./src/app/components/usuario/resolver/usuario.resolver.ts":
/*!*****************************************************************!*\
  !*** ./src/app/components/usuario/resolver/usuario.resolver.ts ***!
  \*****************************************************************/
/*! exports provided: UsuarioResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioResolver", function() { return UsuarioResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/profissao.service */ "./src/app/core/services/profissao.service.ts");
/* harmony import */ var src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/sexo.service */ "./src/app/core/services/sexo.service.ts");
/* harmony import */ var src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/services/uf.service */ "./src/app/core/services/uf.service.ts");
/* harmony import */ var src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");








var UsuarioResolver = /** @class */ (function () {
    function UsuarioResolver(usuarioService, router, profissaoService, ufService, sexoService, sharedService) {
        this.usuarioService = usuarioService;
        this.router = router;
        this.profissaoService = profissaoService;
        this.ufService = ufService;
        this.sexoService = sexoService;
        this.sharedService = sharedService;
    }
    UsuarioResolver.prototype.resolve = function (route, state) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var id, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (state.url.startsWith('/usuario/completar-cadastro/') && !this.sharedService.isLoggedIn()) {
                            this.router.navigate(['/login']);
                            return [2 /*return*/];
                        }
                        if (state.url.startsWith('/usuario/completar-cadastro/') && this.sharedService.getUserSession().cadastroCompleto) {
                            this.router.navigate(['/home']);
                            return [2 /*return*/];
                        }
                        id = +route.params.id;
                        if (id !== this.sharedService.getUserSession().id) {
                            this.router.navigate(['/acesso-negado']);
                            return [2 /*return*/];
                        }
                        _a = {};
                        return [4 /*yield*/, this.usuarioService.findById(id).toPromise()];
                    case 1:
                        _a.usuario = _b.sent();
                        return [4 /*yield*/, this.profissaoService.findAll().toPromise()];
                    case 2:
                        _a.profissoes = _b.sent();
                        return [4 /*yield*/, this.sexoService.findAll().toPromise()];
                    case 3:
                        _a.sexos = _b.sent();
                        return [4 /*yield*/, this.ufService.findAll().toPromise()];
                    case 4: return [2 /*return*/, (_a.ufs = _b.sent(),
                            _a)];
                }
            });
        });
    };
    UsuarioResolver.ctorParameters = function () { return [
        { type: src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__["UsuarioService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
        { type: src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_3__["ProfissaoService"] },
        { type: src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_6__["UfService"] },
        { type: src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_4__["SexoService"] },
        { type: src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__["SharedService"] }
    ]; };
    UsuarioResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__["UsuarioService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            src_app_core_services_profissao_service__WEBPACK_IMPORTED_MODULE_3__["ProfissaoService"],
            src_app_core_services_uf_service__WEBPACK_IMPORTED_MODULE_6__["UfService"],
            src_app_core_services_sexo_service__WEBPACK_IMPORTED_MODULE_4__["SexoService"],
            src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__["SharedService"]])
    ], UsuarioResolver);
    return UsuarioResolver;
}());



/***/ }),

/***/ "./src/app/components/usuario/usuario-routing.module.ts":
/*!**************************************************************!*\
  !*** ./src/app/components/usuario/usuario-routing.module.ts ***!
  \**************************************************************/
/*! exports provided: UsuarioRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioRoutingModule", function() { return UsuarioRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/guards/auth.guard */ "./src/app/core/guards/auth.guard.ts");
/* harmony import */ var _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../core/model/enum/perfil.enum */ "./src/app/core/model/enum/perfil.enum.ts");
/* harmony import */ var _form_usuario_form_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./form/usuario-form.component */ "./src/app/components/usuario/form/usuario-form.component.ts");
/* harmony import */ var _list_usuario_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./list/usuario-list.component */ "./src/app/components/usuario/list/usuario-list.component.ts");
/* harmony import */ var _pre_cadastro_pre_cadastro_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pre-cadastro/pre-cadastro.component */ "./src/app/components/usuario/pre-cadastro/pre-cadastro.component.ts");
/* harmony import */ var _resolver_usuario_resolver__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./resolver/usuario.resolver */ "./src/app/components/usuario/resolver/usuario.resolver.ts");









var routes = [
    {
        path: '',
        component: _list_usuario_list_component__WEBPACK_IMPORTED_MODULE_6__["UsuarioListComponent"],
        data: {
            role: _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_4__["PerfilEnum"].ADMINISTRADOR
        },
        canActivate: [src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_3__["AuthGuard"]]
    },
    {
        path: 'incluir',
        component: _pre_cadastro_pre_cadastro_component__WEBPACK_IMPORTED_MODULE_7__["PreCadastroComponent"],
        data: {
            role: _core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_4__["PerfilEnum"].ADMINISTRADOR
        },
        canActivate: [src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_3__["AuthGuard"]]
    },
    {
        path: 'alterar/:id',
        component: _form_usuario_form_component__WEBPACK_IMPORTED_MODULE_5__["UsuarioFormComponent"],
        resolve: {
            resolve: _resolver_usuario_resolver__WEBPACK_IMPORTED_MODULE_8__["UsuarioResolver"]
        },
        canActivate: [src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_3__["AuthGuard"]]
    },
    {
        path: 'completar-cadastro/:id',
        component: _form_usuario_form_component__WEBPACK_IMPORTED_MODULE_5__["UsuarioFormComponent"],
        resolve: {
            resolve: _resolver_usuario_resolver__WEBPACK_IMPORTED_MODULE_8__["UsuarioResolver"]
        }
    }
];
var UsuarioRoutingModule = /** @class */ (function () {
    function UsuarioRoutingModule() {
    }
    UsuarioRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
            providers: [_resolver_usuario_resolver__WEBPACK_IMPORTED_MODULE_8__["UsuarioResolver"]]
        })
    ], UsuarioRoutingModule);
    return UsuarioRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/usuario/usuario.module.ts":
/*!******************************************************!*\
  !*** ./src/app/components/usuario/usuario.module.ts ***!
  \******************************************************/
/*! exports provided: UsuarioModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioModule", function() { return UsuarioModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _form_usuario_form_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./form/usuario-form.component */ "./src/app/components/usuario/form/usuario-form.component.ts");
/* harmony import */ var _list_usuario_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./list/usuario-list.component */ "./src/app/components/usuario/list/usuario-list.component.ts");
/* harmony import */ var _pre_cadastro_pre_cadastro_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pre-cadastro/pre-cadastro.component */ "./src/app/components/usuario/pre-cadastro/pre-cadastro.component.ts");
/* harmony import */ var _usuario_routing_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./usuario-routing.module */ "./src/app/components/usuario/usuario-routing.module.ts");









var UsuarioModule = /** @class */ (function () {
    function UsuarioModule() {
    }
    UsuarioModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _list_usuario_list_component__WEBPACK_IMPORTED_MODULE_6__["UsuarioListComponent"],
                _form_usuario_form_component__WEBPACK_IMPORTED_MODULE_5__["UsuarioFormComponent"],
                _pre_cadastro_pre_cadastro_component__WEBPACK_IMPORTED_MODULE_7__["PreCadastroComponent"]
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _usuario_routing_module__WEBPACK_IMPORTED_MODULE_8__["UsuarioRoutingModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"]
            ]
        })
    ], UsuarioModule);
    return UsuarioModule;
}());



/***/ }),

/***/ "./src/app/core/model/enum/sexo.enum.ts":
/*!**********************************************!*\
  !*** ./src/app/core/model/enum/sexo.enum.ts ***!
  \**********************************************/
/*! exports provided: SexoEnum */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SexoEnum", function() { return SexoEnum; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var SexoEnum;
(function (SexoEnum) {
    SexoEnum[SexoEnum["MASCULINO"] = 1] = "MASCULINO";
    SexoEnum[SexoEnum["FEMININO"] = 2] = "FEMININO";
})(SexoEnum || (SexoEnum = {}));


/***/ })

}]);
//# sourceMappingURL=components-usuario-usuario-module.js.map