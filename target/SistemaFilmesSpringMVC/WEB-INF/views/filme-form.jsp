<%@ page contentType="text/html; charset=UTF-8" %>
<html><head><title>Filme</title></head>
<body>
  <h1>${filme.id == null ? "Novo Filme" : "Editar Filme"}</h1>
  <form action="${pageContext.request.contextPath}/filmes${filme.id != null ? '' : ''}" method="post">
    <input type="hidden" name="id" value="${filme.id}"/>
    <p>Título: <input name="titulo" value="${filme.titulo}" required></p>
    <p>Gênero: <input name="genero" value="${filme.genero}"></p>
    <p>Ano: <input name="ano" type="number" value="${filme.ano}"></p>
    <p>Sinopse:<br><textarea name="sinopse" rows="5" cols="50">${filme.sinopse}</textarea></p>
    <button type="submit">Salvar</button>
    <a href="${pageContext.request.contextPath}/filmes">Cancelar</a>
  </form>
</body></html>
