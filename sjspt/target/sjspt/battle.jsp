
<%@include file="WEB-INF/jspf/_header.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="test" uri="/costumForeach"%>
<%@ page isELIgnored="false"%>


<div class="panel-group" id="accordion">
	<div class="panel panel-primary">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne" class="collapseHeader"> Battle of <c:out
							value="${battlefield.name}" default="Unkown" />
					</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body collapseContent" id="collapse1">
					<h2>The Battle!</h2>
					
					<c:forEach var="army" items="${battlefield.armies}">
						<table class="table">
							<tr>
								<td>Army side: <c:out value="${army.side}" /></td>
								<td>Leader: <c:out value="${army.leader.name}" /></td>
							</tr>
							<tr>
							<test:forEach collection="${army.soldiers}"></test:forEach>
								<c:forEach var="entry" items="${army.soldiers}">
									<tr>
										<td><c:out value="${entry.key}" /> TEAM</td>
									</tr>
									<c:forEach var="soldier" items="${entry.value}">
										<td><c:out value="${soldier.name}" /></td>
									</c:forEach>
								</c:forEach>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<div class="panel panel-primary">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo" class="collapseHeader"> Detailed Battle
						Report </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse in">
				<div class="panel-body collapseContent" id="collapse2">
					<c:out value="${battlefield }"></c:out><hr>
					<c:out value="${battlefield.battleReport}" escapeXml="false"></c:out>
				</div>
			</div>
		</div>

	</div>
</div>

<%@include file="WEB-INF/jspf/_footer.jspf"%>