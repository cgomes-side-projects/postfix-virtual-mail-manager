<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/templates/" prefix="template" %>

<template:admin>

  <div class="container">


      <fieldset class="panel panel-default">
        <header class="panel-heading">
          ${title}
        </header>
        <main class="panel-body">
          <form class="form-horizontal">

            <div class="form-group">
              <label class="col-sm-2 text-right control-label" for="exampleInputEmail1">
                E-mail:
              </label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-2 text-right control-label" for="exampleInputEmail1">
                Exibir:
              </label>
              <div class="col-sm-2">
                <select class="form-control">
                  <option value="25">25</option>
                  <option value="50">50</option>
                  <option value="150">150</option>
                  <option value="300">300</option>
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
