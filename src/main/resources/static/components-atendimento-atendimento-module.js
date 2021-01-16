(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-atendimento-atendimento-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/form/atendimento-form.component.html":
/*!*******************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/form/atendimento-form.component.html ***!
  \*******************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>{{ form.controls.id.value ? 'Editar' : 'Cadastar' }} Atendimento de {{ categoriaAtendimentoRouting?.descricao }}\r\n  </h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Dados do Atendimento</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"tipoAtendimento\">Tipo de Atendimento</label>\r\n                  <ng-select id=\"tipoAtendimento\" [disabled]=\"form.controls.id.value\" maxlength=\"50\"\r\n                    [ngModelOptions]=\"{standalone: true}\" [(ngModel)]=\"tipoAtendimentoId\" [clearable]=\"false\"\r\n                    [items]=\"tiposAtendimento\" bindLabel=\"descricao\" bindValue=\"id\"\r\n                    (change)=\"onChangeTipoAtendimento()\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"paciente\">Paciente</label>\r\n                  <ng-select id=\"paciente\" maxlength=\"50\" (change)=\"onChangePaciente()\" formControlName=\"pacienteId\"\r\n                    [items]=\"pacientes\" bindLabel=\"nomeCompleto\" placeholder=\"Selecione\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                  <app-message-required [isInvalidForm]=\"isInvalidForm ||isInvalidFormPacienteId\"\r\n                    [controlComponent]=\"form.get('pacienteId')\">\r\n                  </app-message-required>\r\n                </div>\r\n              </div>\r\n              <ng-container *ngIf=\"form.controls.pacienteId.value || form.controls.id.value\">\r\n                <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"numeroSessao\">Número da Sessão</label>\r\n                    <input [value]=\"quantidadeSessao\" id=\"numeroSessao\" readonly type=\"text\" class=\"form-control\" />\r\n                  </div>\r\n                </div>\r\n                <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"aberto\">Cadastrar o Pós-atendimento?</label>\r\n                    <ng-select id=\"aberto\" maxlength=\"50\" [ngModelOptions]=\"{standalone: true}\"\r\n                      [(ngModel)]=\"isCadastrarPosAtendimento\" [clearable]=\"false\"\r\n                      [disabled]=\"form.controls.id.value && form.controls.aberto.value === false\">\r\n                      <ng-option [value]=true>Sim</ng-option>\r\n                      <ng-option [value]=false>Não</ng-option>\r\n                    </ng-select>\r\n                  </div>\r\n                </div>\r\n              </ng-container>\r\n            </div>\r\n            <ng-container\r\n              *ngIf=\"(isFisioterapia() || isDrenagem()) && (form.controls.pacienteId.value || form.controls.id.value)\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"conduta\">Conduta</label>\r\n                    <textarea trim=\"blur\" style=\"resize: none\" id=\"conduta\" maxlength=\"1000\" type=\"text\" rows=\"5\"\r\n                      formControlName=\"conduta\" class=\"form-control\"></textarea>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </ng-container>\r\n          </div>\r\n        </div>\r\n        <app-dados-pacote *ngIf=\"showDadosPacote()\"\r\n          [pacote]=\"pacote\"\r\n          [showButtonCreatePackage]=\"!form.controls.id.value && form.controls.pacienteId.value && checkTipoAtendimentoPacote()\"\r\n          (onOpenModalCriarPacote)=\"onOpenModalCriarPacote($event)\">\r\n        </app-dados-pacote>\r\n        <ng-container *ngIf=\"form.controls.pacienteId.value || form.controls.id.value\">\r\n          <div class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <h3 class=\"box-title\">Dados do Pré-Atendimento</h3>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"preAtendimentoData\">Data e Hora</label>\r\n                    <input id=\"preAtendimentoData\" (focus)=\"setDataHoraAtual('preAtendimentoData')\" type=\"text\"\r\n                      [validation]=\"false\" mask=\"00/00/0000 00:00\" formControlName=\"preAtendimentoData\"\r\n                      class=\"form-control\" />\r\n                    <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                      [controlComponent]=\"form.get('preAtendimentoData')\">\r\n                    </app-message-required>\r\n                  </div>\r\n                </div>\r\n                <ng-container *ngIf=\"isDrenagem() || isFisioterapia()\">\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"preAtendimentoPressaoArterial\">Pressão Arterial</label>\r\n                      <input [dropSpecialCharacters]=\"false\" [validation]=\"false\" mask=\"000/000\"\r\n                        id=\"preAtendimentoPressaoArterial\" maxlength=\"7\" type=\"text\"\r\n                        formControlName=\"preAtendimentoPressaoArterial\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </ng-container>\r\n\r\n                <ng-container *ngIf=\"isDrenagem()\">\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"preAtendimentoPeso\">Peso (kg)</label>\r\n                      <input currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: ',', decimal: '.', allowNegative: 'false' }\"\r\n                        id=\"preAtendimentoPeso\" maxlength=\"5\" type=\"text\" formControlName=\"preAtendimentoPeso\"\r\n                        class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"preAtendimentoSupraUmbilical\">Supra Umbilical (cm)</label>\r\n                      <input currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" id=\"preAtendimentoSupraUmbilical\" type=\"text\"\r\n                        formControlName=\"preAtendimentoSupraUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"preAtendimentoLinhaUmbilical\">Linha Umbilical (cm)</label>\r\n                      <input currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        id=\"preAtendimentoLinhaUmbilical\" maxlength=\"5\" type=\"text\"\r\n                        formControlName=\"preAtendimentoLinhaUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"preAtendimentoInfraUmbilical\">Infra Umbilical (cm)</label>\r\n                      <input currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        id=\"preAtendimentoInfraUmbilical\" maxlength=\"5\" type=\"text\"\r\n                        formControlName=\"preAtendimentoInfraUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </ng-container>\r\n              </div>\r\n\r\n              <ng-container *ngIf=\"isDrenagem()\">\r\n                <div>\r\n                  <legend class=\"legend-default\">Outras Medidas</legend>\r\n                </div>\r\n                <div class=\"row\">\r\n                  <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                    <div class=\"form-group\">\r\n                      <button title=\"Adicionar Medida\" (click)=\"onClickAdicionarMedida()\"\r\n                        class=\"btn btn-primary\"><span><em class=\"fa fa-plus\"></em>&nbsp;Adicionar Medida</span></button>\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n                <div class=\"row\">\r\n                  <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\"\r\n                    *ngFor=\"let medida of outrasMedidasSelecionadas; let i = index\">\r\n                    <div class=\"form-group\" style=\"text-align: end;\">\r\n                      <button title=\"Remover Medida\" class=\"btn btn-danger\" type=\"button\"\r\n                        (click)=\"onClickRemoverOutraMedida(medida.index)\"><em class=\"fa fa-close\"></em></button>\r\n                    </div>\r\n                    <div class=\"form-group\">\r\n                      <label for=\"descricaOutraMedidaPre{{ i }}\">Medida</label>\r\n                      <ng-select id=\"descricaOutraMedidaPre{{ i }}\" maxlength=\"50\" [items]=\"outrasMedidas\"\r\n                        [ngModelOptions]=\"{standalone: true}\" [(ngModel)]=\"medida.outraMedidaId\" [multiple]=\"false\"\r\n                        bindLabel=\"descricao\" required #descricaoOutraMedidaPre=\"ngModel\" bindValue=\"id\"\r\n                        placeholder=\"Selecione\">\r\n                      </ng-select>\r\n                      <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                        [controlComponent]=\"descricaoOutraMedidaPre\">\r\n                      </app-message-required>\r\n                    </div>\r\n                    <div class=\"form-group\">\r\n                      <label for=\"valorOutraMedidaPre{{ i }}\">Valor (cm)</label>\r\n                      <input id=\"valorOutraMedidaPre{{ i }}\" currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" type=\"text\" [ngModelOptions]=\"{standalone: true}\" [(ngModel)]=\"medida.valorPre\"\r\n                        class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n              </ng-container>\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"preAtendimentoObservacao\">Observacão</label>\r\n                    <textarea trim=\"blur\" style=\"resize: none\" id=\"preAtendimentoObservacao\" maxlength=\"1000\"\r\n                      type=\"text\" rows=\"5\" formControlName=\"preAtendimentoObservacao\" class=\"form-control\"></textarea>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div *ngIf=\"isCadastrarPosAtendimento\" class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <h3 class=\"box-title\">Dados do Pós-Atendimento</h3>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"posAtendimentoData\">Data e Hora</label>\r\n                    <input id=\"posAtendimentoData\" (focus)=\"setDataHoraAtual('posAtendimentoData')\" type=\"text\"\r\n                      [validation]=\"false\" mask=\"00/00/0000 00:00\" formControlName=\"posAtendimentoData\"\r\n                      class=\"form-control\" />\r\n                    <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                      [controlComponent]=\"form.get('posAtendimentoData')\">\r\n                    </app-message-required>\r\n                  </div>\r\n                </div>\r\n                <ng-container *ngIf=\"isDrenagem() || isFisioterapia()\">\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"posAtendimentoPressaoArterial\">Pressão Arterial</label>\r\n                      <input [dropSpecialCharacters]=\"false\" [validation]=\"false\" mask=\"000/000\"\r\n                        id=\"posAtendimentoPressaoArterial\" maxlength=\"7\" type=\"text\"\r\n                        formControlName=\"posAtendimentoPressaoArterial\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </ng-container>\r\n                <ng-container *ngIf=\"isDrenagem()\">\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"posAtendimentoPeso\">Peso (kg)</label>\r\n                      <input currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: ',', decimal: '.', allowNegative: 'false' }\"\r\n                        id=\"pesoPreAtendimento\" maxlength=\"5\" id=\"posAtendimentoPeso\" type=\"text\"\r\n                        formControlName=\"posAtendimentoPeso\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"posAtendimentoSupraUmbilical\">Supra Umbilical (cm)</label>\r\n                      <input id=\"posAtendimentoSupraUmbilical\" currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" type=\"text\" formControlName=\"posAtendimentoSupraUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"posAtendimentoLinhaUmbilical\">Linha Umbilical (cm)</label>\r\n                      <input id=\"posAtendimentoLinhaUmbilical\" currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" type=\"text\" formControlName=\"posAtendimentoLinhaUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"col-xs-12 col-sm-2 col-md-2 col-lg-2\">\r\n                    <div class=\"form-group\">\r\n                      <label for=\"posAtendimentoInfraUmbilical\">Infra Umbilical (cm)</label>\r\n                      <input id=\"posAtendimentoInfraUmbilical\" currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" type=\"text\" formControlName=\"posAtendimentoInfraUmbilical\" class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </ng-container>\r\n              </div>\r\n              <ng-container *ngIf=\"isDrenagem()\">\r\n                <div>\r\n                  <legend class=\"legend-default\">Outras Medidas</legend>\r\n                </div>\r\n                <div class=\"row\">\r\n                  <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                    <div class=\"form-group\">\r\n                      <button title=\"Adicionar Medida\" (click)=\"onClickAdicionarMedida()\"\r\n                        class=\"btn btn-primary\"><span><em class=\"fa fa-plus\"></em>&nbsp;Adicionar Medida</span></button>\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n                <div class=\"row\">\r\n                  <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\"\r\n                    *ngFor=\"let medida of outrasMedidasSelecionadas; let i = index\">\r\n                    <div class=\"form-group\" style=\"text-align: end;\">\r\n                      <button title=\"Remover Medida\" class=\"btn btn-danger\" type=\"button\"\r\n                        (click)=\"onClickRemoverOutraMedida(medida.index)\"><em class=\"fa fa-close\"></em></button>\r\n                    </div>\r\n                    <div class=\"form-group\">\r\n                      <label for=\"descricaOutraMedidaPos{{ i }}\">Medida</label>\r\n                      <ng-select id=\"descricaOutraMedidaPos{{ i }}\" maxlength=\"50\" [items]=\"outrasMedidas\"\r\n                        [ngModelOptions]=\"{standalone: true}\" [(ngModel)]=\"medida.outraMedidaId\" [multiple]=\"false\"\r\n                        bindLabel=\"descricao\" bindValue=\"id\" placeholder=\"Selecione\" required\r\n                        #descricaoOutraMedidaPos=\"ngModel\">\r\n                      </ng-select>\r\n                      <app-message-required [isInvalidForm]=\"isInvalidForm\"\r\n                        [controlComponent]=\"descricaoOutraMedidaPos\">\r\n                      </app-message-required>\r\n                    </div>\r\n                    <div class=\"form-group\">\r\n                      <label for=\"valorOutraMedidaPos{{ i }}\">Valor (cm)</label>\r\n                      <input id=\"valorOutraMedidaPos{{ i }}\" currencyMask\r\n                        [options]=\"{ align: 'left', suffix: '', prefix: '', precision: 1, thousands: '.', decimal: ',', allowNegative: 'false' }\"\r\n                        maxlength=\"5\" type=\"text\" [ngModelOptions]=\"{standalone: true}\" [(ngModel)]=\"medida.valorPos \"\r\n                        class=\"form-control\" />\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n              </ng-container>\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <div class=\"form-group\">\r\n                    <label for=\"posAtendimentoObservacao\">Observacão</label>\r\n                    <textarea trim=\"blur\" style=\"resize: none\" id=\"posAtendimentoObservacao\" maxlength=\"700\" type=\"text\"\r\n                      rows=\"5\" formControlName=\"posAtendimentoObservacao\" class=\"form-control\"></textarea>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div *ngIf=\"isNotMassagem\" class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <h3 class=\"box-title\">Imagens</h3>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">\r\n                  <div class=\"form-group\">\r\n                    <div class=\"fileUpload btn btn-primary\">\r\n                      <span><em class=\"fa fa-plus\"></em>&nbsp;Adicionar Imagens</span>\r\n                      <input title=\"Adicionar Imagens\" #inputImage id=\"imagem\" type=\"file\" multiple class=\"upload\"\r\n                        (change)=\"onChangeImage($event.target.files)\" (click)=\"inputImage.value=null\" />\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              <div>\r\n                <legend *ngIf=\"form.controls.imagens.value?.length\" class=\"legend-default\"></legend>\r\n              </div>\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\"\r\n                  *ngFor=\"let imagem of form.controls.imagens.value; let i = index\">\r\n                  <div class=\"form-group\" style=\"text-align: end;\">\r\n                    <button title=\"Baixar Imagem\" (click)=\"onClickDownloadFile(imagem.index)\"\r\n                      class=\"btn btn-primary\"><em class=\"fa fa-cloud-download\"></em></button>\r\n                    <button style=\"margin-left: 5px;\" title=\"Remover Imagem\" class=\"btn btn-danger\" type=\"button\"\r\n                      (click)=\"onClickRemoverImagem(imagem.index)\"><em class=\"fa fa-close\"></em></button>\r\n                  </div>\r\n                  <div class=\"form-group\">\r\n                    <img alt=\"Imagem\" [src]=\"imagem.imagem\" id=\"image{{ i }}\" width=\"100%\" height=\"100%\">\r\n                  </div>\r\n                  <div class=\"form-group\">\r\n                    <label for=\"observacaoImagem{{ i }}\">Observacão</label>\r\n                    <textarea trim=\"blur\" style=\"resize: none;\" id=\"observacaoImagem{{ i }}\"\r\n                      [(ngModel)]=\"imagem.observacao\" [ngModelOptions]=\"{standalone: true}\" id=\"observacaoImagem\"\r\n                      maxlength=\"200\" type=\"text\" rows=\"4\" class=\"form-control\"></textarea>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box box-primary\">\r\n            <div class=\"box-footer\">\r\n              <button class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\" (click)=\"onClickFormSubmit()\"><em\r\n                  class=\"fa fa-save\"></em>&nbsp;Salvar</button>\r\n              <button class=\"btn btn-danger pull-right\" (click)=\"onClickCancelar()\"><em\r\n                  class=\"fa fa-ban\"></em>&nbsp;Cancelar</button>\r\n            </div>\r\n          </div>\r\n        </ng-container>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/list/atendimento-list.component.html":
/*!*******************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/list/atendimento-list.component.html ***!
  \*******************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<section class=\"content-header\">\r\n  <h1>Buscar Atendimentos de {{ categoriaAtendimentoRouting.descricao }}</h1>\r\n</section>\r\n<section class=\"content\">\r\n  <form [formGroup]=\"form\">\r\n    <div class=\"row\">\r\n      <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n        <div class=\"box box-primary\">\r\n          <div class=\"box-header with-border\">\r\n            <h3 class=\"box-title\">Filtros</h3>\r\n          </div>\r\n          <div class=\"box-body\">\r\n            <div class=\"row\">\r\n              <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"tipoAtendimento\">Tipo de Atendimento</label>\r\n                  <ng-select id=\"tipoAtendimento\" maxlength=\"50\" formControlName=\"tipoAtendimentoId\"\r\n                    [items]=\"tiposAtendimento\" bindLabel=\"descricao\" bindValue=\"id\">\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"preAtendimentoData\">Data e Hora do Pré-atendimento</label>\r\n                  <input id=\"preAtendimentoData\" [validation]=\"false\" type=\"text\" mask=\"00/00/0000 00:00\"\r\n                    formControlName=\"preAtendimentoData\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"posAtendimentoData\">Data e Hora do Pós-atendimento</label>\r\n                  <input id=\"posAtendimentoData\" [validation]=\"false\" type=\"text\" mask=\"00/00/0000 00:00\"\r\n                    formControlName=\"posAtendimentoData\" class=\"form-control\" />\r\n                </div>\r\n              </div>\r\n              <div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"aberto\">Status do Atendimento</label>\r\n                  <ng-select id=\"aberto\" maxlength=\"50\" formControlName=\"aberto\">\r\n                    <ng-option [value]=true>Em Aberto</ng-option>\r\n                    <ng-option [value]=false>Encerrado</ng-option>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"row\">\r\n              <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"paciente\">Paciente</label>\r\n                  <ng-select id=\"paciente\" maxlength=\"50\" formControlName=\"pacienteId\" [items]=\"pacientes\"\r\n                    bindLabel=\"nomeCompleto\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n              <div *ngIf=\"authGuardService.isPermitido(permissaoAdministrador)\"\r\n                class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">\r\n                <div class=\"form-group\">\r\n                  <label for=\"usuario\">Usuário</label>\r\n                  <ng-select id=\"usuario\" maxlength=\"50\" formControlName=\"usuarioId\" [items]=\"usuarios\"\r\n                    bindLabel=\"nomeCompleto\" bindValue=\"id\">\r\n                    <ng-template ng-option-tmp let-item=\"item\">\r\n                      {{ item.nomeCompleto }}\r\n                      <br />\r\n                      <small>CPF: {{ item.cpf | cpf }}</small>\r\n                    </ng-template>\r\n                  </ng-select>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n          <div class=\"box-footer\">\r\n            <button (click)=\"onClickFormSubmit()\" class=\"btn btn-primary pull-right\" style=\"margin-left: 15px;\"><em\r\n                class=\"fa fa-search\"></em>&nbsp;Buscar</button>\r\n            <button class=\"btn btn-warning pull-right\" (click)=\"onClickLimparCampos()\"><em\r\n                class=\"fa fa-eraser\"></em>&nbsp;Limpar</button>\r\n          </div>\r\n        </div>\r\n\r\n        <div *ngIf=\"dados?.content?.length > 0\" class=\"col-md-12\" style=\"padding: 0px\">\r\n          <div class=\"box box-primary\">\r\n            <div class=\"box-header with-border\">\r\n              <div class=\"row\">\r\n                <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n                  <h3 class=\"box-title\">Atendimentos</h3>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"box-body\">\r\n              <div class=\"table-roll\">\r\n                <table id=\"example2\" class=\"table table-bordered table-hover\">\r\n                  <thead>\r\n                    <tr>\r\n                      <th>Opções</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('pacote.valor')\"><em\r\n                          [class]=\"getIconOrderBy('pacote.valor')\"></em>&nbsp;Valor do Pacote</th>\r\n                      <th>Total Pago</th>\r\n                      <th>Total à Pagar</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('aberto')\"><em\r\n                          [class]=\"getIconOrderBy('aberto')\"></em>&nbsp;Status</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('paciente.nomeCompleto')\"><em\r\n                          [class]=\"getIconOrderBy('paciente.nomeCompleto')\"></em>&nbsp;Paciente</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('usuario.nomeCompleto')\"><em\r\n                          [class]=\"getIconOrderBy('usuario.nomeCompleto')\"></em>&nbsp;Usuário</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('preAtendimento.data')\"><em\r\n                          [class]=\"getIconOrderBy('preAtendimento.data')\"></em>&nbsp;Data e Hora do Pré-atendimento</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('posAtendimento.data')\"><em\r\n                          [class]=\"getIconOrderBy('posAtendimento.data')\"></em>&nbsp;Data e Hora do Pós-atendimento</th>\r\n                      <th>Tempo de Atendimento</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('tipoAtendimento.descricao')\"><em\r\n                          [class]=\"getIconOrderBy('tipoAtendimento.descricao')\"></em>&nbsp;Tipo de\r\n                        Atendimento</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('pacote.numero')\"><em\r\n                          [class]=\"getIconOrderBy('pacote.numero')\"></em>&nbsp;Número do Pacote</th>\r\n                      <th style=\"cursor: pointer\" (click)=\"onClickOrderBy('numero')\"><em\r\n                          [class]=\"getIconOrderBy('numero')\"></em>&nbsp;Número da Sessão</th>\r\n                    </tr>\r\n                  </thead>\r\n                  <tbody>\r\n                    <tr *ngFor=\"let atendimento of dados?.content\">\r\n                      <td>\r\n                        <button title=\"Editar\" (click)=\"onClickEditar(atendimento.id)\" class=\"btn btn-primary\"><em\r\n                            class=\"fa fa-pencil\"></em></button>\r\n                        <button title=\"Visualizar\" (click)=\"onClickOpenModalVisualizar(atendimento)\"\r\n                          class=\"btn btn-primary btn-left\"><em class=\"fa fa-eye\"></em></button>\r\n                        <button title=\"Gerenciar Lançamentos\" *ngIf=\"isSessao(atendimento.tipoAtendimentoId)\"\r\n                          (click)=\"onClickOpenModalGerenciarLancamentoSessao(atendimento.id)\"\r\n                          class=\"btn btn-success btn-left\"><em class=\"fa fa-usd\"></em></button>\r\n                        <button title=\"Gerenciar Lançamentos\" *ngIf=\"isPacote(atendimento.tipoAtendimentoId)\"\r\n                          (click)=\"onClickOpenModalGerenciarLancamentoPacote(atendimento.pacoteId)\"\r\n                          class=\"btn btn-success btn-left\"><em class=\"fa fa-usd\"></em></button>\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento.pacoteValor ? (atendimento.pacoteValor | currency:'BRL':'symbol':'0.2-2':'pt') : '-' }}\r\n                      </td>\r\n                      <td [ngStyle]=\"{'color': !atendimento.totalPago ? 'red' : 'green', 'font-weight': 'bold'}\"\r\n                        *ngIf=\"isSessao(atendimento.tipoAtendimentoId)\">\r\n                        {{ atendimento.totalPago || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td [ngStyle]=\"{'color': atendimento.pacoteTotalPago < atendimento.pacoteValor ? 'red' : 'green', 'font-weight': 'bold'}\"\r\n                        *ngIf=\"isPacote(atendimento.tipoAtendimentoId)\">\r\n                        {{ atendimento.pacoteTotalPago || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <td *ngIf=\"isPacote(atendimento.tipoAtendimentoId); else elseTotalPagar\">\r\n                        {{ atendimento.pacoteValor - atendimento.pacoteTotalPago || 0 | currency:'BRL':'symbol':'0.2-2':'pt' }}\r\n                      </td>\r\n                      <ng-template #elseTotalPagar>\r\n                        <td>\r\n                          {{ '-' }}\r\n                        </td>\r\n                      </ng-template>\r\n                      <td [ngStyle]=\"{'color': atendimento.aberto ? 'red' : 'green', 'font-weight': 'bold'}\">\r\n                        {{ atendimento.aberto ? 'Em Aberto' : 'Encerrado' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento.pacienteNomeCompleto }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento.usuarioNomeCompleto }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento.preAtendimentoData | date: 'dd/MM/yyyy HH:mm' }}\r\n                      </td>\r\n                      <td *ngIf=\"atendimento?.posAtendimentoData\">\r\n                        {{ atendimento?.posAtendimentoData | date: 'dd/MM/yyyy HH:mm' }}\r\n                      </td>\r\n                      <td *ngIf=\"!atendimento?.posAtendimentoData\">\r\n                        {{ '-' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ calcularTempo(atendimento.preAtendimentoData, atendimento?.posAtendimentoData) }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento?.tipoAtendimentoDescricao }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento?.pacoteNumero || '-' }}\r\n                      </td>\r\n                      <td>\r\n                        {{ atendimento.numero}}\r\n                      </td>\r\n                    </tr>\r\n                  </tbody>\r\n                </table>\r\n              </div>\r\n            </div>\r\n            <div class=\"box-footer\">\r\n              <app-page-action [dados]=\"dados\" [filtro]=\"filtro\" (searchByFilter)=\"searchByFilter()\">\r\n              </app-page-action>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <app-no-records *ngIf=\"showNoRecords && !dados.content?.length\"></app-no-records>\r\n      </div>\r\n    </div>\r\n  </form>\r\n</section>\r\n");

/***/ }),

