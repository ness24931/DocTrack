const head_text = `<div class="container-fluid" id="wrapper">
<div class="row">
<div class="col-4 col-md-2 offset-1" id="divImg">
    <img src="../img/images.png" class="img-fluid float-left" alt="Municipalidad Heredia">
</div>
<div class="col-4 col-md-3 col-lg-5">
    <h3 id="h3">
        Municipalidad de San Pablo de Heredia
    </h3>
</div>
</div>
</div>`;

function loadHeader() {
    let header = document.getElementById('head_user');
    if (header !== undefined && header !== null) {
        header.insertAdjacentHTML('afterbegin', head_text);
    } else {
        console.log('doesnt load the header');
    }    
}