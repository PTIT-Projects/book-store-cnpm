-- Disable foreign key checks
ALTER TABLE tblImportedBookTitle NOCHECK CONSTRAINT ALL;
ALTER TABLE tblImportBill NOCHECK CONSTRAINT ALL;

-- Delete data in the correct order
DELETE FROM tblImportedBookTitle;
DELETE FROM tblImportBill;
DELETE FROM tblBookTitle;
DELETE FROM tblProvider;
DELETE FROM tblUser;
DBCC CHECKIDENT ('tblUser', RESEED, 0);
DBCC CHECKIDENT ('tblProvider', RESEED, 0);
DBCC CHECKIDENT ('tblBookTitle', RESEED, 0);
DBCC CHECKIDENT ('tblImportBill', RESEED, 0);
DBCC CHECKIDENT ('tblImportedBookTitle', RESEED, 0);

-- Re-enable foreign key checks
ALTER TABLE tblImportedBookTitle CHECK CONSTRAINT ALL;
ALTER TABLE tblImportBill CHECK CONSTRAINT ALL;