/***/ "./src/app/components/atendimento/atendimento-routing.module.ts":
/*!**********************************************************************!*\
  !*** ./src/app/components/atendimento/atendimento-routing.module.ts ***!
  \**********************************************************************/
/*! exports provided: AtendimentoRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoRoutingModule", function() { return AtendimentoRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./form/atendimento-form.component */ "./src/app/components/atendimento/form/atendimento-form.component.ts");
/* harmony import */ var _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./list/atendimento-list.component */ "./src/app/components/atendimento/list/atendimento-list.component.ts");
/* harmony import */ var _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./resolver/atendimento-form.resolver */ "./src/app/components/atendimento/resolver/atendimento-form.resolver.ts");
/* harmony import */ var _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./resolver/atendimento-list.resolver */ "./src/app/components/atendimento/resolver/atendimento-list.resolver.ts");







var routes = [
    {
        path: 'drenagem',
        component: _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__["AtendimentoListComponent"],
        data: {
            id: 1,
            descricao: 'Drenagem Linfática',
            rota: 'drenagem'
        },
        resolve: {
            resolve: _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
        },
    },
    {
        path: 'drenagem/incluir',
        data: {
            id: 1,
            descricao: 'Drenagem Linfática',
            rota: 'drenagem'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'drenagem/alterar/:id',
        data: {
            id: 1,
            descricao: 'Drenagem Linfática',
            rota: 'drenagem'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'fisioterapia',
        data: {
            id: 2,
            descricao: 'Fisioterapia',
            rota: 'fisioterapia'
        },
        resolve: {
            resolve: _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
        },
        component: _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__["AtendimentoListComponent"]
    },
    {
        path: 'fisioterapia/incluir',
        data: {
            id: 2,
            descricao: 'Fisioterapia',
            rota: 'fisioterapia'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'fisioterapia/alterar/:id',
        data: {
            id: 2,
            descricao: 'Fisioterapia',
            rota: 'fisioterapia'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'rpg',
        data: {
            id: 3,
            descricao: 'Reeducação Postural Global',
            rota: 'rpg'
        },
        resolve: {
            resolve: _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
        },
        component: _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__["AtendimentoListComponent"]
    },
    {
        path: 'rpg/incluir',
        data: {
            id: 3,
            descricao: 'Reeducação Postural Global',
            rota: 'rpg'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'rpg/alterar/:id',
        data: {
            id: 3,
            descricao: 'Reeducação Postural Global',
            rota: 'rpg'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'pilates',
        data: {
            id: 4,
            descricao: 'Pilates',
            rota: 'pilates'
        },
        resolve: {
            resolve: _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
        },
        component: _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__["AtendimentoListComponent"]
    },
    {
        path: 'pilates/incluir',
        data: {
            id: 4,
            descricao: 'Pilates',
            rota: 'pilates'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'pilates/alterar/:id',
        data: {
            id: 4,
            descricao: 'Pilates',
            rota: 'pilates'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'massagem-relaxante',
        data: {
            id: 5,
            descricao: 'Massagem Relaxante',
            rota: 'massagem-relaxante'
        },
        resolve: {
            resolve: _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
        },
        component: _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_4__["AtendimentoListComponent"]
    },
    {
        path: 'massagem-relaxante/incluir',
        data: {
            id: 5,
            descricao: 'Massagem Relaxante',
            rota: 'massagem-relaxante'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    },
    {
        path: 'massagem-relaxante/alterar/:id',
        data: {
            id: 5,
            descricao: 'Massagem Relaxante',
            rota: 'massagem-relaxante'
        },
        resolve: {
            resolve: _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"]
        },
        component: _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_3__["AtendimentoFormComponent"]
    }
];
var AtendimentoRoutingModule = /** @class */ (function () {
    function AtendimentoRoutingModule() {
    }
    AtendimentoRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
            providers: [
                _resolver_atendimento_form_resolver__WEBPACK_IMPORTED_MODULE_5__["AtendimentoFormResolver"],
                _resolver_atendimento_list_resolver__WEBPACK_IMPORTED_MODULE_6__["AtendimentoListResolver"]
            ]
        })
    ], AtendimentoRoutingModule);
    return AtendimentoRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/atendimento/atendimento.module.ts":
/*!**************************************************************!*\
  !*** ./src/app/components/atendimento/atendimento.module.ts ***!
  \**************************************************************/
/*! exports provided: AtendimentoModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoModule", function() { return AtendimentoModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/shared.module */ "./src/app/shared/shared.module.ts");
/* harmony import */ var _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../sisms-commons.module */ "./src/app/components/sisms-commons.module.ts");
/* harmony import */ var _atendimento_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./atendimento-routing.module */ "./src/app/components/atendimento/atendimento-routing.module.ts");
/* harmony import */ var _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./form/atendimento-form.component */ "./src/app/components/atendimento/form/atendimento-form.component.ts");
/* harmony import */ var _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./list/atendimento-list.component */ "./src/app/components/atendimento/list/atendimento-list.component.ts");








var AtendimentoModule = /** @class */ (function () {
    function AtendimentoModule() {
    }
    AtendimentoModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _list_atendimento_list_component__WEBPACK_IMPORTED_MODULE_7__["AtendimentoListComponent"],
                _form_atendimento_form_component__WEBPACK_IMPORTED_MODULE_6__["AtendimentoFormComponent"]
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _atendimento_routing_module__WEBPACK_IMPORTED_MODULE_5__["AtendimentoRoutingModule"],
                _sisms_commons_module__WEBPACK_IMPORTED_MODULE_4__["SismsCommonsModule"],
                src_app_shared_shared_module__WEBPACK_IMPORTED_MODULE_3__["SharedModule"]
            ]
        })
    ], AtendimentoModule);
    return AtendimentoModule;
}());



