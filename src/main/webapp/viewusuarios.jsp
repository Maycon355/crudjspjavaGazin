<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de usuários</title>
</head>
<body>
	<%@ page
		import="com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<h1>Listagem de usuário:</h1>

	<%
	List<Usuario> list = UsuarioDao.getAllUsuarios();
	request.setAttribute("list", list);
	%>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Sexo</th>
			<th>Hobby</th>
			<th>Cidade - Estado</th>
			<th>Data de Nascimento</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>

		<c:forEach items="${list}" var="usuario">
			<tr>
				<td>${usuario.getId()}</td>
				<td>${usuario.getNome()}</td>
				<td>${usuario.getSexo()}</td>
				<td>${usuario.getHobby()}</td>
				<td>${usuario.getCidade()}</td>
				<td>${usuario.getDatanascimento()}</td>
				<td><a href="editform.jsp?id=${usuario.getId()}"><button>
							Editar</button> </a></td>
				<td><a href="deleteusuario.jsp?id=${usuario.getId()}"><button>
							Excluir</button> </a></td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<td><a href="usuarioform.html"><button>Adicionar
				Usuário Novo</button> </a></td>


</body>
</html>