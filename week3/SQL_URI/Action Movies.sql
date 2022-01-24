SELECT id,name 
FROM movies 
WHERE id_genres = (SELECT id 
		   FROM genres 
		   WHERE description = 'Action'
		  )