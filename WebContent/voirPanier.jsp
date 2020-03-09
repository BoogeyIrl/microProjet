<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="display:inline;"> Bonjour mr ${sessionScope.utilisateur.nom} ${sessionScope.utilisateur.prenom} </p>
<c:if test="${!empty utilisateur.panier}">
<table>
  <tr>
    <th>Code Article</th>
    <th>Designation</th>
    <th>Prix</th>
    <th>Stock</th>
    <th></th>
  </tr>

<c:forEach var="item" items="${utilisateur.panier}">
	<tr>
 		<tr><td>${item.article.codeArticle}</td>
 		<td>${item.article.designation}</td>
 		<td>${item.article.prix}</td>
 		<td>${item.quantite}</td>
 		<td>
 		<a href="SupprimerArticle?articleasupp=${item}">Supprimer </a>
 		</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>