<html>
<head>
	<title>Index title</title>
</head>
<body>
	<h2>Hello World!</h2>
	<p>Old Time: <%= request.getAttribute("oldTime") %></p>
	<p>New Time: <%= request.getAttribute("newTime") %></p>
	<p>init Param: <%= getServletConfig().getInitParameter("JSP-init-param") %></p>
	<p>Admin e-mail: <%= getServletContext().getInitParameter("adminEmail") %></p>
</body>
</html>
