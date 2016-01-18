<%@ attribute name="instance" required="true" type="com.pvmm.utils.Paginator" %>
<nav class="text-center">
  <ul class="pagination">

    <li class="<%= instance.isFirst() ? "disabled" : ""  %>">
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <% for(int i = instance.getStartButton(); i <= instance.getEndButton(); i++) { %>
      <li class="<%= instance.isCurrentPage(i) ? "disabled" : ""  %>">
        <a href="#"><%=i %></a>
      </li>
    <% } %>

    <li class="<%= instance.isLast() ? "disabled" : ""  %>">
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
