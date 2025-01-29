Rough notes to get some documentation started

Problem Statement:
    For too long, guitarists and bassists have neglected their music dyslexia and have
    refused to properly learn the notes on their instrument. "Chug-eh-chugchugchug-eh" is not
    a substitute learning intervals and there's more to life than the lowest two strings on your bass; we all know
    you bought that five-string because you're scared of everything below the E string. Despite having a book with printouts
    that show everything you want, musical notation is scary and quite frankly, boring. This tool allows you to skip the tedious
    parts of theory and will do all the scary stuff behind the scenes so you can have a nice
    highlighted display of the scale/notes you want.


User Stories:
1. User Profiles
   1. Create user profile page
   2. Login/logout functionality
   3. Manage profile:
      1. change password
      2. edit profile information
      3. view custom profile data (scales, patterns, etc.)
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
   4. CRUD Interface
      1. interface that allows a user to CRUD custom scales or note patterns
        1. (NOTES) Would be a mix of the interactive display and a UI to enter notes to allow 
      visualization of the pattern while CRUD'ing. UI would have to utilize onclick behavior
      2. CRUD interface will be present and enabled for logged-in users, disabled for unlogged-in users to allow use of base tool without a profile
   5. Admin Features
      1. Admin profile with special access to:
         1. user profile management (delete, reset password?)
         2. standard scales in CRUD interface (global, non-user-entered scales)
      2. Notifications (TBD)
        1. notified of password reset requests
        2. notified of requests for new scales to be added to global list
        3. misc feedback link?