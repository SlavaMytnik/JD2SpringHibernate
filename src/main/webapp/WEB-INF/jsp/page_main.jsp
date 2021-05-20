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
				<span>${fmt_hello},
					<c:if test="${username != null}">
						<c:if test="${role != null && role.equals(attr_role_admin)}">
							${fmt_admin}
						</c:if>
						${username}
					</c:if>
				</span><br>
			<c:url var="link_logout" value="${attr_command_logout}" />
			<a href="${link_logout}">${fmt_logout}</a><br>
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
				<c:if test="${news != null}">
					<c:forEach var="c_news" items="${news}">
						<tr>
							<td>
								<b>${c_news.title}</b>
							</td>
						</tr>
						<tr>
							<td>
									${c_news.brief}<br>
								<c:url var="link_show_news_page" value="${attr_command_show_news_page}">
									<c:param name="${attr_id}" value="${c_news.id}" />
									<c:param name="${attr_edited}" value="false" />
								</c:url>
								<a href="${link_show_news_page}">${fmt_read}</a>
							</td>
						</tr>
						<tr>
							<td>
								<br>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</td>
	</tr>
</table>
</body>
</html>