function main() {
  var btn = document.querySelector('#salvar');
  btn.addEventListener("click", validar);
}

function validar() {
  var camposinvalidos = [];
  var camposvalidos = [];
  var i = 0;
  var j = 0;
  var id = document.querySelector('#campoIdServico');
  var nome = document.querySelector('#campoNomeServico');
  var preco = document.querySelector('#campoPrecoPeca');


  if (id.value == '') {
    camposinvalidos[i] = "#campoIdServico";
    i++;
  } else {
    camposvalidos[j] = "#campoIdServico";
    j++;
  }
  if (nome.value == '') {
    camposinvalidos[i] = "#campoNomeServico";
    i++;
  } else {
    camposvalidos[j] = "#campoNomeServico";
    j++;
  
  }
  if (preco.value == '') {
    camposinvalidos[i] = "#campoPrecoPeca";
    i++;
  } else {
    camposvalidos[j] = "#campoPrecoPeca";
    j++;
  }
  if (i != 0) {
    
    destacacampos(camposinvalidos);
    if (j != 0) {
      retornacampos(camposvalidos);
    }
  } else {
    retornacampos(camposvalidos);
  }
}

function destacacampos(camposinvalidos) {
  for (var i = 0; i < camposinvalidos.length; i++) {
      document.querySelector(camposinvalidos[i]).className = 'camposdestacados';
    }
}

function retornacampos(camposvalidos) {
  for (var i = 0; i < camposvalidos.length; i++) {
      document.querySelector(camposvalidos[i]).className = 'campos';
    }
}

window.addEventListener("load", main);
