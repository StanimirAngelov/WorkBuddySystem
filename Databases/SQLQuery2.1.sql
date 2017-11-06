DROP  TABLE countries;

CREATE TABLE [dbo].[countries](
    [ID] [int] IDENTITY(1,1) NOT NULL,
    [CountryName] [nvarchar](50) NOT NULL
) ON [PRIMARY]

insert into countries values ('India')
insert into countries values ('Spain')
insert into countries values ('New Zealand')
insert into countries values ('Italy')
insert into countries values ('Istanbul')
insert into countries values ('USA')
insert into countries values ('Australia')
insert into countries values ('Brazil')

