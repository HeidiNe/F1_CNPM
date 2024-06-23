create database QLF1
go
use QLF1
go

create table tblTournament(
	id int primary key,
	name nvarchar(50) not null,
	season int not null
);
go

create table tblGrandPrix (
	id int primary key,
	name nvarchar(50) not null,
	numberOfLap int not null,
	location nvarchar(255) not null,
	date date not null,
	describe nvarchar(255),
	tournamentid int references tblTournament(id) not null
);
go

create table tblUser (
	id int primary key,
	username nvarchar(50) not null,
	password nvarchar(50) not null,
	fullname nvarchar(50) not null,
	role nvarchar(50) not null
);
go

create table tblDriver (
	id int primary key,
	name nvarchar(50) not null,
	dateOfBrith date not null,
	nationality nvarchar(50) not null,
	story nvarchar(255)
);
go

create table tblRaceTeam (
	id int primary key,
	name nvarchar(50) not null,
	brand nvarchar(50) not null,
	describe nvarchar(255),
);
go

create table tblContract (
	id int primary key,
	startTime date not null,
	endTime date,
	clause nvarchar(255),
	driverid int references tblDriver(id) not null,
	raceteamid int references tblRaceTeam(id) not null
);
go

create table tblEntry (
	id int primary key,
	entryDate date not null,
	clause nvarchar(255),
	grandPrixid int references tblGrandPrix(id) not null,
	userid int references tblUser(id) not null,
	contractid int references tblContract(id) not null
);
go

------------------------------------------DB---------------------------------------------

insert into [dbo].[tblTournament] values
(101, N'Mùa giải 2022', 2023),
(102, N'Mùa giải 2024', 2024)
go


INSERT INTO [dbo].[tblGrandPrix] VALUES
(2024001, 'Bahrain ', 50, 'Bahrain ', CONVERT(date, '05/03/2024', 103), NULL, 102),
(2024002, 'Italian ', 55, 'Italy ', CONVERT(date, '19/03/2024', 103), NULL, 102),
(2024003, 'Australian ', 50, 'Australia ', CONVERT(date, '02/04/2024', 103), NULL, 102),
(2024004, 'Miami ', 60, 'USA ', CONVERT(date, '07/04/2024', 103), NULL, 102),
(2024005, 'Emilia Romagna ', 60, 'Italy ', CONVERT(date, '07/05/2024', 103), NULL, 102),
(2024006, 'Spanish ', 70, 'Spain ', CONVERT(date, '04/06/2024', 103), NULL, 102),
(2024007, 'Austrian ', 70, 'Austria ', CONVERT(date, '02/07/2024', 103), NULL, 102),
(2024008, 'Balgian ', 65, 'Balgium ', CONVERT(date, '30/07/2024', 103), NULL, 102)
go


insert [dbo].[tblUser] values
(101, 'thangnm', 'b21dcnn668', N'Nguyễn Minh Thắng', 'manager' ),
(102, 'thinhvx', 'b21dccn694', N'Vũ Xuân Thịnh', 'manager' ),
(103, 'quynhnd', 'b21dccn646', N'Nguyễn Đức Quỳnh', 'receptionist' ),
(104, 'khoadd', 'B21dccn068', N'Đỗ Đăng Khoa', 'receptionist' )
go


insert [dbo].[tblDriver] values
(1, 'Max Verstappen', CONVERT(date, '30/09/1997', 103),  'Netherlands',  NULL ),
(2, 'Sergio Perez', CONVERT(date, '26/01/1990', 103),  'Mexico',  NULL ),
(3, 'Charles Leclerc', CONVERT(date, '16/10/1997', 103),  'Monaco',  NULL ),
(4, 'Carlos Sainz', CONVERT(date, '01/09/1994', 103),  'Spain',  NULL ),
(5, 'Zeus', CONVERT(date, '31/01/2004', 103),  'Korea',  NULL ),
(6, 'Oner', CONVERT(date, '24/12/2002', 103),  'Korea',  NULL ),
(7, 'Faker', CONVERT(date, '07/05/1996', 103),  'Korea',  NULL ),
(8, 'Gumayusi', CONVERT(date, '06/02/2002', 103),  'Korea',  NULL ),
(9, 'Keria', CONVERT(date, '14/10/2002', 103),  'Korea',  NULL ),
(10, 'Lando Norris', CONVERT(date, '13/11/1999', 103),  'United Kingdom',  NULL ),
(11, 'Oscar Piastri', CONVERT(date, '06/04/2001', 103),  'Australia',  NULL ),
(12, 'George Russell', CONVERT(date, '15/02/1998', 103),  'United Kingdom',  NULL ),
(13, 'Fernando Alonso', CONVERT(date, '29/07/1981', 103),  'Spain',  NULL ),
(14, 'Lewis Hamilton', CONVERT(date, '07/01/1985', 103),  'United Kingdom',  NULL ),
(15, 'Lance Stroll', CONVERT(date, '29/10/1998', 103),  'Canada',  NULL ),
(16, 'Yuki Tsunoda', CONVERT(date, '11/05/2000', 103),  'Japan',  NULL ),
(17, 'Nico Hulkenberg', CONVERT(date, '19/08/1987', 103),  'Germany',  NULL ),
(18, 'Kevin Magnussen', CONVERT(date, '05/10/1992', 103),  'Denmark',  NULL ),
(19, 'Alexander Albon', CONVERT(date, '23/03/1996', 103),  'Thailand',  NULL ),
(20, 'Esteban Ocon', CONVERT(date, '17/09/1996', 103),  'France',  NULL ),
(21, 'Valtteri Bottas', CONVERT(date, '28/08/1989', 103),  'Finland',  NULL ),
(22, 'Logan Sargeant', CONVERT(date, '31/12/2000', 103),  'United States',  NULL ),
(23, 'Pierre Gasly', CONVERT(date, '07/02/1996', 103),  'France',  NULL ),
(24, 'ShowMaker', CONVERT(date, '22/07/2000', 103),  'Korea',  NULL ),
(25, 'Aiming', CONVERT(date, '20/07/2000', 103),  'Korea',  NULL )
go
 