/***/ }),

/***/ "./src/app/components/atendimento/form/atendimento-form.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/components/atendimento/form/atendimento-form.component.ts ***!
  \***************************************************************************/
/*! exports provided: AtendimentoFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoFormComponent", function() { return AtendimentoFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var blob_util__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! blob-util */ "./node_modules/blob-util/dist/blob-util.es.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var ngx_spinner__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ngx-spinner */ "./node_modules/ngx-spinner/fesm5/ngx-spinner.js");
/* harmony import */ var resize_base64__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! resize-base64 */ "./node_modules/resize-base64/index.js");
/* harmony import */ var src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/core/model/enum/categoria-atendimento.enum */ "./src/app/core/model/enum/categoria-atendimento.enum.ts");
/* harmony import */ var src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/core/model/enum/tipo-atendimento.enum */ "./src/app/core/model/enum/tipo-atendimento.enum.ts");
/* harmony import */ var src_app_core_model_model_categoria_atendimento_routing_model__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/core/model/model/categoria-atendimento-routing.model */ "./src/app/core/model/model/categoria-atendimento-routing.model.ts");
/* harmony import */ var src_app_core_model_model_pacote_model__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! src/app/core/model/model/pacote.model */ "./src/app/core/model/model/pacote.model.ts");
/* harmony import */ var src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! src/app/core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! src/app/core/services/outra-medida.service */ "./src/app/core/services/outra-medida.service.ts");
/* harmony import */ var src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! src/app/core/services/pacote.service */ "./src/app/core/services/pacote.service.ts");
/* harmony import */ var src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! src/app/shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var src_app_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! src/app/shared/modais/modal-confirmacao/modal-confirmacao.component */ "./src/app/shared/modais/modal-confirmacao/modal-confirmacao.component.ts");
/* harmony import */ var src_app_shared_modais_modal_criar_pacote_modal_criar_pacote_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! src/app/shared/modais/modal-criar-pacote/modal-criar-pacote.component */ "./src/app/shared/modais/modal-criar-pacote/modal-criar-pacote.component.ts");
/* harmony import */ var src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! src/app/shared/util/util */ "./src/app/shared/util/util.ts");
/* harmony import */ var _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../../core/services/atendimento.service */ "./src/app/core/services/atendimento.service.ts");




















