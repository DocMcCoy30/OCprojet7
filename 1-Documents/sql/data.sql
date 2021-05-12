--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-28 14:42:18

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

--
-- TOC entry 3168 (class 0 OID 38603)
-- Dependencies: 219
-- Data for Name: pays; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pays (id, nom, code_alpha2, code_alpha3, code) OVERRIDING SYSTEM VALUE VALUES (1, 'France', 'FR', 'FRA', 250);


--
-- TOC entry 3166 (class 0 OID 38593)
-- Dependencies: 217
-- Data for Name: adresse; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) OVERRIDING SYSTEM VALUE VALUES (1, 'Place de la Maison Carrée', '30033', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) OVERRIDING SYSTEM VALUE VALUES (2, '1 Place Debussy', '30900', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) OVERRIDING SYSTEM VALUE VALUES (3, '297 avenue Monseigneur Robert Dalverny', '30000', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) OVERRIDING SYSTEM VALUE VALUES (4, '31 rue Ambroise Croizat', '30000', 'Nîmes', 1);


--
-- TOC entry 3164 (class 0 OID 38583)
-- Dependencies: 215
-- Data for Name: bibliotheque; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) OVERRIDING SYSTEM VALUE VALUES (1, 'CEN', '51946426700011', 'Bibliothèque du Carré d''Art', 1);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) OVERRIDING SYSTEM VALUE VALUES (2, 'VAL', '51946426700012', 'Bibliothèque Marc Bernard', 2);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) OVERRIDING SYSTEM VALUE VALUES (3, 'JDO', '51946426700013', 'Bibliothèque Jean d''Ormesson', 3);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) OVERRIDING SYSTEM VALUE VALUES (4, 'SER', '51946426700014', 'Bibliothèque Serre Cavalier', 4);