insert into [dbo].[tblRaceTeam] values
(1, 'Mercedes-AMG ', 'Mercedes-Benz', NULL),
(2, 'Red Bull Racing Honda ', 'Red Bull', NULL),
(3, 'Scuderia Ferrari ', 'Ferrari', NULL),
(4, 'T1 ', 'T1', NULL ),
(5, 'Alpine F1 Team ', 'Alpine', NULL),
(6, 'Williams Racing ', 'Williams', NULL),
(7, 'Haas F1 Team ', 'Haas Automation', NULL),
(8, 'McLaren Racing ', 'McLaren', NULL),
(9, 'Alfa Romeo Racing ', 'Alfa Romeo', NULL),
(10, 'DK ', 'Dplus KIA', NULL)
go


insert into [dbo].[tblContract] values
(1,  CONVERT(date, '01/01/2024', 103), CONVERT(date, '01/06/2024', 103), NULL, 1, 2),
(2,  CONVERT(date, '04/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 2, 2),
(3,  CONVERT(date, '02/02/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 3, 3),
(4,  CONVERT(date, '13/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 4, 3),
(5,  CONVERT(date, '02/02/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 5, 4),
(6,  CONVERT(date, '15/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 6, 4),
(7,  CONVERT(date, '03/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 7, 4),
(8,  CONVERT(date, '05/02/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 8, 4),
(9,  CONVERT(date, '24/04/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 9, 4),
(10,  CONVERT(date, '02/02/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 10, 8),
(11,  CONVERT(date, '02/02/2025', 103), CONVERT(date, '12/12/2024', 103), NULL, 11, 8),
(12,  CONVERT(date, '12/02/2024', 103), CONVERT(date, '01/06/2024', 103), NULL, 12, 1),
(13,  CONVERT(date, '03/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 13, 9),
(14,  CONVERT(date, '13/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 14, 1),
(15,  CONVERT(date, '25/01/2024', 103), CONVERT(date, '01/06/2024', 103), NULL, 15, 9),
(16,  CONVERT(date, '13/01/2024', 103), CONVERT(date, '12/12/2024', 103), NULL, 16, 9),
(17,  CONVERT(date, '03/01/2024', 103), CONVERT(date, '12/12/2025', 103), NULL, 17, 7),
(18,  CONVERT(date, '15/01/2024', 103), CONVERT(date, '12/12/2026', 103), NULL, 18, 7),
(19,  CONVERT(date, '15/01/2024', 103), CONVERT(date, '12/12/2027', 103), NULL, 19, 6),
(20,  CONVERT(date, '13/01/2024', 103), CONVERT(date, '12/12/2028', 103), NULL, 20, 5),
(21,  CONVERT(date, '15/01/2024', 103), CONVERT(date, '12/12/2029', 103), NULL, 23, 5),
(22,  CONVERT(date, '15/01/2024', 103), CONVERT(date, '12/12/2030', 103), NULL, 24, 10),
(23,  CONVERT(date, '03/01/2024', 103), CONVERT(date, '12/12/2031', 103), NULL, 25, 10),
(24,  CONVERT(date, '03/06/2024', 103), CONVERT(date, '12/03/2025', 103), NULL, 1, 1),
(25,  CONVERT(date, '03/06/2025', 103), CONVERT(date, '13/02/2025', 103), NULL, 12, 9),
(26,  CONVERT(date, '03/06/2026', 103), CONVERT(date, '07/01/2025', 103), NULL, 15, 2)
