<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="head.jsp"/>

<html>
<body>

    <h1>SCALE MANAGEMENT</h1>

    <div class="container-fluid">

        <h1 class="mb-4">Add a New Scale</h1>

        <c:import url="addTemplate.jsp" />

        <div>
            <c:if test="${not empty requestScope.message}">
                <p>${requestScope.message}</p>
            </c:if>
        </div>
    </div>

    <div>
        <h2>Existing Scales</h2>

        <c:if test="${not empty requestScope.scaleList}">

            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Root</th>
                    <th>Second</th>
                    <th>Third</th>
                    <th>Category</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="scale" items="${requestScope.scaleList}">
                        <tr>
                            <td>${scale.id}</td>
                            <td>${scale.name}</td>
                            <td>${scale.root}</td>
                            <td>${scale.second}</td>
                            <td>${scale.third}</td>
                            <td>${scale.foreignKey.name}</td>
                            <td><a href="${pageContext.request.contextPath}/editScale?id=${scale.id}">EDIT</a></td>
                            <td><a href="${pageContext.request.contextPath}/deleteScale?id=${scale.id}">DELETE</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>


    <c:if test="${not empty sessionScope.scaleToEdit}">
        <div class="container-fluid">
            <h2>Edit Scale</h2>
            <c:import url="updateTemplate.jsp"/>
        </div>
        <c:remove var="scaleToEdit" scope="session"/>
    </c:if>
</body>
</html>
