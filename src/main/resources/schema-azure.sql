USE [bookstore-test1]

/*
-- Table creation statements - commented out as they appear to be already created
CREATE TABLE tblUser (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    full_name NVARCHAR(250) NOT NULL,
    role NVARCHAR(250) NOT NULL
);

CREATE TABLE tblProvider (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250) NOT NULL,
    address NVARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    phone_number VARCHAR(250) NOT NULL,
    note NVARCHAR(500)
);

CREATE TABLE tblBookTitle (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250) NOT NULL,
    author NVARCHAR(250) NOT NULL,
    publication_year INT NOT NULL,
    publisher NVARCHAR(250) NOT NULL,
    unit_price INT NOT NULL
);

CREATE TABLE tblImportBill (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    import_date DATE NOT NULL,
    sale_off INT NOT NULL,
    payment_method NVARCHAR(100) NOT NULL,
    note NVARCHAR(500),
    user_id NUMERIC, 
    provider_id NUMERIC,
    FOREIGN KEY (user_id) REFERENCES tblUser(id),
    FOREIGN KEY (provider_id) REFERENCES tblProvider(id)
);

CREATE TABLE tblImportedBookTitle (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    import_bill_id NUMERIC,
    book_title_id NUMERIC,
    FOREIGN KEY (import_bill_id) REFERENCES tblImportBill(id),
    FOREIGN KEY (book_title_id) REFERENCES tblBookTitle(id)
);
*/


/*
-- Insert User data
SET IDENTITY_INSERT [dbo].[tblUser] ON 
INSERT INTO [dbo].[tblUser] ([id], [username], [password], [full_name], [role])
VALUES (CAST(1 AS Numeric(18, 0)), 'a', '123456', 'A', N'Nhân viên kho')
SET IDENTITY_INSERT [dbo].[tblUser] OFF

-- Insert BookTitle data
SET IDENTITY_INSERT [dbo].[tblBookTitle] ON 
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(1 AS Numeric(18, 0)), N'7 viên ngọc Rồng tập 6', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(2 AS Numeric(18, 0)), N'7 viên ngọc rồng tập 7', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(3 AS Numeric(18, 0)), N'7 viên ngọc rồng tập 8', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(4 AS Numeric(18, 0)), N'Những người khốn khổ', N'Victor Hugo', 2020, N'Trẻ', 100000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(5 AS Numeric(18, 0)), N'Harry Potter và chiếc cốc lửa', N'J.K.Rowling', 2017, N'Trẻ', 500000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (CAST(6 AS Numeric(18, 0)), N'Harry Potter và phòng chứa bí mật', N'J.K.Rowling', 2018, N'Trẻ', 550000)
SET IDENTITY_INSERT [dbo].[tblBookTitle] OFF

-- Insert Provider data
SET IDENTITY_INSERT [dbo].[tblProvider] ON 
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (CAST(2 AS Numeric(18, 0)), N'B', N'Hà Đông, Hà Nội', N'nccb@gmail.com', N'0123456789', N'Chuyên cung cấp truyện thiếu nhi')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (CAST(3 AS Numeric(18, 0)), N'B', N'Quận 1, Thành phố Hồ Chí Minh', N'sgb@gmail.com', N'0987654321', N'Chuyên cung cấp truyện tranh Conan')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (CAST(4 AS Numeric(18, 0)), N'Bình An', N'Hoàn Kiếm, Hà Nội', N'nccbinhan@gmail.com', N'123123123', N'Chuyên cung cấp tiểu thuyết')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (CAST(5 AS Numeric(18, 0)), N'Hữu Hoà', N'Thanh Xuân, Hà Nội', N'ncchuuhoa@gmail.com', N'0981243675', N'Chuyên cung cấp truyện trinh thám')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (CAST(6 AS Numeric(18, 0)), N'An Bình', N'Phú Lương, Hà Đông, Hà Nội', N'nccanbinh@gmail.com', N'0129834122', N'Chuyên cung cấp truyện Doraemon')
SET IDENTITY_INSERT [dbo].[tblProvider] OFF

*/
-- Insert ImportBill data
SET IDENTITY_INSERT [dbo].[tblImportBill] ON 
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(5 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 100000, N'Chuyển khoản', N'Giảm 100000 cho lần nhập đầu tiên', CAST(1 AS Numeric(18, 0)), CAST(2 AS Numeric(18, 0)))
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(6 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 100000, N'Thẻ tín dụng', N'Giảm giá do thanh toán bằng thẻ tín dụng', CAST(1 AS Numeric(18, 0)), CAST(3 AS Numeric(18, 0)))
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(7 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 1000000, N'Chuyển khoản', N'Giảm giá 1 triệu đồng', CAST(1 AS Numeric(18, 0)), CAST(3 AS Numeric(18, 0)))
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(8 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 0, N'Tiền mặt', N'', CAST(1 AS Numeric(18, 0)), CAST(5 AS Numeric(18, 0)))
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(9 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 220000, N'Thẻ tín dụng', N'', CAST(1 AS Numeric(18, 0)), CAST(4 AS Numeric(18, 0)))
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (CAST(10 AS Numeric(18, 0)), CAST(N'2025-05-01' AS Date), 1000000, N'Chuyển khoản', N'', CAST(1 AS Numeric(18, 0)), CAST(6 AS Numeric(18, 0)))
SET IDENTITY_INSERT [dbo].[tblImportBill] OFF

-- Insert ImportedBookTitle data
SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] ON 
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(1 AS Numeric(18, 0)), 20, 30000, CAST(5 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(2 AS Numeric(18, 0)), 30, 30000, CAST(6 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(3 AS Numeric(18, 0)), 20, 30000, CAST(7 AS Numeric(18, 0)), CAST(3 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(4 AS Numeric(18, 0)), 40, 100000, CAST(7 AS Numeric(18, 0)), CAST(4 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(5 AS Numeric(18, 0)), 30, 30000, CAST(8 AS Numeric(18, 0)), CAST(2 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(6 AS Numeric(18, 0)), 20, 100000, CAST(8 AS Numeric(18, 0)), CAST(4 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(7 AS Numeric(18, 0)), 20, 30000, CAST(9 AS Numeric(18, 0)), CAST(3 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(8 AS Numeric(18, 0)), 30, 500000, CAST(10 AS Numeric(18, 0)), CAST(5 AS Numeric(18, 0)))
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (CAST(9 AS Numeric(18, 0)), 0, 550000, CAST(10 AS Numeric(18, 0)), CAST(6 AS Numeric(18, 0)))
SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] OFF
GO