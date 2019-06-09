ALTER TABLE BOARD DROP CONSTRAINT FK_CATEGORY_TO_BOARD CASCADE;
ALTER TABLE BOARD DROP CONSTRAINT FK_MEMBER_TO_BOARD CASCADE;


ALTER TABLE HOTPLACE DROP CONSTRAINT FK_LOC_TO_HOTPLACE CASCADE;
ALTER TABLE HOTPLACE DROP CONSTRAINT FK_CATEGORY_TO_HOTPLACE CASCADE;
ALTER TABLE HOTPLACE DROP CONSTRAINT FK_MEMBER_TO_HOTPLACE CASCADE;


ALTER TABLE H_REPLY DROP CONSTRAINT FK_HOTPLACE_TO_H_REPLY CASCADE;
ALTER TABLE H_REPLY DROP CONSTRAINT FK_MEMBER_TO_H_REPLY CASCADE;


ALTER TABLE B_REPLY DROP CONSTRAINT FK_BOARD_TO_B_REPLY CASCADE;
ALTER TABLE B_REPLY DROP CONSTRAINT FK_MEMBER_TO_B_REPLY CASCADE;


ALTER TABLE MEMBER DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE BOARD DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE HOTPLACE DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE H_REPLY DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE CATEGORY DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE LOC DROP PRIMARY KEY CASCADE KEEP INDEX;
ALTER TABLE B_REPLY DROP PRIMARY KEY CASCADE KEEP INDEX;



DROP TABLE MEMBER CASCADE CONSTRAINTS;/* 회원 */
DROP TABLE BOARD CASCADE CONSTRAINTS;/* 게시판 */
DROP TABLE HOTPLACE CASCADE CONSTRAINTS;/* 맛집 */
DROP TABLE H_REPLY CASCADE CONSTRAINTS;/* 맛집 댓글 */
DROP TABLE CATEGORY CASCADE CONSTRAINTS;/* 업종 */
DROP TABLE LOC CASCADE CONSTRAINTS;/* 지역 */
DROP TABLE CATEGORY CASCADE CONSTRAINTS; /*업종*/
DROP TABLE B_REPLY CASCADE CONSTRAINTS;/* 게시판 댓글 */

DROP SEQUENCE HOTPLACE_SEQ;
DROP SEQUENCE HREPLY_SEQ;
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE B_REPLY_SEQ;

PURGE RECYCLEBIN;