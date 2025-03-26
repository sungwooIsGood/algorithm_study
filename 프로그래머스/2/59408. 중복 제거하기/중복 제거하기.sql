select count(*)
from(select name
    from animal_ins
    group by name
    having name is not null) aa;