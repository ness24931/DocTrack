function loadData(url, data, callback) {
    fetch(url, {
        // mode: 'cors',
        method: 'POST',
        body: data,
        // headers: {
        //     'Origin': 'http://localhost:3000'       
        // }
    }).
    then(result => {
        if (result.status != 200) {
            // if (!result.ok) {
            throw Error(result.statusText);
        } else {
            return result.json();
        }
    }).then(callback).catch(function () {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "El usuario ya existe"
        })
    });
}