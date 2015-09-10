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
-- Name: activities; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE activities (
    id integer NOT NULL,
    activity_type character varying,
    description character varying
);


ALTER TABLE activities OWNER TO "Guest";

--
-- Name: activities_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE activities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE activities_id_seq OWNER TO "Guest";

--
-- Name: activities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE activities_id_seq OWNED BY activities.id;


--
-- Name: students; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE students (
    id integer NOT NULL,
    name character varying,
    age integer,
    phone character varying,
    email character varying
);


ALTER TABLE students OWNER TO "Guest";

--
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE students_id_seq OWNER TO "Guest";

--
-- Name: students_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE students_id_seq OWNED BY students.id;


--
-- Name: students_teachers_activities; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE students_teachers_activities (
    id integer NOT NULL,
    student_id integer,
    teacher_id integer,
    activity_id integer
);


ALTER TABLE students_teachers_activities OWNER TO "Guest";

--
-- Name: students_teachers_activities_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE students_teachers_activities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE students_teachers_activities_id_seq OWNER TO "Guest";

--
-- Name: students_teachers_activities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE students_teachers_activities_id_seq OWNED BY students_teachers_activities.id;


--
-- Name: teachers; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
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
    activity_id integer,
    class_time character varying
);


ALTER TABLE teachers OWNER TO "Guest";

--
-- Name: teachers_activities; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE teachers_activities (
    id integer NOT NULL,
    activity_id integer,
    teacher_id integer
);


ALTER TABLE teachers_activities OWNER TO "Guest";

--
-- Name: teachers_activities_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE teachers_activities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE teachers_activities_id_seq OWNER TO "Guest";

--
-- Name: teachers_activities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE teachers_activities_id_seq OWNED BY teachers_activities.id;


--
-- Name: teachers_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE teachers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE teachers_id_seq OWNER TO "Guest";

--
-- Name: teachers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE teachers_id_seq OWNED BY teachers.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY activities ALTER COLUMN id SET DEFAULT nextval('activities_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY students_teachers_activities ALTER COLUMN id SET DEFAULT nextval('students_teachers_activities_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY teachers ALTER COLUMN id SET DEFAULT nextval('teachers_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY teachers_activities ALTER COLUMN id SET DEFAULT nextval('teachers_activities_id_seq'::regclass);


--
-- Data for Name: activities; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY activities (id, activity_type, description) FROM stdin;
\.


--
-- Name: activities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('activities_id_seq', 1, false);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY students (id, name, age, phone, email) FROM stdin;
\.


--
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('students_id_seq', 1, false);


--
-- Data for Name: students_teachers_activities; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY students_teachers_activities (id, student_id, teacher_id, activity_id) FROM stdin;
\.


--
-- Name: students_teachers_activities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('students_teachers_activities_id_seq', 1, false);


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY teachers (id, name, qualification, experience, no_of_students, fees, location, spots_avaialble, class_start_date, class_end_date, activity_id, class_time) FROM stdin;
\.


--
-- Data for Name: teachers_activities; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY teachers_activities (id, activity_id, teacher_id) FROM stdin;
\.


--
-- Name: teachers_activities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('teachers_activities_id_seq', 1, false);


--
-- Name: teachers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('teachers_id_seq', 1, false);


--
-- Name: activities_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY activities
    ADD CONSTRAINT activities_pkey PRIMARY KEY (id);


--
-- Name: students_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);


--
-- Name: students_teachers_activities_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY students_teachers_activities
    ADD CONSTRAINT students_teachers_activities_pkey PRIMARY KEY (id);


--
-- Name: teachers_activities_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY teachers_activities
    ADD CONSTRAINT teachers_activities_pkey PRIMARY KEY (id);


--
-- Name: teachers_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY teachers
    ADD CONSTRAINT teachers_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: Guest
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Guest";
GRANT ALL ON SCHEMA public TO "Guest";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

