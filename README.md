Problem Statement:
For too long, guitarists and bassists have neglected their music dyslexia and have
refused to properly learn the notes on their instrument. "Chug-eh-chugchugchug-eh" is not
a substitute learning intervals and there's more to life than the lowest two strings on your bass; we all know
you bought that five-string because you're scared of everything below the E string. Despite having a book with printouts
that show everything you want, musical notation is scary and quite frankly, boring. This tool allows you to skip the tedious
parts of theory and will do all the scary stuff behind the scenes so you can have a nice
highlighted display of the scale/notes you want.


User Stories:
*The terms "scales" and "patterns" are used interchangeably - scales are just patterns
*MVP designates minimal requirements

*MVP Create Profile:
As a new user, I want to be able to create my own profile

*MVP Manage Profile:
As a registered user, I'd like to be able to view my profile information and make updates to my password

*MVP Manage Custom Scales:
As a registered user, I'd like to be able to create, view, edit, and/or delete custom scales

*MVP Search Public Scales By Name:
As any user, I'd like to search, view, and use public scales

*MVP Search Public and User Scales:
As a registered user, I'd like to search, view, and use both public and custom scales from my profile

MAYBE - DON'T GET CRAZY
Search Scales By Interval
As any user, I'd like to retrieve scales based on interval values (such as a flattened 4th or augmented 7th)

*MVP Highlight Single Notes:
As any user, I'd like to highlight single notes

*MVP Highlight Scale Notes:
As any user, I'd like to highlight scale groupings of notes

*MVP Highlight Uncaged Occurrences:
As any user, I'd like to highlight all known occurrences of highlighted notes or scale groupings

Highlight Caged Occurrences (there are 3 or 4 common, caged, scale patterns for each scale. This might take some work)
As any user, I'd like to highlight only caged scale notes (notes that do not extend past or below pattern range)

Highlight Caged Occurrences based on Pattern (see above)
As any user, I'd like to highlight scale patterns based on their alternative patterns

*MVP Highlight On Click:
As any user, I'd like to highlight notes by clicking them, to hold the pattern while doing other things

*MVP Highlight On Hover:
As any user, I'd like to highlight notes by hovering over them

*MVP Configure Fretboard Generation:
As any user, I'd like to enter how many strings and which tunings I'm using to match the display to my instrument

Toggle Highlight interval colors:
As any user, I'd like to see different highlight colors representing different intervals (root = red, second = blue, etc.)


*MVP Manage User Profiles:
As an admin, I'd like to be able to manage/CRUD user profiles

*MVP Manage Public Scales:
As an Admin, I'd like to be able to manage/CRUD publicly available scales and patterns


Technology:
1. Security/Authentication
    - Cognito

2. Database:
    - MySQL 8

3. ORM/JPA:
    - Hibernate

4. Dependency Management:
    - Maven

5. Web Services being consumed:
    - TBD

6. Data Validation:
    - Bootstrap, Servlets/Classes
    - TBD

7. Logging:
    - Log4j2

8. Testing:
    - Junit

9. Hosting:
    - AWS

10. Technology to look in to:
    - Tailwind CSS
    - I wonder if I'd be able to bring in my Typescript environment instead of the plain js version
    - Java Server Faces for UI development
    - Mockito for testing servlets and other exceptions











    
User Story Bullet Points:
1. User Profiles
    1. As a new user, I want to be able to create a new profile
    2. Login/logout functionality
    3. Manage profile:
        1. change password
        2. edit profile data
        3. view profile data (scales, patterns, etc.)
        4. delete profile

2. Tool Functionality
    1. Select scales to highlight
        1. option to select a handful of initial scales to highlight (uncategorized for now)
        2. option to select custom user-specific scales/patterns to highlight
        3. (TBD, JS needs to be worked out for this) local scale highlight vs. total scale highlight
    2. Select single note to highlight
        1. highlight all repeated occurrences of a single note rather than a scale
    3. Onclick vs. On-hover
        1. Currently, on-hover is implemented, onclick would merely lock the current note to whichever note \<td> is clicked

3. CRUD Interface
    1. interface that allows a user to CRUD custom scales or note patterns
        1. (NOTES) Ideally would be a mix of the interactive display and a UI to enter notes to allow
           visualization of the pattern while CRUD'ing. UI would have to utilize onclick and/or drag behavior
    2. CRUD interface will be present and enabled for logged-in users
    3. Allows

4. Admin Features
    1. Admin profile with special access to:
        1. user profile management (delete, reset password?)
        2. standard scales in CRUD interface (global, non-user-entered scales)
    2. Notifications (TBD)
        1. notified of password reset requests
        2. notified of requests for new scales to be added to global list
        3. misc feedback link?