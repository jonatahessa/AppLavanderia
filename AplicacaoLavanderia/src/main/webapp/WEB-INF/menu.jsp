<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="StyleSheet" type="text/css" href="./resources/CSS/menu.css" media="screen" >
<div id="menu">
 <div class="col-md-1">
            <ul class="nav nav-pills nav-stacked">
                <!--<li class="active"><a href="index.jsp"><i class="fa fa-home fa-fw"></i> Início</a></li>
                <li><a href="lavar.jsp"><i class="fa fa-shower"></i>Lavar</a></li>
                <li><a href="consultaServico.jsp"><i class="fa fa-cubes fa-fw"></i> Serviços</a></li>
                <li><a href="consultaCliente.jsp"><i class="fa fa-users fa-fw"></i> Clientes</a></li>
                <li><a href="consultaFuncionario.jsp"><i class="fa fa-id-card fa-fw"></i> Funcionários</a></li>
                <li><a href="consultaUnidade.jsp"><i class="fa fa-building fa-fw"></i> Unidades</a></li>
                <li><a href="relatorios.jsp"><i class="fa fa-pie-chart fa-fw"></i> Relatórios</a></li>
                -->
                <li class="active"><form action="Redirecionar" method="post" id="home">
                        <input type="hidden" name="tela" value="/WEB-INF/home.jsp">
                        <a href="#" onclick="document.getElementById('home').submit()"><i class="fa fa-home fa-fw"></i>Home</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="lavar">
                        <input type="hidden" name="tela" value="/WEB-INF/lavar.jsp">
                        <a href="#" onclick="document.getElementById('lavar').submit()"><i class="fa fa-shower"></i>Lavar</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="servico">
                        <input type="hidden" name="tela" value="/WEB-INF/consultaServico.jsp">
                        <a href="#" onclick="document.getElementById('servico').submit()"><i class="fa fa-cubes fa-fw"></i>Servicos</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="cliente">
                        <input type="hidden" name="tela" value="/WEB-INF/consultaCliente.jsp">
                        <a href="#" onclick="document.getElementById('cliente').submit()"><i class="fa fa-users fa-fw"></i>Clientes</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="funcionario">
                        <input type="hidden" name="tela" value="/WEB-INF/consultaFuncionario.jsp">
                        <a href="#" onclick="document.getElementById('funcionario').submit()"><i class="fa fa-id-card fa-fw"></i>Funcionários</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="unidade">
                        <input type="hidden" name="tela" value="/WEB-INF/consultaUnidade.jsp">
                        <a href="#" onclick="document.getElementById('unidade').submit()"><i class="fa fa-building fa-fw"></i>Unidades</a>
                     </form>
                </li>
                <li><form action="Redirecionar" method="post" id="relatorio">
                        <input type="hidden" name="tela" value="/WEB-INF/relatorio.jsp">
                        <a href="#" onclick="document.getElementById('relatorio').submit()"><i class="fa fa-pie-chart fa-fw"></i>Relatório</a>
                     </form>
                </li>
                
            </ul>
        </div>
</div>


<!--

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" type="text/css" href="./resources/CSS/menu.css" media="screen" >
<meta charset="utf-8">
<div id = "menu">
    <form method="get" action="consultaFuncionario.jsp"><button class="botaomenu" type="submit">Funcionários</button></form>
    <form method="get" action="consultaCliente.jsp"><button class="botaomenu" type="submit">Clientes</button></form>
    <form method="get" action="consultaServico.jsp"><button class="botaomenu" type="submit">Serviços</button></form>
    <form method="get" action="relatorios.jsp"><button class="botaomenu" type="submit">Relatórios</button></form>
    <form method="get" action="vender.jsp"><button class="botaomenu" type="submit">Vender</button></form>
    <form method="get" action="cadastroUnidade.jsp"><button class="botaomenu" type="submit">Unidades</button></form>
</div> -->
