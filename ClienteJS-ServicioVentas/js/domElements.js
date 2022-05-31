const domElements = (() => {

    const $table = document.getElementById("tableData");
    //const $idObject = document.getElementById("idObject");
    const $tBody = $table.children[1];

    const _createRow = (id, folio, cliente, empresa, fecha, monto, descripcion) => {
        const $tr = document.createElement("tr");
        const $tdId = document.createElement("td");
        const $tdFolio = document.createElement("td");
        const $tdCliente = document.createElement("td");
        const $tdEmpresa = document.createElement("td");
        const $tdFecha = document.createElement("td");
        const $tdMonto = document.createElement("td");
        const $tdDescripcion = document.createElement("td");
        const $tdAcciones = document.createElement("td");

        const $buttonEdit = _createButtonEdit();
        const $buttonDelete = _createButtonDelete();

        $tdId.innerText = id;
        $tdFolio.innerText = folio;
        $tdCliente.innerText = cliente;
        $tdEmpresa.innerText = empresa;
        $tdFecha.innerText = fecha;
        $tdMonto.innerText = monto;
        $tdDescripcion.innerText = descripcion;

        $tdAcciones.appendChild($buttonEdit);
        $tdAcciones.appendChild($buttonDelete);

        $tr.appendChild($tdId);
        $tr.appendChild($tdFolio);
        $tr.appendChild($tdCliente);
        $tr.appendChild($tdEmpresa);
        $tr.appendChild($tdFecha);
        $tr.appendChild($tdMonto);
        $tr.appendChild($tdDescripcion);
        $tr.appendChild($tdAcciones);
        $tBody.appendChild($tr);
    };

    const _createButtonEdit = () => {
        const $buttonEdit = document.createElement("button");
        const $inputFolio = document.getElementById("folio");
        const $inputCliente = document.getElementById("cliente");
        const $inputEmpresa = document.getElementById("empresa");
        const $inputFecha = document.getElementById("fecha");
        const $inputMonto = document.getElementById("monto");
        const $inputDescription = document.getElementById("descripcion");
        $buttonEdit.innerText = "Edit";

        $buttonEdit.addEventListener("click", (event) => {
            const $tdParent = event.target.parentElement;
            const $trParent = $tdParent.parentElement;

            const $folio = $trParent.children[1].innerText;
            const $cliente = $trParent.children[2].innerText;
            const $empresa = $trParent.children[3].innerText;
            const $fecha = $trParent.children[4].innerText;
            const $monto = $trParent.children[5].innerText;
            const $descripcion = $trParent.children[6].innerText;

            $inputFolio.value = $folio;
            $inputCliente.value = $cliente;
            $inputEmpresa.value = $empresa;
            $inputFecha.value = $fecha;
            $inputMonto.value = $monto;
            $inputDescription.value = $descripcion;

        });
        return $buttonEdit;
    }

    const _createButtonDelete = () => {
        const $buttonDelete = document.createElement("button");
        $buttonDelete.innerText = "Delete";

        $buttonDelete.addEventListener("click", (event) => {
            const $tdParent = event.target.parentElement;
            const $trParent = $tdParent.parentElement;
            let elementosTD = $trParent.getElementsByTagName("td");
            let valor = elementosTD[0].innerHTML;
            //$idObject.value = valores;
            clienteHttp.delete("http://localhost:8084/api/v1/venta/" + valor, domMain.Mostrar, domMain.Fallo)
            $tBody.removeChild($trParent);
        });
        return $buttonDelete;
    }

    return {
        createRow: _createRow
    }
})();