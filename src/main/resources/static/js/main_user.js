// import { TDepartment } from "./class.js";

var listUsuarios = [];
var listDepartments = [];
var listDepartments1 = [];
var listRequisitos = [];
var reqProc = [];
var list_request = [];
var prod = null;


/* Side Bar and Nav Menu Bar*/
function openNav(element) {
    loadSidMenu(element);
    $("#mySidebar").css("width", "260px");
    $("#navBar_main").css("marginLeft", "260px");
    $("#main_area").css("marginLeft", "260px");
    $("#link_procesos").attr("onclick", "closeNav(this)");
    $("#link_requisitos").attr("onclick", "closeNav(this)");
    $("#link_usuarios").attr("onclick", "closeNav(this)");

}

function closeNav() {
    $("#mySidebar").css("width", "0");
    $("#navBar_main").css("marginLeft", "0");
    $("#main_area").css("marginLeft", "0");
    $("#link_procesos").attr("onclick", "openNav(this)");
    $("#link_requisitos").attr("onclick", "openNav(this)");
    $("#link_usuarios").attr("onclick", "openNav(this)");
    deleteSidebarLink();
}

function loadSidMenu(element) {
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

function deleteSidebarLink() {
    let element = document.getElementById("ul_menu");
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }
}

function menuProcess() {
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showCreateP()">Crear Procesos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Listar Procesos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showUpdtP()">Actualizar Procesos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Eliminar Procesos</a></li>`);
}

function menuRequirements() {
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showCreateR()">Crear Requisitos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Listar Requisitos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showUpdtR()">Actualizar Requisitos</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Eliminar Requisitos</a></li>`);
}

function menuUsers() {
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showCreateU()">Crear Usuarios</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Listar Usuarios</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="javascript:showUpdtU()">Actualizar Usuarios</a></li>`);
    $("#ul_menu").append(`<li><a class="side_link" href="#">Eliminar Usuarios</a></li>`);
}
/* End Side Bar and Nav Menu Bar*/

/******************************************************************************************************************************************* */

/* Panel Functions*/

function hideAll() {
    /* Hide Users */
    let create_user = document.getElementById('create_user');
    create_user.style.zIndex = "-1";
    create_user.style.display = "none";

    let updt_user = document.getElementById('updt_user');
    updt_user.style.zIndex = "-1";
    updt_user.style.display = "none";

    /* Hide Requirements */
    let create_req = document.getElementById('create_req');
    create_req.style.zIndex = "-1";
    create_req.style.display = "none";

    let updt_req = document.getElementById('updt_req');
    updt_req.style.zIndex = "-1";
    updt_req.style.display = "none";

    /* Hide Process */
    let create_proc = document.getElementById('create_proc');
    create_proc.style.zIndex = "-1";
    create_proc.style.display = "none";

    let updt_proc = document.getElementById('updt_proc');
    updt_proc.style.zIndex = "-1";
    updt_proc.style.display = "none";

    closeNav();
}

/* Panel Users */
function showCreateU() {
    hideAll();
    requestDepartments();
    let create_user = document.getElementById('create_user');
    create_user.style.zIndex = "10";
    create_user.style.display = "block";
}

function showUpdtU() {
    hideAll();
    requestUpdateDataUser();
    requestDepartments();
    let updt_user = document.getElementById('updt_user');
    updt_user.style.zIndex = "10";
    updt_user.style.display = "block";
}

/* Panel Requirements */
function showCreateR() {
    hideAll();
    let updt_user = document.getElementById('create_req');
    updt_user.style.zIndex = "10";
    updt_user.style.display = "block";
}

function showUpdtR() {
    hideAll();
    let updt_user = document.getElementById('updt_req');
    updt_user.style.zIndex = "10";
    updt_user.style.display = "block";
}

/* Panel Procedures */
function showCreateP() {
    hideAll();
    requestRequirements();
    let updt_user = document.getElementById('create_proc');
    updt_user.style.zIndex = "50";
    updt_user.style.display = "block";
}

function showUpdtP() {
    hideAll();
    requestRequirements();
    loadUpdate();
    let updt_user = document.getElementById('updt_proc');
    updt_user.style.zIndex = "10";
    updt_user.style.display = "block";
}


/* End Panel Functions*/

/* Requirements  */
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

