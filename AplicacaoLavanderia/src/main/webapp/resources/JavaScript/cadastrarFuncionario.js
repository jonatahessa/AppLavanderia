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

function mascara(t, mask) {
  var i = t.value.length;
  var saida = mask.substring(1, 0);
  var texto = mask.substring(i)
  if (texto.substring(0, 1) != saida) {
    t.value += texto.substring(0, 1);
  }
}

window.addEventListener("load", main);
