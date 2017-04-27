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


window.addEventListener("load", main);
