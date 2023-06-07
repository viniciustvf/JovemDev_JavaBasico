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
-- 21 Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os
--votos registrados são considerados os votos para os candidatos, mais os votos
--brancos e nulos.
select ((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos) 
from voto
inner join candidato ON candidato.id = voto.candidato
inner join cargo ON cargo.id  = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade ON cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
group by voto_invalido.brancos , voto_invalido.nulos;


--22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão.     
select c.qt_eleitores  - (((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos) )
	from voto
	inner join candidato ON candidato.id = voto.candidato
	inner join cargo ON cargo.id  = candidato.cargo and cargo.nome = 'Prefeito'
	inner join cidade c ON c.id = candidato.cidade and c.nome = 'TUBARÃO'
	inner join voto_invalido on voto_invalido.cidade = c.id and voto_invalido.cargo = cargo.id
	group by c.qt_eleitores, voto_invalido.brancos , voto_invalido.nulos ;
		


-- 23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade,ordenado pela maior quantidade de faltantes.

	select c.nome, (c.qt_eleitores  - (((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos))) as abstenções
	from voto
	inner join candidato ON candidato.id = voto.candidato
	inner join cargo ON cargo.id  = candidato.cargo and cargo.nome = 'Prefeito'
	inner join cidade c ON c.id = candidato.cidade 
	inner join voto_invalido on voto_invalido.cidade = c.id and voto_invalido.cargo = cargo.id
	group by c.nome, c.qt_eleitores, voto_invalido.brancos , voto_invalido.nulos 
    order by abstenções desc;


-- 24 Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual.
	
	select c.nome, ((c.qt_eleitores  - (((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos)))/ c.qt_eleitores * 100) as abstenções
	from voto
	inner join candidato ON candidato.id = voto.candidato
	inner join cargo ON cargo.id  = candidato.cargo and cargo.nome = 'Prefeito'
	inner join cidade c ON c.id = candidato.cidade 
	inner join voto_invalido on voto_invalido.cidade = c.id and voto_invalido.cargo = cargo.id
	group by c.nome, c.qt_eleitores, voto_invalido.brancos , voto_invalido.nulos 
    order by abstenções desc;

-- 25 Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade
 
	select distinct on (c.nome) c.nome, c2.nome, voto.voto
	from cidade c 
	inner join candidato c2 on c2.cidade = c.id
	inner join voto on voto.candidato = c2.id
	inner join cargo on cargo.id = c2.cargo and cargo.nome = 'Prefeito'
	order by c.nome, voto.voto desc;