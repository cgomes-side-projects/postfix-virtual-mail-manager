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
              <a href="/emails" class="btn btn-sm btn-warning">
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


    <fieldset class="panel panel-default">
      <header class="panel-heading">
        Enviar cópia para:
      </header>
      <main class="panel-body">
        <form novalidate class="form-horizontal">
          <div class="form-group">


            <div class="col-sm-9 col-md-8">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Destinatário" />
                <span class="input-group-btn">
                  <button class="btn btn-primary" type="button">
                    <i class="fa fa-plus-circle"></i>
                    Adicionar
                  </button>
                </span>
              </div>
            </div>
          </div>
        </form>

        <div class="table-responsive">
          <table class="table table-striped">
            <tbody>
              <tr>
                <td>
                  <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
                </td>
                <td>
                  teste@tests.com.br
                </td>
              </tr><tr>
                <td>
                  <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
                </td>
                <td>
                  teste@tests.com.br
                </td>
              </tr><tr>
                <td>
                  <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
                </td>
                <td>
                  teste@tests.com.br
                </td>
              </tr><tr>
                <td>
                  <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
                </td>
                <td>
                  teste@tests.com.br
                </td>
              </tr>
            </tbody>
          </table>
        </div>

      </main>
    </fieldset>


    <fieldset class="panel panel-default">
      <header class="panel-heading">
        Recebe cópias de:
      </header>
      <main class="panel-body">
        <form novalidate class="form-horizontal">
          <div class="form-group">


            <div class="col-sm-9 col-md-8">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Remetente" />
                <span class="input-group-btn">
                  <button class="btn btn-primary" type="button">
                    <i class="fa fa-plus-circle"></i>
                    Adicionar
                  </button>
                </span>
              </div>
            </div>
          </div>
        </form>

        <div class="table-responsive">
          <table class="table table-striped">
            <tbody>
            <tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr>
            </tbody>
          </table>
        </div>

      </main>
    </fieldset>

    <fieldset class="panel panel-default">
      <header class="panel-heading">
        Participação em grupos:
      </header>
      <main class="panel-body">
        <form novalidate class="form-horizontal">
          <div class="form-group">


            <div class="col-sm-9 col-md-8">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Grupo" />
                <span class="input-group-btn">
                  <button class="btn btn-primary" type="button">
                    <i class="fa fa-plus-circle"></i>
                    Adicionar
                  </button>
                </span>
              </div>
            </div>
          </div>
        </form>

        <div class="table-responsive">
          <table class="table table-striped">
            <tbody>
            <tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr><tr>
              <td>
                <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
              </td>
              <td>
                teste@tests.com.br
              </td>
            </tr>
            </tbody>
          </table>
        </div>

      </main>
    </fieldset>

  </div>
</template:admin>
