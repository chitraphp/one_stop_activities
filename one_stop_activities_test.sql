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
-- Name: activitites; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE activitites (
    id integer NOT NULL,
    activity_type character varying,
    description character varying
);


ALTER TABLE activitites OWNER TO archanabongale;

--
-- Name: activitites_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE activitites_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE activitites_id_seq OWNER TO archanabongale;

--
-- Name: activitites_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE activitites_id_seq OWNED BY activitites.id;


--
-- Name: activity_joint; Type: TABLE; Schema: public; Owner: archanabongale; Tablespace: 
--

CREATE TABLE activity_joint (
    id integer NOT NULL,
    teacher_id integer,
    student_id integer,
    activity_id integer
);


ALTER TABLE activity_joint OWNER TO archanabongale;

--
-- Name: activity_joint_id_seq; Type: SEQUENCE; Schema: public; Owner: archanabongale
--

CREATE SEQUENCE activity_joint_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE activity_joint_id_seq OWNER TO archanabongale;

--
-- Name: activity_joint_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: archanabongale
--

ALTER SEQUENCE activity_joint_id_seq OWNED BY activity_joint.id;


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
    time_slot character varying
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

ALTER TABLE ONLY activitites ALTER COLUMN id SET DEFAULT nextval('activitites_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY activity_joint ALTER COLUMN id SET DEFAULT nextval('activity_joint_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: archanabongale
--

ALTER TABLE ONLY teachers ALTER COLUMN id SET DEFAULT nextval('teachers_id_seq'::regclass);


--
-- Data for Name: activitites; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY activitites (id, activity_type, description) FROM stdin;
\.


--
-- Name: activitites_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('activitites_id_seq', 1, false);


--
-- Data for Name: activity_joint; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY activity_joint (id, teacher_id, student_id, activity_id) FROM stdin;
\.


--
-- Name: activity_joint_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('activity_joint_id_seq', 1, false);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY students (id, name, age, phone, email, activity_enrolled) FROM stdin;
\.


--
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('students_id_seq', 1, false);


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: archanabongale
--

COPY teachers (id, name, qualification, experience, no_of_students, fees, location, spots_avaialble, class_start_date, class_end_date, time_slot) FROM stdin;
\.


--
-- Name: teachers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: archanabongale
--

SELECT pg_catalog.setval('teachers_id_seq', 1, false);


--
-- Name: activitites_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY activitites
    ADD CONSTRAINT activitites_pkey PRIMARY KEY (id);


--
-- Name: activity_joint_pkey; Type: CONSTRAINT; Schema: public; Owner: archanabongale; Tablespace: 
--

ALTER TABLE ONLY activity_joint
    ADD CONSTRAINT activity_joint_pkey PRIMARY KEY (id);


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

