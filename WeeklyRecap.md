<h1>Time Log</h1>

<div>
    <h2>Weeks 1-2</h2>
    <table>
        <tr>
            <th>Date</th>
            <th>Task</th>
            <th>Hours</th>
            <th>Notes</th>
        </tr>
        <tr>
            <td>Week 1</td>
            <td>Week 1 setup activities</td>
            <td>8</td>
            <td>Tomcat needs certain security permissions allowed in Windows to function correctly (users/intellij needs 'modify' access to scan Tomcat tmp folder)</td>
        </tr>
        <tr>
            <td>Week 2</td>
            <td>Weekly activities/videos/exercises | Documentation, project setup, project implementation planning/drafting, problem statement, user stories</td>
            <td>5 hours</td>
            <td>N/A</td>
        </tr>
    </table>
</div>


<h2>Changing to Journal format...</h2>
<div>

    Week 3

    Tasks:
    I can't really remember what I did this week - I was more focused on JavaScript

    Hours:

    Notes:

</div>

<div>

    Week 4

    Tasks:

        Hibernate reading material and videos
        Hibernate/DAO demo w/videos
        Setup and configuration of indie project (environment, DB, classes, resources/utilities, etc..)
        Built out a testing environment/DBs and adapted class Hibernate/Dao examples to fit my project
        Configured a dynamic one-page does all MVC setup for the CRUD interface - scaled back some of the form 
            templating complexity to reuse the same form, not worth the headache for now, 
            currently two separate templates

    Hours: 15 ish

    Notes:
        Spent a while putzing with indie project environment and how I wanted to do things, 
            Considering JakartaEE and Tomcat 10 upgrade later on, depending on differences with class material.
        The current environment seems to be configured and working correctly without any version issues. Can be difficult 
            to tell issues come from code or from differences in environment, dependencies, imports.
        Need to eventually double check getByPropertyName(), unique constraint had to be dropped for update()
            to work without deleting and then recreating the record. Only servlet prevents duplicate names.
        Should also probably double check update() for duplicate name validation in servlet/method.
        It looks like JSFs might simplify some of the UI work, should look into.
        getByPropertyName() and getByPropertyId() could probably be reused for UserDao and CRUD, interface?.
        Keeping the size of scales scaled way back to only go up to 3rd scale interval to ease prototyping and testing.
    
</div>

<div>

    Week 5

    Tasks:
        Building out indie project deliverables.
        Created screen design for Home page and Profile page to cover user stories. Admin page wasn't included
            in screen design - working prototype exists in the project already (not much different from profile page).
            Admin interface would need to include user management as well, they could probably fit on the same page
            but might be better separated to reduce mistaking one for the other.
        Templating is going to either simplify or severely complicate update/create forms.
    Hours: 
        6-ish

    Notes:
        Need to doublecheck DB requirements for project - user/pattern and scale/category table groups don't need to be connected
            to function, but seems to simplistic.
            Created a BOOKMARK junction chain to link user table as many-to-many with pattern and scale tables separately.
            This method is going to require Java querying of both scale and pattern bookmarks separately, but this seems to hold better 
            referential integrity

</div>
