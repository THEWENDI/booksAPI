<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${book.title }</h1>
	<p>Description:  ${book.description }</p>
	<p>Language:  ${book.language }</p>
	<P>Number of Pages:  ${book.numberOfPages}</P>
</body>
</html>