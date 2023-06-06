select * from cargo;

select qt_vereadores, nome from cidade c;

select qt_vereadores, nome from cidade c 
where qt_vereadores  > 9;

select count(*)
from cidade
where qt_vereadores > 9;

select max(qt_vereadores)
from cidade;

select nome, qt_vereadores 
from cidade c
where qt_vereadores = (select max(qt_vereadores) from cidade);

select c.nome
from candidato c 
inner join cargo on cargo.id
where c.cargo = 1
order by nome;

select nome
from candidato
where cargo = 2 and nome = 'MARIA'
order by nome;

select nome
from candidato
where cargo = 2 and nome like 'Y%'
order by nome;

select candidato.nome as nome_candidato, cidade.nome as nome_cidade
from candidato
join cidade on cidade.id = candidato.id
join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;

select candidato.nome as nome_candidato, cidade.nome as nome_cidade
from candidato
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by candidato.nome;

select c.nome, max(ci.qt_eleitores) 
from candidato c 
inner join cargo c2 on c2.id = c.cargo and c2.nome = 'Prefeito'
inner join cidade ci on ci.id = c.cidade
group by c.nome
order by max(ci.qt_eleitores) desc;

select qt_vereadores
from cidade c 
where c.nome = 'TUBARÃO';

select c.nome, qt_vereadores
from cidade c 
order by c.nome;

select brancos, nulos, c.nome cargo, ci.nome cidade
from voto_invalido vi 
inner join cargo c on c.id = vi.cargo 
inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO';

select (sum(vi.brancos) + sum(vi.nulos)) as total_nulos_e_brancos, c.nome as cargo, ci.nome as cidade
from voto_invalido vi 
inner join cargo c on c.id = vi.cargo 
inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO'
group by c.nome, ci.nome;

select voto, c.nome 
from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo c3 on c3.id = c.cargo and c3.nome = 'Prefeito'
inner join cidade c2 on c2.id = c.cidade and c2.nome = 'TUBARÃO'
order by v.voto desc;

select voto, c.nome 
from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo c3 on c3.id = c.cargo and c3.nome = 'Vereador'
inner join cidade c2 on c2.id = c.cidade and c2.nome = 'TUBARÃO'
order by v.voto desc;

select max(v.voto) as max_votos, c2.nome as cidade
from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo c3 on c3.id = c.cargo and c3.nome = 'Prefeito'
inner join cidade c2 on c2.id = c.cidade
group by c2.nome 
order by max_votos desc;