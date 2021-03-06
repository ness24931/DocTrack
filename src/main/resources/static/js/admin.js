var listUsuarios = [];
var listFilter = [];

var listTramites = [];
var listFilterTramites = [];

var listDepartments = [];
var listRequisitos = [];
var reqProc = [];
var list_request = [];
var prod = null;
var selected = null;

function openNav(element) {
    switch (element.id) {
        case "link_procesos":
            menuProcess();
            break;
        case "link_requisitos":
            menuRequirements();
            break;
        case "link_usuarios":
            menuUsers();
            break;
        default:
            break;
    }
}

function menuProcess() {
    // cargarTablaUsers();
    const url = 'http://localhost:8080/t_requests/listar';
    let data = new FormData();
    loadData(url, data, loadProcess);
}

function loadProcess(datos) {
    listTramites = datos;
    cargarTablaTramites(listTramites);
    requestRequirements();
    document.getElementById('text_whereIam').innerText = 'Módulo de tramites';
    document.getElementById('btn_filter').setAttribute('data-target', '#modal_filter_tramites');
    document.getElementById('btn_insert').setAttribute('data-target', '#modal_proc');
    document.getElementById('btn_updt').setAttribute('data-target', '#updt_proc');
    document.getElementById('btn_updt').addEventListener('click', function () {
        seleccionarProc();
    });

    document.getElementById('btn_crud').style.display = 'block';
}


function cargarTablaTramites(tramites) {
    listFilterTramites = tramites;
    let thead = document.getElementById('header_table');
    thead.innerHTML = "";
    let row = thead.insertRow(0);

    let cell = document.createElement('th');
    cell.innerText = 'Código de trámite';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Nombre';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Descripción';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    // cell = document.createElement('th');
    // cell.innerText = 'Segundo Apellido';
    // cell.setAttribute('scope', 'col');
    // row.appendChild(cell);

    // cell = document.createElement('th');
    // cell.innerText = 'Correo';
    // cell.setAttribute('scope', 'col');
    // row.appendChild(cell);

    // cell = document.createElement('th');
    // cell.innerText = 'Teléfono';
    // cell.setAttribute('scope', 'col');
    // row.appendChild(cell);

    // cell = document.createElement('th');
    // cell.innerText = 'Departamento';
    // cell.setAttribute('scope', 'col');
    // row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = '...';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    let tbody = document.getElementById('body_table');
    tbody.innerHTML = "";
    let i = 0;
    for (let tram of listFilterTramites) {
        row = tbody.insertRow(0);

        cell = document.createElement('td');
        cell.innerText = tram.requestId;
        row.appendChild(cell);

        cell = document.createElement('td');
        cell.innerText = tram.title;
        row.appendChild(cell);

        cell = document.createElement('td');
        cell.innerText = tram.description;
        row.appendChild(cell);

        // cell = document.createElement('td');
        // cell.innerText = tram.temployee.secondSurname;
        // row.appendChild(cell);

        // cell = document.createElement('td');
        // cell.innerText = tram.temployee.email;
        // row.appendChild(cell);

        // cell = document.createElement('td');
        // cell.innerText = tram.temployee.telephone;
        // row.appendChild(cell);

        // cell = document.createElement('td');
        // cell.innerText = tram.temployee.tdepartment.departmentName;
        // row.appendChild(cell);

        cell = document.createElement('td');
        let buttonMore = document.createElement('button');
        buttonMore.innerText = 'Ver Requisitos';
        buttonMore.setAttribute('value', i++);
        buttonMore.setAttribute('class', "btn btn-primary");
        buttonMore.setAttribute('data-toggle', "modal");
        buttonMore.setAttribute('data-target', "#modal_viewMoreRequi");
        buttonMore.addEventListener("click", function () {
            showMoreRequi(buttonMore.value);
        });
        row.addEventListener("click", function () {
            selectRow(buttonMore.value);
        });
        cell.appendChild(buttonMore);
        row.appendChild(cell);
    }
}

