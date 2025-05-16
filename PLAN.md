## DELIVERABLES SUMMARY
### Technologies
- Logging Framework
  - TODO
  - Add logging statements in key areas
- JPA/Hibernate - IMPLEMENTED
- Authentication/Authorization
  - TODO
  - Have a working example in Java, but need to figure out the JS method of doing so
  - Retrieve auth/val token in JS, send to API call to Java, then verify token and continue to user home
- Provides ability to register new user 
  - TODO (see above)
- Database includes multiple one-to-many relationships - IMPLEMENTED
- Deployed to AWS for public access
  - TODO
  - JS frontend needs to be deployed (split front end, running with node/express)
  - Java backend needs to be deployed and configured to receive/return API calls to frontend
    - Add a header key to prevent unauthorized API calls
- Testing
  - TODO
  - Need to convert old Unit Tests to match the newer code (changes in classes, methods, and logic)
  - Postman tests are saved and available - All API calls working locally as expected

### Synthesis of Multiple Technologies
- 2 or More technologies
  - JS node/express frontend with modern syntax and module setup
  - Tailwind CSS styling TODO


### Code Review
- TODO 
- If possible, most likely a recorded video. Would like to make sure new/researched concepts are being handled correctly
  - Not a must-have if time/schedule/availability don't allow

### Project Presentation
- TODO 
- Hopefully complex, or Difficult

### Checkpoints
- Checkpoint 2 - TODO
- Checkpoint 3 - TODO


## DELIVERABLES TIME ESTIMATION
I'm estimating that to accomplish the above tasks, I'd need until about from now (5/16) to until about 5/23 to complete the above deliverables.


## GRADE 
For the project, most of the objectives I'm trying to hit are exemplary or at least met.
For the class, I'd be aiming for a B (or C) one the project is completed.
- I have 2 challenges completed and 1 professional development item
- I've completed 1 peer review with Justin Gritton-Bell
- Team Project/Team Checkpoints are completed
- TODO, will be completing Individual Project Checkpoints 2 and 3


## PROJECT STATUS
For a quick summary of my project - I decided to go with a split frontend in JS/Node/Express and a backend with Java/Tomcat, MySQL/Hibernate ORM. 
Because I didn't quite find an API that I thought would fit my project, I wanted to try to do something I might see professionally and have a complete split
between both ends while incorporating the AdvancedJS topics I've been covering this semester.

The backend is about 80%-90% completed with CRUD operations working as expected and used as endpoints consumed by the frontend. 
A generic DAO is implemented to handle all classes similarly in the endpoints and uses HQL instead of criteria builder (HQL makes a bit more sense to me).
The endpoints will need some configuration to allow requests from the frontend.

The frontend is about 70% completed with the primary interactions/events/DHTML logic sorted out. Once a successful request to the backend is configured, 
persistent data/logic will be further built out (need to work out impact of async on current logic). The user management/persistent data pieces from the 
User page will need to be reworked.

Once the integrations are successful, I'll finalize the public hosting and connection between the backend endpoints and frontend API calls and finalize my 
presentation.

Currently, my project has the following implemented and more or less 'figured out'
- Generic DAO with Hibernate ORM MySQL mappings for all classes (includes one-to-many interactions)
- The core endpoints for entity CRUD are working locally with output formatted (Successful Postman tests)
  - Needs to be configured to allow requests from JS frontend (basic JS API request was denied)
- JS web/server environment with node/express is implemented
- JS frontend's core logic is functional 
  - Event listeners for detecting changes in button/option selections are implemented
  - Dynamic fretboard generation is implemented for (4,5,6,7,8)-string variants
  - Standard tuning selection is implemented
  - Hover features are implemented - Click features will be implemented last