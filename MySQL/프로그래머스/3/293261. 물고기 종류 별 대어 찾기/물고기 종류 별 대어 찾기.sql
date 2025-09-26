select i.id, n.fish_name, i.length from fish_info i
join fish_name_info n on i.fish_type=n.fish_type
where i.length = (
    select max(length) from fish_info
    where fish_type=i.fish_type
);