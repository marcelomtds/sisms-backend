(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["common"],{

/***/ "./node_modules/resize-base64/index.js":
/*!*********************************************!*\
  !*** ./node_modules/resize-base64/index.js ***!
  \*********************************************/
/*! exports provided: resizeBase64ForMaxWidth, resizeBase64ForMaxHeight, resizeBase64ForMaxWidthAndMaxHeight */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "resizeBase64ForMaxWidth", function() { return resizeBase64ForMaxWidth; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "resizeBase64ForMaxHeight", function() { return resizeBase64ForMaxHeight; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "resizeBase64ForMaxWidthAndMaxHeight", function() { return resizeBase64ForMaxWidthAndMaxHeight; });
if (!String.prototype.startsWith) {
  String.prototype.startsWith = function(search, pos) {
	  return this.substr(!pos || pos < 0 ? 0 : +pos, search.length) === search;
  };
}

const DEFAULT_RATIO = 1;

function validateInput(base64String, maxWidth, maxHeight) {
	let validationResult = {
		isValid: false,
		errorMessage: 'An error occurred.'
	};

	if(!base64String) {
		validationResult.errorMessage = 'The input parameter base64String is ' + base64String + '.';
	} else if(typeof(base64String) != 'string') {
		validationResult.errorMessage = 'The input parameter base64String is not of type \'string\'.';
	} else if(!base64String.startsWith('data:image')) {
		validationResult.errorMessage = 'The input parameter base64String does not start with \'data:image\'.';
	} else if(!maxWidth) {
		validationResult.errorMessage = 'The input parameter maxWidth is ' + maxWidth + '.';
	} else if(typeof(maxWidth) != 'number') {
		validationResult.errorMessage = 'The input parameter maxWidth is not of type \'number\'.';
	} else if(maxWidth < 2) {
		validationResult.errorMessage = 'The input parameter maxWidth must be at least 2 pixel.';
	} else if(!maxHeight) {
		validationResult.errorMessage = 'The input parameter maxHeight is ' + maxHeight + '.';
	} else if(typeof(maxHeight) != 'number') {
		validationResult.errorMessage = 'The input parameter maxHeight is not of type \'number\'.';
	} else if(maxHeight < 2) {
		validationResult.errorMessage = 'The input parameter maxHeight must be at least 2 pixel.';
	} else {
		validationResult.isValid = true;
		validationResult.errorMessage = null;
	}

	return validationResult;
}

function maxWidthRatioFunction(imageWidth, imageHeight, targetWidth, targetHeight) {
	let ratio = DEFAULT_RATIO;

	if(imageWidth > targetWidth) {
		ratio = targetWidth / imageWidth;
	}

	return {
		width: ratio,
		height: ratio
	};
}

function maxHeightRatioFunction(imageWidth, imageHeight, targetWidth, targetHeight) {
	let ratio = DEFAULT_RATIO;

	if(imageHeight > targetHeight) {
		ratio = targetHeight / imageHeight;
	}

	return {
		width: ratio,
		height: ratio
	};
}

function maxWidthMaxHeightRatioFunction(imageWidth, imageHeight, targetWidth, targetHeight) {
	let widthRatio = targetWidth / imageWidth;
	let heightRatio = targetHeight / imageHeight;

	return {
		width: widthRatio,
		height: heightRatio
	};
}

function resizeBase64ForMaxWidth(base64String, maxWidth, maxHeight, successCallback, errorCallback) {
	let validationResult = validateInput(base64String, maxWidth, maxHeight);

	if(validationResult.isValid === true) {
		resizeBase64(base64String, maxWidth, maxHeight, maxWidthRatioFunction, successCallback, errorCallback);
	} else {
		errorCallback(validationResult.errorMessage);
	}
}

function resizeBase64ForMaxHeight(base64String, maxWidth, maxHeight, successCallback, errorCallback) {
	let validationResult = validateInput(base64String, maxWidth, maxHeight);

	if(validationResult.isValid === true) {
		resizeBase64(base64String, maxWidth, maxHeight, maxHeightRatioFunction, successCallback, errorCallback);
	} else {
		errorCallback(validationResult.errorMessage);
	}
}

function resizeBase64ForMaxWidthAndMaxHeight(base64String, maxWidth, maxHeight, successCallback, errorCallback) {
	let validationResult = validateInput(base64String, maxWidth, maxHeight);

	if(validationResult.isValid === true) {
		resizeBase64(base64String, maxWidth, maxHeight, maxWidthMaxHeightRatioFunction, successCallback, errorCallback);
	} else {
		errorCallback(validationResult.errorMessage);
	}
}

function resizeBase64(base64String, maxWidth, maxHeight, ratioFunction, successCallback, errorCallback) {
	// Create and initialize two canvas
	let canvas = document.createElement("canvas");
	let ctx = canvas.getContext("2d");
	let canvasCopy = document.createElement("canvas");
	let copyContext = canvasCopy.getContext("2d");

	// Create original image
	let img = new Image();
	img.src = base64String;

	img.onload = function() {
		let ratioResult = ratioFunction(img.width, img.height, maxWidth, maxHeight);
		let widthRatio = ratioResult.width;
		let heightRatio = ratioResult.height;

		// Draw original image in second canvas
		canvasCopy.width = img.width;
		canvasCopy.height = img.height;
		copyContext.drawImage(img, 0, 0);

		// Copy and resize second canvas to first canvas
		canvas.width = img.width * widthRatio;
		canvas.height = img.height * heightRatio;
		ctx.drawImage(canvasCopy, 0, 0, canvasCopy.width, canvasCopy.height, 0, 0, canvas.width, canvas.height);

		successCallback(canvas.toDataURL());
	};

	img.onerror = function() {
		errorCallback('Error while loading image.');
	};
};





/***/ }),

/***/ "./src/app/core/model/enum/tipo-atendimento.enum.ts":
/*!**********************************************************!*\
  !*** ./src/app/core/model/enum/tipo-atendimento.enum.ts ***!
  \**********************************************************/
/*! exports provided: TipoAtendimentoEnum */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TipoAtendimentoEnum", function() { return TipoAtendimentoEnum; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var TipoAtendimentoEnum;
(function (TipoAtendimentoEnum) {
    TipoAtendimentoEnum[TipoAtendimentoEnum["SESSAO"] = 1] = "SESSAO";
    TipoAtendimentoEnum[TipoAtendimentoEnum["PACOTE"] = 2] = "PACOTE";
})(TipoAtendimentoEnum || (TipoAtendimentoEnum = {}));


/***/ }),

