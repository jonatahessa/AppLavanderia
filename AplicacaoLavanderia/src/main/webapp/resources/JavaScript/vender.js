window.addEventListener("load", main);

function main() {
  var cancelar = document.querySelector("#cancelar");
  cancelar.addEventListener("click", limpar);
}

function limpar() {
  var campos = document.querySelectorAll("input");
  for (var i=0; i < campos.length; i++) {
      campos[i].value = "";
  }
}