<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  import="com.nacre.pms.dto.InterviewRoundDTO"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body><%-- 
${interviewrounds}
 --%> <%-- <c:forEach var="interviews" items="${interviewrounds}">
<li>
<ol>

${interviews.roundNo}
${interviews.description}
${interviews.date}
</ol>
</li>
</c:forEach> --%>


<%InterviewRoundDTO irdto=(InterviewRoundDTO)session.getAttribute("interviewrounds");%>

client name========<%=irdto.getJobPost().getClientaddress().getClient().getClientName()%>
Rounddetails<%=irdto.getRoundNo() %>
            <%=irdto.getDate() %>
            <%=irdto.getDescription() %>
</body>
</html>