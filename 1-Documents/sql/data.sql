INSERT INTO public.pays (id, nom, code_alpha2, code_alpha3, code) VALUES (1, 'France', 'FR', 'FRA', 250);

INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (1, 'Place de la Maison Carrée', '30033', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (2, '1 Place Debussy', '30900', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (3, '297 avenue Monseigneur Robert Dalverny', '30000', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (4, '31 rue Ambroise Croizat', '30000', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (6, '4, place de Joseph', '30000', 'Nîmes', 1);
INSERT INTO public.adresse (id, rue, code_postal, ville, id_pays) VALUES (5, '23, boulevard Nathalie Thierry', '30000', 'Nîmes', 1);

INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (1, 'Voltaire', '', '1689', '1778');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (2, 'Rousseau', 'Jean-Jacques', '1712', '1778');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (3, 'Hugo', 'Victor', '1802', '1885');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (4, 'Zola', 'Emile', '1840', '1902');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (5, 'Malraux', 'André', '1901', '1976');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (6, 'Dumas', 'Alexandre', '1802', '1870');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (7, 'de Montaigne', 'Michel', '1533', '1592');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (8, 'de La Fontaine', 'Jean', '1621', '1695');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (9, 'Moliere', '', '1622', '1673');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (10, 'Stendhal', '', '1783', '1842');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (11, 'Flaubert', 'Gustave', '1821', '1880');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (12, 'Baudelaire', 'Charles', '1821', '1867');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (13, 'de Maupassant', 'Guy', '1850', '1893');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (15, 'Camus', 'Albert', '1913', '1960');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (16, 'Steinbeck', 'John', '1902', '1968');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (17, 'A. Heinlein', 'Robert', '1907', '1988');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (18, 'Fante', 'John', '1909', '1983');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (19, 'Williams', 'Tennessee', '1911', '1983');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (20, 'Miller', 'Arthur', '1915', '2005');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (21, 'Asimov', 'Isaac', '1920', '1992');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (22, 'Bradbury', 'Ray', '1920', '2012');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (23, 'Bukowski', 'Charles', '1920', '1994');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (24, 'Kerouac', 'Jack', '1922', '1969');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (25, 'Ellroy', 'James', '1948', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (26, 'Easton Ellis', 'Bret', '1964', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (27, 'Lehane', 'Dennis', '1965', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (28, 'Tolstoï', 'Leon', '1828', '1910');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (29, 'Calvino', 'Italo', '1923', '1985');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (30, 'Chattam', 'Maxime', '1976', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (31, 'Dickens', 'Charles', '1812', '1870');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (32, 'Garcia Marquez', 'Gabriel', '1927', '2014');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (33, 'Kafka', 'Franz', '1883', '1924');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (34, 'King', 'Stephen', '1947', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (35, 'Kipling', 'Rudyard', '1865', '1936');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (36, 'Allan Poe', 'Edgar', '1809', '1849');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (37, 'Stocker', 'Bram', '1847', '1912');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (38, 'Verne', 'Jules', '1828', '1905');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (39, 'Wilde', 'Oscar', '1854', '1900');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (40, 'Rowling', 'J. K.', '1965', '');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (41, 'Tolkien', 'J. R. R.', '1892', '1973');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (42, 'Faulkner', 'William', '1897', '1962');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (43, 'Hemingway', 'Ernest', '1899', '1961');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (44, 'Mann', 'Thomas', '1875', '1955');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (45, 'Melville', 'Herman', '1819', '1891');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (46, 'Nabokov', 'Vladimir', '1899', '1977');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (47, 'Proust', 'Marcel', '1871', '1922');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (48, 'Shakespeare', 'William', '1564', '1616');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (14, 'Céline', 'Louis Ferdinand', '1894', '1961');
INSERT INTO public.auteur (id, nom, prenom, date_naissance, date_deces) VALUES (49, 'Herbert', 'Franck', '1920', '1986');

INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) VALUES (1, 'CEN', '51946426700011', 'Bibliothèque du Carré d''Art', 1);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) VALUES (2, 'VAL', '51946426700012', 'Bibliothèque Marc Bernard', 2);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) VALUES (3, 'JDO', '51946426700013', 'Bibliothèque Jean d''Ormesson', 3);
INSERT INTO public.bibliotheque (id, code, numero_siret, nom, id_adresse) VALUES (4, 'SER', '51946426700014', 'Bibliothèque Serre Cavalier', 4);

INSERT INTO public.editeur (id, nom_maison_edition) VALUES (1, 'Gallimard');
INSERT INTO public.editeur (id, nom_maison_edition) VALUES (2, 'J''''ai lu');
INSERT INTO public.editeur (id, nom_maison_edition) VALUES (3, 'Le Livre de Poche');
INSERT INTO public.editeur (id, nom_maison_edition) VALUES (4, 'Albin Michel');
INSERT INTO public.editeur (id, nom_maison_edition) VALUES (5, 'JC Lattès');
INSERT INTO public.editeur (id, nom_maison_edition) VALUES (6, 'Ace');

INSERT INTO public.genre (id, genre) VALUES (12, 'Philosophie');
INSERT INTO public.genre (id, genre) VALUES (9, 'Science-Fiction');
INSERT INTO public.genre (id, genre) VALUES (8, 'Horreur');
INSERT INTO public.genre (id, genre) VALUES (10, 'Fantasy');
INSERT INTO public.genre (id, genre) VALUES (13, 'Histoire');
INSERT INTO public.genre (id, genre) VALUES (7, 'Thriller');
INSERT INTO public.genre (id, genre) VALUES (14, 'Economie');
INSERT INTO public.genre (id, genre) VALUES (6, 'Policier');
INSERT INTO public.genre (id, genre) VALUES (11, 'Biographie');
INSERT INTO public.genre (id, genre) VALUES (2, 'Litterature Française');
INSERT INTO public.genre (id, genre) VALUES (17, 'Poesie');
INSERT INTO public.genre (id, genre) VALUES (16, 'Theatre');
INSERT INTO public.genre (id, genre) VALUES (5, 'Roman Historique');
INSERT INTO public.genre (id, genre) VALUES (15, 'Droit');
INSERT INTO public.genre (id, genre) VALUES (19, 'Bandes Dessinees');
INSERT INTO public.genre (id, genre) VALUES (1, 'Classique');
INSERT INTO public.genre (id, genre) VALUES (18, 'Dictionnaire');
INSERT INTO public.genre (id, genre) VALUES (20, 'Enfant');
INSERT INTO public.genre (id, genre) VALUES (4, 'Roman');
INSERT INTO public.genre (id, genre) VALUES (3, 'Litterature Etrangere');

INSERT INTO public.langue (id, code, langue) VALUES (4, 'es', 'Espagnol');
INSERT INTO public.langue (id, code, langue) VALUES (2, 'en', 'Anglais');
INSERT INTO public.langue (id, code, langue) VALUES (3, 'de', 'Allemand');
INSERT INTO public.langue (id, code, langue) VALUES (5, 'it', 'Italien');
INSERT INTO public.langue (id, code, langue) VALUES (1, 'fr', 'Français');

INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (10, 'Salem', 'Le Maine, 1970. Ben Mears revient à Salem, s''installer à Marsten House, inhabitée depuis la mort tragique de ses propriétaires, vingt-ans auparavant. Mais très vite, il devra se rendre à l''évidence : il se passe des choses étranges dans cette petite bourgade. Un chien est immolé, un enfant disparaît et l''horreur s''infiltre, s''étend, se répand, aussi inéluctable que la nuit qui descend sur Salem.', '30 octobre 2013', '978-2709628181', 5, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (5, 'Féerie pour une autre fois', 'Cette édition est la première qui réunisse en un seul volume et sous le même titre, conformément à l''intention initiale de Céline, les deux parties de Féerie pour une autre fois. Depuis leur édition originale, respectivement en 1952 et 1954, et jusqu''à la publication, en 1993, du tome IV des Romans de Céline dans la Bibliothèque de la Pléiade qui les contient, elles avaient été éditées à part, la seconde, qui plus est, sous le titre de "Normance", alors que c''est aux épisodes qu''elle raconte que le titre Féerie pour une autre fois avait été plus spécialement destiné.Céline, tandis qu''il y travaillait, pensait à ce roman comme à un second Voyage au bout de la nuit, de nature, vingt ans après, à étonner le public autant que le roman de 1932, et ouvrant comme lui des voies nouvelles qu''il pourrait ensuite explorer. Il n''est pas dit que, son oeuvre romanesque désormais considérée et appréciée dans sa totalité, Féerie pour une autre fois n''y trouve pas cette place qu''il lui avait assignée', '1 mai 2014', '978-2070393312', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (2, 'Mort à crédit', 'Deuxième grand roman de Louis-Ferdinand Céline, Mort à crédit, publié en 1936, raconte l''enfance du Bardamu de Voyage au bout de la nuit, paru quatre ans auparavant. Après un prologue situant son présent, médecin dans les années trente, le héros narrateur, Ferdinand, se rappelle ses jeunes années, dans un milieu petit bourgeois, vers 1900. Il est fils unique, élevé dans un passage parisien entre une grand-mère éducatrice fine et intuitive, une mère sacrificielle propriétaire d''un petit magasin de dentelles et objets de curiosité et un père violent et acariâtre, employé dans une compagnie d''assurances. Il grandit maladroitement, sans cesse victime des reproches amers de ses parents, multiplie les apprentissages et les échecs sentimentaux et professionnels, séjourne dans un collège anglais avant de voir son destin basculer avec la rencontre d''un inventeur loufoque, Léonard de Vinci de la fumisterie scientifique, pour vivre des aventures toujours tragi-comiques...
Texte des origines, marqué par le sceau de l''image maternelle, Mort à crédit est un parcours initiatique, tout en violence et en émotion, où les souvenirs s''accompagnent des misères et des révoltes de l''enfance. C''est aussi une formidable évocation de Paris au tournant du siècle, drôle et riche de cocasseries irrésistibles, dans un style propre à Céline, fait d''exclamation, cassant la syntaxe traditionnelle, transposant le parler populaire dru et vert dans le langage écrit.', '6 février 2014', '978-2070376926', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (4, 'D''un château l''autre', 'En 1932, avec le Voyage au bout de la nuit, Louis-Ferdinand Céline s''imposait d''emblée comme un des grands novateurs de notre temps. Le Voyage était traduit dans le monde entier et de nombreux écrivains ont reconnu ce qu''ils devaient à Céline, de Henry Miller à Marcel Aymé, de Sartre à Jacques Perret, de Simenon à Félicien Marceau. D''un château l''autre pourrait s''intituler "le bout de la nuit". Les châteaux dont parle Céline sont en effet douloureux, agités de spectres qui se nomment la Guerre, la Haine, la Misère. Céline s''y montre trois fois châtelain : à Sigmaringen en compagnie du maréchal Pétain et de ses ministres ; au Danemark où il demeure dix-huit mois dans un cachot, puis quelques années dans une ferme délabrée ; enfin à Meudon où sa clientèle de médecin se réduit à quelques pauvres, aussi miséreux que lui. Il s''agit pourtant d''un roman autant que d''une confession, car Céline n''est pas fait pour l''objectivité. Avec un comique somptueux, il décrit les Allemands affolés, l''Europe entière leur retombant sur la tête, les ministres de Vichy sans ministère, et le Maréchal à la veille de la Haute Cour. D''un château l''autre doit être considéré au même titre que le Voyage au bout de la nuit et Mort à crédit comme un des grands livres de Céline auqel il donna du reste une suite avec Nord (1960) et Rigodon (1969).', '21 décembre 2011', '978-2070367764', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (1, 'Voyage au bout de la nuit', 'Le premier et le plus célèbre roman de Céline, le Voyage au bout de la nuit, est une geste contemporaine dont le héros, Ferdinand Bardamu, issu de la petite bourgeoisie faubourienne, nous emporte avec lui jusqu''au bout de ses expériences. De la Première Guerre mondiale aux prémices de la Seconde, on suit son chemin hasardeux en Afrique, aux Etats-Unis, dans la banlieue parisienne, à Toulouse... Publié en 1932, le Voyage au bout de la nuit obtint le prix Renaudot et fut accueilli comme un grand événement littéraire.', '14 février 2014', '978-2070360284', 1, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (9, 'Simetierre', 'Louis Creed, un jeune médecin de Chicago, vient s''installer avec sa famille à Ludlow, petite bourgade du Maine. Leur voisin, le vieux Jud Grandall les emmène visiter le pittoresque « simetierre » où des générations d''enfants ont enterré leurs animaux familiers. Mais au-delà de ce « simetierre », tout au fond de la forêt, se trouvent les terres sacrées des Indiens, lieu interdit qui séduit pourtant par ses monstrueuses promesses. Un drame atroce va bientôt déchirer l''existence des Creed, et l''on se retrouve happé dans un suspense cauchemardesque...', '31 octobre 1985', '978-2226024824', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (11, 'Docteur Sleep', 'Depuis Shining, le petit Danny Torrance a grandi. Ses démons aussi...', '30 octobre 2013', '978-2226252005', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (7, 'Ça Tome 2', 'Tout avait commencé juste avant les vacances d''été quand le petit Browers avait gravé ses initiales au couteau sur le ventre de son copain Ben Hascom. Tout s''était terminé deux mois plus tard dans les égouts par la poursuite infernale d''une créature étrange, incarnation même du mal. Mais aujourd''hui tout recommence. Les enfants terrorisés sont devenus des adultes. Le présent retrouve le passé, le destin reprend ses droits, l''horreur ressurgit. Chacun retrouvera dans ce roman à la construction saisissante ses propres souvenirs, ses angoisses et ses terreurs d''enfant, la peur de grandir dans un monde de violence.', '9 novembre 1988', '978-2226034540', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (8, 'Shining', 'Situé dans les montagnes Rocheuses, l’Overlook Hotel est tenu pour être l’un des plus beaux lieux du monde. Beauté, confort, luxe, volupté…L’hiver, l’hôtel est fermé, coupé du monde par le froid, la neige, les glaces. Seul l’habite un gardien. Cet hiver-là, c’est Jack Torrance, un alcoolique qui tente d’échapper à l’échec et au désespoir. Il est venu accompagné de sa femme, Wendy, qui espère, grâce à cet isolement, reconstruire son foyer menacé, et de leur enfant, Danny.
Mais Danny possède le don de sentir, de voir, de ressusciter les choses et les êtres à jamais disparus. Dans les cent dix chambres vides de l’Overlook, le démon est omniprésent. Cauchemar ou réalité, le corps de cette femme assassinée, ces bruits de fête qui derivent dans les couloirs, cette vie si étrange qui anime l’hôtel ?
Stephen King est considéré dans le monde entier comme le maître de la littérature d’épouvante. Shining – dont Docteur Sleep est la suite – demeure son roman le plus célèbre, adapté prodigieusement par Stanley Kubrick, avec Jack Nicholson dans le rôle principal.', '30 octobre 2013', '978-2709646048', 5, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (6, 'Ça Tome 1', 'Tout avait commencé juste avant les vacances d''été quand le petit Browers avait gravé ses initiales au couteau sur le ventre de son copain Ben Hascom. Tout s''était terminé deux mois plus tard dans les égouts par la poursuite infernale d''une créature étrange, incarnation même du mal. Mais aujourd''hui tout recommence. Les enfants terrorisés sont devenus des adultes. Le présent retrouve le passé, le destin reprend ses droits, l''horreur ressurgit. Chacun retrouvera dans ce roman à la construction saisissante ses propres souvenirs, ses angoisses et ses terreurs d''enfant, la peur de grandir dans un monde de violence.', '9 novembre 1988', '978-2226034533', 4, 1);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (16, 'God Emperor of Dune', 'Millennia have passed on Arrakis, and the once-desert planet is green with life. Leto Atreides, the son of the world’s savior, the Emperor Paul Muad’Dib, is still alive but far from human. To preserve humanity’s future, he sacrificed his own by merging with a sandworm, granting him near immortality as God Emperor of Dune for the past thirty-five hundred years.

Leto’s rule is not a benevolent one. His transformation has made not only his appearance but his morality inhuman. A rebellion, led by Siona, a member of the Atreides family, has risen to oppose the despot’s rule. But Siona is unaware that Leto’s vision of a Golden Path for humanity requires her to fulfill a destiny she never wanted—or could possibly conceive....', '4 juin 2019', '978-0593098257', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (12, 'Dune', 'Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for....

When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a journey toward a destiny greater than he could ever have imagined. And as he evolves into the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most ancient and unattainable dream. 

A stunning blend of adventure and mysticism, environmentalism and politics, Dune won the first Nebula Award, shared the Hugo Award, and formed the basis of what is undoubtedly the grandest epic in science fiction.', '1 septembre 1990', '978-0441172719', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (14, 'Children of Dune', 'The Children of Dune are twin siblings Leto and Ghanima Atreides, whose father, the Emperor Paul Muad’Dib, disappeared in the desert wastelands of Arrakis nine years ago. Like their father, the twins possess supernormal abilities—making them valuable to their manipulative aunt Alia, who rules the Empire in the name of House Atreides.

Facing treason and rebellion on two fronts, Alia’s rule is not absolute. The displaced House Corrino is plotting to regain the throne while the fanatical Fremen are being provoked into open revolt by the enigmatic figure known only as The Preacher. Alia believes that by obtaining the secrets of the twins’ prophetic visions, she can maintain control over her dynasty.

But Leto and Ghanima have their own plans for their visions—and their destinies....', '4 juin 2019', '978-0593098240', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (15, 'Heretics of Dune', 'Leto Atreides, the God Emperor of Dune, is dead. In the fifteen hundred years since his passing, the Empire has fallen into ruin. The great Scattering saw millions abandon the crumbling civilization and spread out beyond the reaches of known space. The planet Arrakis—now called Rakis—has reverted to its desert climate, and its great sandworms are dying.

Now the Lost Ones are returning home in pursuit of power. And as these factions vie for control over the remnants of the Empire, a girl named Sheeana rises to prominence in the wastelands of Rakis, sending religious fervor throughout the galaxy. For she possesses the abilities of the Fremen sandriders—fulfilling a prophecy foretold by the late God Emperor....', '4 juin 2019', '978-0593098264', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (13, 'Dune Messiah', 'Dune Messiah continues the story of Paul Atreides, better known—and feared—as the man christened Muad’Dib. As Emperor of the known universe, he possesses more power than a single man was ever meant to wield. Worshipped as a religious icon by the fanatical Fremen, Paul faces the enmity of the political houses he displaced when he assumed the throne—and a conspiracy conducted within his own sphere of influence.

And even as House Atreides begins to crumble around him from the machinations of his enemies, the true threat to Paul comes to his lover, Chani, and the unborn heir to his family’s dynasty...', '4 juin 2019', '978-0593098233', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (17, 'Chapterhouse: Dune', 'The desert planet Arrakis, called Dune, has been destroyed. The remnants of the Old Empire have been consumed by the violent matriarchal cult known as the Honored Matres. Only one faction remains a viable threat to their total conquest—the Bene Gesserit, heirs to Dune’s power.

Under the leadership of Mother Superior Darwi Odrade, the Bene Gesserit have colonized a green world on the planet Chapterhouse and are turning it into a desert, mile by scorched mile. And once they’ve mastered breeding sandworms, the Sisterhood will control the production of the greatest commodity in the known galaxy—the spice melange. But their true weapon remains a man who has lived countless lifetimes—a man who served under the God Emperor Paul Muad’Dib....', '4 juin 2019', '978-0593098271', 6, 2);
INSERT INTO public.livre (id, titre, resume, date_edition, numero_isbn13, id_editeur, id_langue) VALUES (3, 'Guignol''s band I – Guignol''s band II', 'On est parti dans la vie avec les conseils des parents. Ils n''ont pas tenu devant l''existence. On est tombé dans les salades qu''étaient plus affreuses l''une que l''autre. On est sorti comme on a pu de ces conflagrations funestes, plutôt de traviole, tout crabe baveux, à reculons, pattes en moins. On s''est bien marré quelques fois, faut être juste, même avec la merde, mais toujours en proie d''inquiétudes que les vacheries recommenceraient... Et toujours elles ont recommencé... Rappelons-nous !', '6 février 2014', '978-2070381487', 1, 1);

INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (1, 'http://localhost:8081/imageserver/static/Ca - tome 1.jpg', 'couverture', 6);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (2, 'http://localhost:8081/imageserver/static/Voyage au bout de la nuit.jpg', 'couverture', 1);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (3, 'http://localhost:8081/imageserver/static/Mort à crédit.jpg', 'couverture', 2);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (4, 'http://localhost:8081/imageserver/static/Guignol''s band.jpg', 'couverture', 3);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (5, 'http://localhost:8081/imageserver/static/D''un château l''autre.jpg', 'couverture', 4);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (6, 'http://localhost:8081/imageserver/static/Féerie pour une autre fois.jpg', 'couverture', 5);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (7, 'http://localhost:8081/imageserver/static/Ca - tome 2.jpg', 'couverture', 7);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (8, 'http://localhost:8081/imageserver/static/Shining.jpg', 'couverture', 8);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (9, 'http://localhost:8081/imageserver/static/Simetierre .jpg', 'couverture', 9);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (10, 'http://localhost:8081/imageserver/static/Salem.jpg', 'couverture', 10);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (11, 'http://localhost:8081/imageserver/static/Docteur Sleep.jpg', 'couverture', 11);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (12, 'http://localhost:8081/imageserver/static/Dune.jpg', 'couverture', 12);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (13, 'http://localhost:8081/imageserver/static/Dune Messiah.jpg', 'couverture', 13);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (14, 'http://localhost:8081/imageserver/static/Children of Dune.jpg', 'couverture', 14);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (15, 'http://localhost:8081/imageserver/static/Heretics of Dune.jpg', 'couverture', 15);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (16, 'http://localhost:8081/imageserver/static/God Emperor of Dune.jpg', 'couverture', 16);
INSERT INTO public.illustration (id, url, type_illustration, id_livre) VALUES (17, 'http://localhost:8081/imageserver/static/Chapterhouse Dune.jpg', 'couverture', 17);

INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (1, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (2, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (3, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (4, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (5, 14);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (6, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (7, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (8, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (9, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (10, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (11, 34);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (12, 49);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (13, 49);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (14, 49);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (15, 49);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (16, 49);
INSERT INTO public.many_livre_has_many_auteur (id_livre, id_auteur) VALUES (17, 49);

INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (1, 2);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (1, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (2, 2);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (2, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (3, 2);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (3, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (4, 2);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (4, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (5, 2);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (5, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (6, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (6, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (7, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (7, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (8, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (8, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (9, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (9, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (10, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (10, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (11, 4);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (11, 8);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (12, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (12, 9);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (13, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (13, 9);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (14, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (14, 9);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (15, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (15, 9);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (16, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (16, 9);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (17, 3);
INSERT INTO public.many_livre_has_many_genre (id_livre, id_genre) VALUES (17, 9);

INSERT INTO public.role (id, role, description) VALUES (1, 'ROLE_USER', 'accès à signIn/LogIn/recherche');
INSERT INTO public.role (id, role, description) VALUES (2, 'ROLE_ABONNE', 'accès à ConsultationProfil/Prolongation');
INSERT INTO public.role (id, role, description) VALUES (3, 'ROLE_EMPLOYE', 'accès à emprunt/retour');
INSERT INTO public.role (id, role, description) VALUES (4, 'ROLE_ADMIN', 'accès BackOffice');

INSERT INTO public.utilisateur (id, username, prenom, nom, email, password, numero_telephone, public_id, date_creation_compte, numero_abonne, matricule, date_entree, date_sortie, id_adresse) VALUES (2, 'employe', 'Employe', 'Test', 'employe@test.com', '$2a$10$Yucfu3jogrC/9aIDqm1rSOov5OSUFJ84m5eiav2u3OrGp8g3jQGe2', '0600000000', 'b621286b-3eaa-40ab-8e0c-9211800dfe24', '2021-06-23', 'EMPTES-b621', NULL, NULL, NULL, 6);
INSERT INTO public.utilisateur (id, username, prenom, nom, email, password, numero_telephone, public_id, date_creation_compte, numero_abonne, matricule, date_entree, date_sortie, id_adresse) VALUES (1, 'abonne', 'Abonne', 'Test', 'abonne@test.com', '$2a$10$vO2M0r50fG4V171sdfnVyOFdvYP8RX3gI499LRAD52s1BPDAJfPOe', '0600000000', 'b385ca58-c820-444b-ace2-2fcc057ef65a', '2021-06-23', 'ABOTES-b385', NULL, NULL, NULL, 5);

INSERT INTO public.many_utilisateur_has_many_role (id_utilisateur, id_role) VALUES (1, 2);
INSERT INTO public.many_utilisateur_has_many_role (id_utilisateur, id_role) VALUES (2, 2);
INSERT INTO public.many_utilisateur_has_many_role (id_utilisateur, id_role) VALUES (2, 3);

INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (5, 'VAL_VOY_1_2', false, 2, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (6, 'VAL_VOY_1_3', false, 2, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (7, 'JDO_VOY_1_1', false, 3, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (8, 'JDO_VOY_1_2', false, 3, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (9, 'JDO_VOY_1_3', false, 3, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (16, 'VAL_MOR_2_1', false, 2, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (17, 'VAL_MOR_2_2', false, 2, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (18, 'VAL_MOR_2_3', false, 2, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (19, 'JDO_MOR_2_1', false, 3, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (20, 'JDO_MOR_2_2', false, 3, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (21, 'JDO_MOR_2_3', false, 3, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (22, 'SER_MOR_2_1', false, 4, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (23, 'SER_MOR_2_2', false, 4, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (24, 'SER_MOR_2_3', false, 4, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (11, 'SER_VOY_1_2', false, 4, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (12, 'SER_VOY_1_3', false, 4, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (28, 'VAL_GUI_3_1', false, 2, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (29, 'VAL_GUI_3_2', false, 2, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (30, 'VAL_GUI_3_3', false, 2, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (31, 'JDO_GUI_3_1', false, 3, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (32, 'JDO_GUI_3_2', false, 3, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (33, 'JDO_GUI_3_3', false, 3, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (34, 'SER_GUI_3_1', false, 4, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (35, 'SER_GUI_3_2', false, 4, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (36, 'SER_GUI_3_3', false, 4, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (40, 'VAL_CHA_4_1', false, 2, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (41, 'VAL_CHA_4_2', false, 2, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (42, 'VAL_CHA_4_3', false, 2, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (43, 'JDO_CHA_4_1', false, 3, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (44, 'JDO_CHA_4_2', false, 3, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (45, 'JDO_CHA_4_3', false, 3, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (46, 'SER_CHA_4_1', false, 4, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (47, 'SER_CHA_4_2', false, 4, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (48, 'SER_CHA_4_3', false, 4, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (52, 'VAL_FEE_5_1', false, 2, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (53, 'VAL_FEE_5_2', false, 2, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (54, 'VAL_FEE_5_3', false, 2, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (55, 'JDO_FEE_5_1', false, 3, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (56, 'JDO_FEE_5_2', false, 3, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (57, 'JDO_FEE_5_3', false, 3, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (58, 'SER_FEE_5_1', false, 4, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (59, 'SER_FEE_5_2', false, 4, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (60, 'SER_FEE_5_3', false, 4, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (63, 'CEN_CA1_6_3', false, 1, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (64, 'VAL_CA1_6_1', false, 2, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (65, 'VAL_CA1_6_2', false, 2, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (66, 'VAL_CA1_6_3', false, 2, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (67, 'JDO_CA1_6_1', false, 3, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (68, 'JDO_CA1_6_2', false, 3, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (69, 'JDO_CA1_6_3', false, 3, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (70, 'SER_CA1_6_1', false, 4, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (71, 'SER_CA1_6_2', false, 4, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (72, 'SER_CA1_6_3', false, 4, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (74, 'CEN_CA2_7_2', false, 1, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (75, 'CEN_CA2_7_3', false, 1, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (76, 'VAL_CA2_7_1', false, 2, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (77, 'VAL_CA2_7_2', false, 2, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (78, 'VAL_CA2_7_3', false, 2, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (79, 'JDO_CA2_7_1', false, 3, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (80, 'JDO_CA2_7_2', false, 3, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (81, 'JDO_CA2_7_3', false, 3, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (82, 'SER_CA2_7_1', false, 4, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (83, 'SER_CA2_7_2', false, 4, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (84, 'SER_CA2_7_3', false, 4, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (86, 'CEN_SHI_8_2', false, 1, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (87, 'CEN_SHI_8_3', false, 1, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (88, 'VAL_SHI_8_1', false, 2, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (89, 'VAL_SHI_8_2', false, 2, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (90, 'VAL_SHI_8_3', false, 2, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (91, 'JDO_SHI_8_1', false, 3, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (92, 'JDO_SHI_8_2', false, 3, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (93, 'JDO_SHI_8_3', false, 3, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (94, 'SER_SHI_8_1', false, 4, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (95, 'SER_SHI_8_2', false, 4, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (96, 'SER_SHI_8_3', false, 4, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (97, 'CEN_SIM_9_1', false, 1, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (98, 'CEN_SIM_9_2', false, 1, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (99, 'CEN_SIM_9_3', false, 1, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (100, 'VAL_SIM_9_1', false, 2, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (101, 'VAL_SIM_9_2', false, 2, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (102, 'VAL_SIM_9_3', false, 2, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (103, 'JDO_SIM_9_1', false, 3, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (104, 'JDO_SIM_9_2', false, 3, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (105, 'JDO_SIM_9_3', false, 3, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (106, 'SER_SIM_9_1', false, 4, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (107, 'SER_SIM_9_2', false, 4, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (108, 'SER_SIM_9_3', false, 4, 9);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (110, 'CEN_SAL_10_2', false, 1, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (111, 'CEN_SAL_10_3', false, 1, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (112, 'VAL_SAL_10_1', false, 2, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (113, 'VAL_SAL_10_2', false, 2, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (114, 'VAL_SAL_10_3', false, 2, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (115, 'JDO_SAL_10_1', false, 3, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (116, 'JDO_SAL_10_2', false, 3, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (117, 'JDO_SAL_10_3', false, 3, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (118, 'SER_SAL_10_1', false, 4, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (119, 'SER_SAL_10_2', false, 4, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (120, 'SER_SAL_10_3', false, 4, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (121, 'CEN_DOC_11_1', false, 1, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (122, 'CEN_DOC_11_2', false, 1, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (123, 'CEN_DOC_11_3', false, 1, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (124, 'VAL_DOC_11_1', false, 2, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (125, 'VAL_DOC_11_2', false, 2, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (126, 'VAL_DOC_11_3', false, 2, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (127, 'JDO_DOC_11_1', false, 3, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (128, 'JDO_DOC_11_2', false, 3, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (129, 'JDO_DOC_11_3', false, 3, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (130, 'SER_DOC_11_1', false, 4, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (131, 'SER_DOC_11_2', false, 4, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (132, 'SER_DOC_11_3', false, 4, 11);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (136, 'VAL_DUN1_12_1', false, 2, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (134, 'CEN_DUN1_12_2', false, 1, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (2, 'CEN_VOY_1_2', false, 1, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (133, 'CEN_DUN1_12_1', false, 1, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (37, 'CEN_CHA_4_1', false, 1, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (62, 'CEN_CA1_6_2', false, 1, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (10, 'SER_VOY_1_1', true, 4, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (135, 'CEN_DUN1_12_3', true, 1, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (25, 'CEN_GUI_3_1', false, 1, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (39, 'CEN_CHA_4_3', false, 1, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (27, 'CEN_GUI_3_3', false, 1, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (26, 'CEN_GUI_3_2', false, 1, 3);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (50, 'CEN_FEE_5_2', false, 1, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (49, 'CEN_FEE_5_1', false, 1, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (109, 'CEN_SAL_10_1', false, 1, 10);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (4, 'VAL_VOY_1_1', false, 2, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (38, 'CEN_CHA_4_2', false, 1, 4);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (73, 'CEN_CA2_7_1', false, 1, 7);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (51, 'CEN_FEE_5_3', false, 1, 5);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (137, 'VAL_DUN1_12_2', false, 2, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (138, 'VAL_DUN1_12_3', false, 2, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (139, 'JDO_DUN1_12_1', false, 3, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (140, 'JDO_DUN1_12_2', false, 3, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (141, 'JDO_DUN1_12_3', false, 3, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (142, 'SER_DUN1_12_1', false, 4, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (143, 'SER_DUN1_12_2', false, 4, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (144, 'SER_DUN1_12_3', false, 4, 12);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (145, 'CEN_DUN2_13_1', false, 1, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (146, 'CEN_DUN2_13_2', false, 1, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (147, 'CEN_DUN2_13_3', false, 1, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (148, 'VAL_DUN2_13_1', false, 2, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (149, 'VAL_DUN2_13_2', false, 2, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (150, 'VAL_DUN2_13_3', false, 2, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (151, 'JDO_DUN2_13_1', false, 3, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (152, 'JDO_DUN2_13_2', false, 3, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (153, 'JDO_DUN2_13_3', false, 3, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (154, 'SER_DUN2_13_1', false, 4, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (155, 'SER_DUN2_13_2', false, 4, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (156, 'SER_DUN2_13_3', false, 4, 13);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (157, 'CEN_DUN3_14_1', false, 1, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (158, 'CEN_DUN3_14_2', false, 1, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (159, 'CEN_DUN3_14_3', false, 1, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (160, 'VAL_DUN3_14_1', false, 2, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (161, 'VAL_DUN3_14_2', false, 2, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (162, 'VAL_DUN3_14_3', false, 2, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (163, 'JDO_DUN3_14_1', false, 3, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (164, 'JDO_DUN3_14_2', false, 3, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (165, 'JDO_DUN3_14_3', false, 3, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (166, 'SER_DUN3_14_1', false, 4, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (167, 'SER_DUN3_14_2', false, 4, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (168, 'SER_DUN3_14_3', false, 4, 14);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (169, 'CEN_DUN4_15_1', false, 1, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (170, 'CEN_DUN4_15_2', false, 1, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (171, 'CEN_DUN4_15_3', false, 1, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (172, 'VAL_DUN4_15_1', false, 2, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (173, 'VAL_DUN4_15_2', false, 2, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (174, 'VAL_DUN4_15_3', false, 2, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (175, 'JDO_DUN4_15_1', false, 3, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (176, 'JDO_DUN4_15_2', false, 3, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (177, 'JDO_DUN4_15_3', false, 3, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (178, 'SER_DUN4_15_1', false, 4, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (179, 'SER_DUN4_15_2', false, 4, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (180, 'SER_DUN4_15_3', false, 4, 15);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (181, 'CEN_DUN5_16_1', false, 1, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (182, 'CEN_DUN5_16_2', false, 1, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (183, 'CEN_DUN5_16_3', false, 1, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (184, 'VAL_DUN5_16_1', false, 2, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (185, 'VAL_DUN5_16_2', false, 2, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (186, 'VAL_DUN5_16_3', false, 2, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (187, 'JDO_DUN5_16_1', false, 3, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (188, 'JDO_DUN5_16_2', false, 3, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (189, 'JDO_DUN5_16_3', false, 3, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (190, 'SER_DUN5_16_1', false, 4, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (191, 'SER_DUN5_16_2', false, 4, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (192, 'SER_DUN5_16_3', false, 4, 16);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (193, 'CEN_DUN6_17_1', false, 1, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (194, 'CEN_DUN6_17_2', false, 1, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (195, 'CEN_DUN6_17_3', false, 1, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (196, 'VAL_DUN6_17_1', false, 2, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (197, 'VAL_DUN6_17_2', false, 2, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (198, 'VAL_DUN6_17_3', false, 2, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (199, 'JDO_DUN6_17_1', false, 3, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (200, 'JDO_DUN6_17_2', false, 3, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (201, 'JDO_DUN6_17_3', false, 3, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (202, 'SER_DUN6_17_1', false, 4, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (203, 'SER_DUN6_17_2', false, 4, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (204, 'SER_DUN6_17_3', false, 4, 17);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (1, 'CEN_VOY_1_1', false, 1, 1);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (61, 'CEN_CA1_6_1', false, 1, 6);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (85, 'CEN_SHI_8_1', false, 1, 8);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (15, 'CEN_MOR_2_3', false, 1, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (13, 'CEN_MOR_2_1', false, 1, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (14, 'CEN_MOR_2_2', false, 1, 2);
INSERT INTO public.ouvrage (id, id_interne, emprunte, id_bibliotheque, id_livre) VALUES (3, 'CEN_VOY_1_3', false, 1, 1);

SELECT pg_catalog.setval('public.adresse_id_seq1', 8, false);

SELECT pg_catalog.setval('public.auteur_id_seq1', 1, false);

SELECT pg_catalog.setval('public.bibliotheque_id_seq1', 1, false);

SELECT pg_catalog.setval('public.editeur_id_seq1', 1, false);

SELECT pg_catalog.setval('public.genre_id_seq1', 1, false);

SELECT pg_catalog.setval('public.illustration_id_seq1', 1, false);

SELECT pg_catalog.setval('public.langue_id_seq1', 1, false);

SELECT pg_catalog.setval('public.livre_id_seq1', 1, false);

SELECT pg_catalog.setval('public.ouvrage_id_seq1', 1, false);

SELECT pg_catalog.setval('public.pays_id_seq1', 1, false);

SELECT pg_catalog.setval('public.pret_id_seq1', 1, false);

SELECT pg_catalog.setval('public.role_id_seq1', 1, false);

SELECT pg_catalog.setval('public.utilisateur_id_seq', 3, false);
