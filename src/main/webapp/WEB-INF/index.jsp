<%--
  Created by IntelliJ IDEA.
  User: WillieManuel
  Date: 16/7/16
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <meta content="Calculadora de Excel" name="description" />
        <meta content="Willie Caminero" name="author" />
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="../resources/css/styles.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <img class="logo img-responsive img-circle" src="../resources/images/logo.jpg" alt="Logo">
                    </div>
                    <div class="col-md-6">
                        <div class="page-header">
                            <h1 class="titulo">Calculadora de Excel</h1>
                        </div>
                        <div class="list-group">
                            <a href="" class="list-group-item">
                                <h4 class="list-group-item-heading">Cantidad Total de Articulos:</h4>
                                <p class="list-group-item-text"># ${respuestaProcesoExcel.getCantidadArticulos()}</p>
                            </a>
                        </div>
                        <div class="list-group">
                            <a href="" class="list-group-item">
                                <h4 class="list-group-item-heading">Cantidad General de Articulos:</h4>
                                <p class="list-group-item-text"># ${respuestaProcesoExcel.getCantidadArticulosGeneral()}</p>
                            </a>
                        </div>
                        <div class="list-group">
                            <a href="" class="list-group-item">
                                <h4 class="list-group-item-heading">Ingresos Netos:</h4>
                                <p class="list-group-item-text"># ${respuestaProcesoExcel.getIngresosNetos()}</p>
                            </a>
                        </div>
                        <div class="list-group">
                            <a href="" class="list-group-item">
                                <h4 class="list-group-item-heading">Impuestos:</h4>
                                <p class="list-group-item-text"># ${respuestaProcesoExcel.getImpuestos()}</p>
                            </a>
                        </div>
                        <div class="list-group">
                            <a href="" class="list-group-item">
                                <h4 class="list-group-item-heading">Ingresos Brutos:</h4>
                                <p class="list-group-item-text"># ${respuestaProcesoExcel.getIngresosBrutos()}</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <button type="button" class="btn btn-default btn-lg btn-block " onclick="window.location.href='/procesarExcel.html'">
                        Procesar <span class="glyphicon glyphicon-refresh"></span>
                    </button>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <link rel="script" href="../resources/js/jquery-1.11.3.min.js"/>
        <link rel="script" href="../resources/js/bootstrap.min.js"/>
    </body>
</html>
