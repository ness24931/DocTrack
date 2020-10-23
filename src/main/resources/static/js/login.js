function login() {
    let user = document.getElementById('username').value;
    let pass = document.getElementById('password').value;
    console.log(user);
    console.log(pass);
    if (user !== undefined && user !== null && user !== "" &&
        pass !== undefined && pass !== null && pass !== "") {
        let data = new FormData();
        data.append('user', user);
        data.append('pass', pass);
        fetch('http://localhost:8080/tusers/validate', {
            // mode: 'cors',
            method: 'POST',
            body: data
            // headers: {
            //     'Origin': 'http://localhost:3000'
            // }
        }).
        then(result => {
            return result.json()
        }).then(datos => {
            if (datos.rol === 1) {
                // console.log(JSON.stringify(datos));
                window.alert("Se ha logueado")
                window.location.href = "html/view_admin.html";
            } else
            if (datos.rol === -1) {
                window.alert("NO TIENE LOS PERMISOS NECESARIOS")
            }
        });
    }
}