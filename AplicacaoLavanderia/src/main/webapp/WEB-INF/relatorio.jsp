<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoCliente"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/relatorio.css">
        <script type="text/javascript" src="./resources/JavaScript/relatorio.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- lib box de confirmação -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>
        <!-- lib salvar para excel -->
        <link rel="stylesheet" type="text/css" href="https://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>


        <title>Consulta Cliente</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./relatorio" method="post">
                <fieldset>
                    <h1>Relatório</h1>
                    <article>
                        <section class="color-pattern-1">
                            <div class="campoTotal">
                                <div class="filho">
                                    <label>De:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>      
                                <div class="filho">
                                    <label>Até:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>   
                                <button class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-search fa-la"></span> Pesquisar</button>
                                <input type="button" class="btn btn-info button button-1 button-1a button_add" value=" Salvar" onclick="exportToExcel('exTable')" /></span>
                        </section>
                    </article> 
                </fieldset>
            </form>
            <table id="exTable" border="1">
                <thead class="lockedRecordsBg">
                    <tr>
                        <th>S#</th>
                        <th>name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Country</th>
                </thead>
                <tbody>
                    <tr>
                        <td rel="client">1</td>
                        <td rel="regionName">Sudhir K Gupta</td>
                        <td rel="date">sudhirgupta.456@gmail.com</td>
                        <td rel="shift">+91 89********</td> 
                        <td rel="shift">India</td>             
                    </tr>
                    <tr>
                        <td rel="client">2</td>
                        <td rel="regionName">Sudhir K Gupta</td>
                        <td rel="date">test@gmail.com</td>
                        <td rel="shift">+91 89********</td> 
                        <td rel="shift">USA</td>             
                    </tr>
                </tbody>
            </table> 
            
        </div>

    </body>
</html>
