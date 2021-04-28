--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-28 14:43:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 221 (class 1259 OID 38625)
-- Name: abonne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.abonne (
    id integer NOT NULL,
    username character varying NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    numero_telephone character varying NOT NULL,
    date_creation_compte date NOT NULL,
    numero_abonne character varying NOT NULL,
    bibliotheque_preferee integer,
    id_adresse integer
);


ALTER TABLE public.abonne OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 38623)
-- Name: abonne_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.abonne ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.abonne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 38593)
-- Name: adresse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresse (
    id integer NOT NULL,
    rue character varying NOT NULL,
    code_postal character varying NOT NULL,
    ville character varying NOT NULL,
    id_pays integer
);


ALTER TABLE public.adresse OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 38591)
-- Name: adresse_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.adresse ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.adresse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 38516)
-- Name: auteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auteur (
    id integer NOT NULL,
    nom character varying,
    prenom character varying,
    date_naissance character varying,
    date_deces character varying
);


ALTER TABLE public.auteur OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 38514)
-- Name: auteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.auteur ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.auteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 215 (class 1259 OID 38583)
-- Name: bibliotheque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bibliotheque (
    id integer NOT NULL,
    code character varying NOT NULL,
    numero_siret character varying,
    nom character varying NOT NULL,
    id_adresse integer
);


ALTER TABLE public.bibliotheque OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 38581)
-- Name: bibliotheque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.bibliotheque ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.bibliotheque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 38526)
-- Name: editeur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editeur (
    id integer NOT NULL,
    nom_maison_edition character varying NOT NULL
);


ALTER TABLE public.editeur OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 38524)
-- Name: editeur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.editeur ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.editeur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 229 (class 1259 OID 38706)
-- Name: employe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employe (
    id integer NOT NULL,
    username character varying NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    numero_telephone character varying NOT NULL,
    date_creation_compte date NOT NULL,
    matricule character varying NOT NULL,
    date_entree date NOT NULL,
    date_sortie date,
    id_adresse integer
);


ALTER TABLE public.employe OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 38704)
-- Name: employe_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employe ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 38546)
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genre (
    id integer NOT NULL,
    genre character varying NOT NULL
);


ALTER TABLE public.genre OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 38544)
-- Name: genre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.genre ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.genre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 38561)
-- Name: illustration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.illustration (
    id integer NOT NULL,
    url character varying,
    type_illustration character varying,
    id_livre integer
);


ALTER TABLE public.illustration OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 38559)
-- Name: illustration_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.illustration ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.illustration_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 207 (class 1259 OID 38536)
-- Name: langue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.langue (
    id integer NOT NULL,
    code character varying NOT NULL,
    langue character varying NOT NULL
);


ALTER TABLE public.langue OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 38534)
-- Name: langue_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.langue ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.langue_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 38506)
-- Name: livre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livre (
    id integer NOT NULL,
    titre character varying NOT NULL,
    resume character varying NOT NULL,
    date_edition character varying NOT NULL,
    numero_isbn13 character varying,
    id_editeur integer,
    id_langue integer
);


ALTER TABLE public.livre OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 38504)
-- Name: livre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.livre ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.livre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 231 (class 1259 OID 38748)
-- Name: many_abonne_has_many_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.many_abonne_has_many_role (
    id_abonne integer NOT NULL,
    id_role integer NOT NULL
);


ALTER TABLE public.many_abonne_has_many_role OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 38733)
-- Name: many_employe_has_many_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.many_employe_has_many_role (
    id_employe integer NOT NULL,
    id_role integer NOT NULL
);


ALTER TABLE public.many_employe_has_many_role OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 38663)
-- Name: many_livre_has_many_auteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.many_livre_has_many_auteur (
    id_livre integer NOT NULL,
    id_auteur integer NOT NULL
);


ALTER TABLE public.many_livre_has_many_auteur OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 38683)
-- Name: many_livre_has_many_genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.many_livre_has_many_genre (
    id_livre integer NOT NULL,
    id_genre integer NOT NULL
);


ALTER TABLE public.many_livre_has_many_genre OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 38645)
-- Name: ouvrage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ouvrage (
    id integer NOT NULL,
    id_interne character varying NOT NULL,
    emprunte boolean NOT NULL,
    id_bibliotheque integer,
    id_livre integer
);


