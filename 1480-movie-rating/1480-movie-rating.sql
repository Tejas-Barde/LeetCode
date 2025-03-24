SELECT results
FROM (
    SELECT u.user_id, u.name AS results
    FROM users u 
    JOIN movierating mr ON u.user_id = mr.user_id
    GROUP BY u.user_id, u.name
    ORDER BY COUNT(*) DESC, u.name
)
WHERE ROWNUM = 1

UNION ALL

SELECT results
FROM (
    SELECT m.movie_id, m.title AS results
    FROM movies m 
    JOIN movierating mr ON m.movie_id = mr.movie_id
    WHERE created_at < '2020-03-01' 
    AND created_at > '2020-01-31'
    GROUP BY m.movie_id, m.title
    ORDER BY AVG(rating) DESC, m.title
)
WHERE ROWNUM = 1;
