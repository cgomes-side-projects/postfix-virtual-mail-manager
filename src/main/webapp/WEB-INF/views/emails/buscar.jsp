<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>

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
                registros por vez
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


  </div>

</template:admin>
