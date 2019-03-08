<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:redirect url="http://localhost:1111/sso/logout"/>
<%--<a href='http://upms.dape.cn:1111/sso/logout'>退出登录</a>--%>