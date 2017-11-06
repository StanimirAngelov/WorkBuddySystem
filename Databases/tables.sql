drop table Users; 
Create Table Department 
(
	DeptID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
	Name VARCHAR(20),
	Location VARCHAR(10)
);

Create Table Users 
(
	UserID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
	Username VARCHAR(20),
	Password VARCHAR(10) ,
	DeptID INT FOREIGN KEY REFERENCES Department(DeptID) ,
	Role VARCHAR(10) NOT NULL
);

Create Table Roster 
(
	R_Day Date  NOT NULL,
	UserID INT FOREIGN KEY REFERENCES Users(UserID),
	DeptID INT FOREIGN KEY REFERENCES Department(DeptID),
	S_Time time,
	E_Time time,
	PRIMARY KEY (R_Day, UserID, DeptID)
);

drop table Roster;

Create Table E_login
(
	D_day SMALLDATETIME,
	DeptID INT FOREIGN KEY REFERENCES Department(DeptID),
	UserID INT FOREIGN KEY REFERENCES Users(UserID),
	PRIMARY KEY (D_Day, UserID, DeptID)
);


Create Table E_Logout
(
	D_day SMALLDATETIME,
	DeptID INT FOREIGN KEY REFERENCES Department(DeptID),
	UserID INT FOREIGN KEY REFERENCES Users(USERID),
	PRIMARY KEY (D_Day, UserID, DeptID)
);




