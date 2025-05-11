USE [bookstore];

CREATE TABLE tblUser (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    full_name NVARCHAR(250) NOT NULL,
    role NVARCHAR(250) NOT NULL
);

CREATE TABLE tblProvider (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250) NOT NULL,
    address NVARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    phone_number VARCHAR(250) NOT NULL,
    note NVARCHAR(500)
);

CREATE TABLE tblBookTitle (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250) NOT NULL,
    author NVARCHAR(250) NOT NULL,
    publication_year INT NOT NULL,
    publisher NVARCHAR(250) NOT NULL,
    unit_price INT NOT NULL
);

CREATE TABLE tblImportBill (
    id INT IDENTITY(1,1) PRIMARY KEY,
    import_date DATE NOT NULL,
    sale_off INT NOT NULL,
    payment_method NVARCHAR(100) NOT NULL,
    note NVARCHAR(500),
    user_id INT, 
    provider_id INT,
    FOREIGN KEY (user_id) REFERENCES tblUser(id),
    FOREIGN KEY (provider_id) REFERENCES tblProvider(id)
);

CREATE TABLE tblImportedBookTitle (
    id INT IDENTITY(1,1) PRIMARY KEY,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    import_bill_id INT,
    book_title_id INT,
    FOREIGN KEY (import_bill_id) REFERENCES tblImportBill(id),
    FOREIGN KEY (book_title_id) REFERENCES tblBookTitle(id)
);

INSERT INTO tblUser(username, password, full_name, role)
VALUES ('a', '123456', 'A', N'Nhân viên kho');

SET IDENTITY_INSERT [dbo].[tblBookTitle] ON 
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (1, N'7 viên ngọc Rồng tập 6', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (2, N'7 viên ngọc rồng tập 7', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (3, N'7 viên ngọc rồng tập 8', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (4, N'Những người khốn khổ', N'Victor Hugo', 2020, N'Trẻ', 100000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (5, N'Harry Potter và chiếc cốc lửa', N'J.K.Rowling', 2017, N'Trẻ', 500000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (6, N'Harry Potter và phòng chứa bí mật', N'J.K.Rowling', 2018, N'Trẻ', 550000)
SET IDENTITY_INSERT [dbo].[tblBookTitle] OFF

-- Insert Provider data
SET IDENTITY_INSERT [dbo].[tblProvider] ON 
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (2, N'B', N'Hà Đông, Hà Nội', N'nccb@gmail.com', N'0123456789', N'Chuyên cung cấp truyện thiếu nhi')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (3, N'B', N'Quận 1, Thành phố Hồ Chí Minh', N'sgb@gmail.com', N'0987654321', N'Chuyên cung cấp truyện tranh Conan')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (4, N'Bình An', N'Hoàn Kiếm, Hà Nội', N'nccbinhan@gmail.com', N'123123123', N'Chuyên cung cấp tiểu thuyết')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (5, N'Hữu Hoà', N'Thanh Xuân, Hà Nội', N'ncchuuhoa@gmail.com', N'0981243675', N'Chuyên cung cấp truyện trinh thám')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (6, N'An Bình', N'Phú Lương, Hà Đông, Hà Nội', N'nccanbinh@gmail.com', N'0129834122', N'Chuyên cung cấp truyện Doraemon')
SET IDENTITY_INSERT [dbo].[tblProvider] OFF

-- Insert ImportBill data
SET IDENTITY_INSERT [dbo].[tblImportBill] ON 
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (5, CAST(N'2025-05-01' AS Date), 100000, N'Chuyển khoản', N'Giảm 100000 cho lần nhập đầu tiên', 1, 2)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (6, CAST(N'2025-05-01' AS Date), 100000, N'Thẻ tín dụng', N'Giảm giá do thanh toán bằng thẻ tín dụng', 1, 3)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (7, CAST(N'2025-05-01' AS Date), 1000000, N'Chuyển khoản', N'Giảm giá 1 triệu đồng', 1, 3)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (8, CAST(N'2025-05-01' AS Date), 0, N'Tiền mặt', N'', 1, 5)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (9, CAST(N'2025-05-01' AS Date), 220000, N'Thẻ tín dụng', N'', 1, 4)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (10, CAST(N'2025-05-01' AS Date), 1000000, N'Chuyển khoản', N'', 1, 6)
SET IDENTITY_INSERT [dbo].[tblImportBill] OFF

-- Insert ImportedBookTitle data
SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] ON 
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (1, 20, 30000, 5, 1)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (2, 30, 30000, 6, 1)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (3, 20, 30000, 7, 3)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (4, 40, 100000, 7, 4)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (5, 30, 30000, 8, 2)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (6, 20, 100000, 8, 4)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (7, 20, 30000, 9, 3)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (8, 30, 500000, 10, 5)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (9, 0, 550000, 10, 6)
SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] OFF
GO