function loadInfo() {
    let i = document.getElementById('list_req').value;
    let info_req = document.getElementById("info_req");
    info_req.innerText = listRequisitos[i].description;
    console.log(i);
    // let i = event.target.value;

    // info_req.textContent = event.target.value;
}

/* Departments */

function requestDepartments() {
    const url = 'http://localhost:8080/t_departments/listar';
    let data = new FormData();
    loadData(url, data, loadDepartments);
}

function loadDepartments(datos, id = 'e_department') {
    datos.array.forEach(element => {
        let depa = new TDepartment(element.departmentId, element.departmentName);
        listDepartments1.push(depa);
    });
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

/*  User  */

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
    loadData(url, data, () => window.alert("Usuario Ingresado"));
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


function requestUpdateDataUser() {
    const url = 'http://localhost:8080/tusersE/listar';
    let data = new FormData();
    loadData(url, data, loadUpdateDataUser);
}

function loadUpdateDataUser(data) {
    let tbody = document.getElementById('bodyTable_users');
    listUsuarios = data;
    tbody.innerHTML = '';
    let i = 0;
    for (let d of data) {
        let tr = document.createElement('tr');
        let tdText1 = document.createElement('td');
        let tdText2 = document.createElement('td');
        let tdText3 = document.createElement('td');
        let tdText4 = document.createElement('td');
        let tdText5 = document.createElement('td');
        let tdText6 = document.createElement('td');
        let tdText7 = document.createElement('td');
        let tdText8 = document.createElement('td');
        let tdText9 = document.createElement('td');
        let tdText10 = document.createElement('td');
        let tdText11 = document.createElement('td');
        let tdText12 = document.createElement('td');

        tdText1.appendChild(document.createTextNode(d.temployee.dni + ''));
        tdText2.appendChild(document.createTextNode(d.temployee.firstName + ''));
        tdText3.appendChild(document.createTextNode(d.temployee.firstSurname + ''));
        tdText4.appendChild(document.createTextNode(d.temployee.secondSurname + ''));
        tdText5.appendChild(document.createTextNode(d.temployee.email + ''));
        tdText6.appendChild(document.createTextNode(d.temployee.telephone + ''));
        tdText7.appendChild(document.createTextNode(d.temployee.tdepartment.departmentName + ''));
        tdText8.appendChild(document.createTextNode(d.temployee.tjob.jobTitle + ''));
        tdText9.appendChild(document.createTextNode(d.status + ''));
        tdText10.appendChild(document.createTextNode(d.username + ''));
        tdText11.appendChild(document.createTextNode(d.passwd + ''));

        tr.appendChild(tdText1);
        tr.appendChild(tdText2);
        tr.appendChild(tdText3);
        tr.appendChild(tdText4);
        tr.appendChild(tdText5);
        tr.appendChild(tdText6);
        tr.appendChild(tdText7);
        tr.appendChild(tdText8);
        tr.appendChild(tdText9);
        tr.appendChild(tdText10);
        tr.appendChild(tdText11);

        let btn = document.createElement('button');
        btn.setAttribute('value', i++);
        btn.type = 'button';
        btn.innerText = "Seleccionar"
        btn.addEventListener('click', function () {
            seleccionar(btn.value);
        });
        tdText12.appendChild(btn);
        tr.appendChild(tdText12);
        tbody.appendChild(tr);
    }
}

function seleccionar(i) {
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
        updateUser(i);
    });

    e_emailUpdt.value = listUsuarios[i].temployee.email;
    e_telUpdt.value = listUsuarios[i].temployee.telephone;
    u_userUpdt.value = listUsuarios[i].username;
    u_passUpdt.value = listUsuarios[i].passwd;
    e_departmentUpdt.selectedIndex = getIndex(e_departmentUpdt, listUsuarios[i].temployee.tdepartment.departmentName);
    e_positionUpdt.selectedIndex = getIndex(e_positionUpdt, listUsuarios[i].temployee.tjob.jobTitle);
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

