create database examen;
use examen;

create table persona(
	nombre varchar(100),
    p_apellido varchar(100),
    m_apellido varchar(100),
    año int(4),
    mes int(2),
    dia int(2),
    codigoEst varchar(10),
    sexo varchar(1)
);
drop table persona;

describe persona;