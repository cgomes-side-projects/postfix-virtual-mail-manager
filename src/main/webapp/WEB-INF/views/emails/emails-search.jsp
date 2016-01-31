<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils" %>

<template:admin>

  <div class="container-fluid">

      <fieldset class="panel panel-default">

        <header class="panel-heading">
          Buscar e-mails
        </header>

        <form class="container-fluid wrapper" novalidate>

          <div class="row">
            <div class="col-sm-8 col-sm-push-2">
              <div class="input-group">
                <input type="email" class="form-control input-sm" placeholder="Digite um nome para filtrar" name="email" value="${ param.email }">
                <span class="input-group-btn">
                  <button class="btn btn-sm btn-primary" type="submit"><i class="fa fa-search"></i></button>
                </span>
              </div>
            </div>
          </div>
        </form>

        <c:choose>
          <c:when test="${ emails.getNumberOfElements() == 0 }">
            <div class="bg-danger text-center">
              <p class="wrapper">
                <i class="glyphicon glyphicon-info-sign"></i>
                Nenhum e-mail encontrado
              </p>
            </div>
          </c:when>
          <c:otherwise>

            <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                <tr>
                  <th></th>
                  <th>Email</th>
                  <th>Criado em</th>
                  <th>Ativo</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ emails.getContent() }" var="email">
                  <tr>
                    <td>
                      <a href="/emails/edit/${ email.getId() }" class="btn btn-primary btn-xs">
                        <i class="fa fa-pencil"></i>
                      </a>
                    </td>
                    <td>${ email.getEmail() }@${email.getDomain().getName() }</td>
                    <td></td>
                    <td></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>


              <footer class="panel-footer">
                <div class="row">
                  <aside class="col-md-6 text-muted text-center"> Exibindo ${ paginator.getPageFirstItemNumber() } - ${ paginator.getPageLastItemNumber() }  de ${ paginator.getTotalItems() } registros</aside>
                  <aside class="col-md-6">
                    <c:if test="${ emails.getTotalPages() > 1 }">
                      <utils:paginator instance="${ paginator }"/>
                    </c:if>
                  </aside>
                </div>
              </footer>
          </c:otherwise>
        </c:choose>



      </fieldset>
  </div>

</template:admin>
