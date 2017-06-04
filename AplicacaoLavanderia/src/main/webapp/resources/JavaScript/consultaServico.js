var removerForm;
function apagar(form) {
    var div = document.querySelector(".alerta");
    div.classList.add("visivel");
    var div2 = document.querySelector(".nevoa");
    div2.classList.add("visivel");
    removerForm = form;
    return false;
}

function confirmar() {
    removerForm.submit();
}

function cancelar() {
    removerForm = null;
    var div = document.querySelector(".alerta");
    div.classList.remove("visivel");
    var div2 = document.querySelector(".nevoa");
    div2.classList.remove("visivel");
}