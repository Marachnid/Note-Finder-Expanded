<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
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

                <fieldset class="form-group row">
                    <legend>Category:</legend>
                    <label for="major">Major
                        <input type="radio" id="major" name="category" value="1"
                               class="form-control" required>
                    </label>

                    <label for="minor">Minor
                        <input type="radio" id="minor" name="category" value="2"
                                class="form-control" required>
                    </label>

                    <label for="diminished">Diminished
                        <input type="radio" id="diminished" name="category" value="3"
                               class="form-control" required>
                    </label>

                    <label for="augmented">Augmented
                        <input type="radio" id="augmented" name="category" value="4"
                               class="form-control" required>
                    </label>
                </fieldset>
            </div>

        </div>
        <button type="submit" class="btn btn-primary">Create Scale</button>
    </form>
</div>
