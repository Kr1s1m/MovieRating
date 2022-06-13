# MovieRating (IMDb+Reddit)

The idea of the project is to develop a web-based movie rating system similar to IMDb combined with Reddit. The system will contain information about movies and real life individuals who participated in their creation. The system will allow users to review and rate movies. The users will also be able to upvote and downvote account reviews which will generate account karma.


## ***Basic Business Requirements***
- A Home page which shows available movies in the movie database, trending movies (often reviewed, upvoted, hot topic) and has search functionality

- A movie page which contains:
  - Detailed information about the movie. For example, movie title, movie rating, year, director, writer,     actors, genre, annotation.
  - User reviews (comments with or without rating the movie)
  - Functionality to jump to a person (actor/director/writer/etc) page
  - Functionality for users to leave reviews (and additionally if advanced requirements are met then also - edit own reviews, delete own reviews)
  - Functionality for users to upvote or downvote account reviews
  
- A filmography page for people (actors/directors/writers/etc) which contains:
  - Information about the person (Biography)
  - Functionality which allows to jump to another movie associated with that person (Filmography)


## ***Advanced Business Requirements***

- Accounts

- Login page

- A page for users which contains:
  - User information
  - User join date
  - User karma (upvote - downvote total)
  - User reviews
  
- Administration registry for users with the following actions:
  - Create account 
  - Remove account
  - Modify account information
  
- Add authorization so that only admin and moderator users can:
  - Create/Update/Delete account reviews
  - Create/Update/Delete users
  
- Add authorization so that only admin users can:
  - Create/Update/Delete movies
  
- Logout functionality with a redirect to the login page 
