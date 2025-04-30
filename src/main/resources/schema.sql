USE [bookstore];

CREATE TABLE tblUser (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(250),
    password VARCHAR(250),
    fullName NVARCHAR(250),
    role NVARCHAR(250)
);

CREATE TABLE tblProvider (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250),
    address NVARCHAR(250),
    email VARCHAR(250),
    phone_number VARCHAR(250),
    note NVARCHAR(500)
);

CREATE TABLE tblBookTitle (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(250),
    author NVARCHAR(250),
    publicationYear INT,
    publisher NVARCHAR(250),
    unitPrice INT
);

CREATE TABLE tblImportBill (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    import_date DATE,
    sale_off INT,
    payment_method NVARCHAR(100),
    note NVARCHAR(500),
    user_id NUMERIC, 
    provider_id NUMERIC,
    FOREIGN KEY (user_id) REFERENCES tblUser(id),
    FOREIGN KEY (provider_id) REFERENCES tblProvider(id)
);

CREATE TABLE tblImportedBookTitle (
    id NUMERIC IDENTITY(1,1) PRIMARY KEY,
    quantity INT,
    unitPrice INT,
	import_bill_id NUMERIC,
	book_title_id NUMERIC,
	FOREIGN KEY (import_bill_id) REFERENCES tblImportBill(id),
    FOREIGN KEY (book_title_id) REFERENCES tblBookTitle(id)
);

INSERT INTO tblUser(username, password, fullName, role)
VALUES ('a', '123456', 'A', N'Nhân viên kho')
