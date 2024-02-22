-- data.sql
INSERT INTO AUTHOR_MODEL (ID, CREATE_DATE, LAST_UPDATE_TIME, NAME) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'firstAuthor');

insert into TAG_MODEL (id, NAME ) VALUES (1,'firstTagModel');

insert into NEWS_MODEL (id, CONTENT, CREATE_DATE , LAST_UPDATE_TIME , TITLE , AUTHOR_ID) VALUES (1, 'firstNewsModel', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ,'firstTitle',1);

insert into NEWS_TAG (TAG_ID, NEWS_ID ) VALUES (1, 1);

insert into COMMENT_MODEL (id, CONTENT, CREATED , MODIFIED , NEWS_ID) VALUES (1, 'firstCommentModel', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP , 1);
