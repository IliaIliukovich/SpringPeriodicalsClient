<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default">
		<div class="container-fluid">
		
			<div class="navbar-header">
      			<a class="navbar-brand" href="#">Periodicals Client</a>
    		</div>
    		
    		<ul class="nav navbar-nav">
    		
    			<li><a href="<spring:url value="/"/>">Welcome</a></li>
				<sec:authorize access="hasRole('ROLE_CLIENT_USER')">
					<li><a href="<spring:url value="/myjournals"/>">My journals</a></li>
				</sec:authorize>

				<li>
					<sec:authorize access="authenticated" var="authenticated"/>
					<c:choose>
						<c:when test="${authenticated}">
							<li>
								<p class="navbar-text">
									Welcome,
									<sec:authentication property="name"/>
									!
									<a id="logout" href="#">Logout</a>
								</p>
								<form id="logout-form" action="<c:url value="/logout"/>" method="post">
									<sec:csrfInput/>
								</form>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="<spring:url value="/login/"/>">Sign In</a></li>
						</c:otherwise>
					</c:choose>
    			</li>

    		</ul>
    		
		</div>
</nav>