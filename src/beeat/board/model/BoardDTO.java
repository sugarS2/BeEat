package beeat.board.model;

import java.sql.Date;

public class BoardDTO {
   private int b_code;
   private String b_title;
   private int c_code;
   private String b_content;
   private String b_img1;
   private String b_img2;
   private String b_img3;
   private Date b_date;
   private int b_readnum;
   private String email;
   private String c_name;
   private String name;
   
   public BoardDTO(){
   }

   public BoardDTO(int b_code, String b_title, int c_code, String b_content, String b_img1,
         String b_img2, String b_img3, Date b_date, int b_readnum, String email) {
      super();
      this.b_code = b_code;
      this.b_title = b_title;
      this.c_code = c_code;
      this.b_content = b_content;
      this.b_img1 = b_img1;
      this.b_img2 = b_img2;
      this.b_img3 = b_img3;
      this.b_date = b_date;
      this.b_readnum = b_readnum;
      this.email = email;
   }

   public BoardDTO(int b_code, String b_title, int c_code, String b_content, String b_img1,
         String b_img2, String b_img3, Date b_date, int b_readnum, String email, String c_name) {
      super();
      this.b_code = b_code;
      this.b_title = b_title;
      this.c_code = c_code;
      this.b_content = b_content;
      this.b_img1 = b_img1;
      this.b_img2 = b_img2;
      this.b_img3 = b_img3;
      this.b_date = b_date;
      this.b_readnum = b_readnum;
      this.email = email;
      this.c_name = c_name;
   }
   
   public BoardDTO(int b_code, String b_title, int c_code, String b_content, String b_img1,
         String b_img2, String b_img3, Date b_date, int b_readnum, String email, String c_name, String name) {
      super();
      this.b_code = b_code;
      this.b_title = b_title;
      this.c_code = c_code;
      this.b_content = b_content;
      this.b_img1 = b_img1;
      this.b_img2 = b_img2;
      this.b_img3 = b_img3;
      this.b_date = b_date;
      this.b_readnum = b_readnum;
      this.email = email;
      this.c_name = c_name;
      this.name = name;
   }
   
   public int getB_code() {
      return b_code;
   }

   public void setB_code(int b_code) {
      this.b_code = b_code;
   }

   public String getB_title() {
      return b_title;
   }

   public void setB_title(String b_title) {
      this.b_title = b_title;
   }

   public int getC_code() {
      return c_code;
   }

   public void setC_code(int c_code) {
      this.c_code = c_code;
   }

   public String getB_content() {
      return b_content;
   }

   public void setB_content(String b_content) {
      this.b_content = b_content;
   }

   public String getB_img1() {
      return b_img1;
   }

   public void setB_img1(String b_img1) {
      this.b_img1 = b_img1;
   }

   public String getB_img2() {
      return b_img2;
   }

   public void setB_img2(String b_img2) {
      this.b_img2 = b_img2;
   }

   public String getB_img3() {
      return b_img3;
   }

   public void setB_img3(String b_img3) {
      this.b_img3 = b_img3;
   }

   public Date getB_date() {
      return b_date;
   }

   public void setB_date(Date b_date) {
      this.b_date = b_date;
   }

   public int getB_readnum() {
      return b_readnum;
   }

   public void setB_readnum(int b_readnum) {
      this.b_readnum = b_readnum;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   
   public String getC_name() {
      return c_name;
   }
   
   public void setC_name(String c_name) {
      this.c_name = c_name;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
}