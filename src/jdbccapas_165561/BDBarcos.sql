create schema viajes;
create table barcos(matricula varchar(10), nombre
varchar (20) not null, amarre int not null,cuota int not null);
create table socios(id int not null auto_increment,dni varchar(15),
nombre varchar(20));
use barcos;

insert into barcos(matricula, nombre, amarre, cuota) values
(1556,'serena',5,300),
(123,'macarena',1,500),
(654,'la poderosa',8,200),
(789,'calmada',2,350),
(8779,'la prostipirugolfa',3,100)
;
