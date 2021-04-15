--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-15 16:26:22

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
-- TOC entry 3007 (class 0 OID 35824)
-- Dependencies: 207
-- Data for Name: auteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (1, 'Marc Aurèle', NULL, '0121-04-26', '0180-03-17');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (2, 'Hugo', 'Victor', '1802-02-26', '1885-05-22');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (3, 'Dumas', 'Alexandre', '1802-07-24', '1870-12-05');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (4, 'Céline', NULL, '1894-05-27', '1961-07-01');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) OVERRIDING SYSTEM VALUE VALUES (5, 'Verne', 'Jules', '1828-02-08', '1905-03-24');


--
-- TOC entry 3005 (class 0 OID 27619)
-- Dependencies: 205
-- Data for Name: livre; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (1, 'Pensées pour moi-même', 'Les Pensées pour moi-même (en grec ancien : Τὰ εἰς ἑαυτόν, Ta eis heauton), souvent simplement intitulé Pensées, est le titre d''une série de réflexions divisées en douze livres, rédigées en grec entre 170 et 180 par l''empereur Marc Aurèle qui régna de 161 à 180 apr. J.-C., et écrites au moins partiellement pendant ses campagnes militaires. Les Pensées n''étaient au départ qu''un journal non destiné à être publié et révélé au public, mais devant être détruit à la mort de l''auteur. N''étant pas destiné à être lu par qui que ce soit excepté l''auteur lui-même, le texte est adressé à Marc Aurèle lui-même. L''empereur s''y fait de nombreux reproches, réexpose périodiquement les mêmes idées et se donne des exercices afin de ne pas céder aux multiples tentations et facilités auxquelles il est exposé, et afin de persévérer dans la voie de la philosophie qu''il reconnaît comme la seule mesure de la valeur d''un homme.', '9 juillet 2020', '979-8664984149');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (2, 'Les Misérables, tome 1', 'Paris et ses prisons, ses égouts. Paris insurgé : le Paris des révolutions, des barricades sur lesquelles fraternisent les hommes du peuple. Paris incarné à travers la fi gure de Gavroche, enfant des rues effronté et malicieux. Hugo retrace ici avec force les misères et les heures glorieuses des masses vivantes qui se retrouvent. Les événements se précipitent, les personnages se rencontrent, se heurtent, s''unissent parfois, à l''image de Cosette et de Marius. L''histoire du forçat évadé et de la petite miséreuse symbolise quelque chose de plus grand : avec Les Misérables, Hugo réalise enfin l''esprit du peuple.', '1 janvier 1999', '978-2070409228');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (3, 'Les Misérables, tome 2', 'C''est un tel classique qu''on a toujours l''impression de l''avoir déjà lu... ou vu : avec Michel Bouquet dans le rôle de Javert, ou bien Depardieu. Relire donc Les Misérables, publié par Victor Hugo en 1862, offre le plaisir de la reconnaissance et du recommencement. Toujours on sera emporté par la tension romanesque du livre, ses figures inoubliables, ses langues multiples - n''oublions pas que Hugo est le premier à introduire l''argot et la langue populaire dans le français écrit -, ses histoires et son temps. De la récidive malheureuse de Jean Valjean, frais libéré du bagne, à sa progressive rédemption, de l''enfance désastreuse de Cosette à son idylle avec Marius, de la figure sacrificielle de Fantine aux personnages sinistres de Thénardier et de Javert, le roman propose une belle leçon d''humanité vivante. "Je viens détruire la fatalité humaine, écrit Hugo, je condamne l''esclavage, je chasse la misère, j''enseigne l''ignorance, je traite la maladie, j''éclaire la nuit, je hais la haine. Voilà ce que je suis et voilà pourquoi j''ai fait Les Misérables."', '1 janvier 1999', '978-2070409235');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (6, 'Les Trois Mousquetaires', 'Un des grands classiques de Publié en 1844, Les Trois Mousquetaires est le plus célèbre roman d’Alexandre Dumas. D’Artagnan, Athos, Porthos et Aramis, mousquetaires du roi Louis XIII, combattent le méchant cardinal de Richelieu.
                                                        Ce roman est à la base de la plupart des histoires de cape et d’épée de nos jours et a été adapté de très nombreuses fois pour le grand et le petit écran. littérature française. Le Comte de Monte-Cristo, publié en 1844, s’inspire partiellement de la vie de Pierre Picaud, victime d’une machination politique sous le Premier Empire.
Effectivement, on retrouve des traces de ce personnage dans l’histoire d’un marin trahi par ses amis jaloux et emprisonné. Le jeune homme trouvera malgré tout le moyen de se venger en s’évadant puis en entrant en possession d’un trésor.', '1 août 2011', '978-2253008880');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (7, 'Le Comte de Monte-Cristo, tome 1', 'Un des grands classiques de la littérature française. Le Comte de Monte-Cristo, publié en 1844, s’inspire partiellement de la vie de Pierre Picaud, victime d’une machination politique sous le Premier Empire.
Effectivement, on retrouve des traces de ce personnage dans l’histoire d’un marin trahi par ses amis jaloux et emprisonné. Le jeune homme trouvera malgré tout le moyen de se venger en s’évadant puis en entrant en possession d’un trésor.', '26 août 1998', '978-2253008880');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (8, 'Le Comte de Monte-Cristo, tome 2', 'Un des grands classiques de la littérature française. Le Comte de Monte-Cristo, publié en 1844, s’inspire partiellement de la vie de Pierre Picaud, victime d’une machination politique sous le Premier Empire.
Effectivement, on retrouve des traces de ce personnage dans l’histoire d’un marin trahi par ses amis jaloux et emprisonné. Le jeune homme trouvera malgré tout le moyen de se venger en s’évadant puis en entrant en possession d’un trésor.', '26 août 1998', '978-2070405923');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (9, 'Voyage au bout de la nuit', 'Roman picaresque, roman d''initiation, Voyage au bout de la nuit, signé Louis-Ferdinand Céline, Louis Destouches de son vrai nom, a été récompensé par le prix Renaudot en 1932. À la suite d''un défilé militaire, Ferdinand Bardamu s''engage dans un régiment. Plongé dans la Grande Guerre, il fait l''expérience de l''horreur et rencontre Robinson, qu''il retrouvera tout au long de ses aventures. Blessé, rapatrié, il vit le conflit depuis l''arrière, partagé entre les conquêtes féminines et les crises de folie. Réformé, il s''embarque pour l''Afrique, travaille dans une compagnie coloniale. Malade, il gagne les États-Unis, rencontre Molly, prostituée au grand coeur à Detroit tandis qu''il est ouvrier à la chaîne. De retour en France, médecin, installé dans un dispensaire de banlieue, il est confronté au tout-venant sordide de la misère, en même temps qu''il rencontre ici et là des êtres sublimes de générosité, de délicatesse infinie, "une gaieté pour l''univers"...
Épopée antimilitariste, anticolonialiste et anticapitaliste, somme de toutes les expériences de l''auteur, Voyage au bout de la nuit est peuplé de pauvres hères brinquebalés dans un monde où l''horreur le dispute à l''absurde. Mais au bout de cette nuit, le voyage ne manque ni de drôlerie, ni de personnages fringants, de beautés féminines "en route pour l''infini". Texte essentiel de la littérature du XXe siècle, il est émaillé d''aphorismes cinglants, dynamité par des expressions familières, argotiques, et un éclatement de la syntaxe qui a fait la réputation de Céline.', '14 février 2014', NULL);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (10, 'Mort à crédit', 'Deuxième grand roman de Louis-Ferdinand Céline, Mort à crédit, publié en 1936, raconte l''enfance du Bardamu de Voyage au bout de la nuit, paru quatre ans auparavant. Après un prologue situant son présent, médecin dans les années trente, le héros narrateur, Ferdinand, se rappelle ses jeunes années, dans un milieu petit bourgeois, vers 1900. Il est fils unique, élevé dans un passage parisien entre une grand-mère éducatrice fine et intuitive, une mère sacrificielle propriétaire d''un petit magasin de dentelles et objets de curiosité et un père violent et acariâtre, employé dans une compagnie d''assurances. Il grandit maladroitement, sans cesse victime des reproches amers de ses parents, multiplie les apprentissages et les échecs sentimentaux et professionnels, séjourne dans un collège anglais avant de voir son destin basculer avec la rencontre d''un inventeur loufoque, Léonard de Vinci de la fumisterie scientifique, pour vivre des aventures toujours tragi-comiques...', '6 février 2014', NULL);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (11, 'Vingt mille lieues sous les mers', 'Le capitaine Nemo embarque les lecteurs à bord d’un fabuleux voyage dans son sous-marin, le Nautilus. Ce roman a fasciné les lecteurs de l’époque qui n’avaient jamais exploré de cette sorte le monde des profondeurs sous-marines.', '25 août 2021', '978-2211312295');
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13) OVERRIDING SYSTEM VALUE VALUES (12, 'Le Tour du Monde en 80 jours', 'En 1872, un riche gentleman londonien, Phileas Fogg, parie vingt mille livres qu''il fera le tour du monde en quatre-vingts jours. Accompagné de son valet de chambre, le dévoué Passepartout, il quitte Londres pour une formidable course contre la montre. Au prix de mille aventures, notre héros va s''employer à gagner ce pari.', ' 27 août 2014', '978-2010015809');


--
-- TOC entry 3008 (class 0 OID 35850)
-- Dependencies: 208
-- Data for Name: auteurs_livres; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (1, 1);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (2, 2);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (2, 3);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (3, 6);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (3, 7);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (3, 8);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (4, 9);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (4, 10);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (5, 11);
INSERT INTO public.auteurs_livres (id_auteur, id_livre) VALUES (5, 12);


--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 206
-- Name: auteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auteur_id_seq', 5, true);


--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 204
-- Name: livre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livre_id_seq', 12, true);


-- Completed on 2021-04-15 16:26:23

--
-- PostgreSQL database dump complete
--