ALTER TABLE public.ouvrage OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 38643)
-- Name: ouvrage_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.ouvrage ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ouvrage_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 38603)
-- Name: pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays (
    id integer NOT NULL,
    nom character varying NOT NULL,
    code_alpha2 character varying NOT NULL,
    code_alpha3 character varying NOT NULL,
    code integer NOT NULL
);


ALTER TABLE public.pays OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 38601)
-- Name: pays_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pays ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pays_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 38576)
-- Name: pret; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pret (
    id integer NOT NULL,
    date_emprunt date NOT NULL,
    date_restitution date,
    date_prolongation date,
    prolongation boolean NOT NULL,
    id_ouvrage integer,
    id_abonne integer
);


ALTER TABLE public.pret OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 38574)
-- Name: pret_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pret ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pret_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 38635)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id integer NOT NULL,
    role character varying NOT NULL,
    description character varying
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 38633)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.role ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2980 (class 2606 OID 38632)
-- Name: abonne abonne_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abonne
    ADD CONSTRAINT abonne_pk PRIMARY KEY (id);


--
-- TOC entry 2982 (class 2606 OID 38725)
-- Name: abonne abonne_uq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abonne
    ADD CONSTRAINT abonne_uq UNIQUE (id_adresse);


--
-- TOC entry 2976 (class 2606 OID 38600)
-- Name: adresse adresse_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT adresse_pk PRIMARY KEY (id);


--
-- TOC entry 2960 (class 2606 OID 38523)
-- Name: auteur auteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auteur
    ADD CONSTRAINT auteur_pk PRIMARY KEY (id);


--
-- TOC entry 2972 (class 2606 OID 38590)
-- Name: bibliotheque bibliotheque_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bibliotheque
    ADD CONSTRAINT bibliotheque_pk PRIMARY KEY (id);


--
-- TOC entry 2974 (class 2606 OID 38622)
-- Name: bibliotheque bibliotheque_uq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bibliotheque
    ADD CONSTRAINT bibliotheque_uq UNIQUE (id_adresse);


--
-- TOC entry 2962 (class 2606 OID 38533)
-- Name: editeur editeur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editeur
    ADD CONSTRAINT editeur_pk PRIMARY KEY (id);


--
-- TOC entry 2992 (class 2606 OID 38713)
-- Name: employe employe_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT employe_pk PRIMARY KEY (id);


--
-- TOC entry 2994 (class 2606 OID 38732)
-- Name: employe employe_uq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT employe_uq UNIQUE (id_adresse);


--
-- TOC entry 2966 (class 2606 OID 38553)
-- Name: genre genre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genre
    ADD CONSTRAINT genre_pk PRIMARY KEY (id);


--
-- TOC entry 2968 (class 2606 OID 38568)
-- Name: illustration illustration_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illustration
    ADD CONSTRAINT illustration_pk PRIMARY KEY (id);


--
-- TOC entry 2964 (class 2606 OID 38543)
-- Name: langue langue_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.langue
    ADD CONSTRAINT langue_pk PRIMARY KEY (id);


--
-- TOC entry 2958 (class 2606 OID 38513)
-- Name: livre livre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT livre_pk PRIMARY KEY (id);


--
-- TOC entry 2998 (class 2606 OID 38752)
-- Name: many_abonne_has_many_role many_abonne_has_many_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_abonne_has_many_role
    ADD CONSTRAINT many_abonne_has_many_role_pk PRIMARY KEY (id_abonne, id_role);


--
-- TOC entry 2996 (class 2606 OID 38737)
-- Name: many_employe_has_many_role many_employe_has_many_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_employe_has_many_role
    ADD CONSTRAINT many_employe_has_many_role_pk PRIMARY KEY (id_employe, id_role);


--
-- TOC entry 2988 (class 2606 OID 38667)
-- Name: many_livre_has_many_auteur many_livre_has_many_auteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_auteur
    ADD CONSTRAINT many_livre_has_many_auteur_pk PRIMARY KEY (id_livre, id_auteur);


--
-- TOC entry 2990 (class 2606 OID 38687)
-- Name: many_livre_has_many_genre many_livre_has_many_genre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_genre
    ADD CONSTRAINT many_livre_has_many_genre_pk PRIMARY KEY (id_livre, id_genre);