function updateUser(i) {
    const url = 'http://localhost:8080/tusersE/update';
    let e_emailUpdt = document.getElementById('e_emailUpdt').value;
    let e_telUpdt = document.getElementById('e_telUpdt').value;
    let e_departmentUpdt = document.getElementById('e_departmentUpdt').value;
    let e_positionUpdt = document.getElementById('e_positionUpdt').value;
    let u_userUpdt = document.getElementById('u_userUpdt').value;
    let u_passUpdt = document.getElementById('u_passUpdt').value;
    let usuario = listUsuarios[i];
    usuario.temployee.email = e_emailUpdt;
    usuario.temployee.telephone = e_telUpdt;
    usuario.temployee.tdepartment.departmentName = e_departmentUpdt;
    usuario.temployee.tjob.jobTitle = e_positionUpdt;
    usuario.username = u_userUpdt;
    usuario.passwd = u_passUpdt;
    let data = new FormData();
    data.append('user', JSON.stringify(usuario));
    console.log(JSON.stringify(usuario));
    loadData(url, data, () => {
        window.alert("Actualizado")
    });
}

function addReq() {
    // let panelAlreadyAdd = document.getElementById('panelAlreadyAdd');
    let i = document.getElementById('list_req').value;
    reqProc.push(listRequisitos[i]);
    let panelAlreadyAdd = document.getElementById('panelAlreadyAdd');
    let li = document.createElement('li');
    li.innerHTML = `<div><p>${listRequisitos[i].title}</p><span><button type='button' onclick="deleteReqProc(${listRequisitos[i].requirementId})">Eliminar</button></span></div>`;
    li.setAttribute('id', `li_${listRequisitos[i].requirementId}`)
    panelAlreadyAdd.appendChild(li);
}

function deleteReqProc(requirementId) {
    let panelAlreadyAdd = document.getElementById('list_reqUpdt');
    let li = document.getElementById('li_' + requirementId);
    panelAlreadyAdd.removeChild(li);
}

function createProc() {
    let data = new FormData();
    const url = 'http://localhost:8080/t_requests/insert';
    let title = document.getElementById('title_proc').value;
    let desc = document.getElementById('desc_proc').value;
    data.append('TRequirements', JSON.stringify(reqProc));
    data.append('title', title);
    data.append('description', desc);
    loadData(url, data, () => {
        window.alert("insertado")
    });
}

function loadUpdate() {
    const url = 'http://localhost:8080/t_requests/listar';
    let data = new FormData();
    loadData(url, data, loadUpdateDataRequest);
}

function loadUpdateDataRequest(datos) {
    list_request = datos;
    let bodyTablaUpdt = document.getElementById('bodyTablaUpdt');
    for (let d of datos) {
        let tr = document.createElement('tr');
        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        td1.textContent = d.title;
        td2.textContent = d.description;
        td3.innerHTML = `<button type='button' onclick="addReqUpdt(${d.requestId})">Ver Requisitos</button>`;
        td4.innerHTML = `<button type='button' onclick="selecProc(${d.requestId})">Seleccionar</button>`;
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        bodyTablaUpdt.appendChild(tr);
    }
}

function addReqUpdt(id) {
    // let i = document.getElementById('list_reqUpdt').value;
    let request = list_request.find(r => r.requestId === id);
    if (request) {
        let list = request.trequirements;
        let ulRequire = document.getElementById('list_reqUpdt');
        ulRequire.innerHTML = '';
        for (let r of list) {
            let li = document.createElement('li');
            li.innerHTML = `<div><p>${r.title}</p><span><button type='button' onclick="deleteReqProc(${r.requirementId})">Eliminar</button></span></div>`;
            li.setAttribute('id', `li_${r.requirementId}`);
            ulRequire.appendChild(li);
        }
    }
}


function updateProc() {
    const url = 'http://localhost:8080/t_requests/update';
    let data = new FormData();
    data.append('TRequirements', JSON.stringify(listRequisitos));
    data.append('title', document.getElementById('title_procUpdt').value);
    data.append('description', document.getElementById('desc_procUdpt').value);
    loadData(url, data, () => {
        window.alert('Actualizado');
    });
}

function selecProc(id) {
    let request = list_request.find(r => r.requestId === id);
    if (request) {
        let t = document.getElementById('title_procUpdt');
        let d = document.getElementById('desc_procUdpt');
        t.value = request.title;
        d.value = request.description;
    }
}

window.onunload = () => {
    listUsuarios = [];
    listDepartments = [];
    listDepartments1 = [];
    listRequisitos = [];
    reqProc = [];
    list_request = [];
    prod = null;
};