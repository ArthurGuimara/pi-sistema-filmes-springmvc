<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html><head><title>Lista de Filmes</title></head>
<body>
  <h1>Lista de Filmes</h1>
  <p><a href="${pageContext.request.contextPath}/filmes/novo">+ Novo</a></p>
  <table border="1" cellpadding="6">
    <tr><th>ID</th><th>Título</th><th>Gênero</th><th>Ano</th><th>Ações</th></tr>
    <c:forEach var="f" items="${filmes}">
      <tr>
        <td>${f.id}</td>
        <td>${f.titulo}</td>
        <td>${f.genero}</td>
        <td>${f.ano}</td>
        <td>
          <a href="${pageContext.request.contextPath}/filmes/${f.id}/editar">Editar</a>
          <form action="${pageContext.request.contextPath}/filmes/${f.id}/excluir" method="post" style="display:inline">
            <button type="submit">Excluir</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body></html>
