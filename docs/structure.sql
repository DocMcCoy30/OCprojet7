--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-15 16:25:26

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
-- TOC entry 207 (class 1259 OID 35824)
-- Name: auteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auteur (
    id integer NOT NULL,
    nom character varying,
    prenom character varying,
    date_naissance date,
    date_deces date
);


ALTER TABLE public.auteur OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 35822)
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
-- TOC entry 208 (class 1259 OID 35850)
-- Name: auteurs_livres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auteurs_livres (
    id_auteur integer NOT NULL,
    id_livre integer NOT NULL
);


ALTER TABLE public.auteurs_livres OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 27619)
-- Name: livre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livre (
    id integer NOT NULL,
    titre character varying NOT NULL,
    resume character varying NOT NULL,
    date_edition character varying NOT NULL,
    numero_isbn13 character varying
);


ALTER TABLE public.livre OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 27617)
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
-- TOC entry 2869 (class 2606 OID 35831)
-- Name: auteur auteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auteur
    ADD CONSTRAINT auteur_pk PRIMARY KEY (id);


--
-- TOC entry 2871 (class 2606 OID 35854)
-- Name: auteurs_livres auteurs_livres_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auteurs_livres
    ADD CONSTRAINT auteurs_livres_pk PRIMARY KEY (id_auteur, id_livre);


--
-- TOC entry 2867 (class 2606 OID 27626)
-- Name: livre livre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT livre_pk PRIMARY KEY (id);


--
-- TOC entry 2872 (class 2606 OID 35855)
-- Name: auteurs_livres auteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auteurs_livres
    ADD CONSTRAINT auteur_fk FOREIGN KEY (id_auteur) REFERENCES public.auteur(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2873 (class 2606 OID 35860)
-- Name: auteurs_livres livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auteurs_livres
    ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2021-04-15 16:25:26

--
-- PostgreSQL database dump complete
--

