# Watchlist

App that lets user search for a movie or series title, and returns the movie with year of release, plot, imdb rating and the actors. 
Moreover the user has a easy accessible watchlist with movies.

Missing: 
- the function that adds and removes movies to the string that is the input for the listview. Add button is kept in place but
not functional. 
- listview of results from searching, now the result is only 1 movie instead of a list. 

# Activities: 
- Main activity (opening screen): lets user enter title
- Full info: displays all info of movie/series user searched for
- Watchlist: shows a list of movies which can be clicked -> starts Full info activity

# other classes
-httphelper: creates url and creates jsonobject
-watchlistasynctask: all async tasks (onpreexectue -> toast, doinbackground -> retrieves data from jsonobject, onpostexecute -> start full info activity, give intent data)
