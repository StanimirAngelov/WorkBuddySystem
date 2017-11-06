DROP TABLE Test1;
CREATE TABLE [dbo].[Test1] (
    [userID]   INT          IDENTITY (1, 1) NOT NULL, 
    [name] VARCHAR (20) NULL,
	[username] VARCHAR (20) NULL,
    [age]   INT          NULL,
	[password] VARCHAR (10) NULL,
    PRIMARY KEY CLUSTERED ([userID] ASC),
);

SELECT * From Test1;

insert into Test1 values ('1', 'stan', 'stan', '32' , 'da')