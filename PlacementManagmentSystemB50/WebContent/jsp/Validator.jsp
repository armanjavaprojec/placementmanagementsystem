<%@page import="com.nacre.pms.util.URLConstants"%>
<%@page import="com.nacre.pms.util.StringConstants"%>
<%
String vUserId = (String)session.getAttribute(StringConstants._SESSION_USER_ID);
if(vUserId!=null){
String vRoleId = (String)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID);

if(vRoleId!=null){
Integer iRoleId = Integer.parseInt(vRoleId);
	if (iRoleId == StringConstants._ADMIN_ROLE_ID) {
		response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
	} else if (iRoleId == StringConstants._HR_ROLE_ID) {
		response.sendRedirect(request.getContextPath() + "/" + URLConstants.HR_HOME_PAGE_URL);
	}  else if (iRoleId == StringConstants._TRAINEE_ROLE_ID) {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.TRAINEE_HOME_PAGE_URL);

	} else {
		response.sendRedirect(request.getContextPath() + "/" + URLConstants.LOGIN_PAGE_URL);
	}

}
}

%>