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

select nome
from candidato c 
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
order by cidade.nome, candidato.nome;

select candidato.nome as nome_candidato, cidade.nome as nome_cidade
from candidato
join cidade on cidade.id = candidato.cidade 
where cidade.nome = 'TUBARÃO' and candidato.cargo = 1
order by candidato.nome;

select c.nome
from candidato c
join cidade c2 on c2.id = c.cidade where max(c2.qt_eleitores)
order by c.nome;