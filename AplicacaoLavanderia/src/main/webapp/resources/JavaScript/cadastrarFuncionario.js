function main() {
    var btn = document.querySelector('#salvar');
    btn.addEventListener("click", validar);
}

function validar() {
    var camposinvalidos = [];
    var camposvalidos = [];
    var i = 0;
    var j = 0;
    var nome = document.querySelector('#camponome');
    var cpf = document.querySelector('#campocpf');
    var data_Nasc = document.querySelector('#campoidade');
    var sexo = document.querySelector('#camposexo');
    var endereco = document.querySelector('#campoendereco');
    var cep = document.querySelector('#campocep');
    var cidade = document.querySelector('#campocidade');
    var estado = document.querySelector('#campoestado');
    var email = document.querySelector('#campoemail');
    var telefone = document.querySelector('#campotelefone');
    var ctps = document.querySelector('#campoctps');
    var data_Admissao = document.querySelector('#campoadmissao');
    var cargo = document.querySelector('#campocargo');
    var filaiis = document.querySelector('#campofiliais');
    
    if (nome.value == '') {
        camposinvalidos[i] = "#camponome";
        i++;
    } else {
        camposvalidos[j] = "#camponome";
        j++;
    }
    if (cpf.value == '') {
        camposinvalidos[i] = "#campocpf";
        i++;
    } else {
        camposvalidos[j] = "#campocpf";
        j++;
    }
      if (data_Nasc.value == '') {
        camposinvalidos[i] = "#campoidade";
        i++;
    } else {
        camposvalidos[j] = "#campoidade";
        j++;
    }
      if (sexo.value == '') {
        camposinvalidos[i] = "#camposexo";
        i++;
    } else {
        camposvalidos[j] = "#camposexo";
        j++;
    }
      if (endereco.value == '') {
        camposinvalidos[i] = "#campoendereco";
        i++;
    } else {
        camposvalidos[j] = "#campoendereco";
        j++;
    }
      if (cep.value == '') {
        camposinvalidos[i] = "#campocep";
        i++;
    } else {
        camposvalidos[j] = "#campocep";
        j++;
    }
      if (cidade.value == '') {
        camposinvalidos[i] = "#campocidade";
        i++;
    } else {
        camposvalidos[j] = "#campocidade";
        j++;
    }
      if (estado.value == '') {
        camposinvalidos[i] = "#campoestado";
        i++;
    } else {
        camposvalidos[j] = "#campoestado";
        j++;
    }
          if (ctps.value == '') {
        camposinvalidos[i] = "#campoctps";
        i++;
    } else {
        camposvalidos[j] = "#campoctps";
        j++;
    }
      if (data_Admissao.value == '') {
        camposinvalidos[i] = "#campoadmissao";
        i++;
    } else {
        camposvalidos[j] = "#campoadmissao";
        j++;
    }
          if (cargo.value == '') {
        camposinvalidos[i] = "#campoecargo";
        i++;
    } else {
        camposvalidos[j] = "#campofiliais";
        j++;
    }
          if (filiais.value == '') {
        camposinvalidos[i] = "#campofiliais";
        i++;
    } else {
        camposvalidos[j] = "#campofiliais";
        j++;
    }
    
    if (validaemail(email.value) == false) {
        camposinvalidos[i] = "#campoemail";
        i++;
    } else {
        camposvalidos[j] = "#campoemail";
        j++;
    }
    if (telefone.value == '') {
        camposinvalidos[i] = "#campotelefone";
        i++;
    } else {
        camposvalidos[j] = "#campotelefone";
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
