<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
	<c:forEach items="${categories }" var="cat">
		<tr>
			<td>
				<a href="produitsParCat?idCat=${cat.idCategorie}">${cat.nomCategorie}</a>
			</td>
		</tr>
	</c:forEach>
</table>