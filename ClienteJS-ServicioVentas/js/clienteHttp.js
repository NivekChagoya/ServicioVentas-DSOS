const clienteHttp = (() => {
    const _get = (url, fnExito, fnFallo) => {
        fetch(url)
            .then((resp) => resp.json())
            .then(fnExito)
            .catch(fnFallo);
    };

    const _post = (url, payload, fnExito, fnFallo) => {
        fetch(url, {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(payload),
        })
            .then((resp) => resp.json())
            .then(fnExito)
            .catch(fnFallo);
    };

    const _delete = (url, fnExito, fnFallo) => {
        fetch(url, {
            method: "DELETE",
        })
            .then((resp) => resp.json())
            .then(fnExito)
            .catch(fnFallo);
    }

    const _update = (url, payload, fnExito, fnFallo) => {
        fetch(url, {
            method: "PUT",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(payload),
        })
            .then((resp) => resp.json())
            .then(fnExito)
            .catch(fnFallo);
    };

    //Insertar de manera asincrona
    const _postAsync = async (url, payload) => {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(payload),
        })
        const responseJSON = await response.json;
        return responseJSON
    };

    return {
        get: _get,
        post: _post,
        postAsync: _postAsync,
        delete: _delete,
        update: _update
    };
})();
