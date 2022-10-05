CREATE DATABASE "BD_DataCompensar"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "BD_DataCompensar"
    IS 'Base de Datos creada para la administración de la informacion sobre el proyecto de la universidad el cual consiste de un proceso de analisis de datos para la EPS Compensar';
	
	
-- Table: public.tpe_tipopersona

-- DROP TABLE IF EXISTS public.tpe_tipopersona;

CREATE TABLE IF NOT EXISTS public.tpe_tipopersona
(
    tpe_id integer NOT NULL,
    tpe_nombretipo text COLLATE pg_catalog."default",
    CONSTRAINT tpe_tipopersona_pkey PRIMARY KEY (tpe_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tpe_tipopersona
    OWNER to postgres;

COMMENT ON TABLE public.tpe_tipopersona
    IS 'Tabla para el manejo de los tipos de roles que manejaran los usuarios';	

	-- Table: public.tdo_tipodocumento

-- DROP TABLE IF EXISTS public.tdo_tipodocumento;

CREATE TABLE IF NOT EXISTS public.tdo_tipodocumento
(
    tdo_id integer NOT NULL,
    tdo_tipodocumento text COLLATE pg_catalog."default",
    CONSTRAINT tdo_tipodocumento_pkey PRIMARY KEY (tdo_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tdo_tipodocumento
    OWNER to postgres;

COMMENT ON TABLE public.tdo_tipodocumento
    IS 'Tabla para el manejo de tipo de documentos';
	
	
-- Table: public.per_persona

-- DROP TABLE IF EXISTS public.per_persona;

CREATE TABLE IF NOT EXISTS public.per_persona
(
    per_id integer NOT NULL,
    per_nombres text COLLATE pg_catalog."default",
    per_apellidos text COLLATE pg_catalog."default",
    tdo_id integer,
    per_documento text COLLATE pg_catalog."default",
    tpe_id integer,
    CONSTRAINT per_persona_pkey PRIMARY KEY (per_id),
    CONSTRAINT tipodocumento FOREIGN KEY (tdo_id)
        REFERENCES public.tdo_tipodocumento (tdo_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tipopersona FOREIGN KEY (tpe_id)
        REFERENCES public.tpe_tipopersona (tpe_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.per_persona
    OWNER to postgres;

COMMENT ON TABLE public.per_persona
    IS 'Tabla para el manejo de personas
	
	
	