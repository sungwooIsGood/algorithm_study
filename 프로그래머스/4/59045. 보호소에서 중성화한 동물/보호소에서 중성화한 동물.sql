select i.animal_id as animal_id, i.animal_type as animal_type, i.name as name
from animal_ins i
inner join animal_outs o
on i.animal_id = o.animal_id
where i.sex_upon_intake != o.sex_upon_outcome
order by animal_id;