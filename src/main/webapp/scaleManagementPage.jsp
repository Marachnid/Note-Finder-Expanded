<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="head.jsp"/>

<html>
<body>

    <h1>SCALE MANAGEMENT</h1>

    <div class="container-fluid">

        <h1 class="mb-4">Add a New Scale</h1>
        <p><i>
            *WIP, end users will eventually be entering notes, not interval distances.
            <br>
            There needs to be a conversion or UI for pairing desired notes/patterns with interval distances.
        </i></p>

        <form action="${pageContext.request.contextPath}/addScale" method="GET">

            <div id="searchTermContainer" class="mb-3">
                <div class="form-group row">
                    <label for="name">Name:
                        <input type="text" id="name" name="name" pattern="^[a-zA-Z0-9 ]+$"
                               class="form-control" required>
                    </label>
                    <label for="root">Root:
                        <input type="text" id="root" name="root" pattern="^[0-9]+$"
                               class="form-control" required>
                    </label>
                    <label for="second">Second:
                        <input type="text" id="second" name="second" pattern="^[0-9]+$"
                               class="form-control" required>
                    </label>
                    <label for="third">Third:
                        <input type="text" id="third" name="third" pattern="^[0-9]+$"
                               class="form-control" required>
                    </label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Create Scale</button>
        </form>
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
                            <td><a href="/editScale">EDIT</a></td>
                            <td><a href="/deleteScale">DELETE</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>

    </div>

</body>
</html>
