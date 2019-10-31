-- Database: users

-- DROP DATABASE users;

CREATE DATABASE users
    WITH 
    OWNER = adm_users
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT TEMPORARY, CONNECT ON DATABASE users TO PUBLIC;

GRANT ALL ON DATABASE users TO adm_users;