var AtendimentoFormComponent = /** @class */ (function () {
    function AtendimentoFormComponent(formBuilder, pacotService, service, route, messageService, router, spinnerService, modalService, outraMedidaService) {
        var _this = this;
        this.formBuilder = formBuilder;
        this.pacotService = pacotService;
        this.service = service;
        this.route = route;
        this.messageService = messageService;
        this.router = router;
        this.spinnerService = spinnerService;
        this.modalService = modalService;
        this.outraMedidaService = outraMedidaService;
        this.tiposAtendimento = new Array();
        this.pacientes = new Array();
        this.outrasMedidas = new Array();
        this.outrasMedidasSelecionadas = new Array();
        this.tipoAtendimentoId = src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoEnum"].SESSAO;
        this.categoriaAtendimentoRouting = new src_app_core_model_model_categoria_atendimento_routing_model__WEBPACK_IMPORTED_MODULE_10__["CategoriaAtendimentoRouting"]();
        this.pacote = new src_app_core_model_model_pacote_model__WEBPACK_IMPORTED_MODULE_11__["Pacote"]();
        this.quantidadeSessao = 0;
        this.isCadastrarPosAtendimento = false;
        this.isInvalidForm = false;
        this.isInvalidFormPacienteId = false;
        this.isInvalidFormOutraMedidaDescricao = false;
        this.subscription = this.outraMedidaService.getOutrasMedidas().subscribe(function () {
            _this.onRefreshComboOutraMedida();
        });
    }
    AtendimentoFormComponent.prototype.ngOnDestroy = function () {
        this.subscription.unsubscribe();
    };
    AtendimentoFormComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCategoriaAtendimento();
        this.findById();
        this.onLoadCombos();
    };
    AtendimentoFormComponent.prototype.checkTipoAtendimentoPacote = function () {
        return this.tipoAtendimentoId === src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoEnum"].PACOTE;
    };
    AtendimentoFormComponent.prototype.checkCategoriaAtendimentoFisioterapia = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].FISIOTERAPIA;
    };
    AtendimentoFormComponent.prototype.checkCategoriaAtendimentoRPG = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].RPG;
    };
    AtendimentoFormComponent.prototype.checkCategoriaAtendimentoPilates = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].PILATES;
    };
    AtendimentoFormComponent.prototype.checkCategoriaAtendimentoMassagem = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].MASSAGEM_RELAXANTE;
    };
    Object.defineProperty(AtendimentoFormComponent.prototype, "isNotMassagem", {
        get: function () {
            return this.categoriaAtendimentoRouting.id !== src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].MASSAGEM_RELAXANTE;
        },
        enumerable: true,
        configurable: true
    });
    AtendimentoFormComponent.prototype.findById = function () {
        var _this = this;
        this.route.data.subscribe(function (dados) {
            var response = dados.resolve.atendimento;
            if (!response.result) {
                return;
            }
            _this.form.setValue({
                id: response.result.id,
                pacoteId: response.result.pacoteId || null,
                pacienteId: response.result.pacienteId,
                preAtendimentoId: response.result.preAtendimentoId,
                preAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].convertDateTimeToString(new Date(response.result.preAtendimentoData)),
                preAtendimentoPressaoArterial: response.result.preAtendimentoPressaoArterial || null,
                preAtendimentoPeso: response.result.preAtendimentoPeso || 0,
                preAtendimentoSupraUmbilical: response.result.preAtendimentoSupraUmbilical || 0,
                preAtendimentoLinhaUmbilical: response.result.preAtendimentoLinhaUmbilical || 0,
                preAtendimentoInfraUmbilical: response.result.preAtendimentoInfraUmbilical || 0,
                preAtendimentoObservacao: response.result.preAtendimentoObservacao || null,
                preAtendimentoOutrasMedidas: [],
                posAtendimentoId: response.result.posAtendimentoId || null,
                posAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].convertDateTimeToString(response.result.posAtendimentoData ? new Date(response.result.posAtendimentoData) : null),
                posAtendimentoPressaoArterial: response.result.posAtendimentoPressaoArterial || null,
                posAtendimentoPeso: response.result.posAtendimentoPeso || 0,
                posAtendimentoSupraUmbilical: response.result.posAtendimentoSupraUmbilical || 0,
                posAtendimentoLinhaUmbilical: response.result.posAtendimentoLinhaUmbilical || 0,
                posAtendimentoInfraUmbilical: response.result.posAtendimentoInfraUmbilical || 0,
                posAtendimentoObservacao: response.result.posAtendimentoObservacao || null,
                posAtendimentoOutrasMedidas: [],
                categoriaAtendimentoId: response.result.categoriaAtendimentoId,
                imagens: response.result.imagens || [],
                aberto: response.result.aberto,
                conduta: response.result.conduta || null,
            });
            _this.form.controls.pacienteId.disable();
            _this.form.controls.pacienteId.updateValueAndValidity();
            _this.isCadastrarPosAtendimento = true;
            if (_this.form.controls.imagens.value) {
                _this.form.controls.imagens.value.forEach(function (element) {
                    element.index = _this.gerarIndex(_this.form.controls.imagens.value);
                });
            }
            var listaPre = response.result.preAtendimentoOutrasMedidas;
            var listaPos = response.result.posAtendimentoOutrasMedidas;
            for (var i = 0; i < listaPre.length; i++) {
                _this.outrasMedidasSelecionadas.push({
                    index: _this.gerarIndex(_this.outrasMedidasSelecionadas),
                    outraMedidaId: listaPre[i].outraMedidaId,
                    valorPre: listaPre[i].valor,
                    valorPos: listaPos ? listaPos[i].valor : 0,
                });
            }
            _this.quantidadeSessao = response.result.numero;
            if (_this.form.value.pacoteId) {
                _this.tipoAtendimentoId = src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoEnum"].PACOTE;
                _this.pacotService.findById(_this.form.value.pacoteId).subscribe(function (packageResponse) {
                    _this.pacote = packageResponse.result;
                });
            }
        });
    };
    AtendimentoFormComponent.prototype.onClickCancelar = function () {
        this.messageService.clearAllMessages();
        window.history.back();
    };
    AtendimentoFormComponent.prototype.onClickDownloadFile = function (index) {
        this.messageService.clearAllMessages();
        this.spinnerService.show();
        try {
            var imagem = this.form.controls.imagens.value.find(function (x) { return x.index === index; });
            var array = imagem.imagem.toString().split(';base64,');
            var blob = Object(blob_util__WEBPACK_IMPORTED_MODULE_4__["base64StringToBlob"])(array[array.length - 1]);
            var elemento = document.createElement('a');
            elemento.href = window.URL.createObjectURL(blob);
            elemento.download = imagem.nome;
            elemento.click();
            elemento.remove();
            this.spinnerService.hide();
        }
        catch (_a) {
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0011);
            this.spinnerService.hide();
        }
    };
    AtendimentoFormComponent.prototype.onLoadCategoriaAtendimento = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.categoriaAtendimentoRouting = response;
            _this.form.controls.categoriaAtendimentoId.setValue(response.id);
        });
    };
    AtendimentoFormComponent.prototype.onLoadCombos = function () {
        var _this = this;
        this.route.data.subscribe(function (responseData) {
            responseData.resolve.combos.subscribe(function (responseComo) {
                _this.pacientes = responseComo[0].result;
                _this.outrasMedidas = responseComo[1].result;
                _this.tiposAtendimento = responseComo[2].result;
            });
        });
    };
    AtendimentoFormComponent.prototype.onRefreshComboOutraMedida = function () {
        var _this = this;
        this.outraMedidaService.findAll().subscribe(function (response) {
            _this.outrasMedidas = response.result;
        });
    };
    AtendimentoFormComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            id: [null],
            pacoteId: [null],
            pacienteId: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            preAtendimentoId: [null],
            preAtendimentoData: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            preAtendimentoPressaoArterial: [null],
            preAtendimentoPeso: [0],
            preAtendimentoSupraUmbilical: [0],
            preAtendimentoLinhaUmbilical: [0],
            preAtendimentoInfraUmbilical: [0],
            preAtendimentoObservacao: [null],
            preAtendimentoOutrasMedidas: [[]],
            posAtendimentoId: [null],
            posAtendimentoData: [null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            posAtendimentoPressaoArterial: [null],
            posAtendimentoPeso: [0],
            posAtendimentoSupraUmbilical: [0],
            posAtendimentoLinhaUmbilical: [0],
            posAtendimentoInfraUmbilical: [0],
            posAtendimentoObservacao: [null],
            posAtendimentoOutrasMedidas: [[]],
            categoriaAtendimentoId: [null],
            imagens: [[]],
            aberto: [true],
            conduta: [null],
        });
    };
    AtendimentoFormComponent.prototype.setDataHoraAtual = function (field) {
        if (!this.form.controls[field].value) {
            this.form.controls[field].setValue(src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].convertDateTimeToString(new Date()));
        }
    };
    AtendimentoFormComponent.prototype.onChangeTipoAtendimento = function () {
        this.messageService.clearAllMessages();
        this.onResetValues();
    };
    AtendimentoFormComponent.prototype.getNomePaciente = function (id) {
        return this.pacientes.find(function (x) { return x.id === id; }).nomeCompleto;
    };
    AtendimentoFormComponent.prototype.onChangePaciente = function () {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var pacienteId, pacienteNomeCompleto, modalRef, pacienteNomeCompleto, modalRef;
            var _this = this;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        pacienteId = this.form.controls.pacienteId.value;
                        this.onResetValues();
                        if (pacienteId) {
                            this.isInvalidFormPacienteId = false;
                            this.form.controls.pacienteId.setValue(pacienteId);
                        }
                        else {
                            this.isInvalidFormPacienteId = true;
                        }
                        if (!(pacienteId && this.tipoAtendimentoId === src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoEnum"].SESSAO)) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.service.findTotalBySession(pacienteId, this.categoriaAtendimentoRouting.id).toPromise().then(function (response) {
                                _this.quantidadeSessao = response.result + 1;
                            })];
                    case 1:
                        _a.sent();
                        return [3 /*break*/, 4];
                    case 2:
                        if (!(pacienteId && this.tipoAtendimentoId === src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoEnum"].PACOTE)) return [3 /*break*/, 4];
                        return [4 /*yield*/, this.pacotService.findLastOpen(this.categoriaAtendimentoRouting.id, pacienteId).toPromise().then(function (response) {
                                _this.pacote = response.result;
                            })];
                    case 3:
                        _a.sent();
                        if (!this.pacote) {
                            pacienteNomeCompleto = this.getNomePaciente(pacienteId);
                            modalRef = this.modalService.show(src_app_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_16__["ModalConfirmacaoComponent"], { backdrop: 'static' });
                            modalRef.content.titulo = 'Confirmação de Criação de Pacote';
                            modalRef.content.corpo = "N\u00E3o existe pacote de " + this.categoriaAtendimentoRouting.descricao + " em aberto para o paciente " + pacienteNomeCompleto + ". Deseja criar agora?";
                            modalRef.content.onClose.subscribe(function (result) {
                                if (result) {
                                    _this.onOpenModalCriarPacote(true);
                                }
                                else {
                                    _this.onResetValues();
                                }
                            });
                        }
                        else {
                            if (this.pacote.quantidadeSessao === this.pacote.quantidadeAtendimentos) {
                                pacienteNomeCompleto = this.getNomePaciente(pacienteId);
                                modalRef = this.modalService.show(src_app_shared_modais_modal_confirmacao_modal_confirmacao_component__WEBPACK_IMPORTED_MODULE_16__["ModalConfirmacaoComponent"], { backdrop: 'static' });
                                modalRef.content.titulo = 'Aviso de Limite de Atendimentos';
                                modalRef.content.corpo = "O limite de atendimentos para este pacote j\u00E1 foi atingido (" + this.pacote.quantidadeAtendimentos + "/" + this.pacote.quantidadeSessao + "). Crie um novo pacote ou altere o pacote atual. Criar novo pacote?";
                                modalRef.content.onClose.subscribe(function (result) {
                                    if (result) {
                                        _this.onOpenModalCriarPacote(true);
                                    }
                                    else {
                                        _this.onResetValues();
                                    }
                                });
                            }
                            this.form.controls.pacoteId.setValue(this.pacote.id);
                            this.quantidadeSessao = this.pacote.quantidadeAtendimentos + 1;
                        }
                        _a.label = 4;
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    AtendimentoFormComponent.prototype.onOpenModalCriarPacote = function (isResetValues) {
        var _this = this;
        var pacienteId = this.form.controls.pacienteId.value;
        var pacienteNomeCompleto = this.getNomePaciente(pacienteId);
        var initialState = {
            dados: {
                pacienteId: pacienteId,
                pacienteNomeCompleto: pacienteNomeCompleto,
                categoriaAtendimentoId: this.categoriaAtendimentoRouting.id,
                categoriaAtendimentoDescricao: this.categoriaAtendimentoRouting.descricao
            }
        };
        var modalRefPackage = this.modalService.show(src_app_shared_modais_modal_criar_pacote_modal_criar_pacote_component__WEBPACK_IMPORTED_MODULE_17__["ModalCriarPacoteComponent"], { class: 'gray modal-lg', initialState: initialState, backdrop: 'static' });
        modalRefPackage.content.onClose.subscribe(function (result) {
            if (result) {
                _this.pacotService.findLastOpen(_this.categoriaAtendimentoRouting.id, pacienteId).subscribe(function (response) {
                    _this.pacote = response.result;
                    _this.form.controls.pacoteId.setValue(_this.pacote.id);
                    _this.quantidadeSessao = response.result.quantidadeAtendimentos + 1;
                });
            }
            else {
                if (isResetValues) {
                    _this.onResetValues();
                }
            }
        });
    };
    AtendimentoFormComponent.prototype.onResetValues = function () {
        this.onCreateForm();
        this.form.controls.categoriaAtendimentoId.setValue(this.categoriaAtendimentoRouting.id);
        this.outrasMedidasSelecionadas = new Array();
        this.quantidadeSessao = 0;
        this.pacote = new src_app_core_model_model_pacote_model__WEBPACK_IMPORTED_MODULE_11__["Pacote"]();
        this.isCadastrarPosAtendimento = false;
        this.isInvalidFormPacienteId = false;
        this.isInvalidForm = false;
    };
    AtendimentoFormComponent.prototype.onClickAdicionarMedida = function () {
        if (this.outrasMedidasSelecionadas.length < 10) {
            this.outrasMedidasSelecionadas.push({
                index: this.gerarIndex(this.outrasMedidasSelecionadas),
                outraMedidaId: null,
                valorPre: 0,
                valorPos: 0
            });
        }
        else {
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0025);
        }
    };
    AtendimentoFormComponent.prototype.onClickRemoverOutraMedida = function (index) {
        var result = this.outrasMedidasSelecionadas.findIndex(function (x) { return x.index === index; });
        if (result !== -1) {
            this.outrasMedidasSelecionadas.splice(result, 1);
        }
    };
    AtendimentoFormComponent.prototype.onChangeImage = function (images) {
        var e_1, _a;
        var _this = this;
        this.messageService.clearAllMessages();
        if (this.form.value.imagens.length + images.length > 10) {
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0024);
            return;
        }
        if (images && images.length) {
            try {
                if (!this.validarFormatoImagem(images)) {
                    this.messageService.sendMessageError(images.length > 1 ? src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0021 : src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0020);
                    return;
                }
                if (!this.validarTamanhoImagem(images)) {
                    this.messageService.sendMessageError(images.length > 1 ? src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0023 : src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0022);
                    return;
                }
                var _loop_1 = function (image) {
                    var reader = new FileReader();
                    reader.readAsDataURL(image);
                    reader.onload = function () {
                        _this.spinnerService.show();
                        Object(resize_base64__WEBPACK_IMPORTED_MODULE_7__["resizeBase64ForMaxWidthAndMaxHeight"])(reader.result, 1024, 768, function (resizedImage) {
                            _this.form.value.imagens.push({
                                index: _this.gerarIndex(_this.form.value.imagens),
                                nome: image.name,
                                imagem: resizedImage,
                                observacao: null
                            });
                            _this.spinnerService.hide();
                        });
                    };
                };
                try {
                    for (var images_1 = tslib__WEBPACK_IMPORTED_MODULE_0__["__values"](images), images_1_1 = images_1.next(); !images_1_1.done; images_1_1 = images_1.next()) {
                        var image = images_1_1.value;
                        _loop_1(image);
                    }
                }
                catch (e_1_1) { e_1 = { error: e_1_1 }; }
                finally {
                    try {
                        if (images_1_1 && !images_1_1.done && (_a = images_1.return)) _a.call(images_1);
                    }
                    finally { if (e_1) throw e_1.error; }
                }
            }
            catch (_b) {
                this.messageService.sendMessageError(images.length > 1 ? src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0012 : src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0011);
                this.spinnerService.hide();
            }
        }
    };
    AtendimentoFormComponent.prototype.gerarIndex = function (lista) {
        var _loop_2 = function () {
            var index = Math.floor((Math.random() * 100) + 1);
            if (!lista.find(function (x) { return x.index === index; })) {
                return { value: index };
            }
        };
        while (true) {
            var state_1 = _loop_2();
            if (typeof state_1 === "object")
                return state_1.value;
        }
    };
    AtendimentoFormComponent.prototype.validarFormatoImagem = function (imagens) {
        var e_2, _a;
        try {
            for (var imagens_1 = tslib__WEBPACK_IMPORTED_MODULE_0__["__values"](imagens), imagens_1_1 = imagens_1.next(); !imagens_1_1.done; imagens_1_1 = imagens_1.next()) {
                var image = imagens_1_1.value;
                if (!src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].isFormatoImagemValido(image)) {
                    return false;
                }
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (imagens_1_1 && !imagens_1_1.done && (_a = imagens_1.return)) _a.call(imagens_1);
            }
            finally { if (e_2) throw e_2.error; }
        }
        return true;
    };
    AtendimentoFormComponent.prototype.validarTamanhoImagem = function (imagens) {
        var e_3, _a;
        try {
            for (var imagens_2 = tslib__WEBPACK_IMPORTED_MODULE_0__["__values"](imagens), imagens_2_1 = imagens_2.next(); !imagens_2_1.done; imagens_2_1 = imagens_2.next()) {
                var image = imagens_2_1.value;
                if (!src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].isTamanhoArquivoValido(image)) {
                    return false;
                }
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (imagens_2_1 && !imagens_2_1.done && (_a = imagens_2.return)) _a.call(imagens_2);
            }
            finally { if (e_3) throw e_3.error; }
        }
        return true;
    };
    AtendimentoFormComponent.prototype.onClickRemoverImagem = function (index) {
        var result = this.form.value.imagens.findIndex(function (x) { return x.index === index; });
        if (result !== -1) {
            this.form.value.imagens.splice(result, 1);
        }
    };
    AtendimentoFormComponent.prototype.removerValidacao = function () {
        if (!this.isCadastrarPosAtendimento) {
            this.form.controls.posAtendimentoData.setValidators([]);
            this.form.controls.posAtendimentoData.updateValueAndValidity();
        }
    };
    AtendimentoFormComponent.prototype.onClickFormSubmit = function () {
        var e_4, _a;
        var _this = this;
        this.messageService.clearAllMessages();
        this.removerValidacao();
        if (this.form.valid) {
            var preAtendimentoData = this.form.value.preAtendimentoData;
            var posAtendimentoData = this.form.value.posAtendimentoData;
            if (preAtendimentoData && !src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].isDataHoraValida(preAtendimentoData)) {
                this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0016);
                return;
            }
            if (posAtendimentoData && !src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].isDataHoraValida(posAtendimentoData)) {
                this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0017);
                return;
            }
            this.form.value.preAtendimentoOutrasMedidas = [];
            this.form.value.posAtendimentoOutrasMedidas = [];
            if (this.outrasMedidasSelecionadas.length) {
                try {
                    for (var _b = tslib__WEBPACK_IMPORTED_MODULE_0__["__values"](this.outrasMedidasSelecionadas), _c = _b.next(); !_c.done; _c = _b.next()) {
                        var item = _c.value;
                        if (!item.outraMedidaId) {
                            this.showErrorInvalidForm();
                            return;
                        }
                        this.form.value.preAtendimentoOutrasMedidas.push({
                            outraMedidaId: item.outraMedidaId,
                            valor: item.valorPre
                        });
                        if (this.isCadastrarPosAtendimento) {
                            this.form.value.posAtendimentoOutrasMedidas.push({
                                outraMedidaId: item.outraMedidaId,
                                valor: item.valorPos
                            });
                        }
                    }
                }
                catch (e_4_1) { e_4 = { error: e_4_1 }; }
                finally {
                    try {
                        if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                    }
                    finally { if (e_4) throw e_4.error; }
                }
            }
            var formValue = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { pacienteId: this.form.controls.pacienteId.value, aberto: !this.isCadastrarPosAtendimento, preAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].convertStringToDateTime(preAtendimentoData), posAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_18__["default"].convertStringToDateTime(posAtendimentoData) });
            if (formValue.id) {
                this.service.update(formValue.id, formValue).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.router.navigate(["/atendimento/" + _this.categoriaAtendimentoRouting.rota]);
                });
            }
            else {
                this.service.create(formValue).subscribe(function (response) {
                    _this.messageService.sendMessageSuccess(response.message);
                    _this.router.navigate(["/atendimento/" + _this.categoriaAtendimentoRouting.rota]);
                });
            }
        }
        else {
            this.showErrorInvalidForm();
        }
    };
    AtendimentoFormComponent.prototype.showErrorInvalidForm = function () {
        this.isInvalidForm = true;
        this.isInvalidFormOutraMedidaDescricao = true;
        this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0004);
    };
    AtendimentoFormComponent.prototype.isDrenagem = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].DRENAGEM_LINFATICA;
    };
    AtendimentoFormComponent.prototype.isFisioterapia = function () {
        return this.categoriaAtendimentoRouting.id === src_app_core_model_enum_categoria_atendimento_enum__WEBPACK_IMPORTED_MODULE_8__["CategoriaAtendimentoEnum"].FISIOTERAPIA;
    };
    AtendimentoFormComponent.prototype.showDadosPacote = function () {
        return this.form.controls.pacienteId.value && this.checkTipoAtendimentoPacote() && this.pacote.id ? true : false;
    };
    AtendimentoFormComponent.ctorParameters = function () { return [
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__["PacoteService"] },
        { type: _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__["AtendimentoService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] },
        { type: src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: ngx_spinner__WEBPACK_IMPORTED_MODULE_6__["NgxSpinnerService"] },
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_5__["BsModalService"] },
        { type: src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_13__["OutraMedidaService"] }
    ]; };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('inputImage', { static: false }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], AtendimentoFormComponent.prototype, "inputImage", void 0);
    AtendimentoFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-atendimento-form',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./atendimento-form.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/form/atendimento-form.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_14__["PacoteService"],
            _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__["AtendimentoService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            ngx_spinner__WEBPACK_IMPORTED_MODULE_6__["NgxSpinnerService"],
            ngx_bootstrap__WEBPACK_IMPORTED_MODULE_5__["BsModalService"],
            src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_13__["OutraMedidaService"]])
    ], AtendimentoFormComponent);
    return AtendimentoFormComponent;
}());



