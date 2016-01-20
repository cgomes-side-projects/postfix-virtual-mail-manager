<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="instance" required="true" type="com.pvmm.utils.Paginator" %>
<nav class="text-center">
  <ul class="pagination pagination-sm">

    <li class="<%= instance.isFirst() ? "disabled" : ""  %>">
      <a <% if( ! instance.isFirst() ) { %>href="${ instance.getPageLink(1) }"<% } %> aria-label="Primeira página" title="Primeira página">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <% for(int i = instance.getStartButton(); i <= instance.getEndButton(); i++) { %>
      <li class="<%= instance.isCurrentPage(i) ? "disabled" : ""  %>">
        <a <% if( ! instance.isCurrentPage(i) ) { %>href="<%= instance.getPageLink(i) %>" <% } %>><%= i %></a>
      </li>
    <% } %>

    <li class="<%= instance.isLast() ? "disabled" : ""  %>">
      <a <% if( ! instance.isLast() ) { %>href="${ instance.getPageLink( instance.getTotalPages() ) }"<% } %> aria-label="Última página" title="Última página">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
