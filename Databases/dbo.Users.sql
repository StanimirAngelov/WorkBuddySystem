CREATE TABLE [dbo].[Users] (
    [UserID]   INT          IDENTITY (1, 1) NOT NULL,
    [Username] VARCHAR (20) NULL,
    [Password] VARCHAR (10) NULL,
    [DeptID]   INT          NULL,
    [Role]     VARCHAR (10) NOT NULL,
    PRIMARY KEY CLUSTERED ([UserID] ASC),
    FOREIGN KEY ([DeptID]) REFERENCES [dbo].[Department] ([DeptID])
);

