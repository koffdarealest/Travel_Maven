
---------------------------------- Create Table ----------------------------------
create table dest(
	destination nvarchar(255) primary key,
	image nvarchar(255)
)

create table tour(
	ID nvarchar(7) primary key,
	name nvarchar(255),
	destination nvarchar(255),
	numOfPerson int,
	numOfDay int,
	price int,
	describe nvarchar(255),
	rating double,
    image nvarchar(255),
	foreign key (destination) references dest(destination)
)

create table account (
	accID int IDENTITY(100000,1),
	accMail nvarchar(255),
	accUsername nvarchar(255) primary key,
	accPassword nvarchar(255),
	accPhone nvarchar(10),
	isAdmin BIT
)

create table booking(
	bookID int IDENTITY(100000000,1) primary key,
	cusName nvarchar(255),
	cusMail nvarchar(255),
	cusPhone nvarchar(10),
	startDate date,
	TourID nvarchar(7),
	accUsername nvarchar(255),
	foreign key (TourID) references tour(ID),
	foreign key (accUsername) references account(accUsername)
)

---------------------------------- Insert ----------------------------------
insert into dest(destination, image)
values	('Viet Nam','img/DaNang.jpg'),
		('France','img/Paris.jpg'),
		('Italy','img/Roma.jpg'),
		('Thailand','img/Bangkok.jpg'),
		('Singapore','img/Singapore.jpg'),
		('Brazil','img/RioDeJaneiro.jpg')


insert into tour(ID, [name], destination, numOfPerson, numOfDay, describe, price, rating, image)
values	('T000001','Ha Long Bay','Viet Nam',7,3,'Short family tour of Ha Long Bay', 650, 4.9,'img/HaLong.jpg' ),
		('T000002','Da Nang','Viet Nam',7,3,'Short family tour of Da Nang', 550, 4.6,'img/DaNang.jpg'),
		('T000003','Ho Chi Minh City','Viet Nam',7,3,'Short family tour of Ho Chi Minh City', 650, 4.7,'img/HCM.jpg'),
		('T000004','Hoi An','Viet Nam',7,3,'Short family tour of Hoi An', 500, 4.5,'img/HoiAn.jpg'),
		('T000005','Da Lat','Viet Nam',7,3,'Short family tour of Da Lat', 530, 4.9,'img/DaLat.jpg'),
		('T000006','Paris, Nice, Lyon','France',2,9,' Long Couple tour in France A', 3500, 4.9,'img/Paris.jpg'),
		('T000007','Paris, Nice, Lyon, Bordeaux ','France',2,11,' Long Couple tour in France B', 4500, 4.9,'img/Paris2.jpg'),
		('T000008','Cannes','France',2,7,'Honeymoon in Cannes', 3200, 4.7,'img/Cannes.jpg'),
		('T000009','Paris','France',2,7,'Honeymoon in Paris', 3200, 4.8,'img/Paris4.jpg'),
		('T000010','Lyon','France',2,7,'Honeymoon in Lyon', 3400, 4.5,'img/Lyon.jpg'),
		('T000011','Roma','Italy',2,7,'Honeymoon in Roma', 4000, 4.3,'img/Roma.jpg'),
		('T000012','Venice','Italy',2,7,'Honeymoon in Roma', 4500, 4.5,'img/Venice.jpg'),
		('T000013','Milan, Roma, Napoli, Como','Italy',7,13,' Long Family tour in Italy', 7500, 4.9,'img/Milan.jpg'),
		('T000014','Bangkok','Thailand',2,5,'Couple tour in Bangkok', 1200, 4.8,'img/Bangkok.jpg'),
		('T000015','Phuket','Thailand',2,5,'Couple tour in Phuket', 1100, 4.6,'img/Phuket.jpg'),
		('T000016','Singapore','Singapore',4,4,'Modern Singapore tour', 900, 4.2,'img/Singapore.jpg'),
		('T000017','Rio De Janeiro','Brazil',4,7,'Brazilian Cultural Festival tour', 2900, 4.9,'img/RioDeJaneiro.jpg'),
		('T000018','Fernando de Noronha','Brazil',2,9,'Honeymoon in Fernando de Noronha', 3900, 4.2,'img/FernandodeNoronha.jpg')


insert into account(accMail, accUsername, accPassword, accPhone, isAdmin)
values ('admingmail', 'admin', 'admin', '0000000000', 1)
---------------------------------- Query ----------------------------------
select * from dest
select * from booking
select * from tour
select b.bookID, b.cusName, b.cusMail, b.cusPhone, b.startDate, b.TourID from booking b join account c on b.accUsername = c.accUsername where c.accUsername = 'tamtamtam'
select * from booking b join account c on b.accUsername = c.accUsername where c.accUsername = 'tamtamtam'
select * from account

select * from account where accMail = 'tamtamtam@gmail.com'

delete from account	where accID = 100003

INSERT INTO booking (cusName, cusMail, cusPhone, startDate, TourID, accUsername) VALUES ('Hoàng Tâm', 'tamtamtam@gmail.com', '0853641509', '2023-11-11', 'T000001', 'tamtamtam')

update booking set cusName = ?, cusMail = ?, cusPhone = ? , startDate = ?, where bookID = ?

delete from booking where bookID = ?

insert into tour(ID, [name], destination, numOfPerson, numOfDay, describe, price, rating, image) values ('T000A', 'a', 'Viet Nam', 3, 3,'test', 300,  4.5, 'img/Milan.jpg')

delete from tour where ID = 'T000A'