/***/ }),

/***/ "./src/app/components/atendimento/list/atendimento-list.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/components/atendimento/list/atendimento-list.component.ts ***!
  \***************************************************************************/
/*! exports provided: AtendimentoListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoListComponent", function() { return AtendimentoListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-bootstrap */ "./node_modules/ngx-bootstrap/esm5/ngx-bootstrap.js");
/* harmony import */ var src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/guards/auth.guard */ "./src/app/core/guards/auth.guard.ts");
/* harmony import */ var src_app_core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/model/enum/perfil.enum */ "./src/app/core/model/enum/perfil.enum.ts");
/* harmony import */ var src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/model/enum/tipo-atendimento.enum */ "./src/app/core/model/enum/tipo-atendimento.enum.ts");
/* harmony import */ var src_app_core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/core/model/filter/filter.filter */ "./src/app/core/model/filter/filter.filter.ts");
/* harmony import */ var src_app_core_model_model_categoria_atendimento_routing_model__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/core/model/model/categoria-atendimento-routing.model */ "./src/app/core/model/model/categoria-atendimento-routing.model.ts");
/* harmony import */ var src_app_core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/core/model/model/usuario.model */ "./src/app/core/model/model/usuario.model.ts");
/* harmony import */ var src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! src/app/core/services/lancamento.service */ "./src/app/core/services/lancamento.service.ts");
/* harmony import */ var src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! src/app/core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! src/app/core/services/pacote.service */ "./src/app/core/services/pacote.service.ts");
/* harmony import */ var src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! src/app/shared/components/pagination/pagination */ "./src/app/shared/components/pagination/pagination.ts");
/* harmony import */ var src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! src/app/shared/messages/messages */ "./src/app/shared/messages/messages.ts");
/* harmony import */ var src_app_shared_modais_modal_visualizar_atendimento_modal_visualizar_atendimento_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! src/app/shared/modais/modal-visualizar-atendimento/modal-visualizar-atendimento.component */ "./src/app/shared/modais/modal-visualizar-atendimento/modal-visualizar-atendimento.component.ts");
/* harmony import */ var src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! src/app/shared/util/util */ "./src/app/shared/util/util.ts");
/* harmony import */ var _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../core/model/model/page.model */ "./src/app/core/model/model/page.model.ts");
/* harmony import */ var _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../../core/services/atendimento.service */ "./src/app/core/services/atendimento.service.ts");
/* harmony import */ var _controle_caixa_modal_gerenciar_lancamento_pacote_modal_gerenciar_lancamento_pacote_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ../../controle-caixa/modal/gerenciar-lancamento-pacote/modal-gerenciar-lancamento-pacote.component */ "./src/app/components/controle-caixa/modal/gerenciar-lancamento-pacote/modal-gerenciar-lancamento-pacote.component.ts");
/* harmony import */ var _controle_caixa_modal_gerenciar_lancamento_sessao_modal_gerenciar_lancamento_sessao_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ../../controle-caixa/modal/gerenciar-lancamento-sessao/modal-gerenciar-lancamento-sessao.component */ "./src/app/components/controle-caixa/modal/gerenciar-lancamento-sessao/modal-gerenciar-lancamento-sessao.component.ts");






















var AtendimentoListComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](AtendimentoListComponent, _super);
    function AtendimentoListComponent(formBuilder, service, messageService, route, pacoteService, router, authGuardService, modalService, lancamentoService) {
        var _this = _super.call(this, messageService) || this;
        _this.formBuilder = formBuilder;
        _this.service = service;
        _this.route = route;
        _this.pacoteService = pacoteService;
        _this.router = router;
        _this.authGuardService = authGuardService;
        _this.modalService = modalService;
        _this.lancamentoService = lancamentoService;
        _this.pacientes = new Array();
        _this.usuarios = new Array();
        _this.tiposAtendimento = new Array();
        _this.categoriaAtendimentoRouting = new src_app_core_model_model_categoria_atendimento_routing_model__WEBPACK_IMPORTED_MODULE_9__["CategoriaAtendimentoRouting"]();
        _this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_18__["default"]();
        _this.currentUser = new src_app_core_model_model_usuario_model__WEBPACK_IMPORTED_MODULE_10__["Usuario"]();
        _this.permissaoAdministrador = src_app_core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_6__["PerfilEnum"].ADMINISTRADOR;
        _this.showNoRecords = false;
        _this.subscription = _this.lancamentoService.getLancamento().subscribe(function () {
            _this.searchByFilter();
        });
        return _this;
    }
    AtendimentoListComponent.prototype.ngOnInit = function () {
        this.onCreateForm();
        this.onLoadCombos();
        this.onLoadCategoriaAtendimento();
    };
    AtendimentoListComponent.prototype.isSessao = function (value) {
        return src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_7__["TipoAtendimentoEnum"].SESSAO === value;
    };
    AtendimentoListComponent.prototype.isPacote = function (value) {
        return src_app_core_model_enum_tipo_atendimento_enum__WEBPACK_IMPORTED_MODULE_7__["TipoAtendimentoEnum"].PACOTE === value;
    };
    AtendimentoListComponent.prototype.calcularTempo = function (dataInicio, dataFim) {
        return src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__["default"].calcularTempoHorasMinutos(dataInicio, dataFim);
    };
    AtendimentoListComponent.prototype.onLoadCategoriaAtendimento = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.categoriaAtendimentoRouting = response;
            _this.form.controls.categoriaAtendimentoId.setValue(response.id);
        });
    };
    AtendimentoListComponent.prototype.onCreateForm = function () {
        this.form = this.formBuilder.group({
            tipoAtendimentoId: [null],
            pacienteId: [null],
            usuarioId: [null],
            preAtendimentoData: [null],
            posAtendimentoData: [null],
            aberto: null,
            categoriaAtendimentoId: [null]
        });
    };
    AtendimentoListComponent.prototype.onLoadCombos = function () {
        var _this = this;
        this.route.data.subscribe(function (response) {
            _this.pacientes = response.resolve[0].result;
            _this.usuarios = response.resolve[1].result;
            _this.tiposAtendimento = response.resolve[2].result;
        });
    };
    AtendimentoListComponent.prototype.onClickFormSubmit = function () {
        this.messageService.clearAllMessages();
        var dataInicio = this.form.value.preAtendimentoData;
        var dataFim = this.form.value.posAtendimentoData;
        if (dataInicio && !src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__["default"].isDataHoraValida(dataInicio)) {
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0016);
            return;
        }
        if (dataFim && !src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__["default"].isDataHoraValida(dataFim)) {
            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_15__["Messages"].MSG0017);
            return;
        }
        this.filtro = new src_app_core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.filtro = tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.filtro, { orderBy: 'preAtendimento.data', direction: 'DESC', filter: tslib__WEBPACK_IMPORTED_MODULE_0__["__assign"]({}, this.form.value, { preAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__["default"].convertStringToDateTime(dataInicio), posAtendimentoData: src_app_shared_util_util__WEBPACK_IMPORTED_MODULE_17__["default"].convertStringToDateTime(dataFim) }) });
        this.searchByFilter();
    };
    AtendimentoListComponent.prototype.searchByFilter = function () {
        var _this = this;
        this.service.findByFilter(this.filtro).subscribe(function (response) {
            _this.showNoRecords = true;
            _this.dados = response.result;
        });
    };
    AtendimentoListComponent.prototype.onClickLimparCampos = function () {
        this.messageService.clearAllMessages();
        this.onCreateForm();
        this.dados = new _core_model_model_page_model__WEBPACK_IMPORTED_MODULE_18__["default"]();
        this.filtro = new src_app_core_model_filter_filter_filter__WEBPACK_IMPORTED_MODULE_8__["PageableFilter"]();
        this.form.controls.categoriaAtendimentoId.setValue(this.categoriaAtendimentoRouting.id);
        this.showNoRecords = false;
    };
    AtendimentoListComponent.prototype.onClickEditar = function (id) {
        this.messageService.clearAllMessages();
        this.router.navigate(["/atendimento/" + this.categoriaAtendimentoRouting.rota + "/alterar/" + id]);
    };
    AtendimentoListComponent.prototype.onClickOpenModalVisualizar = function (atendimento) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var initialState, _a, _b;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_c) {
                switch (_c.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        _a = {};
                        return [4 /*yield*/, this.service.findById(atendimento.id).toPromise()];
                    case 1:
                        _a.atendimento = (_c.sent()).result;
                        if (!atendimento.pacoteId) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.pacoteService.findById(atendimento.pacoteId).toPromise()];
                    case 2:
                        _b = (_c.sent()).result;
                        return [3 /*break*/, 4];
                    case 3:
                        _b = null;
                        _c.label = 4;
                    case 4:
                        initialState = (_a.pacote = _b,
                            _a);
                        this.modalService.show(src_app_shared_modais_modal_visualizar_atendimento_modal_visualizar_atendimento_component__WEBPACK_IMPORTED_MODULE_16__["ModalVisualizarAtendimentoComponent"], { initialState: initialState, class: 'gray modal-lg', backdrop: 'static' });
                        return [2 /*return*/];
                }
            });
        });
    };
    AtendimentoListComponent.prototype.onClickOpenModalGerenciarLancamentoSessao = function (id) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var initialState, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        _a = {};
                        return [4 /*yield*/, this.service.findById(id).toPromise()];
                    case 1:
                        initialState = (_a.atendimento = (_b.sent()).result,
                            _a);
                        this.modalService.show(_controle_caixa_modal_gerenciar_lancamento_sessao_modal_gerenciar_lancamento_sessao_component__WEBPACK_IMPORTED_MODULE_21__["ModalGerenciarLancamentoSessaoComponent"], { initialState: initialState, class: 'gray modal-lg', backdrop: 'static' });
                        return [2 /*return*/];
                }
            });
        });
    };
    AtendimentoListComponent.prototype.onClickOpenModalGerenciarLancamentoPacote = function (id) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var initialState, _a;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_b) {
                switch (_b.label) {
                    case 0:
                        this.messageService.clearAllMessages();
                        _a = {};
                        return [4 /*yield*/, this.pacoteService.findById(id).toPromise()];
                    case 1:
                        initialState = (_a.pacote = (_b.sent()).result,
                            _a);
                        this.modalService.show(_controle_caixa_modal_gerenciar_lancamento_pacote_modal_gerenciar_lancamento_pacote_component__WEBPACK_IMPORTED_MODULE_20__["ModalGerenciarLancamentoPacoteComponent"], { initialState: initialState, class: 'gray modal-lg', backdrop: 'static' });
                        return [2 /*return*/];
                }
            });
        });
    };
    AtendimentoListComponent.ctorParameters = function () { return [
        { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] },
        { type: _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__["AtendimentoService"] },
        { type: src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] },
        { type: src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_13__["PacoteService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
        { type: src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"] },
        { type: ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__["BsModalService"] },
        { type: src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_11__["LancamentoService"] }
    ]; };
    AtendimentoListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-atendimento-list',
            template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./atendimento-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/atendimento/list/atendimento-list.component.html")).default
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_19__["AtendimentoService"],
            src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_12__["MessageService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            src_app_core_services_pacote_service__WEBPACK_IMPORTED_MODULE_13__["PacoteService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            src_app_core_guards_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"],
            ngx_bootstrap__WEBPACK_IMPORTED_MODULE_4__["BsModalService"],
            src_app_core_services_lancamento_service__WEBPACK_IMPORTED_MODULE_11__["LancamentoService"]])
    ], AtendimentoListComponent);
    return AtendimentoListComponent;
}(src_app_shared_components_pagination_pagination__WEBPACK_IMPORTED_MODULE_14__["Pagination"]));