--
-- TOC entry 3170 (class 0 OID 38625)
-- Dependencies: 221
-- Data for Name: abonne; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3152 (class 0 OID 38516)
-- Dependencies: 203
-- Data for Name: auteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (1, 'Voltaire', '', '1689', '1778');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (2, 'Rousseau', 'Jean-Jacques', '1712', '1778');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (3, 'Hugo', 'Victor', '1802', '1885');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (4, 'Zola', 'Emile', '1840', '1902');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (5, 'Malraux', 'André', '1901', '1976');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (6, 'Dumas', 'Alexandre', '1802', '1870');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (7, 'de Montaigne', 'Michel', '1533', '1592');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (8, 'de La Fontaine', 'Jean', '1621', '1695');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (9, 'Moliere', '', '1622', '1673');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (10, 'Stendhal', '', '1783', '1842');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (11, 'Flaubert', 'Gustave', '1821', '1880');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (12, 'Baudelaire', 'Charles', '1821', '1867');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (13, 'de Maupassant', 'Guy', '1850', '1893');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (15, 'Camus', 'Albert', '1913', '1960');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (16, 'Steinbeck', 'John', '1902', '1968');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (17, 'A. Heinlein', 'Robert', '1907', '1988');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (18, 'Fante', 'John', '1909', '1983');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (19, 'Williams', 'Tennessee', '1911', '1983');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (20, 'Miller', 'Arthur', '1915', '2005');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (21, 'Asimov', 'Isaac', '1920', '1992');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (22, 'Bradbury', 'Ray', '1920', '2012');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (23, 'Bukowski', 'Charles', '1920', '1994');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (24, 'Kerouac', 'Jack', '1922', '1969');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (25, 'Ellroy', 'James', '1948', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (26, 'Easton Ellis', 'Bret', '1964', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (27, 'Lehane', 'Dennis', '1965', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (28, 'Tolstoï', 'Leon', '1828', '1910');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (29, 'Calvino', 'Italo', '1923', '1985');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (30, 'Chattam', 'Maxime', '1976', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (31, 'Dickens', 'Charles', '1812', '1870');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (32, 'Garcia Marquez', 'Gabriel', '1927', '2014');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (33, 'Kafka', 'Franz', '1883', '1924');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (34, 'King', 'Stephen', '1947', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (35, 'Kipling', 'Rudyard', '1865', '1936');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (36, 'Allan Poe', 'Edgar', '1809', '1849');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (37, 'Stocker', 'Bram', '1847', '1912');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (38, 'Verne', 'Jules', '1828', '1905');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (39, 'Wilde', 'Oscar', '1854', '1900');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (40, 'Rowling', 'J. K.', '1965', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (41, 'Tolkien', 'J. R. R.', '1892', '1973');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (42, 'Faulkner', 'William', '1897', '1962');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (43, 'Hemingway', 'Ernest', '1899', '1961');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (44, 'Mann', 'Thomas', '1875', '1955');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (45, 'Melville', 'Herman', '1819', '1891');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (46, 'Nabokov', 'Vladimir', '1899', '1977');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (47, 'Proust', 'Marcel', '1871', '1922');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (48, 'Shakespeare', 'William', '1564', '1616');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (14, 'Céline', 'Louis Ferdinand', '1894', '1961');


--
-- TOC entry 3154 (class 0 OID 38526)
-- Dependencies: 205
-- Data for Name: editeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (1, 'Hachette');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (2, 'Flammarion');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (3, 'Bayard');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (4, 'Gallimard');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (5, 'Albin Michel');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (6, 'Actes Sud');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (7, 'Eyrolles');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (8, 'Les Editions de Minuit');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (9, 'Belin');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (10, 'Larousse');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (11, 'JC Lattès');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (12, 'Seuil');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (13, 'Grasset');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (14, 'PLON');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (15, 'Stock');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (16, 'Fayard');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (17, 'Nathan');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (18, 'Presses Universitaires de France');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (19, 'Folio');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (20, 'Le Livre de Poche');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (21, 'J''ai Lu');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (22, '10X18');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (23, 'Robert Laffont');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (24, 'Penguin Classics');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (25, 'New Edition');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (26, 'Point');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (27, 'Rivages/Noir');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (28, 'Pocket');
INSERT INTO public.editeur (id, nom_maison_edition) OVERRIDING SYSTEM VALUE VALUES (29, 'Seuil');


--
-- TOC entry 3178 (class 0 OID 38706)
-- Dependencies: 229
-- Data for Name: employe; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3158 (class 0 OID 38546)
-- Dependencies: 209
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (1, 'classique');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (2, 'litterature française');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (3, 'litterature etrangere');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (4, 'roman');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (5, 'roman historique');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (6, 'policier');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (7, 'thriller');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (8, 'horreur');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (9, 'science-fiction');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (10, 'fantasy');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (11, 'biographie');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (12, 'philosophie');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (13, 'histoire');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (14, 'economie');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (15, 'droit');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (16, 'theatre');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (17, 'poesie');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (18, 'dictionnaire');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (19, 'bandes dessinees');
INSERT INTO public.genre (id, genre) OVERRIDING SYSTEM VALUE VALUES (20, 'enfant');


--
-- TOC entry 3156 (class 0 OID 38536)
-- Dependencies: 207
-- Data for Name: langue; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.langue (id, code, langue) OVERRIDING SYSTEM VALUE VALUES (1, 'fr', 'français');
INSERT INTO public.langue (id, code, langue) OVERRIDING SYSTEM VALUE VALUES (2, 'en', 'anglais');
INSERT INTO public.langue (id, code, langue) OVERRIDING SYSTEM VALUE VALUES (3, 'de', 'allemand');
INSERT INTO public.langue (id, code, langue) OVERRIDING SYSTEM VALUE VALUES (4, 'es', 'espagnol');
INSERT INTO public.langue (id, code, langue) OVERRIDING SYSTEM VALUE VALUES (5, 'it', 'italien');


--
-- TOC entry 3150 (class 0 OID 38506)
-- Dependencies: 201
-- Data for Name: livre; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (1, 'Zadig ou La Destinée', 'xxxxxxxxxxxxxx', '5 juin 2015', '978-2070466610', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (2, 'Candide et autres contes', 'xxxxxxxxxxxxxx', '22 mai 1992', '978-2070384822', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (3, 'Les confessions', 'xxxxxxxxxxxxxx', '26 mars 2009', '978-2070399697', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (5, 'La Nouvelle Héloïse', 'xxxxxxxxxxxxxx', '02 octobre 2002', '978-2253161097', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (6, 'Les Misérables', 'xxxxxxxxxxxxxx', '29 juin 2017', '978-2072730672', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (7, 'Notre-Dame de Paris', 'xxxxxxxxxxxxxx', '1 avril 1975', '978-2253009689', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (8, 'Oeuvres poétiques - Anthologies', 'xxxxxxxxxxxxxx', '27 décembre 2001', '978-2253160816', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (10, 'Au bonheur des dames', 'xxxxxxxxxxxxxx', '1 janvier 1997', '978-2253002864', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (11, 'Germinal', 'xxxxxxxxxxxxxx', '1 janvier 2000', '978-2253004226', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (13, 'La condition humaine', 'xxxxxxxxxxxxxx', '7 janvier 1972', '978-2070360017', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (14, 'Malraux : Oeuvres complètes, tome 1', 'xxxxxxxxxxxxxx', '3 mai 1989', '978-2070111428', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (15, 'La Voie royale', 'xxxxxxxxxxxxxx', '1 décembre 1976', '978-2253010357', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (16, 'Le Comte de Monte-Cristo, tome 1', 'xxxxxxxxxxxxxx', '26 août 1998', '978-2070405374', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (17, 'Le Comte de Monte-Cristo, tome 2', 'xxxxxxxxxxxxxx', '26 août 1998', '978-2070405923', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (18, 'Les Trois mousquetaires', 'xxxxxxxxxxxxxx', '1 août 2011', '978-2253008880', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (19, 'La Reine Margot', 'xxxxxxxxxxxxxx', '4 septembre 2002', '978-2253099994', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (20, 'Essais (Tome 1-Livre premier)', 'xxxxxxxxxxxxxx', '31 décembre 1999', '978-2070423811', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (21, 'Essais (Tome 2-Livre second)', 'xxxxxxxxxxxxxx', '24 septembre 2009', '978-2070423828', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (22, 'Essais (Tome 3-Livre troisième)', 'xxxxxxxxxxxxxx', '24 septembre 2009', '978-2070423835', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (23, 'La Fontaine : Fables', 'xxxxxxxxxxxxxx', '12 juin 2002', '978-2253010043', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (24, 'Les Fourberies de Scapin ', 'xxxxxxxxxxxxxx', '23 mai 2018', '978-2091887630', 17, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (25, 'Dom Juan', 'xxxxxxxxxxxxxx', '23 août 2018', '978-2091891187', 17, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (27, 'Bibliocollège - Le Médecin malgré lui', 'xxxxxxxxxxxxxx', '7 juin 2017', '978-2013949774', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (28, 'Le Misanthrope', 'xxxxxxxxxxxxxx', '10 janvier 2013', '978-2070449934', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (30, 'Œuvres complètes (Tome 1)', 'xxxxxxxxxxxxxx', '17 mai 2010', '978-2070117413', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (32, 'Bibliocollège - Le Malade imaginaire', 'xxxxxxxxxxxxxx', '27 février 2019', '978-2017064572', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (31, 'Bibliolycée - L''Ecole des femmes, Molière - Parcours Comédie et satire (texte intégral)', 'xxxxxxxxxxxxxx', '22 mai 2019', '978-2017064671', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (29, 'L''Avare', 'xxxxxxxxxxxxxx', '9 août 2013', '978-2701175980', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (9, 'L''Assommoir', 'xxxxxxxxxxxxxx', '7 décembre 1971', '978-2253002857', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (26, 'Bibliocollège - L''Avare', 'xxxxxxxxxxxxxx', '26 août 2015', '978-2012706132', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (12, 'L''Affaire Dreyfus: "J''accuse !" et autres textes', 'xxxxxxxxxxxxxx', '25 août 2010', '978-2253088721', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (4, 'Discours sur l''origine et les fondements de l''inégalité parmi les hommes', 'xxxxxxxxxxxxxx', '31 décembre 2011', '978-2081275256', 2, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (33, 'La Chartreuse de Parme', 'xxxxxxxxxxxxxx', '1 septembre 2000', '978-2253160687', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (34, 'Le Rouge et le noir (Nouvelle édition)', 'xxxxxxxxxxxxxx', '19 août 2020', '978-2253077497', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (35, 'De l''amour', 'xxxxxxxxxxxxxx', '24 avril 1980', '978-2070371891', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (36, 'L"Education sentimentale', 'xxxxxxxxxxxxxx', '16 mai 2002', '978-2253010692', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (37, 'Baudelaire : Oeuvres complètes, tome 1', 'xxxxxxxxxxxxxx', '27 novembre 1975', '978-2070108299', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (38, 'Baudelaire : Oeuvres Complètes, tome 2', 'xxxxxxxxxxxxxx', '14 octobre 1976', '978-2070108534', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (39, 'Les Fleurs du mal', 'xxxxxxxxxxxxxx', '29 mai 2019', '979-1035805319', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (40, 'Bibliolycée - Bel-Ami', 'xxxxxxxxxxxxxx', '6 juin 2018', '978-2013949873', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (41, 'Une vie', 'xxxxxxxxxxxxxx', '1 juillet 1979', '978-2253004240', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (42, 'Le Horla', 'xxxxxxxxxxxxxx', '18 février 2011', '978-2701156422', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (43, 'Bibliocollège - Le Horla et six contes fantastiques', 'xxxxxxxxxxxxxx', '21 mars 2018', '978-2013949958', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (44, 'Contes du jour et de la nuit', 'xxxxxxxxxxxxxx', '1 mai 1988', '978-2253046547', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (45, 'Guignol''s band, tomes 1 et 2', 'xxxxxxxxxxxxxx', '21 avril 1989', '978-2070381487', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (46, 'D''un château l''autre', 'xxxxxxxxxxxxxx', '4 août 1976', '978-2070367764', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (47, 'Mort à crédit', 'xxxxxxxxxxxxxx', '24 septembre 1985', '978-2070376926', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (48, 'Voyage au bout de la nuit', 'xxxxxxxxxxxxxx', '16 février 1972', '978-2253030225', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (49, 'L''étranger', 'xxxxxxxxxxxxxx', '1 décembre 1971', '978-2070360024', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (50, 'Des souris et des hommes', 'xxxxxxxxxxxxxx', '16 février 1972', '978-2070360376', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (51, 'Les raisins de la colère', 'xxxxxxxxxxxxxx', '9 mai 1972', '978-2266002707', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (52, 'Étoiles, garde à vous: Starship troopers', 'xxxxxxxxxxxxxx', '13 octobre 2003', '978-2290332238', 21, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (53, 'Marionnettes humaines', 'xxxxxxxxxxxxxx', '7 avril 2011', '978-2070441266', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (54, 'Le Chat passe-muraille', 'xxxxxxxxxxxxxx', '5 mars 1993', '978-2277222484', 21, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (55, 'Une porte sur l''été', 'xxxxxxxxxxxxxx', '19 mai 2010', '978-2253023401', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (56, 'La route de Los Angeles', 'xxxxxxxxxxxxxx', '3 janvier 2002', '978-2264032232', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (57, 'Bandini', 'xxxxxxxxxxxxxx', '3 janvier 2002', '978-2264033000', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (58, 'Demande à la poussière', 'xxxxxxxxxxxxxx', '3 janvier 2002', '978-2264033024', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (59, 'La Chatte sur un toit brûlant', 'xxxxxxxxxxxxxx', '22 novembre 2018', '978-2221216217', 23, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (60, 'Un tramway nommé Désir', 'xxxxxxxxxxxxxx', '9 novembre 2017', '978-2221203743', 23, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (61, 'A Streetcar Named Desire', 'xxxxxxxxxxxxxx', '9 février 2009', '978-0141190273', 24, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (62, 'Death of a Salesman: Certain Private Conversations in Two Acts and a Requiem', 'xxxxxxxxxxxxxx', '1 septembre 2000', '978-0141182742', 25, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (63, 'Les Sorcières de Salem', 'xxxxxxxxxxxxxx', '1 octobre 2015', '978-2221191453', 23, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (64, 'Les Misfits', 'xxxxxxxxxxxxxx', '14 juin 2018', '978-2221218181', 23, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (65, 'Mort d''un commis voyageur', 'xxxxxxxxxxxxxx', '7 avril 2016', '978-2221193358', 23, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (66, 'Le cycle des robots, tome 1 : Les robots', 'xxxxxxxxxxxxxx', '8 janvier 2020', '978-2290227268', 21, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (67, 'Le cycle des robots, tome 2 : Un défilé de robots', 'xxxxxxxxxxxxxx', '10 avril 2001', '978-2290311257', 21, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (68, 'Le cycle des robots, tome 3 : Les cavernes d''acier', 'xxxxxxxxxxxxxx', '23 septembre 2002', '978-2290319024', 21, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (69, 'Fondation (Tome 1)', 'xxxxxxxxxxxxxx', '22 octobre 2015', '978-2070463619', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (70, 'Le cycle de Fondation, II : Fondation et Empire', 'xxxxxxxxxxxxxx', '26 mars 2009', '978-2070360550', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (71, 'Le cycle de Fondation, III : Seconde Fondation', 'xxxxxxxxxxxxxx', '26 mars 2009', '978-2070360529', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (72, 'Chroniques martiennes', 'xxxxxxxxxxxxxx', '8 décembre 2002', '978-2070417742', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (73, 'Fahrenheit 451', 'xxxxxxxxxxxxxx', '22 août 2018', '979-1035801823', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (74, 'Souvenirs d''un pas grand-chose', 'xxxxxxxxxxxxxx', '4 mars 1987', '978-2253041030', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (75, 'Journal d''un vieux dégueulasse', 'xxxxxxxxxxxxxx', '1 février 1998', '978-2253143840', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (76, 'Contes de la folie ordinaire', 'xxxxxxxxxxxxxx', '1 janvier 1983', '978-2253031338', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (77, 'Le postier', 'xxxxxxxxxxxxxx', '8 octobre 2020', '978-2264076281', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (78, 'Women', 'xxxxxxxxxxxxxx', '1 mars 1984', '978-2253033974', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (79, 'Les Jours s''en vont comme des chevaux sauvages dans les collines', 'xxxxxxxxxxxxxx', '17 novembre 2011', '978-2757825655', 26, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (80, 'Au sud de nulle part', 'xxxxxxxxxxxxxx', '1 février 1986', '978-2253038368', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (81, 'Sur la route', 'xxxxxxxxxxxxxx', '20 juillet 1976', '978-2070367665', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (82, 'American Death Trip', 'xxxxxxxxxxxxxx', '23 août 2018', '978-2743611705', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (83, 'Underworld Usa', 'xxxxxxxxxxxxxx', '5 octobre 2011', '978-2743622732', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (84, 'Le Grand Nulle part', 'xxxxxxxxxxxxxx', '1 juin 1991', '978-2869304673', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (85, 'Le dahlia noir', 'xxxxxxxxxxxxxx', '18 octobre 2006', '978-2743615871', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (86, 'American Psycho', 'xxxxxxxxxxxxxx', '21 avril 2005', '978-2264039378', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (87, 'Lunar Park', 'xxxxxxxxxxxxxx', '16 septembre 2010', '978-2264051134', 22, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (88, 'Mystic River', 'xxxxxxxxxxxxxx', '7 mai 2004', '978-2743612818', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (89, 'Shutter Island', 'xxxxxxxxxxxxxx', '16 septembre 2009', '978-2743620066', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (90, 'Gone baby gone', 'xxxxxxxxxxxxxx', '14 novembre 2007', '978-2743617424', 27, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (91, 'La Guerre et la Paix, tome 1', 'xxxxxxxxxxxxxx', '30 juin 2002', '978-2070425174', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (92, 'La Guerre et la Paix, tome 2', 'xxxxxxxxxxxxxx', '25 août 2010', '978-2253089018', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (93, 'Marcovaldo ou Les saisons en ville', 'xxxxxxxxxxxxxx', '17 février 2017', '978-2070453009', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (94, 'Le Signal', 'xxxxxxxxxxxxxx', '6 février 2020', '978-2266269100', 28, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (95, 'Carnages ', 'xxxxxxxxxxxxxx', '12 mai 2010', '978-2266201711', 28, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (96, 'In Tenebris', 'xxxxxxxxxxxxxx', '11 mars 2004', '978-2266138086', 28, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (97, 'Maléfices ', 'xxxxxxxxxxxxxx', '15 mars 2005', '978-2266143752', 28, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (98, 'Les Aventures d''Oliver Twist', 'xxxxxxxxxxxxxx', '24 août 2005', '978-2253081098', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (99, 'Les grandes espérances', 'xxxxxxxxxxxxxx', '26 mai 1999', '978-2070388301', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (100, 'L''Amour aux temps du choléra', 'xxxxxxxxxxxxxx', '1 janvier 1992', '978-2253060543', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (101, 'Cent ans de solitude', 'xxxxxxxxxxxxxx', '21 février 1995', '978-2020238113', 29, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (102, 'Chronique d''une mort annoncée', 'xxxxxxxxxxxxxx', '1 novembre 1987', '978-2253043973', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (103, 'La Métamorphose', 'xxxxxxxxxxxxxx', '1 janvier 2015', '978-2070462872', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (104, 'Le Procès', 'xxxxxxxxxxxxxx', '25 mai 1987', '978-2070378401', 19, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (105, 'Salem', 'xxxxxxxxxxxxxx', '25 février 2009', '978-2253124993', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (106, 'Carrie', 'xxxxxxxxxxxxxx', '6 janvier 2010', '978-2253096764', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (107, 'Shining', 'xxxxxxxxxxxxxx', '31 octobre 2007', '978-2253151623', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (108, 'Docteur Sleep', 'xxxxxxxxxxxxxx', '4 mars 2015', '978-2253183600', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (109, 'Simetierre', 'xxxxxxxxxxxxxx', '3 septembre 2003', '978-2253151432', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (110, 'Misery ', 'xxxxxxxxxxxxxx', '4 septembre 2002', '978-2253151371', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (111, 'Histoires comme ça', 'xxxxxxxxxxxxxx', '6 juin 2007', '978-2013223997', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (112, 'Le Livre de la Jungle', 'xxxxxxxxxxxxxx', '5 avril 2017', '978-2410003796', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (113, 'Histoires extraordinaires', 'xxxxxxxxxxxxxx', '1 mars 1972', '978-2253006923', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (114, 'Nouvelles Histoires extraordinaires', 'xxxxxxxxxxxxxx', '7 novembre 2008', '978-2081221147', 2, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (115, 'Voyage au centre de la Terre', 'xxxxxxxxxxxxxx', '22 octobre 2014', '978-2010023705', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (116, 'Le tour du monde en 80 jours', 'xxxxxxxxxxxxxx', '27 août 2014', '978-2010015809', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (117, 'L''île mystérieuse', 'xxxxxxxxxxxxxx', '27 août 2014', '978-2010009310', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (118, 'Vingt mille lieues sous les mers', 'xxxxxxxxxxxxxx', '13 novembre 2014', '978-2012031975', 20, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) OVERRIDING SYSTEM VALUE VALUES (119, 'Le Portrait de Dorian Gray', 'xxxxxxxxxxxxxx', '19 décembre 1972', '978-2253002888', 20, 1);


--
-- TOC entry 3160 (class 0 OID 38561)
-- Dependencies: 211
-- Data for Name: illustration; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3172 (class 0 OID 38635)
-- Dependencies: 223
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (id, role, description) OVERRIDING SYSTEM VALUE VALUES (1, 'ROLE_USER', 'accès à signIn/LogIn/recherche');
INSERT INTO public.role (id, role, description) OVERRIDING SYSTEM VALUE VALUES (2, 'ROLE_ABONNE', 'accès à ConsultationProfil/Prolongation');
INSERT INTO public.role (id, role, description) OVERRIDING SYSTEM VALUE VALUES (3, 'ROLE_EMPLOYE', 'accès à emprunt/retour');
INSERT INTO public.role (id, role, description) OVERRIDING SYSTEM VALUE VALUES (4, 'ROLE_ADMIN', 'accès BackOffice');


--
-- TOC entry 3180 (class 0 OID 38748)
-- Dependencies: 231
-- Data for Name: many_abonne_has_many_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3179 (class 0 OID 38733)
-- Dependencies: 230
-- Data for Name: many_employe_has_many_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3175 (class 0 OID 38663)
-- Dependencies: 226
-- Data for Name: many_livre_has_many_auteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (1, 1);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (2, 1);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (3, 2);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (4, 2);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (5, 2);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (6, 3);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (7, 3);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (8, 3);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (9, 4);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (10, 4);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (11, 4);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (12, 4);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (13, 5);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (14, 5);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (15, 5);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (16, 6);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (17, 6);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (18, 6);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (19, 6);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (20, 7);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (21, 7);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (22, 7);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (23, 8);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (24, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (25, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (26, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (27, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (28, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (29, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (30, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (31, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (32, 9);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (33, 10);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (34, 10);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (35, 10);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (36, 11);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (37, 12);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (38, 12);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (39, 12);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (40, 13);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (41, 13);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (42, 13);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (43, 13);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (44, 13);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (45, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (46, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (47, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (48, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (49, 15);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (50, 16);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (51, 16);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (52, 17);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (53, 17);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (54, 17);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (55, 17);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (56, 18);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (57, 18);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (58, 18);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (59, 19);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (60, 19);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (61, 19);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (62, 20);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (63, 20);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (64, 20);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (65, 20);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (66, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (67, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (68, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (69, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (70, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (71, 21);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (72, 22);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (73, 22);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (74, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (75, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (76, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (77, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (78, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (79, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (80, 23);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (81, 24);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (82, 25);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (83, 25);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (84, 25);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (85, 25);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (86, 26);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (87, 26);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (88, 27);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (89, 27);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (90, 27);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (91, 28);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (92, 28);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (93, 29);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (94, 30);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (95, 30);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (96, 30);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (97, 30);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (98, 31);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (99, 31);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (100, 32);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (101, 32);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (102, 32);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (103, 33);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (104, 33);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (105, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (106, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (107, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (108, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (109, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (110, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (111, 35);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (112, 35);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (113, 36);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (114, 36);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (115, 38);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (116, 38);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (117, 38);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (118, 38);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (119, 39);


--
-- TOC entry 3176 (class 0 OID 38683)
-- Dependencies: 227
-- Data for Name: many_livre_has_many_genre; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3174 (class 0 OID 38645)
-- Dependencies: 225
-- Data for Name: ouvrage; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3162 (class 0 OID 38576)
-- Dependencies: 213
-- Data for Name: pret; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3186 (class 0 OID 0)
-- Dependencies: 220
-- Name: abonne_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 1, false);


--
-- TOC entry 3187 (class 0 OID 0)
-- Dependencies: 216
-- Name: adresse_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.adresse_id_seq', 4, true);


--
-- TOC entry 3188 (class 0 OID 0)
-- Dependencies: 202
-- Name: auteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auteur_id_seq', 48, true);


--
-- TOC entry 3189 (class 0 OID 0)
-- Dependencies: 214
-- Name: bibliotheque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bibliotheque_id_seq', 4, true);


--
-- TOC entry 3190 (class 0 OID 0)
-- Dependencies: 204
-- Name: editeur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.editeur_id_seq', 29, true);


--
-- TOC entry 3192 (class 0 OID 0)
-- Dependencies: 208
-- Name: genre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genre_id_seq', 20, true);


--
-- TOC entry 3193 (class 0 OID 0)
-- Dependencies: 210
-- Name: illustration_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.illustration_id_seq', 1, false);


--
-- TOC entry 3194 (class 0 OID 0)
-- Dependencies: 206
-- Name: langue_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.langue_id_seq', 5, true);


--
-- TOC entry 3195 (class 0 OID 0)
-- Dependencies: 200
-- Name: livre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livre_id_seq', 119, true);


--
-- TOC entry 3196 (class 0 OID 0)
-- Dependencies: 224
-- Name: ouvrage_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ouvrage_id_seq', 1, false);


--
-- TOC entry 3197 (class 0 OID 0)
-- Dependencies: 218
-- Name: pays_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pays_id_seq', 1, true);


--
-- TOC entry 3198 (class 0 OID 0)
-- Dependencies: 212
-- Name: pret_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pret_id_seq', 1, false);


--
-- TOC entry 3199 (class 0 OID 0)
-- Dependencies: 222
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 4, true);


-- Completed on 2021-04-28 14:42:18

--
-- PostgreSQL database dump complete
--

