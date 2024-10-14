SELECT p.ID,
       SUM(w.SALARY) * DATEDIFF('DAY', p.START_DATE, p.FINISH_DATE) AS PRICE
FROM project p
         JOIN project_worker pw ON p.ID = pw.PROJECT_ID
         JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY p.ID
ORDER BY PRICE DESC;
