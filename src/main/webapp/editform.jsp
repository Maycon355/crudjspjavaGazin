<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuário</title>
</head>
<body>
	<%@ page import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDao"%>

		<%
		String id = request.getParameter("id");
		Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
		%>
			
		<h1>Edição do Usuário</h1>
		
		<form action="editusuario.jsp" method="post">
			<input type="hidden" name="id" value="<%=usuario.getId()%>"/>
			<table>
				<tr>
					<td>Nome: </td>
					<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/> </td>
				</tr>
				<tr>
					<td>Hobby: </td>
					<td><input type="text" name="hobby" value="<%=usuario.getHobby()%>"/> </td>
				</tr>
			<tr>
				<td>Sexo:</td>
				<td><input type="radio" name="sexo" value="M" />Masculino <input
					type="radio" name="sexo" value="F" />Feminino <input type="radio"
					name="sexo" value="O" />Outros
			</tr>
			<tr>
					<td>Cidade: </td>
					<td> <select name="cidade">
					<option>Maringá</option>	
					<option>Marialva</option>
					<option>Paiçandu</option>
					<option>Sarandi</option>
					<option>Jandaia do Sul</option>
					<option>Nova Esperança</option>	
					<option>Outros</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Data de Nascimento: </td>
					<td><input name="datanascimento" type="text" value="<%=usuario.getDatanascimento()%>"></input>
					 </td>
				</tr>	
				<tr>
					<td><input type="submit" value="Editar Usuário"></input></td>
				</tr>	
			</table>
		</form>
</body>
</html>