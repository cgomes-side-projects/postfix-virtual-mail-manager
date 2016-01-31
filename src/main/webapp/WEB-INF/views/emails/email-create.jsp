<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>

<template:admin>
  <div class="container-fluid">
    <form:form method="POST" action="/emails/create" modelAttribute="newEmail">
      <fieldset class="panel panel-default">

        <header class="panel-heading">
          <i class="fa fa-globe"></i>
          Novo E-mail
        </header>

        <main class="form-horizontal wrapper">

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Email:</label>

            <div class="col-sm-9 col-md-6">
              <input name="email" class="form-control" placeholder="Digite o email" value="${email.getEmail()}" type="text" />
            </div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Domínio:</label>

            <div class="col-sm-9 col-md-6">
              <input name="domain.id" class="form-control" value="${email.getDomain().getName()}" type="text" />
            </div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Senha:</label>

            <div class="col-sm-9 col-md-6">
              <input name="password" class="form-control" placeholder="Digite a senha" value="${email.getPassword() }" type="password" />
            </div>
          </div>


          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Ativo:</label>
            <div class="col-md-3">
              <div class="radio">
                <label>
                  <input type="radio" name="active" id="active1" value="1" checked />
                  Sim
                </label>
                <label>
                  <input type="radio" name="active" id="active2" value="0" />
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
              <a href="/emails" class="btn btn-sm btn-warning">
                <i class="fa fa-arrow-left"></i>
                Voltar
              </a>

              <button type="submit" class="btn btn-sm btn-success">
                <i class="fa fa-save"></i>
                Gravar
              </button>
            </div>
          </div>
        </footer>

      </fieldset>
    </form:form>

  </div>
</template:admin>

