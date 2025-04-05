SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d')
from rest_review r
inner join member_profile m
on r.member_id = m.member_id
where m.member_id in (select member_id
from rest_review
group by member_id
having count(*) = (select count(*)
from rest_review
group by member_id
order by count(*) desc
limit 1))
order by 3,2