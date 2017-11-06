Create Table Users 
(
	UserID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
	Username VARCHAR(20),
	Password VARCHAR(10) ,
	Role VARCHAR(10) NOT NULL
);

delete from Users where Username = 'stanimir';
Select * from Users;