
package com.spring.helloworld.domain;

public class MemberVO {
   private String userid;
   private String password;
   private String user_name;
   private String user_gender;
   private String user_email;
   private String user_birth;
   private String user_phone;
   private String user_state;
   private String user_photo;
   
   
   public MemberVO() {
      
   }
   
   public MemberVO(String userid, String password, String user_name, String user_gender, String user_email,
         String user_birth, String user_phone, String user_state, String user_photo) {
      super();
      this.userid = userid;
      this.password = password;
      this.user_name = user_name;
      this.user_gender = user_gender;
      this.user_email = user_email;
      this.user_birth = user_birth;
      this.user_phone = user_phone;
      this.user_state = user_state;
      this.user_photo = user_photo;
   }




   public String getUserid() {
      return userid;
   }




   public void setUserid(String userid) {
      this.userid = userid;
   }




   public String getPassword() {
      return password;
   }




   public void setPassword(String password) {
      this.password = password;
   }




   public String getUser_name() {
      return user_name;
   }




   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }




   public String getUser_gender() {
      return user_gender;
   }




   public void setUser_gender(String user_gender) {
      this.user_gender = user_gender;
   }




   public String getUser_email() {
      return user_email;
   }




   public void setUser_email(String user_email) {
      this.user_email = user_email;
   }




   public String getUser_birth() {
      return user_birth;
   }




   public void setUser_birth(String user_birth) {
      this.user_birth = user_birth;
   }




   public String getUser_phone() {
      return user_phone;
   }




   public void setUser_phone(String user_phone) {
      this.user_phone = user_phone;
   }




   public String getUser_state() {
      return user_state;
   }




   public void setUser_state(String user_state) {
      this.user_state = user_state;
   }




   public String getUser_photo() {
      return user_photo;
   }




   public void setUser_photo(String user_photo) {
      this.user_photo = user_photo;
   }




   @Override
   public String toString() {
      String str = "유저 아이디 =" + userid + "\n" +
               "비밀번호 = " + password + "\n" +   
               "유저 이름 = " + user_name + "\n" +
               "유저 성별 = " + user_gender+ "\n" + 
               "유저 이메일 = " + user_email + "\n" + 
               "유저 생일 = " + user_birth + "\n" + 
               "유저 핸드폰번호 = " + user_phone + "\n"+
               "유저 사는곳 = " + user_state + "\n";
      return str;
   }

}
   