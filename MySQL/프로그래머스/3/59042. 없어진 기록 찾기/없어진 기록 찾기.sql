SELECT o.animal_id, o.name from animal_outs o
left join animal_ins i on i.animal_id = o.animal_id
where i.INTAKE_CONDITION is null;