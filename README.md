Problem Statement:

    For too long, guitarists and bassists have neglected their music dyslexia and have
    refused to properly learn the notes on their instrument. "Chug-eh-chugchugchug-eh" is not
    a substitute learning intervals and there's more to life than the lowest two strings on your bass; we all know
    you bought that five-string because you're scared of everything below the E string. Despite having a book with printouts
    that show everything you want, musical notation is scary and quite frankly, boring. This tool allows you to skip the tedious
    parts of theory and will do all the scary stuff behind the scenes so you can have a nice
    highlighted display of the scale/notes you want.

Features:

    Note Finder is a tool that will allow users to generate a display of their stringed instrument's fretboard and then interact with
    the fretboard by highlighting musical scales or patterns (such as Natural Minor, Natural Major, etc.) on hover or click. If a user wishes
    to create a profile, they will then be able to create their own custom patterns that they want to use or see - perhaps they only want to see
    the root, second, and sixth interval of a Minor scale, or add in musical scales if it's not available in the program. Users will also be able to search
    the available list of scales via their name as well. Users with a profile will be able to view other custom user-patterns while non-profile users will have
    access to global musical scale patterns. 
    
    Highlighting: Currently, the application allows highlighting of all occurences of repeated notes or scale patterns that are highlighted/clicked, but
    highlighting features will be expanded to allow highlighting 'caged' scale occurences which highlight only the local scale notes, rather than every 
    matching note on the fretboard.

    An admin interface will also exist to allow an admin profile to manage user profiles and global scale patterns for users.
    


## Technology:
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