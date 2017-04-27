function main() {
  var cancelar = document.querySelector("#cancelar");
  cancelar.addEventListener("click", limpar);
}

function limpar() {
  var campos = document.querySelectorAll("input,date");
  for (var i=0; i < campos.length; i++) {
      campos[i].value = "";
  }
}

function validaemail(email) {
    var valida = false;
    var usuario = email.substring(0, email.indexOf("@"));
    var dominio = email.substring(email.indexOf("@") + 1, email.length);

    if ((usuario.length >= 1) &&
            (dominio.length >= 3) &&
            (usuario.search("@") == -1) &&
            (dominio.search("@") == -1) &&
            (usuario.search(" ") == -1) &&
            (dominio.search(" ") == -1) &&
            (dominio.search(".") != -1) &&
            (dominio.indexOf(".") >= 1) &&
            (dominio.lastIndexOf(".") < dominio.length - 1)) {
        valida = true;
    } else {
        valida = false;
    }
    return valida;
}

function mascara(t, mask) {
  var i = t.value.length;
  var saida = mask.substring(1, 0);
  var texto = mask.substring(i)
  if (texto.substring(0, 1) != saida) {
    t.value += texto.substring(0, 1);
  }
}

window.addEventListener("load", main);
