<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils" %>

<template:admin>

  <div class="container">

      <fieldset class="panel panel-primary">
        <header class="panel-heading">
          ${title}
        </header>
        <main class="panel-body">
          <form class="form-horizontal" novalidate>

            <div class="form-group">
              <label class="col-sm-2 text-right control-label" for="fieldEmail">
                E-mail:
              </label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="fieldEmail" placeholder="Email" name="email" value="${ param.email }">
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-2 text-right control-label" for="fieldLimit">
                Exibir:
              </label>
              <div class="col-sm-2">
                <select class="form-control" name="limit" id="fieldLimit">
                  <option value="25" ${ param.limit == 25 ? 'selected="selected"' : '' }>25</option>
                  <option value="50" ${ param.limit == 50 ? 'selected="selected"' : '' }>50</option>
                  <option value="150" ${ param.limit == 150 ? 'selected="selected"' : '' }>150</option>
                  <option value="300" ${ param.limit == 300 ? 'selected="selected"' : '' }>300</option>
                </select>
              </div>
              <div class="col-sm-8">
                registros por página
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Buscar</button>
              </div>
            </div>

          </form>
        </main>
      </fieldset>


    <c:choose>
      <c:when test="${ empty emails }">
        <div class="bg-danger text-center">
          <p>
            <i class="glyphicon glyphicon-info-sign"></i>
            Nenhum e-mail encontrado
          </p>
        </div>
      </c:when>
      <c:otherwise>

        <p class="bg-success text-center">
          Foram encontrados: ${emails.getTotalElements() } registros
        </p>

        <div class="table-responsive">
          <table class="table table-striped table-bordered">
            <thead>
            <tr>
              <th>ID</th>
              <th>Email</th>
              <th>Criado em</th>
              <th>Ativo</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ emails.getContent() }" var="email">
              <tr>
                <td>${ email.getId() }</td>
                <td>${ email.getEmail() }</td>
                <td>${ email.getDateCreated() }</td>
                <td>${ email.getAtivo() }</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>

        <c:if test="${ emails.getTotalPages() > 1 }">
          <utils:paginator instance="${ paginator }"/>
        </c:if>


      </c:otherwise>
    </c:choose>


  </div>

</template:admin>
