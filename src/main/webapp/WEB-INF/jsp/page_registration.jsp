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
</head>
<body>
<table class="tablebase">
	<tr>
		<td class="tableleft">
			<%--@elvariable id="${attr_model_registration_info}" type="java"--%>
			<form:form action="${attr_action_registration}" modelAttribute="${attr_model_registration_info}" method="post">
				<span>${fmt_registration}</span><br>
				<form:input path="${attr_login}" placeholder="${fmt_login}" maxlength="${attr_max_length}" /><br>
				<form:password path="${attr_password}" placeholder="${fmt_password}" maxlength="${attr_max_length}" /><br>
				<form:input path="${attr_name}" placeholder="${fmt_name}" maxlength="${attr_max_length}" /><br>
				<form:input path="${attr_surname}" placeholder="${fmt_surname}" maxlength="${attr_max_length}" /><br>
				<input type="submit" value="${fmt_save}" />
			</form:form>
			<c:if test="${!fmt_language.equals(attr_en)}">
				<c:url var="link_local_en" value="">
					<c:param name="${attr_local}" value="${attr_en}" />
				</c:url>
				<a href="${link_local_en}">${fmt_localbutton_en}</a>
			</c:if>
			<c:if test="${!fmt_language.equals(attr_ru)}">
				<c:url var="link_local_ru" value="">
					<c:param name="${attr_local}" value="${attr_ru}" />
				</c:url>
				<a href="${link_local_ru}">${fmt_localbutton_ru}</a>
			</c:if>
		</td>
		<td class="tableright">
			<table>
				<tr>
					<td>
						<%@ include file="resources/information/termsofservice.jsp" %>
					</td>
				</tr>
				<tr>
					<td class="links">
						<table class="links">
							<tr class="links">
								<td class="linksleft">
									<c:url var="link_show_index_page" value="${attr_command_show_index_page}" />
									<a href="${link_show_index_page}">${fmt_back}</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>