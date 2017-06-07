
function mascara(t, mask) {
  var i = t.value.length;
  var saida = mask.substring(1, 0);
  var texto = mask.substring(i);
  if (texto.substring(0, 1) != saida) {
    t.value += texto.substring(0, 1);
  }
}



var confirmaForm;
function confirmar(form) {
    var div = document.querySelector(".alerta");
    div.classList.add("visivel");
    var div2 = document.querySelector(".nevoa");
    div2.classList.add("visivel");
    confirmaForm = form;
    return false;
}

function confirmar() {
    confirmaForm.submit();
}

function cancelar() {
    confirmaForm = null;
    var div = document.querySelector(".alerta");
    div.classList.remove("visivel");
    var div2 = document.querySelector(".nevoa");
    div2.classList.remove("visivel");
}

function limpar() {
  var campos = document.querySelectorAll("input");
  for (var i=0; i < campos.length; i++) {
      campos[i].value = "";
  }
}
