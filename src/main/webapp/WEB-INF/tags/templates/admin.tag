<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Email manager</title>
  <%-- TODO create a way to update the page title --%>

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- bootstrap -->
  <link rel="stylesheet" href="<c:url value='/assets/styles/main.css'/>">

  <!-- style -->
   <jsp:invoke fragment="extraStyles"/>
</head>

<body>

  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">

        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Project Name</a>
      </div>

      <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<c:url value='/product/form'/>">
                      <i class="glyphicon glyphicon-plus-sign"></i>
                      Add product
                    </a>
                </li>
	              <li>
                    <a href="<c:url value='/product'/>">
                      <i class="glyphicon glyphicon-menu-hamburger"></i>
                      List product
                    </a>
                </li>
				        <li role="separator" class="divider"></li>
	              <li>
                    <a href="<c:url value='/category/form'/>">
                      <i class="glyphicon glyphicon-plus-sign"></i>
                      Add category
                    </a>
                </li>
	              <li>
                    <a href="<c:url value='/category'/>">
                      <i class="glyphicon glyphicon-menu-hamburger"></i>
                      List category
                    </a>
                </li>
				      <li role="separator" class="divider"></li>
            </ul>
          </li>
        </ul>

      </div>
    </div>
  </nav>

	<jsp:doBody />


  <div class="hidden">
    <script src="<c:url value='/assets/js/plugins.min.js'/>"></script>
    <script src="<c:url value='/assets/js/scripts.min.js'/>"></script>
    <jsp:invoke fragment="extraScripts"/>
  </div>

</body>
</html>
