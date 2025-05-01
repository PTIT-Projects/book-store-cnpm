USE [bookstore];

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

INSERT INTO tblUser(username, password, full_name, role)
VALUES ('a', '123456', 'A', N'Nhân viên kho')
