

INSERT INTO tblUser(username, password, full_name, role)
VALUES ('a', '$2a$10$zV2UsHDn5CrAwin/vw1V4O8m7mvaZhWbd3t9hBvVmHvZ2TR07.VLa', 'A', N'Nhân viên kho');

SET IDENTITY_INSERT [dbo].[tblBookTitle] ON 
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (1, N'7 viên ngọc rồng tập 6', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (2, N'7 viên ngọc rồng tập 60', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (3, N'7 viên ngọc rồng tập 7', N'Akira Toriyama', 2023, N'Kim Đồng', 30000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (4, N'Ngoại truyện 7 viên ngọc rồng tập 60', N'Akira Toriyama', 2024, N'Kim Đồng', 40000)
INSERT [dbo].[tblBookTitle] ([id], [name], [author], [publication_year], [publisher], [unit_price]) VALUES (5, N'Ngoại truyện 7 viên ngọc rồng tập 6', N'Akira Toriyama', 2024, N'Kim Đồng', 40000)
SET IDENTITY_INSERT [dbo].[tblBookTitle] OFF


SET IDENTITY_INSERT [dbo].[tblProvider] ON 
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (1, N'B', N'Hà Đông, Hà Nội', N'nccb@gmail.com', N'0123456789', N'Chuyên cung cấp truyện thiếu nhi')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (2, N'Bình An', N'Hoàn Kiếm, Hà Nội', N'nccbinhan@gmail.com', N'123123123', N'Chuyên cung cấp tiểu thuyết')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (3, N'An Bình', N'Đống Đa, Hà Nội', N'nccanbinh@gmail.com', N'0129834122', N'Chuyên cung cấp truyện Doraemon')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (4, N'An', N'Quận 10, Sài Gòn', N'nccan@gmail.com', N'0722645498 ', N'Chuyên cung cấp truyện trinh thám')
INSERT [dbo].[tblProvider] ([id], [name], [address], [email], [phone_number], [note]) VALUES (5, N'An B', N'Thanh Xuân, Hà Nội', N'nccanb@gmail.com', N'0912834162', N'Chuyên cung cấp truyện tranh')
SET IDENTITY_INSERT [dbo].[tblProvider] OFF


SET IDENTITY_INSERT [dbo].[tblImportBill] ON 
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (1, CAST('2025-05-01' AS Date), 100000, N'Chuyển khoản', N'Giảm 100000 cho lần nhập đầu tiên', 1, 1)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (2, CAST('2025-05-01' AS Date), 100000, N'Thẻ tín dụng', N'Giảm giá do thanh toán bằng thẻ tín dụng', 1, 2)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (3, CAST('2025-05-02' AS Date), 0, N'Tiền mặt', N'', 1, 3)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (4, CAST('2025-05-02' AS Date), 0, N'Chuyển khoản', N'', 1, 4)
INSERT [dbo].[tblImportBill] ([id], [import_date], [sale_off], [payment_method], [note], [user_id], [provider_id]) VALUES (5, CAST('2025-05-02' AS Date), 0, N'Tiền mặt', N'', 1, 5)
SET IDENTITY_INSERT [dbo].[tblImportBill] OFF


SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] ON 
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (1, 20, 30000, 1, 1)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (2, 30, 30000, 1, 3)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (3, 25, 30000, 2, 2)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (4, 15, 40000, 2, 4)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (5, 30, 40000, 2, 5)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (6, 20, 30000, 3, 1)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (7, 15, 30000, 3, 2)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (8, 25, 30000, 4, 3)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (9, 20, 40000, 4, 4)
INSERT [dbo].[tblImportedBookTitle] ([id], [quantity], [unit_price], [import_bill_id], [book_title_id]) VALUES (10, 20, 40000, 5, 5)
SET IDENTITY_INSERT [dbo].[tblImportedBookTitle] OFF
GO