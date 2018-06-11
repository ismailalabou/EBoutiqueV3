<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<f:form modelAttribute="categorie" action="enregistrer" enctype="multipart/form-data">
	<div class="error">
		${errors}
	</div>
	
	<table>
		<tr>
			<td>ID Catégorie:</td>
			<td><f:input type="hidden" path="idCategorie"/>
			${categorie.idCategorie}
			</td>
		</tr>
		<tr>
		<td>Nom Catégorie</td>
			<td><f:input path="nomCategorie"/></td>
			<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><f:textarea path="description" cols="50" rows="5"/></td>
			<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
		</tr>
		<tr>
			<td>Photo</td>
			<td>
				<c:if test="${categorie.idCategorie!=null}">
					<img src="photoCat?idCat=${categorie.idCategorie}"/>
				</c:if>
				<input name="file" type="file"/>
			</td>
			<td><f:errors path="photo" cssClass="errors"></f:errors></td>
		</tr>
		<tr>
			<td><input type="submit" value="Enregistrer"></td>
		</tr>
	</table>
</f:form>

<table class="table1">
	<tr>
		<th>ID</th><th>NOM CAT</th> <th>Description</th><th>Photo</th>
	</tr>
	<c:forEach items="${categories}" var="cat">
		<tr>
			<td>${cat.idCategorie }</td>
			<td>${cat.nomCategorie}</td>
			<td>${cat.description}</td>
			<td><img src="photoCat?idCat=${cat.idCategorie}"/></td>
			<td><a href="suppCat?idCat=${cat.idCategorie}">Supprimer</a></td>
			<td><a href="editCat?idCat=${cat.idCategorie}">Edit</a></td>
		</tr>
	</c:forEach>
</table>