<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="document.f.username.focus();">
	<h3 style="color: red">Login with Username and Password</h3>
	<form action="./login" method="POST">
		<table>
			<tbody>
				<tr>
					<td>User:</td>
					<td><input type="text" name="username" value=""></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Remember Me:</td>
					<td><input type="checkbox" name="remember" value="YES"></td>
				</tr>
				<tr>
					<td colspan="2"><input name="submit" type="submit"
						value="Login"></td>
				</tr>
				
				<!-- <input name="_csrf" type="hidden"
					value="53d6557f-bbfc-473d-9c89-bd1415704f17"> -->
			</tbody>
		</table>
	</form>
</body>
</html>