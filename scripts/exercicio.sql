--1
select * from cargo;
--2
select qt_vereadores, nome from cidade c;
--3
select qt_vereadores, nome from cidade c 
where qt_vereadores  > 9;
--4
select count(*)
from cidade
where qt_vereadores > 9;
--5
select max(qt_vereadores)
from cidade;
--6
select nome, qt_vereadores 
from cidade c
where qt_vereadores = (select max(qt_vereadores) from cidade);
--7
select c.nome
from candidato c 
inner join cargo on cargo.id
where c.cargo = 1
order by nome;
--8
select nome
from candidato
where cargo = 2 and nome = 'MARIA'
order by nome;
--9
select nome
from candidato
where cargo = 2 and nome like 'Y%'
order by nome;
--10
select candidato.nome as nome_candidato, cidade.nome as nome_cidade
from candidato
join cidade on cidade.id = candidato.id
join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;
--11
select candidato.nome as nome_candidato, cidade.nome as nome_cidade
from candidato
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by candidato.nome;
--12
select c.nome, max(ci.qt_eleitores) 
from candidato c 
inner join cargo c2 on c2.id = c.cargo and c2.nome = 'Prefeito'
inner join cidade ci on ci.id = c.cidade
group by c.nome
order by max(ci.qt_eleitores) desc;
--13
select count (*) as total_vereadores
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO';
--14
select cidade.nome, count(*) as total_vereadores
from candidato c
inner join cargo ON cargo.id = c.cargo AND cargo.nome = 'Vereador'
inner join cidade ON cidade.id = c.cidade
group by cidade.nome
order by cidade.nome;
--15
select brancos, nulos, c.nome cargo, ci.nome cidade
from voto_invalido vi 
inner join cargo c on c.id = vi.cargo 
inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO';
--16
select sum(vi.brancos + vi.nulos) as total_nulos_e_brancos, c.nome as cargo, ci.nome as cidade
from voto_invalido vi 
inner join cargo c on c.id = vi.cargo and c.nome = 'Prefeito'
inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO'
group by c.nome, ci.nome;
--17
select voto, c.nome 
from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo c3 on c3.id = c.cargo and c3.nome = 'Prefeito'
inner join cidade c2 on c2.id = c.cidade and c2.nome = 'TUBARÃO'
order by v.voto desc;
--18
select voto, c.nome 
from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo c3 on c3.id = c.cargo and c3.nome = 'Vereador'
inner join cidade c2 on c2.id = c.cidade and c2.nome = 'TUBARÃO'
order by v.voto desc;
--19
select cidade.nome, max(voto.voto)
from cidade
inner join candidato c on cidade.id = c.cidade
inner join cargo c3 on c.cargo = c3.id and c3.nome = 'Prefeito'
inner join voto on voto.candidato = c.id
group by cidade.nome;
--20
select partido.sigla, sum(voto.voto) as votos
from partido
inner join candidato on candidato.partido = partido.id
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
group by partido.sigla 
order by votos desc;
--21
select sum(v.voto) + sum(vi.brancos) + sum(vi.nulos) as total_votos_registrados
from voto v 
inner join candidato on candidato.id = v.candidato
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto_invalido vi on vi.cidade = cidade.id and vi.cargo = cargo.id;
--22 TO-DO
select c.qt_eleitores - (sum(v.voto) + sum(vi.brancos) + sum(vi.nulos)) as eleitores_que_nao_votaram 
from cidade c 
left join candidato can on can.cidade = c.id
left join voto v on v.candidato = can.id
left join voto_invalido vi on vi.cidade = c.id
where c.nome = 'TUBARÃO'
group by 