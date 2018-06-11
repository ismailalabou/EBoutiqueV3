<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
<form action="chercherProduits" action="chercherProduits">
<table>
<tr>
<td><input type="text" name="mc" value="${mc}"></td>
<td><input type="submit" value="Chercher"></td>
</tr>
</table>
</form>
</div>
<div>
<f:form modelAttribute="produit" action="saveProduit"
enctype="multipart/form-data">
<table>
<tr>
<td>ID Produit</td>
<td><f:input type="hidden" path="idProduit"/>${produit.idProduit}</td>
<td><f:errors path="idProduit" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Categorie</td>
<td><f:select
path="categorie.idCategorie"
items="${categories}"
itemLabel="nomCategorie"
itemValue="idCategorie" /></td>
<td><f:errors path="categorie.idCategorie"
cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Désignation</td>
<td><f:input path="designation"/></td>
<td><f:errors path="designation" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Description</td>
<td><f:input path="description"/></td>
<td><f:errors path="description" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Prix</td>
<td><f:input path="prix"/></td>
<td><f:errors path="prix" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Sélectioné</td>
<td><f:checkbox path="selectionne"/></td>
<td><f:errors path="selectionne" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Quantité</td>
<td><f:input path="quantite"/></td>
<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Photo</td>
<td>
<c:if test="${produit.idProduit!=null}">
<f:input type="hidden" path="photo"/>
<img alt="" src="<%=request.getContextPath()
%>/photoProduit?idP=${produit.idProduit }">
</c:if>
<input type="file" name="file"></td>
<td>${errors }</td>
</tr>
<tr>
<td><input type="submit" value="enregistrer"></td>
</tr>
</table>
</f:form>
</div>
<div>
<table class="table1">
<tr>
<th>ID</th><th>Designation</th><th>Prix</th><th>Sélectionnée</th>
<th>Quatité</th><th>Photo</th>
</tr>
<c:forEach items="${ produits}" var="p">
<tr>
<td>${p.idProduit }</td> <td>${p.designation }</td>
<td>${p.prix}</td> <td>${p.selectionne}</td>
<td>${p.quantite}</td>
<td><img alt="" src="<%=request.getContextPath()
%>/photoProduit?idP=${p.idProduit }"></td>
<td><a href="deleteProd?idP=${p.idProduit }">Supp</a></td>
<td><a href="editProd?idP=${p.idProduit }">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>