function showMoreRequi(i) {
    let requisitos = listFilterTramites[i].trequirements;
    let bodyTable = document.getElementById('bodyTable_request');
    bodyTable.innerHTML="";
    for (let r of requisitos) {
        let row = bodyTable.insertRow(0);

        let td = document.createElement('td');
        td.innerText = r.requirementId;
        row.appendChild(td);

        td = document.createElement('td');
        td.innerText = r.title;
        row.appendChild(td);

        td = document.createElement('td');
        td.innerText = r.description;
        row.appendChild(td);
    }
}

function filterProcessBy(id, nombre, desc) {
    let filter = listTramites.filter(c => c.requestId.toString().toLowerCase().includes(id.toLowerCase()))
        .filter(n => n.title.toLowerCase().includes(nombre.toLowerCase()))
        .filter(d => d.description.toLowerCase().includes(desc.toLowerCase()));
    listFilterTramites = filter;
    return filter;
}


function loadFilterProcess() {
    let id = $('#filter_numProcess').val();
    let nombre = $('#filter_nameProcess').val();
    let desc = $('#filter_descProcess').val();
    cargarTablaTramites(filterProcessBy(id, nombre, desc));
}

function menuUsers() {
    // cargarTablaUsers();
    requestDepartments();
    const url = 'http://localhost:8080/tusersE/listar';
    let data = new FormData();
    loadData(url, data, loadUsers);
}

function loadUsers(datos) {
    listUsuarios = datos;
    cargarTablaUsers(listUsuarios);
    document.getElementById('text_whereIam').innerText = 'Módulo de usuarios';
    document.getElementById('btn_filter').setAttribute('data-target', '#modal_filter');
    document.getElementById('btn_insert').setAttribute('data-target', '#modal_Admin');
    document.getElementById('btn_updt').setAttribute('data-target', '#updt_panel');
    document.getElementById('btn_updt').addEventListener('click', function () {
        seleccionar();
    });
    document.getElementById('btn_crud').style.display = 'block';
}



function cargarTablaUsers(usuarios) {
    listFilter = usuarios;
    let thead = document.getElementById('header_table');
    thead.innerHTML = "";
    let row = thead.insertRow(0);

    let cell = document.createElement('th');
    cell.innerText = 'Cédula';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Nombre';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Primer Apellido';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Segundo Apellido';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Correo';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Teléfono';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    cell.innerText = 'Departamento';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    cell = document.createElement('th');
    // let cell = row.insertCell(0);
    cell.innerText = '...';
    cell.setAttribute('scope', 'col');
    row.appendChild(cell);

    let tbody = document.getElementById('body_table');
    tbody.innerHTML = "";
    let i = 0;
    for (let user of listFilter) {
        row = tbody.insertRow(0);
        cell = document.createElement('td');
        // cell = row.insertCell(-1);
        cell.innerText = user.temployee.dni;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.firstName;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.firstSurname;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.secondSurname;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.email;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.telephone;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        cell.innerText = user.temployee.tdepartment.departmentName;
        row.appendChild(cell);

        // cell = row.insertCell(-1);
        cell = document.createElement('td');
        let buttonMore = document.createElement('button');
        buttonMore.innerText = 'Ver más';
        buttonMore.setAttribute('value', i++);
        buttonMore.setAttribute('class', "btn btn-primary");
        buttonMore.setAttribute('data-toggle', "modal");
        buttonMore.setAttribute('data-target', "#modal_viewMore");
        buttonMore.addEventListener("click", function () {
            showMore(buttonMore.value);
        });
        row.addEventListener("click", function () {
            selectRow(buttonMore.value);
        });
        cell.appendChild(buttonMore);
        row.appendChild(cell);
        // i++;
    }

}

function showMore(i) {
    let td_username = document.getElementById('td_username');
    let td_pass = document.getElementById('td_pass');
    let td_role = document.getElementById('td_role');
    let td_status = document.getElementById('td_status');

    td_username.innerText = listFilter[i].username;
    td_pass.innerText = listFilter[i].passwd;
    td_role.innerText = listFilter[i].trole.name;
    td_status.innerText = listFilter[i].status;
    // console.log(listUsuarios[i]);
}

