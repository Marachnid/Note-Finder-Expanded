
## User Stories:
*The terms "scales" and "patterns" are used interchangeably - scales are just patterns
*MVP designates minimal requirements

### *MVP API Front End / Back End integration:
- As any user, database integrations will be handled through restful endpoints (not sure of APIs that would fit this well, would have to make my own API)
- Methods: fetchData(), tbd

### *MVP Create Profile:
- As a new user, I want to be able to create my own profile
- Methods: insert()
- Controller: CreateProfileRouter, CreateProfile
- userProfile.jsp, userFormTemplate.jsp

### *MVP Manage Profile:
- As a registered user, I'd like to be able to view my profile information and make updates to my information or delete my profile
- Methods: update(), delete(), getPropertyEqual()
- Controller: EditProfileRouter, EditProfile
- userProfile.jsp, userFormTemplate.jsp

### *MVP Manage Custom Scales:
- As a registered user, I'd like to be able to create, view, edit, and/or delete custom scales
- Methods: insert(), update(), delete(), getPropertyEqual(), getPropertyLike()
- Controller: CreatePatternRouter, CreatePattern, EditPatternRouter, EditPattern, DeletePattern 
- userProfile.jsp, scaleFormTemplate.jsp

### *MVP Search Public Scales By Name:
- As any user, I'd like to search, view, and use public scales
- Methods: getAll(), getPropertyEqual(), getPropertyLike()
- Controller: DisplayRouter, QueryServlet
- index.jsp (index will contain the main highlighting tool, queried data displays locally in index.jsp)

### *MVP Search Public and User Scales:
- As a registered user, I'd like to search, view, and use both public and my custom scales
- Methods: getAll(), getPropertyEqual(), getPropertyLike()
- Controller: QueryServlet
- index.jsp, profile.jsp (both pages allow viewing of either public or user patterns)

### *MVP Highlight Single Notes:
- As any user, I'd like to highlight single notes
- Methods: highlightSingleNotes()
- index.jsp

### *MVP Highlight Scale Notes:
- As any user, I'd like to highlight scale groupings of notes
- Methods: highlightScaleNotes(), getScaleNotes(), fetchData()
- index.jsp

### *MVP Highlight Uncaged Occurrences (this is standard with the logic):
- As any user, I'd like to highlight all known occurrences of highlighted notes or scale groupings
- Methods: highlightScaleNotes(), getScaleNotes(), fetchData()
- index.jsp

### *MVP Highlight On Click:
- As any user, I'd like to highlight notes by clicking them, to hold the pattern while doing other things
- Methods: highlightClick(), (highlightSingleNotes() or (highlightScaleNotes(), getScaleNotes(), fetchData(), etc..))
- index.jsp

### *MVP Highlight On Hover:
- As any user, I'd like to highlight notes by hovering over them
- Methods: highlightHover(), (highlightSingleNotes() or (highlightScaleNotes(), getScaleNotes(), fetchData(), etc..))
- index.jsp

### *MVP Configure Fretboard Generation:
- As any user, I'd like to enter how many strings and which tunings I'm using to match the display to my instrument
- Methods: generateDisplay()
- index.jsp

### *MVP Manage User Profiles:
- As an admin, I'd like to be able to manage/CRUD user profiles
- Methods: insert(), update(), delete(), getPropertyEqual()
- Controller: EditProfileRouter, EditProfile, CreateProfileRouter, CreateProfile
- controlPage.jsp (adminPage.jsp?)

### *MVP Manage Public Scales:
- As an Admin, I'd like to be able to manage/CRUD publicly available scales and patterns
- Methods: insert(), update(), delete(), getPropertyEqual(), getPropertyLike()
- Controller: CreatePatternRouter, CreatePattern, EditPatternRouter, EditPattern, DeletePattern
- controlPage.jsp, scaleFormTemplate.jsp


### MAYBE - DON'T GET CRAZY
#### Search Scales By Interval
- As any user, I'd like to retrieve scales based on interval values (such as a flattened 4th or augmented 7th)
- Methods: getPropertyEqual()
- index.jsp, profile.jsp

#### Highlight Caged Occurrences (there are 3 or 4 common, caged, scale patterns for each scale. This might take some work)
- As any user, I'd like to highlight only caged scale notes (notes that do not extend past or below pattern range)
- Methods: highlightScaleNotes(), getScaleNotes(), fetchData(), cageNotes()
- index.jsp

#### Highlight Caged Occurrences based on Alternate Patterns (see above)
- As any user, I'd like to highlight scale patterns based on their alternative patterns
- Methods: highlightScaleNotes(), getScaleNotes(), fetchData(), cageNotes(), alterPattern()
- index.jsp

#### Toggle Highlight interval colors:
- As any user, I'd like to see different highlight colors representing different intervals (root = red, second = blue, etc.)
- Methods: I have no idea how I'm going to implement this, needs to associate intervals with interval-types
  - May or may not be worth it. It would make uncaged highlighting a lot more readable