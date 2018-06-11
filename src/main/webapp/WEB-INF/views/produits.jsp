<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<div class="errors">
	${exception}
</div>

<div class="cadre" style="text-align: left;">
	<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
</div>

<div id="formProd" class="cadre">
	<f:form modelAttribute="produit" action="saveProd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit:</td>
				<td>${produit.idProduit}<f:input type="hidden" path="idProduit"/></td>
				<td><f:errors path="idProduit" cssClass="errors"></f:errors> </td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><f:input path="designation"/></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Catégorie</td>
				<td><f:select path="categorie.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie"></f:select></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><f:input path="prix"/></td>
				<td><f:errors path="prix" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><f:input path="quantité"/></td>
				<td><f:errors path="quantité" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Sélectionner</td>
				<td><f:checkbox path="selectionner"/></td>
				<td><f:errors path="selectionner" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<c:if test="${produit.idProduit!=null}">
					<td><img src="photoProd?idProd=${produit.idProduit}"></td>
				</c:if>
				<td><input type="file" name="file"></td>
			</tr>
			<tfoot>
				<tr>
					<td></td>
					<td><input type="submit" value="Sauvegarder"></td>
				</tr>
			</tfoot>
		</table>
	</f:form>
</div>

<div id="tabProduits" class="cadre">
	<table class="tabStyle1">
		<tr>
			<th>ID</th><th>Designation</th><th>Catégorie</th><th>Description</th><th>Prix</th><th>Quantité</th><th></th>
			<th>Sélectionner</th><th>PHOTO</th>
		</tr>
		<c:forEach items="${produits}" var="prod">
			<tr>
				<td>${prod.idProduit}</td>
				<td>${prod.designation}</td>
				<td>${prod.categorie.nomCategorie}</td>
				<td>${prod.description}</td>
				<td>${prod.prix}</td>
				<td>${prod.quantité}</td>
				<td>${prod.selectionner}</td>
				<td><img src="photoProd?idProd=${prod.idProduit}"></td>
				<td><a href="suppProd?idProd=${prod.idProduit}">Supprimer</a></td>
				<td><a href="editProd?idProd=${prod.idProduit}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
</div>