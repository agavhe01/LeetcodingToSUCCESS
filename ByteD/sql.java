/*

SELECT 
    CONCAT('Hello ', u.email, ', you have ', COUNT(ut.task_id), ' open tasks assigned') AS message
FROM 
    users u
JOIN 
    users_tasks ut ON u.id = ut.user_id
JOIN 
    tasks t ON ut.task_id = t.id
WHERE 
    t.status IN ('Open', 'In Progress')
GROUP BY 
    u.email
ORDER BY 
    u.email;


*/