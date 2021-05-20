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
					<c:param name="${attr_id}" value="${id}" />
					<c:param name="${attr_edited}" value="${edited}" />
					<c:param name="${attr_local}" value="${attr_en}" />
				</c:url>
				<a href="${link_local_en}">${fmt_localbutton_en}</a>
			</c:if>
			<c:if test="${!fmt_language.equals(attr_ru)}">
				<c:url var="link_local_ru" value="">
					<c:param name="${attr_id}" value="${id}" />
					<c:param name="${attr_edited}" value="${edited}" />
					<c:param name="${attr_local}" value="${attr_ru}" />
				</c:url>
				<a href="${link_local_ru}">${fmt_localbutton_ru}</a>
			</c:if>
		</td>
		<td class="tableright">
			<table>
				<c:if test="${news != null}">
					<tr>
						<td>
							<b>
								<c:if test="${edited != null && edited == true}">
									<c:out value="(${fmt_modified}) " />
								</c:if>
								<c:out value="${news.title}" /></b>
						</td>
					</tr>
					<tr>
						<td>
								${news.content}<br>
						</td>
					</tr>
					<tr>
						<td class="links">
							<table class="links">
								<tr class="links">
									<td class="linksleft">
										<c:url var="link_show_main_page" value="${attr_command_show_main_page}" />
										<a href="${link_show_main_page}">${fmt_back}</a>
									</td>
									<c:if test="${role != null && role.equals(attr_role_admin)}">
										<td class="linksright">
											<c:url var="link_show_edit_page" value="${attr_command_show_edit_page}">
												<c:param name="${attr_id}" value="${id}" />
											</c:url>
											<a href="${link_show_edit_page}">${fmt_edit}</a>
										</td>
										<td class="linksright">
											<form:form action="${attr_action_delete_news}" method="post">
												<input type="hidden" name="${attr_id}" value="${id}" />
												<input type="submit" value="${fmt_delete}" />
											</form:form>
										</td>
									</c:if>
								</tr>
							</table>
						</td>
					</tr>
				</c:if>
			</table>
		</td>
	</tr>
</table>
</body>
</html>