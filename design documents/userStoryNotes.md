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