/***/ }),

/***/ "./src/app/components/atendimento/resolver/atendimento-form.resolver.ts":
/*!******************************************************************************!*\
  !*** ./src/app/components/atendimento/resolver/atendimento-form.resolver.ts ***!
  \******************************************************************************/
/*! exports provided: AtendimentoFormResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoFormResolver", function() { return AtendimentoFormResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_core_model_model_response_model__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/model/model/response.model */ "./src/app/core/model/model/response.model.ts");
/* harmony import */ var src_app_core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/atendimento.service */ "./src/app/core/services/atendimento.service.ts");
/* harmony import */ var src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/services/message.service */ "./src/app/core/services/message.service.ts");
/* harmony import */ var src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/services/outra-medida.service */ "./src/app/core/services/outra-medida.service.ts");
/* harmony import */ var src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/core/services/tipo-atendimento.service */ "./src/app/core/services/tipo-atendimento.service.ts");
/* harmony import */ var src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/shared/messages/messages */ "./src/app/shared/messages/messages.ts");











var AtendimentoFormResolver = /** @class */ (function () {
    function AtendimentoFormResolver(atendimentoService, messageService, router, pacienteService, tipoAtendimentoService, outraMedidaService) {
        this.atendimentoService = atendimentoService;
        this.messageService = messageService;
        this.router = router;
        this.pacienteService = pacienteService;
        this.tipoAtendimentoService = tipoAtendimentoService;
        this.outraMedidaService = outraMedidaService;
    }
    AtendimentoFormResolver.prototype.resolve = function (route) {
        return tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"](this, void 0, void 0, function () {
            var id, atendimento, categoriaAtendimentoId;
            return tslib__WEBPACK_IMPORTED_MODULE_0__["__generator"](this, function (_a) {
                switch (_a.label) {
                    case 0:
                        id = route.params.id;
                        atendimento = new src_app_core_model_model_response_model__WEBPACK_IMPORTED_MODULE_4__["Response"]();
                        if (!id) return [3 /*break*/, 2];
                        categoriaAtendimentoId = +route.data.id;
                        return [4 /*yield*/, this.atendimentoService.findById(+id).toPromise()];
                    case 1:
                        atendimento = _a.sent();
                        if (!atendimento || categoriaAtendimentoId !== atendimento.result.categoriaAtendimentoId) {
                            this.messageService.sendMessageError(src_app_shared_messages_messages__WEBPACK_IMPORTED_MODULE_10__["Messages"].MSG0027);
                            this.router.navigate(['/home']);
                        }
                        _a.label = 2;
                    case 2: 
                    /*return {
                        atendimento: atendimento,
                        this.pacienteService.findAllActive(),
                        this.outraMedidaService.findAll(),
                        this.tipoAtendimentoService.findAll()
                    };*/
                    return [2 /*return*/, {
                            atendimento: atendimento,
                            combos: Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["forkJoin"])([
                                this.pacienteService.findAllActive(),
                                this.outraMedidaService.findAll(),
                                this.tipoAtendimentoService.findAll()
                            ])
                        }];
                }
            });
        });
    };
    AtendimentoFormResolver.ctorParameters = function () { return [
        { type: src_app_core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_5__["AtendimentoService"] },
        { type: src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_6__["MessageService"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
        { type: src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_8__["PacienteService"] },
        { type: src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoService"] },
        { type: src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_7__["OutraMedidaService"] }
    ]; };
    AtendimentoFormResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_core_services_atendimento_service__WEBPACK_IMPORTED_MODULE_5__["AtendimentoService"],
            src_app_core_services_message_service__WEBPACK_IMPORTED_MODULE_6__["MessageService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_8__["PacienteService"],
            src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_9__["TipoAtendimentoService"],
            src_app_core_services_outra_medida_service__WEBPACK_IMPORTED_MODULE_7__["OutraMedidaService"]])
    ], AtendimentoFormResolver);
    return AtendimentoFormResolver;
}());