--
-- TOC entry 2986 (class 2606 OID 38652)
-- Name: ouvrage ouvrage_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouvrage
    ADD CONSTRAINT ouvrage_pk PRIMARY KEY (id);


--
-- TOC entry 2978 (class 2606 OID 38610)
-- Name: pays pays_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT pays_pk PRIMARY KEY (id);


--
-- TOC entry 2970 (class 2606 OID 38580)
-- Name: pret pret_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT pret_pk PRIMARY KEY (id);


--
-- TOC entry 2984 (class 2606 OID 38642)
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- TOC entry 3003 (class 2606 OID 38714)
-- Name: pret abonne_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT abonne_fk FOREIGN KEY (id_abonne) REFERENCES public.abonne(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3017 (class 2606 OID 38753)
-- Name: many_abonne_has_many_role abonne_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_abonne_has_many_role
    ADD CONSTRAINT abonne_fk FOREIGN KEY (id_abonne) REFERENCES public.abonne(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3004 (class 2606 OID 38616)
-- Name: bibliotheque adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bibliotheque
    ADD CONSTRAINT adresse_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3006 (class 2606 OID 38719)
-- Name: abonne adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abonne
    ADD CONSTRAINT adresse_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3014 (class 2606 OID 38726)
-- Name: employe adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT adresse_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3011 (class 2606 OID 38673)
-- Name: many_livre_has_many_auteur auteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_auteur
    ADD CONSTRAINT auteur_fk FOREIGN KEY (id_auteur) REFERENCES public.auteur(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3008 (class 2606 OID 38653)
-- Name: ouvrage bibliotheque_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouvrage
    ADD CONSTRAINT bibliotheque_fk FOREIGN KEY (id_bibliotheque) REFERENCES public.bibliotheque(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3007 (class 2606 OID 38763)
-- Name: abonne bibliotheque_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abonne
    ADD CONSTRAINT bibliotheque_fk FOREIGN KEY (bibliotheque_preferee) REFERENCES public.bibliotheque(id) MATCH FULL ON UPDATE CASCADE;


--
-- TOC entry 2999 (class 2606 OID 38554)
-- Name: livre editeur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT editeur_fk FOREIGN KEY (id_editeur) REFERENCES public.editeur(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3015 (class 2606 OID 38738)
-- Name: many_employe_has_many_role employe_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_employe_has_many_role
    ADD CONSTRAINT employe_fk FOREIGN KEY (id_employe) REFERENCES public.employe(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3013 (class 2606 OID 38694)
-- Name: many_livre_has_many_genre genre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_genre
    ADD CONSTRAINT genre_fk FOREIGN KEY (id_genre) REFERENCES public.genre(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3000 (class 2606 OID 38678)
-- Name: livre langue_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT langue_fk FOREIGN KEY (id_langue) REFERENCES public.langue(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3001 (class 2606 OID 38569)
-- Name: illustration livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illustration
    ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3009 (class 2606 OID 38658)
-- Name: ouvrage livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouvrage
    ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3010 (class 2606 OID 38668)
-- Name: many_livre_has_many_auteur livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_auteur
    ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3012 (class 2606 OID 38689)
-- Name: many_livre_has_many_genre livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_livre_has_many_genre
    ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3002 (class 2606 OID 38699)
-- Name: pret ouvrage_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT ouvrage_fk FOREIGN KEY (id_ouvrage) REFERENCES public.ouvrage(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3005 (class 2606 OID 38611)
-- Name: adresse pays_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT pays_fk FOREIGN KEY (id_pays) REFERENCES public.pays(id) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3016 (class 2606 OID 38743)
-- Name: many_employe_has_many_role role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_employe_has_many_role
    ADD CONSTRAINT role_fk FOREIGN KEY (id_role) REFERENCES public.role(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3018 (class 2606 OID 38758)
-- Name: many_abonne_has_many_role role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.many_abonne_has_many_role
    ADD CONSTRAINT role_fk FOREIGN KEY (id_role) REFERENCES public.role(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2021-04-28 14:43:00

--
-- PostgreSQL database dump complete
--

