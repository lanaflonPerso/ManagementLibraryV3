-- Database: books

-- DROP DATABASE books;

CREATE DATABASE books
    WITH 
    OWNER = adm_books
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT TEMPORARY, CONNECT ON DATABASE books TO PUBLIC;

GRANT ALL ON DATABASE books TO adm_books;

