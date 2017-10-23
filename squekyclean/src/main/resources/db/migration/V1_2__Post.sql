CREATE TABLE Post
( id bigserial
, author varchar(60)
, content varchar(1024)
, datePosted timestamp
, threadId bigint
);

ALTER TABLE Post
 ADD CONSTRAINT POST_PKEY PRIMARY KEY
  ( id
  )
;

ALTER TABLE Post
 ADD CONSTRAINT THREAD_FK FOREIGN KEY
  (
  threadId
  ) REFERENCES Thread MATCH FULL
;