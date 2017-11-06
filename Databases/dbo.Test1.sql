CREATE TABLE [dbo].[Test1] (
    [userID]   INT          IDENTITY (1, 1) NOT NULL,
    [name]     VARCHAR (20) NULL,
    [username] VARCHAR (20) NULL,
    [age]      INT          NULL,
    [password] VARCHAR (10) NULL,
    PRIMARY KEY CLUSTERED ([userID] ASC)
);

