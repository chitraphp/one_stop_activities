--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: activities; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE activities (
    id integer NOT NULL,
    activity_type character varying,
    description character varying
);


ALTER TABLE activities OWNER TO archanabongale;

--
-- Name: activities_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE activities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE activities_id_seq OWNER TO archanabongale;

--
-- Name: activities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE activities_id_seq OWNED BY activities.id;


--
-- Name: students; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE students (
    id integer NOT NULL,
    name character varying,
    age integer,
    phone character varying,
    email character varying,
    activity_enrolled character varying
);


ALTER TABLE students OWNER TO archanabongale;

--
-- Name: students_activities; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE students_activities (
    id integer NOT NULL,
    student_id integer,
    activity_id integer
);


ALTER TABLE students_activities OWNER TO archanabongale;

--
-- Name: students_activities_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE students_activities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE students_activities_id_seq OWNER TO archanabongale;

--
-- Name: students_activities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE students_activities_id_seq OWNED BY students_activities.id;


--
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE students_id_seq OWNER TO archanabongale;

--
-- Name: students_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE students_id_seq OWNED BY students.id;


--
-- Name: teachers; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE teachers (
    id integer NOT NULL,
    name character varying,
    qualification character varying,
    experience character varying,
    no_of_students integer,
    fees double precision,
    location text,
    spots_avaialble integer,
    class_start_date character varying,
    class_end_date character varying,
    "time" character varying,
    activity_id integer
);


ALTER TABLE teachers OWNER TO archanabongale;

--
-- Name: teachers_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE teachers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE teachers_id_seq OWNER TO archanabongale;

--
-- Name: teachers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE teachers_id_seq OWNED BY teachers.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY activities ALTER COLUMN id SET DEFAULT nextval('activities_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY students_activities ALTER COLUMN id SET DEFAULT nextval('students_activities_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY teachers ALTER COLUMN id SET DEFAULT nextval('teachers_id_seq'::regclass);


--
-- Data for Name: activities; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY activities (id, activity_type, description) FROM stdin;
\.


--
-- Name: activities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('activities_id_seq', 1, false);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY students (id, name, age, phone, email, activity_enrolled) FROM stdin;
\.


--
-- Data for Name: students_activities; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY students_activities (id, student_id, activity_id) FROM stdin;
\.


--
-- Name: students_activities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('students_activities_id_seq', 1, false);


--
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('students_id_seq', 1, false);


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY teachers (id, name, qualification, experience, no_of_students, fees, location, spots_avaialble, class_start_date, class_end_date, "time", activity_id) FROM stdin;
\.


--
-- Name: teachers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('teachers_id_seq', 1, false);


--
-- Name: activities_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY activities
    ADD CONSTRAINT activities_pkey PRIMARY KEY (id);


--
-- Name: students_activities_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY students_activities
    ADD CONSTRAINT students_activities_pkey PRIMARY KEY (id);


--
-- Name: students_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);


--
-- Name: teachers_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY teachers
    ADD CONSTRAINT teachers_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: archanabongale
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM archanabongale;
GRANT ALL ON SCHEMA public TO archanabongale;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

