-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(TOTAL_SALES) AS TOTAL_SALES FROM book b
LEFT JOIN (SELECT book_id, sum(sales) AS TOTAL_SALES
        FROM BOOK_SALES 
        WHERE sales_date BETWEEN '2022-01-01' AND '2022-01-31'
        GROUP BY book_id) j
    ON b.book_id=j.book_id
GROUP BY b.category
ORDER BY b.CATEGORY
;