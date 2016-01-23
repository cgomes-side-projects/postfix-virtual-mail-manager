<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>
<jsp:useBean id="email" scope="request" type="com.pvmm.emails.email.Email"/>

<template:admin>
  <div class="container-fluid">
    <form role="form">
      <fieldset class="panel panel-default">

        <header class="panel-heading">
          <i class="fa fa-pencil"></i>
          Editar email
        </header>

        <main class="form-horizontal wrapper">

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Email:</label>

            <div class="col-sm-9 col-md-6">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Digite o email" value="${email.getEmail()}"/>
                <div class="input-group-addon primary">@${ email.getDomain().getDomain() }</div>
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Senha:</label>
            <div class="col-sm-4 col-md-3">
              <input type="text" class="form-control" placeholder="Re-definir senha" />
            </div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Ativo:</label>
            <div class="col-md-3">
              <div class="radio">
                <label>
                  <input type="radio" name="optionsRadios" id="optionsRadios1" value="1" ${ email.isAtivo() ? "checked" : "" } />
                  Sim
                </label>
                <label>
                  <input type="radio" name="optionsRadios" id="optionsRadios2" value="0" ${ ! email.isAtivo() ? "checked" : "" } />
                  Não
                </label>
              </div>
            </div>
          </div>
        </main>

        <footer class="panel-footer container-fluid form-horizontal">
          <div class="form-group">
            <label class="col-sm-3 col-md-2"></label>
            <div class="col-sm-5">
              <a href="/emails/buscar" class="btn btn-sm btn-warning">
                <i class="fa fa-arrow-left"></i>
                voltar
              </a>

              <button type="button" class="btn btn-sm btn-success">
                <i class="fa fa-save"></i>
                Gravar
              </button>
            </div>
          </div>
        </footer>

      </fieldset>
    </form>
  </div>
</template:admin>
