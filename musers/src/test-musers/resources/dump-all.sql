PGDMP     9                    w            users    11.2    12.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    34493    users    DATABASE     �   CREATE DATABASE users WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE users;
             	   adm_users    false            �            1259    72414    address    TABLE     L  CREATE TABLE public.address (
    id bigint NOT NULL,
    complement_street character varying(255),
    complement_street_number character varying(255),
    lattitude character varying(255),
    longitude character varying(255),
    street character varying(255),
    street_number bigint,
    street_type character varying(255)
);
    DROP TABLE public.address;
       public         	   adm_users    false            �            1259    72422    address_city    TABLE     u   CREATE TABLE public.address_city (
    id_address bigint NOT NULL,
    insee_city character varying(255) NOT NULL
);
     DROP TABLE public.address_city;
       public         	   adm_users    false            �            1259    72425    city    TABLE     �   CREATE TABLE public.city (
    insee character varying(255) NOT NULL,
    name character varying(255),
    postal_code character varying(255)
);
    DROP TABLE public.city;
       public         	   adm_users    false            �            1259    72412    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       	   adm_users    false            �            1259    72433    role    TABLE     z   CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255),
    wording character varying(255)
);
    DROP TABLE public.role;
       public         	   adm_users    false            �            1259    72441    users    TABLE        CREATE TABLE public.users (
    id bigint NOT NULL,
    active boolean NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    phone character varying(255),
    id_address bigint
);
    DROP TABLE public.users;
       public         	   adm_users    false            �            1259    72449 
   users_role    TABLE     ]   CREATE TABLE public.users_role (
    id_user bigint NOT NULL,
    id_role bigint NOT NULL
);
    DROP TABLE public.users_role;
       public         	   adm_users    false            �          0    72414    address 
   TABLE DATA           �   COPY public.address (id, complement_street, complement_street_number, lattitude, longitude, street, street_number, street_type) FROM stdin;
    public       	   adm_users    false    197   +        �          0    72422    address_city 
   TABLE DATA           >   COPY public.address_city (id_address, insee_city) FROM stdin;
    public       	   adm_users    false    198   H        �          0    72425    city 
   TABLE DATA           8   COPY public.city (insee, name, postal_code) FROM stdin;
    public       	   adm_users    false    199   e        �          0    72433    role 
   TABLE DATA           1   COPY public.role (id, name, wording) FROM stdin;
    public       	   adm_users    false    200   �        �          0    72441    users 
   TABLE DATA           f   COPY public.users (id, active, email, first_name, last_name, password, phone, id_address) FROM stdin;
    public       	   adm_users    false    201   �        �          0    72449 
   users_role 
   TABLE DATA           6   COPY public.users_role (id_user, id_role) FROM stdin;
    public       	   adm_users    false    202   �!       �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public       	   adm_users    false    196                       2606    72421    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public         	   adm_users    false    197                       2606    72432    city city_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (insee);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public         	   adm_users    false    199                       2606    72440    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public         	   adm_users    false    200                       2606    72453 !   users uk6dotkott2kjsp8vw4d0m25fb7 
   CONSTRAINT     ]   ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7;
       public         	   adm_users    false    201                       2606    72448    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         	   adm_users    false    201                       2606    72454 (   address_city fk96vl80h1sqwd8k74ifbnio52y    FK CONSTRAINT     �   ALTER TABLE ONLY public.address_city
    ADD CONSTRAINT fk96vl80h1sqwd8k74ifbnio52y FOREIGN KEY (insee_city) REFERENCES public.city(insee);
 R   ALTER TABLE ONLY public.address_city DROP CONSTRAINT fk96vl80h1sqwd8k74ifbnio52y;
       public       	   adm_users    false    2066    199    198                       2606    72474 &   users_role fkahsq7xiwuf9xb7261rw6bt3ir    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fkahsq7xiwuf9xb7261rw6bt3ir FOREIGN KEY (id_user) REFERENCES public.users(id);
 P   ALTER TABLE ONLY public.users_role DROP CONSTRAINT fkahsq7xiwuf9xb7261rw6bt3ir;
       public       	   adm_users    false    201    202    2072                       2606    72459 (   address_city fkiglebsbsr9vdwyia2okldxb0n    FK CONSTRAINT     �   ALTER TABLE ONLY public.address_city
    ADD CONSTRAINT fkiglebsbsr9vdwyia2okldxb0n FOREIGN KEY (id_address) REFERENCES public.address(id);
 R   ALTER TABLE ONLY public.address_city DROP CONSTRAINT fkiglebsbsr9vdwyia2okldxb0n;
       public       	   adm_users    false    197    198    2064                       2606    72469 &   users_role fkjm2d8v3yts0ehg9pmly9hnn43    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fkjm2d8v3yts0ehg9pmly9hnn43 FOREIGN KEY (id_role) REFERENCES public.role(id);
 P   ALTER TABLE ONLY public.users_role DROP CONSTRAINT fkjm2d8v3yts0ehg9pmly9hnn43;
       public       	   adm_users    false    2068    202    200                       2606    72464 !   users fkqn6e1vfgae7l0vdporgpbuhf6    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkqn6e1vfgae7l0vdporgpbuhf6 FOREIGN KEY (id_address) REFERENCES public.address(id);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT fkqn6e1vfgae7l0vdporgpbuhf6;
       public       	   adm_users    false    201    197    2064            �      x������ � �      �      x������ � �      �      x������ � �      �   J   x�3���q�wt����tL����,.)J,I--�2��9��:��q���&�rC�C�]�8CK2s2�!�c���� �w      �   �   x��Ϲ�@�z�;h%l�v!�AHX$�	��  �����=�|�8婢2t��+45�L1�1�١�oO�:��#z`;?��$U��k��'jz��g��m��xO�E�vļ5GY���\�|'_�'P,s�����6?�J��"zL3;��\M����y풙%�Z�.�B��  q�      �      x�3�4�2�4�2�4����� A     