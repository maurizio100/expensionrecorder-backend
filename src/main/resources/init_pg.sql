-- Table: public.expense

-- DROP TABLE public.expense;

CREATE TABLE expense
(
  expense_id bigint NOT NULL,
  description character varying(255),
  expense_date date,
  name character varying(255) NOT NULL,
  price numeric(19,2) NOT NULL,
  CONSTRAINT expense_pkey PRIMARY KEY (expense_id)
);

INSERT INTO expense VALUES (1, 'testdescription', NOW(), 'expense1', 50);