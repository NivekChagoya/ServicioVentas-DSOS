const domMain = (() => {

    const $button = document.getElementById("guardar");
    const $idObject = document.getElementById("idObject");
    const $inputFolio = document.getElementById("folio");
    const $inputCliente = document.getElementById("cliente");
    const $inputEmpresa = document.getElementById("empresa");
    const $inputFecha = document.getElementById("fecha");
    const $inputMonto = document.getElementById("monto");
    const $inputDescription = document.getElementById("descripcion");

    const fnCallbackClick = (target) => {
        const folio = $inputFolio.value;
        const cliente = $inputCliente.value;
        const empresa = $inputEmpresa.value;
        const fecha = $inputFecha.value;
        const monto = $inputMonto.value;
        const description = $inputDescription.value;
        if (folio.length == 0 || cliente.length == 0 || empresa.length == 0 || fecha.length == 0 || monto == null || description.length == 0) {
            alert('Uno o más campos vacios');
        } else {
            clienteHttp.post("http://localhost:8084/api/v1/venta/", {
                folioVenta: folio,
                nombreCliente: cliente,
                nombreEmpresa: empresa,
                fechaVenta: fecha,
                monto: monto,
                descripcion: description,
            }, fnExito, fnFallo);
        }
    };

    //Inserta con Funcion Asincrona
    const fnCallbackClick2 = (target) => {
        const folio = $inputFolio.value;
        const cliente = $inputCliente.value;
        const empresa = $inputEmpresa.value;
        const fecha = $inputFecha.value;
        const monto = $inputMonto.value;
        const description = $inputDescription.value;
        if (folio.length == 0 || cliente.length == 0 || empresa.length == 0 || fecha.length == 0 || monto == null || description.length == 0) {
            alert('Uno o más campos vacios');
        } else {
            console.time("peticion A");
            clienteHttp.post("http://localhost:8084/api/v1/venta/", {
                folioVenta: folio,
                nombreCliente: cliente,
                nombreEmpresa: empresa,
                fechaVenta: fecha,
                monto: monto,
                descripcion: description,
            },
                gnerateFnExito("peticion A"),
                fnFallo);
        };
    }

    //Evento de insertar
    $button.addEventListener("click", fnCallbackClick);
    //Evento de insetar con funcion asincrona
    //$button.addEventListener("click", fnCallbackClick2);

    const fnExito = (response) => {
        const httpResponse = response.httpCode;
        if (httpResponse >= 200 && httpResponse <= 299) {
            //const id = $inputId.value;
            const folio = $inputFolio.value;
            const cliente = $inputCliente.value;
            const empresa = $inputEmpresa.value;
            const fecha = $inputFecha.value;
            const monto = $inputMonto.value;
            const description = $inputDescription.value;
            domElements.createRow(folio, cliente, empresa, fecha, monto, description);
        } else {
            alert(response);
        }
    };

    //Funcion de exito para la funcion de insertar asincrona
    const gnerateFnExito = (labelTime = '') => {
        const funtionChild = (response) => {
            console.timeEnd(labelTime);
            const httpResponse = response.httpCode;
            if (httpResponse >= 200 && httpResponse <= 299) {
                const folio = $inputFolio.value;
                const cliente = $inputCliente.value;
                const empresa = $inputEmpresa.value;
                const fecha = $inputFecha.value;
                const monto = $inputMonto.value;
                const description = $inputDescription.value;
                domElements.createRow(folio, cliente, empresa, fecha, monto, description);
            } else {
                alert(response);
            }
        };
        return funtionChild;
    };

    //Funcion para mostrar los objetos del array en la tabla 
    const fnMostrar = (responseService) => {
        let response = responseService.data;
        for (let i = 0; i < response.length; i++) {
            const id = response[i]['idVenta'];
            const folio = response[i]['folioVenta'];
            const cliente = response[i]['nombreCliente'];
            const empresa = response[i]['nombreEmpresa'];
            const fecha = response[i]['fechaVenta'];
            const monto = response[i]['monto'];
            const descripcion = response[i]['descripcion'];
            domElements.createRow(id, folio, cliente, empresa, fecha, monto, descripcion);
        }
        console.log(response);
    };

    /*Funcion para eliminar un objeto
    const fnDelete = (target) => {
        const id = $idObject.value;
        if (id.length == 0) {
            alert('error');
        }
        else {
            clienteHttp.delete("http://localhost:8084/api/v1/venta/" + id, fnMostrar, fnFallo)
        }
    }*/

    const fnFallo = (err) => {
        console.error(err);
    };

    //mostrar en tabla los objetos
    clienteHttp.get("http://localhost:8084/api/v1/venta/", fnMostrar, fnFallo);

    return {
        Mostrar: fnMostrar,
        Fallo: fnFallo,
        Exito: fnCallbackClick
    }
})();