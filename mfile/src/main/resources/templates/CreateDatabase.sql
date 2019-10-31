-- Database: files

-- DROP DATABASE files;

CREATE DATABASE files
    WITH 
    OWNER = adm_file
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT TEMPORARY, CONNECT ON DATABASE files TO PUBLIC;

GRANT ALL ON DATABASE files TO adm_file;