function selectRow(i) {
    let body_table = document.getElementById("body_table");
    for (let r of body_table.rows) {
        r.style.color = "black";
        r.style.background = "";
    }
    let pos = body_table.rows.length - (parseInt(i) + 1);
    let row = body_table.rows[pos];
    row.style.backgroundColor = "#02315f";
    row.style.color = "white";
    selected = listUsuarios[i];
}

function seleccionar() {
    requestDepartments();
    loadDepartments(listDepartments, 'e_departmentUpdt');
    let e_emailUpdt = document.getElementById('e_emailUpdt');
    let e_telUpdt = document.getElementById('e_telUpdt');
    let e_departmentUpdt = document.getElementById('e_departmentUpdt');

    let e_positionUpdt = document.getElementById('e_positionUpdt');
    let u_userUpdt = document.getElementById('u_userUpdt');
    let u_passUpdt = document.getElementById('u_passUpdt');
    let btnUpdate = document.getElementById('bntUpdateU');
    btnUpdate.addEventListener('click', function () {
        updateUser();
    });

    e_emailUpdt.value = selected.temployee.email;
    e_telUpdt.value = selected.temployee.telephone;
    u_userUpdt.value = selected.username;
    u_passUpdt.value = selected.passwd;
    e_departmentUpdt.selectedIndex = getIndex(e_departmentUpdt, selected.temployee.tdepartment.departmentName);
    e_positionUpdt.selectedIndex = getIndex(e_positionUpdt, selected.temployee.tjob.jobTitle);
}

function updateUser() {
    const url = 'http://localhost:8080/tusersE/update';
    let e_emailUpdt = document.getElementById('e_emailUpdt').value;
    let e_telUpdt = document.getElementById('e_telUpdt').value;
    let e_departmentUpdt = document.getElementById('e_departmentUpdt').value;
    let e_positionUpdt = document.getElementById('e_positionUpdt').value;
    let u_userUpdt = document.getElementById('u_userUpdt').value;
    let u_passUpdt = document.getElementById('u_passUpdt').value;
    let usuario = selected;
    usuario.temployee.email = e_emailUpdt;
    usuario.temployee.telephone = e_telUpdt;
    usuario.temployee.tdepartment.departmentName = e_departmentUpdt;
    usuario.temployee.tjob.jobTitle = e_positionUpdt;
    usuario.username = u_userUpdt;
    usuario.passwd = u_passUpdt;
    let data = new FormData();
    data.append('user', JSON.stringify(usuario));
    loadData(url, data, function () {
        window.alert("Usuario Actualizado");
        menuUsers();
    });
}



function getIndex(select, name) {
    let j = 0;
    for (j; j < e_departmentUpdt.options.length; j++) {
        if (select[j].innerHTML === name) {
            break;
        }
    }
    return j;
}

function filterUsersBy(cedula, nombre, departamento, rol) {
    let filter = listUsuarios.filter(c => c.temployee.dni.toLowerCase().includes(cedula.toLowerCase()))
        .filter(n => (n.temployee.firstName.toLowerCase().includes(nombre.toLowerCase()) ||
            n.temployee.firstSurname.toLowerCase().includes(nombre.toLowerCase()) ||
            n.temployee.secondSurname.toLowerCase().includes(nombre.toLowerCase())))
        .filter(d => d.temployee.tdepartment.departmentName.toLowerCase().includes(departamento.toLowerCase()))
        .filter(r => r.trole.name.toLowerCase().includes(rol.toLowerCase()));
    listFilter = filter;
    return filter;
}


function loadFilter() {
    let cedula = $('#filter_dni').val();
    let nombre = $('#filter_name').val();
    let departamento = $('#filter_depa').val();
    let rol = $('#filter_rol').val();
    cargarTablaUsers(filterUsersBy(cedula, nombre, departamento, rol));
}

