<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sql:query var="rs" dataSource="jdbc/TravelDB">
select quarterID, name, luxury from quarters
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>
  
<c:forEach var="row" items="${rs.rows}">
    name ${row.name}<br/>
    luxury ${row.luxury}<br/>
</c:forEach>

  </body>
</html>