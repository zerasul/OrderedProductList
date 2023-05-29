-- Products

insert into Products (id,name,sales_unit,stockRatio)values(1,'V-NECH BASIC SHIRT',100,11.5);
insert into Products (id,name,sales_unit,stockRatio)values(2,'CONSTRASTING FABRIC T-SHIRT',50,51.45);
insert into Products (id,name,sales_unit,stockRatio)values(3,'RAISED PRINT T-SHIRT',50,34.43);

-- Stock

insert into Stock(size,units,idProduct)values('S',4,1);
insert into Stock(size,units,idProduct)values('M',9,1);
insert into Stock(size,units,idProduct)values('L',0,1);

insert into Stock(size,units,idProduct)values('S',35,2);
insert into Stock(size,units,idProduct)values('M',9,2);
insert into Stock(size,units,idProduct)values('L',9,2);

insert into Stock(size,units,idProduct)values('S',20,3);
insert into Stock(size,units,idProduct)values('M',2,3);
insert into Stock(size,units,idProduct)values('L',20,3);

-- Criterias

insert into ProductCriteria(id, name, orderColumns)values(1,'sales','salesUnits:DESC');
insert into ProductCriteria(id, name, orderColumns)values(1,'stocks','stockRatio:DESC');