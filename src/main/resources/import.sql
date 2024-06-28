-- Inserting data into the 'publishers' table
INSERT INTO publishers (name) VALUES ('Penguin Random House'), ('HarperCollins'),('Simon & Schuster');
 

INSERT INTO authors (name) VALUES ('J.K. Rowling'), ('George R.R. Martin'), ('J.R.R. Tolkien');

-- Inserting data into the 'books' table
INSERT INTO books (title, n_pages, price, genre, language, publication_date, publisher_id, author_id) VALUES ('Harry Potter and the Philosopher''s Stone', 223, 19.99, 'FANTASY', 'ENGLISH', '1997-06-26', 1, 1),('A Game of Thrones', 694, 22.99, 'FANTASY', 'ENGLISH', '1996-08-06', 2, 2),('The Hobbit', 310, 15.99, 'FANTASY', 'ENGLISH', '1937-09-21', 3, 3),('Harry Potter and the Chamber of Secrets', 251, 20.99, 'FANTASY', 'ENGLISH', '1998-07-02', 1, 1),('A Clash of Kings', 768, 24.99, 'FANTASY', 'ENGLISH', '1998-11-16', 2, 2),('The Lord of the Rings', 1178, 35.99, 'FANTASY', 'ENGLISH', '1954-07-29', 3, 3);

