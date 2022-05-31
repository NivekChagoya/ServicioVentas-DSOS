select * from public.venta;

select * from public.venta
where id_venta=13;

select * from public.venta
where folio_venta='VENTA-0007';

update public.venta set descripcion='Venta de anillo'
 where id_venta=13
 
delete from public.venta
where folio_venta='VENTA-0007';
 
 

