CREATE TABLE [dbo].[E_Logout] (
    [D_day]  SMALLDATETIME NOT NULL,
    [DeptID] INT           NOT NULL,
    [UserID] INT           NOT NULL,
    PRIMARY KEY CLUSTERED ([D_day] ASC, [UserID] ASC, [DeptID] ASC),
    FOREIGN KEY ([DeptID]) REFERENCES [dbo].[Department] ([DeptID]),
    FOREIGN KEY ([UserID]) REFERENCES [dbo].[Users] ([UserID])
);

