<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils" %>

<c:choose>
  <c:when test="${domain.getId() == 0 }">
    <c:set var="action" value="/domains/create" />
  </c:when>
  <c:otherwise>
    <c:set var="action" value='"/domains/edit/"${  domain.getId() }' />
  </c:otherwise>
</c:choose>

<template:admin>
  <div class="container-fluid">
    <form:form role="form" method="post" action="${action}" modelAttribute="domain" >
      <fieldset class="panel panel-default">

        <header class="panel-heading">
          <i class="fa fa-globe"></i>
          Domínio
        </header>

        <main class="form-horizontal wrapper">

          <utils:messages />

          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Nome:</label>

            <div class="col-sm-9 col-md-6">
              <input name="name" class="form-control" placeholder="Digite o domínio completo" value="${domain.getName()}" type="text" />
              <form:errors path="name" cssClass="error bg-danger" />
            </div>
          </div>


          <div class="form-group">
            <label class="control-label col-sm-3 col-md-2">Ativo:</label>
            <div class="col-md-3">
              <div class="radio">
                <label>
                  <input type="radio" name="active" id="domainActive1" value="1" ${ domain.isActive() ? "checked" : "" } />
                  Sim
                </label>
                <label>
                  <input type="radio" name="active" id="domainActive2" value="0" ${ ! domain.isActive() ? "checked" : "" } />
                  Não
                </label>
              </div>
              <form:errors path="active" cssClass="error bg-danger" />
            </div>
          </div>
        </main>

        <footer class="panel-footer container-fluid form-horizontal">
          <div class="form-group">
            <label class="col-sm-3 col-md-2"></label>
            <div class="col-sm-5">
              <a href="/domains" class="btn btn-sm btn-warning">
                <i class="fa fa-arrow-left"></i>
                voltar
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