/***/ "./src/app/core/model/model/response.model.ts":
/*!****************************************************!*\
  !*** ./src/app/core/model/model/response.model.ts ***!
  \****************************************************/
/*! exports provided: Response */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Response", function() { return Response; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var Response = /** @class */ (function () {
    function Response(result, message, errors) {
        this.result = result;
        this.message = message;
        this.errors = errors;
    }
    return Response;
}());



/***/ }),

/***/ "./src/app/core/services/agenda.service.ts":
/*!*************************************************!*\
  !*** ./src/app/core/services/agenda.service.ts ***!
  \*************************************************/
/*! exports provided: AgendaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AgendaService", function() { return AgendaService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var AgendaService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](AgendaService, _super);
    function AgendaService(http) {
        return _super.call(this, http, '/api/agenda') || this;
    }
    AgendaService.prototype.findAllByWeekDay = function () {
        return this.http.get(this.apiBaseUrl + "/findAllByWeekDay");
    };
    AgendaService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    AgendaService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AgendaService);
    return AgendaService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ }),

/***/ "./src/app/core/services/categoria-atendimento.service.ts":
/*!****************************************************************!*\
  !*** ./src/app/core/services/categoria-atendimento.service.ts ***!
  \****************************************************************/
/*! exports provided: CategoriaAtendimentoService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CategoriaAtendimentoService", function() { return CategoriaAtendimentoService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var CategoriaAtendimentoService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](CategoriaAtendimentoService, _super);
    function CategoriaAtendimentoService(http) {
        return _super.call(this, http, '/api/categoriaAtendimento') || this;
    }
    CategoriaAtendimentoService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    CategoriaAtendimentoService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], CategoriaAtendimentoService);
    return CategoriaAtendimentoService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ }),

/***/ "./src/app/core/services/paciente.service.ts":
/*!***************************************************!*\
  !*** ./src/app/core/services/paciente.service.ts ***!
  \***************************************************/
/*! exports provided: PacienteService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PacienteService", function() { return PacienteService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var PacienteService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PacienteService, _super);
    function PacienteService(http) {
        return _super.call(this, http, '/api/paciente') || this;
    }
    PacienteService.prototype.findAllBirthdaysMonth = function () {
        return this.http.get(this.apiBaseUrl + "/findAllBirthdaysMonth");
    };
    PacienteService.prototype.findAllWithoutBondWithReservation = function () {
        return this.http.get(this.apiBaseUrl + "/findAllWithoutBondWithReservation");
    };
    PacienteService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    PacienteService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], PacienteService);
    return PacienteService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ }),

/***/ "./src/app/core/services/sexo.service.ts":
/*!***********************************************!*\
  !*** ./src/app/core/services/sexo.service.ts ***!
  \***********************************************/
/*! exports provided: SexoService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SexoService", function() { return SexoService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var SexoService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](SexoService, _super);
    function SexoService(http) {
        return _super.call(this, http, '/api/sexo') || this;
    }
    SexoService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    SexoService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], SexoService);
    return SexoService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ }),

/***/ "./src/app/core/services/tipo-atendimento.service.ts":
/*!***********************************************************!*\
  !*** ./src/app/core/services/tipo-atendimento.service.ts ***!
  \***********************************************************/
/*! exports provided: TipoAtendimentoService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TipoAtendimentoService", function() { return TipoAtendimentoService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _base_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./base.service */ "./src/app/core/services/base.service.ts");




var TipoAtendimentoService = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](TipoAtendimentoService, _super);
    function TipoAtendimentoService(http) {
        return _super.call(this, http, '/api/tipoAtendimento') || this;
    }
    TipoAtendimentoService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }
    ]; };
    TipoAtendimentoService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], TipoAtendimentoService);
    return TipoAtendimentoService;
}(_base_service__WEBPACK_IMPORTED_MODULE_3__["BaseService"]));



/***/ })

}]);
//# sourceMappingURL=common.js.map