<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="${pageContext.request.contextPath}/updateScale" method="GET">
        <div id="searchTermContainer" class="mb-3">
            <div class="form-group row">
                <label for="name">Name:
                    <input type="text" id="name" name="name" pattern="^[a-zA-Z0-9 ]+$"
                           class="form-control" value="${sessionScope.scaleToEdit.getName()}" readonly>
                </label>
                <label for="root">Root:
                    <input type="text" id="root" name="root" pattern="^[0-9]+$"
                           class="form-control" value="${sessionScope.scaleToEdit.getRoot()}" required>
                </label>
                <label for="second">Second:
                    <input type="text" id="second" name="second" pattern="^[0-9]+$"
                           class="form-control" value="${sessionScope.scaleToEdit.getSecond()}" required>
                </label>
                <label for="third">Third:
                    <input type="text" id="third" name="third" pattern="^[0-9]+$"
                           class="form-control" value="${sessionScope.scaleToEdit.getThird()}" required>
                </label>
                <input type="hidden" name="id" value="${sessionScope.scaleToEdit.getId()}">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update Scale</button>
    </form>
</div>