/***/ }),

/***/ "./src/app/components/atendimento/resolver/atendimento-list.resolver.ts":
/*!******************************************************************************!*\
  !*** ./src/app/components/atendimento/resolver/atendimento-list.resolver.ts ***!
  \******************************************************************************/
/*! exports provided: AtendimentoListResolver */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AtendimentoListResolver", function() { return AtendimentoListResolver; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/model/enum/perfil.enum */ "./src/app/core/model/enum/perfil.enum.ts");
/* harmony import */ var src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/paciente.service */ "./src/app/core/services/paciente.service.ts");
/* harmony import */ var src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/shared.service */ "./src/app/core/services/shared.service.ts");
/* harmony import */ var src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/core/services/tipo-atendimento.service */ "./src/app/core/services/tipo-atendimento.service.ts");
/* harmony import */ var src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/core/services/usuario.service */ "./src/app/core/services/usuario.service.ts");








var AtendimentoListResolver = /** @class */ (function () {
    function AtendimentoListResolver(pacienteService, tipoAtendimentoService, usuarioService, sharedService) {
        this.pacienteService = pacienteService;
        this.tipoAtendimentoService = tipoAtendimentoService;
        this.usuarioService = usuarioService;
        this.sharedService = sharedService;
    }
    AtendimentoListResolver.prototype.resolve = function () {
        return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["forkJoin"])([
            this.pacienteService.findAllActive(),
            this.isAdministrador() ? this.usuarioService.findAll() : null,
            this.tipoAtendimentoService.findAll()
        ]);
    };
    AtendimentoListResolver.prototype.isAdministrador = function () {
        return this.sharedService.getUserSession().perfilRole === src_app_core_model_enum_perfil_enum__WEBPACK_IMPORTED_MODULE_3__["PerfilEnum"].ADMINISTRADOR;
    };
    AtendimentoListResolver.ctorParameters = function () { return [
        { type: src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"] },
        { type: src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_6__["TipoAtendimentoService"] },
        { type: src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__["UsuarioService"] },
        { type: src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__["SharedService"] }
    ]; };
    AtendimentoListResolver = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_core_services_paciente_service__WEBPACK_IMPORTED_MODULE_4__["PacienteService"],
            src_app_core_services_tipo_atendimento_service__WEBPACK_IMPORTED_MODULE_6__["TipoAtendimentoService"],
            src_app_core_services_usuario_service__WEBPACK_IMPORTED_MODULE_7__["UsuarioService"],
            src_app_core_services_shared_service__WEBPACK_IMPORTED_MODULE_5__["SharedService"]])
    ], AtendimentoListResolver);
    return AtendimentoListResolver;
}());



/***/ }),

/***/ "./src/app/core/model/model/categoria-atendimento-routing.model.ts":
/*!*************************************************************************!*\
  !*** ./src/app/core/model/model/categoria-atendimento-routing.model.ts ***!
  \*************************************************************************/
/*! exports provided: CategoriaAtendimentoRouting */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CategoriaAtendimentoRouting", function() { return CategoriaAtendimentoRouting; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var CategoriaAtendimentoRouting = /** @class */ (function () {
    function CategoriaAtendimentoRouting(id, descricao, rota) {
        this.id = id;
        this.descricao = descricao;
        this.rota = rota;
    }
    return CategoriaAtendimentoRouting;
}());



/***/ })

}]);
//# sourceMappingURL=components-atendimento-atendimento-module.js.map