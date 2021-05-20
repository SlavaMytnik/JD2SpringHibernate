<%@ page language="java"
		 contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" session="false" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>News site</title>
	<style type="text/css">
		<%@ include file="resources/css/main.css" %>
	</style>
	<%@ include file="resources/localization/localization.jsp" %>
	<%@ include file="resources/attr/attr.jsp" %>
	<script type="text/javascript">
		function go(a) {
			setTimeout(function () {
				location=a;
			}, Number(${attr_go_redirect_duration}));
		}
	</script>
</head>
<body>
<div class="simpletext">
	${fmt_error_logination}<br>
	${fmt_redirect}
</div>
<script type="text/javascript">
	go('${attr_go_show_index_page}');
</script>
</body>
</html>