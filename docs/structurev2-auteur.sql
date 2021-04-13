-- Diff code generated with pgModeler (PostgreSQL Database Modeler)
-- pgModeler version: 0.9.3
-- Diff date: 2021-04-13 15:26:57
-- Source model: DB_P7_Bibliotheque
-- Database: DB_P7_Bibliotheque
-- PostgreSQL version: 13.0

-- [ Diff summary ]
-- Dropped objects: 3
-- Created objects: 3
-- Changed objects: 0
-- Truncated tables: 0

SET search_path=public,pg_catalog;
-- ddl-end --


-- [ Dropped objects ] --
ALTER TABLE public.many_auteur_has_many_livre DROP CONSTRAINT IF EXISTS livre_fk CASCADE;
-- ddl-end --
ALTER TABLE public.many_auteur_has_many_livre DROP CONSTRAINT IF EXISTS auteur_fk CASCADE;
-- ddl-end --
DROP TABLE IF EXISTS public.many_auteur_has_many_livre CASCADE;
-- ddl-end --


-- [ Created objects ] --
-- object: public.auteurs_livres | type: TABLE --
-- DROP TABLE IF EXISTS public.auteurs_livres CASCADE;
CREATE TABLE public.auteurs_livres (
	id_auteur integer NOT NULL,
	id_livre integer NOT NULL,
	CONSTRAINT auteurs_livres_pk PRIMARY KEY (id_auteur,id_livre)

);
-- ddl-end --



-- [ Created foreign keys ] --
-- object: auteur_fk | type: CONSTRAINT --
-- ALTER TABLE public.auteurs_livres DROP CONSTRAINT IF EXISTS auteur_fk CASCADE;
ALTER TABLE public.auteurs_livres ADD CONSTRAINT auteur_fk FOREIGN KEY (id_auteur)
REFERENCES public.auteur (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: livre_fk | type: CONSTRAINT --
-- ALTER TABLE public.auteurs_livres DROP CONSTRAINT IF EXISTS livre_fk CASCADE;
ALTER TABLE public.auteurs_livres ADD CONSTRAINT livre_fk FOREIGN KEY (id_livre)
REFERENCES public.livre (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

