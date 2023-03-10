PGDMP                          {            microserviceBD    14.6    14.6                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    19049    microserviceBD    DATABASE     l   CREATE DATABASE "microserviceBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
     DROP DATABASE "microserviceBD";
                postgres    false            ?            1259    19051    account    TABLE     ?   CREATE TABLE public.account (
    account_number bigint NOT NULL,
    account_type character varying(255),
    initial_amount real NOT NULL,
    state boolean NOT NULL,
    id_client bigint
);
    DROP TABLE public.account;
       public         heap    postgres    false            ?            1259    19050    account_account_number_seq    SEQUENCE     ?   CREATE SEQUENCE public.account_account_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.account_account_number_seq;
       public          postgres    false    210                       0    0    account_account_number_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.account_account_number_seq OWNED BY public.account.account_number;
          public          postgres    false    209            ?            1259    19058    client    TABLE     D  CREATE TABLE public.client (
    id_client bigint NOT NULL,
    address character varying(255),
    age bigint,
    gender character varying(255),
    identification character varying(255),
    name character varying(255),
    phone character varying(255),
    password character varying(255),
    state boolean NOT NULL
);
    DROP TABLE public.client;
       public         heap    postgres    false            ?            1259    19057    client_id_client_seq    SEQUENCE     }   CREATE SEQUENCE public.client_id_client_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.client_id_client_seq;
       public          postgres    false    212            	           0    0    client_id_client_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.client_id_client_seq OWNED BY public.client.id_client;
          public          postgres    false    211            ?            1259    19067    movement    TABLE     ?   CREATE TABLE public.movement (
    movement_id bigint NOT NULL,
    date timestamp(6) without time zone,
    movement_type character varying(255),
    total_amount real NOT NULL,
    value real NOT NULL,
    account_number bigint
);
    DROP TABLE public.movement;
       public         heap    postgres    false            ?            1259    19066    movement_movement_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.movement_movement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.movement_movement_id_seq;
       public          postgres    false    214            
           0    0    movement_movement_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.movement_movement_id_seq OWNED BY public.movement.movement_id;
          public          postgres    false    213            f           2604    19054    account account_number    DEFAULT     ?   ALTER TABLE ONLY public.account ALTER COLUMN account_number SET DEFAULT nextval('public.account_account_number_seq'::regclass);
 E   ALTER TABLE public.account ALTER COLUMN account_number DROP DEFAULT;
       public          postgres    false    209    210    210            g           2604    19061    client id_client    DEFAULT     t   ALTER TABLE ONLY public.client ALTER COLUMN id_client SET DEFAULT nextval('public.client_id_client_seq'::regclass);
 ?   ALTER TABLE public.client ALTER COLUMN id_client DROP DEFAULT;
       public          postgres    false    212    211    212            h           2604    19070    movement movement_id    DEFAULT     |   ALTER TABLE ONLY public.movement ALTER COLUMN movement_id SET DEFAULT nextval('public.movement_movement_id_seq'::regclass);
 C   ALTER TABLE public.movement ALTER COLUMN movement_id DROP DEFAULT;
       public          postgres    false    213    214    214            ?          0    19051    account 
   TABLE DATA           a   COPY public.account (account_number, account_type, initial_amount, state, id_client) FROM stdin;
    public          postgres    false    210   G       ?          0    19058    client 
   TABLE DATA           o   COPY public.client (id_client, address, age, gender, identification, name, phone, password, state) FROM stdin;
    public          postgres    false    212   ?                 0    19067    movement 
   TABLE DATA           i   COPY public.movement (movement_id, date, movement_type, total_amount, value, account_number) FROM stdin;
    public          postgres    false    214   y                   0    0    account_account_number_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.account_account_number_seq', 1, false);
          public          postgres    false    209                       0    0    client_id_client_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.client_id_client_seq', 1, false);
          public          postgres    false    211                       0    0    movement_movement_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.movement_movement_id_seq', 7, true);
          public          postgres    false    213            j           2606    19056    account account_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_number);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    210            l           2606    19065    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    212            n           2606    19072    movement movement_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.movement
    ADD CONSTRAINT movement_pkey PRIMARY KEY (movement_id);
 @   ALTER TABLE ONLY public.movement DROP CONSTRAINT movement_pkey;
       public            postgres    false    214            o           2606    19073 #   account fk3a5b43d0pyxvd4q9ap4lk5dyg    FK CONSTRAINT     ?   ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk3a5b43d0pyxvd4q9ap4lk5dyg FOREIGN KEY (id_client) REFERENCES public.client(id_client);
 M   ALTER TABLE ONLY public.account DROP CONSTRAINT fk3a5b43d0pyxvd4q9ap4lk5dyg;
       public          postgres    false    210    3180    212            p           2606    19078 $   movement fkt7emx63h1am1e7d6ml8cfmlh4    FK CONSTRAINT     ?   ALTER TABLE ONLY public.movement
    ADD CONSTRAINT fkt7emx63h1am1e7d6ml8cfmlh4 FOREIGN KEY (account_number) REFERENCES public.account(account_number);
 N   ALTER TABLE ONLY public.movement DROP CONSTRAINT fkt7emx63h1am1e7d6ml8cfmlh4;
       public          postgres    false    210    214    3178            ?   O   x?M?;
?0E?z?bd?h+n?6?????c? i?*m??3]5?0S%?q?]?F??8ߴt????z}?-^5??X?      ?   ?   x?E??N?0???a?w???s??*? g.??Q?@?+???+
??|?Y?s-?
V<??i?0l?8?[?????????b+??KY?t?X0֏?b
?JӜ??\P'???Ԝ?m????ƴEƴ??q-+j ?|3?C??[???I??ũ???蔭!x?}??X?5}?2?ý???=^?|??{Q???;|}???D*         m   x???=
?0??9????M?Y?Nb'A????Q*$Y?A^?0?-?"4n-3?iۯCw0N???W??2?bç???P? ??????v??X?ϳ??=?Q{BKKD7B?4?     