<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils" %>

<template:admin>

  <div class="container-fluid">

    <fieldset class="panel panel-default">

      <header class="panel-heading">
          Gerenciar domínios
      </header>

      <form class="container-fluid wrapper" novalidate>

        <div class="row">
          <div class="col-sm-8 col-sm-push-2">
            <div class="input-group">
              <input type="email" class="form-control input-sm" placeholder="Digite um nome para filtrar" name="email" value="${ param.query }">
                <span class="input-group-btn">
                  <button class="btn btn-sm btn-primary" type="submit"><i class="fa fa-search"></i></button>
                </span>
            </div>
          </div>
        </div>
      </form>

      <c:choose>
        <c:when test="${ domains.getNumberOfElements() == 0 }">
          <div class="bg-danger text-center">
            <p class="wrapper">
              <i class="glyphicon glyphicon-info-sign"></i>
              Nenhum registro encontrado
            </p>
          </div>
        </c:when>
        <c:otherwise>

          <div class="table-responsive">
            <table class="table table-striped">
              <tbody>
              <c:forEach items="${ domains.getContent() }" var="domain">
                <tr>
                  <td class="col-xs-1">
                    <a href="/domains/edit/${ domain.getId() }" class="btn btn-primary btn-xs">
                      <i class="fa fa-pencil"></i>
                    </a>
                  </td>
                  <td class="col-xs-11">
                    ${ domain.name }
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>

          <footer class="panel-footer">
            <div class="row">
              <aside class="col-md-6 text-muted text-center"> Exibindo ${ paginator.getPageFirstItemNumber() } - ${ paginator.getPageLastItemNumber() }  de ${ paginator.getTotalItems() } registros</aside>
              <aside class="col-md-6">
                <c:if test="${ paginator.getTotalPages() > 1 }">
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
