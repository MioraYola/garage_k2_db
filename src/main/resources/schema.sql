create database garage_k2_db;

create type Marque as enum ('KIA', 'HYUNDAI', 'DAEWOO');
create type Modele as enum('GETZ', 'PRIDE', 'LACETTI');

create table modele_voiture (
    id serial primary key,
    marque Marque,
    modele Modele
);

create table piece_auto (
    id serial primary key,
    id_modele_voiture int references modele_voiture(id),
    numero_serie varchar,
    prix int
);

create table vente(
    id serial primary key,
    id_piece_auto int references piece_auto(id),
    quantite int
);




select m.marque, sum(v.quantite) as nbre_piece
from vente v
join piece_auto pa on v.id_piece_auto = pa.id
join modele_voiture m on pa.id_modele_voiture = m.id
group by m.marque;

select
        sum(case when m.modele='GETZ' then v.quantite else 0 end) as piece_getz,
        sum(case when m.modele='PRIDE' then v.quantite else 0 end) as piece_pride,
        sum(case when m.modele='LACETTI' then v.quantite else 0 end) as piece_lacetti
from vente v
join piece_auto pa on v.id_piece_auto = pa.id
join modele_voiture m on pa.id_modele_voiture = m.id;

select
    sum(case when mv.marque = 'KIA' then v.quantite*pa.prix else 0 end) as pt_kia
from vente v
join piece_auto pa on v.id_piece_auto = pa.id
join modele_voiture mv on pa.id_modele_voiture = mv.id;