<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*" %>

<!-- A basic loop -->
<c:forEach var="number" begin="5" end="10">
    <c:out value="${number}"></c:out>
</c:forEach>

<!-- We'll use a scriptlet to create a list to iterate over -->
<%
   // Create an ArrayList with test data
   ArrayList list = new ArrayList();
   list.add("String 1");
   list.add("String 2");
   list.add("String 3");
   pageContext.setAttribute("list", list);
%>

<!-- We can use forEach to loop over the ArrayList -->
<c:forEach items="${list}" var="item">
    <li><c:out value="${fn:toUpperCase(item)}" /></li>
</c:forEach>
