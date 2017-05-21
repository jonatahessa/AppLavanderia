
function calcularTotal(){
    var quantidade = document.forms['formVendas']['quantidade'].value;
    var precounitario = document.forms['formVendas']['precounitario'].value;
    var valorFinal = quantidade * precounitario;
    document.forms['formVendas']['valortotal'].value = valorFinal;
}

$(function () {
  $(".tempInsert").keyup(function (e) {
    if (e.keyCode == 13)
      insertRow();
  });
  $("#tempBtn").click(function () {
    insertRow();
  });
  $("table").on("click", "tbody tr td a", function () {
    $(this).closest("tr").remove();
    return false;
  });
});

function insertRow() {
  if ($(".tempInsert").val().length > 0)
    $("table tbody").append('<tr><td>' + $(".tempNome").val() + '</td>\n\
                                 <td>' + $(".tempPrecoUnitario").val() + '</td>\n\
                                 <td>' + $(".tempQuantidade").val() + '</td>\n\
                                 <td>' + $(".tempInsert").val() + '</td>\n\
                                <td><a href="#">&times;</td></tr>');
  $("#tempInsert").val("");
}




function limpar() {
  var campos = document.querySelectorAll("input");
  for (var i=0; i < campos.length; i++) {
      campos[i].value = "";
  }
}
