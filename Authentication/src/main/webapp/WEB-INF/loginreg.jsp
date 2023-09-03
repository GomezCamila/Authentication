<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AQUI EL TITULO DE TU PLNATILLA</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container mt-5">

		<div class="row">

			<div class="col-md-6">
				<div class="card p-4">
				<h2 class="display-4 mb-4">¡Únete a nosotros!</h2>
				<div>
					<form:errors class="text-danger" path="user.*" />
				</div>

				<form:form method="POST" action="/registration" modelAttribute="user">
					<div class="mb-3">
						<form:label path="email" class="form-label">Email:</form:label>
						<form:input type="email" path="email" class="form-control"/>
					</div>
					<div class="mb-3">
						<form:label path="password" class="form-label">Password:</form:label>
						<form:password path="password" class="form-control"/>
					</div>
					<div class="mb-3">
						<form:label path="passwordConfirmation" class="form-label">Password Confirmation:</form:label>
						<form:password path="passwordConfirmation" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Registrarse</button>
				</form:form>
				<p class="text-success mt-3"> <c:out value="${registro }"></c:out> </p>
				</div>
			</div>

			<div class="col-md-6">
			<div class="card p-4">
				<h2 class="display-4 mb-4">¡Bienvenido de vuelta!</h2>

				<div>
					<form:errors class="text-danger" path="login.*" />
				</div>

				<form:form method="POST" action="/login" modelAttribute="login">
					<div>
						<form:label path="email" class="form-label">Email:</form:label>
						<form:input  path="email" class="form-control" />
					</div>
					<div>
						<form:label path="password" class="form-label">Password:</form:label>
						<form:password path="password" class="form-control"/>
					</div>

					<button type="submit" class="btn btn-primary btn-block m-3">Iniciar sesión</button>
				</form:form>
			</div>
			</div>
		</div>


	</div>
</body>
</html>