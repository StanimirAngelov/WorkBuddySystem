CREATE TABLE [dbo].[Department] (
    [DeptID]   INT          IDENTITY (1, 1) NOT NULL,
    [Name]     VARCHAR (20) NULL,
    [Location] VARCHAR (10) NULL,
    PRIMARY KEY CLUSTERED ([DeptID] ASC)
);

