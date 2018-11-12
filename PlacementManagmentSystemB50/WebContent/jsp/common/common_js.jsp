

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
		<!-- basic scripts -->
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){
				}
			</script>
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

		
		<!-- ace settings handler -->
		<script src="${path}/assets/js/ace-extra.min.js"></script>
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${path}/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${path}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${path}/assets/js/bootstrap.min.js"></script>

		<!-- ace scripts -->
		<script src="${path}/assets/js/ace-elements.min.js"></script>
		<script src="${path}/assets/js/ace.min.js"></script>

