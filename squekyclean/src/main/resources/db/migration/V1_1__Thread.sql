CREATE TABLE Thread
( id bigserial
, threadName varchar(60)
, topicarn varchar(100)
);

ALTER TABLE Thread
 ADD CONSTRAINT THREAD_PKEY PRIMARY KEY
  ( id
  )
;