function genPass(id) {
    let characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    var pass = "";
    for (let i = 0; i < 8; i++) {
        pass += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    let u_pass = document.getElementById(id);
    u_pass.value = pass;
}

function addEmployee() {
    const url = 'http://localhost:8080/tusersE/insert';
    let u_dni = document.getElementById('e_dni').value;
    let u_name = document.getElementById('e_name').value;
    let u_first = document.getElementById('e_first').value;
    let u_second = document.getElementById('e_second').value;
    let u_email = document.getElementById('e_email').value;
    let u_tel = document.getElementById('e_tel').value;
    let departments = document.getElementById('e_department').value;
    let position = document.getElementById('e_position').value;
    let u_user = document.getElementById('u_user').value;
    let u_pass = document.getElementById('u_pass').value;
    let data = new FormData();
    data.append('e_dni', u_dni);
    data.append('e_name', u_name);
    data.append('e_first', u_first);
    data.append('e_second', u_second);
    data.append('e_email', u_email);
    data.append('e_tel', u_tel);
    data.append('e_department', departments);
    data.append('e_position', position);
    data.append('u_user', u_user);
    data.append('u_pass', u_pass);
    loadData(url, data, () => {
        window.alert("Usuario Ingresado");
        menuUsers();
    });
}

function requestDepartments() {
    const url = 'http://localhost:8080/t_departments/listar';
    let data = new FormData();
    loadData(url, data, loadDepartments);
}

function loadDepartments(datos, id = 'e_department') {
    listDepartments = datos;
    let list_depa = document.getElementById(id);
    list_depa.innerHTML = "";
    let option = document.createElement('option');
    option.innerText = 'Departamentos';
    list_depa.add(option);
    for (let d of datos) {
        let option2 = document.createElement('option');
        option2.text = d.departmentName;
        option2.value = d.departmentId;
        list_depa.add(option2);
    }
}

function requestRequirements() {
    const url = 'http://localhost:8080/t_requiremnt/listar';
    let data = new FormData();
    loadData(url, data, loadRequirements);
}

function loadRequirements(datos) {
    listRequisitos = datos;
    let list_req = document.getElementById('list_req');
    list_req.innerHTML = "";
    // list_req.onclick = loadInfo;
    let option = document.createElement('option');
    option.innerText = 'Requisitos';
    list_req.appendChild(option);
    let i = 0;
    for (let d of datos) {
        option = document.createElement('option');
        option.innerText = d.title;
        option.value = i;
        list_req.appendChild(option);
        i++;
    }
}

function addReq() {
    // let panelAlreadyAdd = document.getElementById('panelAlreadyAdd');
    let i = document.getElementById('list_req').value;
    reqProc.push(listRequisitos[i]);
    let panelAlreadyAdd = document.getElementById('panelAlreadyAdd');
    let li = document.createElement('li');
    li.innerHTML = `<div><p>${listRequisitos[i].title}</p><span><button type='button' class="btn btn-secondary" onclick="deleteReqProc(${listRequisitos[i].requirementId})">Eliminar</button></span></div>`;
    li.setAttribute('id', `li_${listRequisitos[i].requirementId}`)
    panelAlreadyAdd.appendChild(li);
}

function createProc() {
    let data = new FormData();
    const url = 'http://localhost:8080/t_requests/insert';
    let title = document.getElementById('title_proc').value;
    let desc = document.getElementById('desc_proc').value;
    data.append('TRequirements', JSON.stringify(reqProc));
    data.append('title', title);
    data.append('description', desc);
    loadData(url, data, async function () {
        menuProcess();
        window.alert("insertado")
    });
}

function updateProc() {
    if (selected.requestId === undefined) {
        window.alert('Seleccione un registro');
    } else {
        const url = 'http://localhost:8080/t_requests/update';
        let data = new FormData();
        data.append('TRequirements', JSON.stringify(listRequisitos));
        data.append('idprocess',selected.requestId);
        data.append('title', document.getElementById('title_procUpdt').value);
        data.append('description', document.getElementById('desc_procUdpt').value);
        loadData(url, data, async function () {
            menuProcess();
            window.alert('Actualizado');            
        });

    }
}