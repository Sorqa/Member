package com.test.join;

import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.http.HttpServletRequest;

public class FormProc {
	
	public boolean getForm(HttpServletRequest request) {
		String[] hobbies = request.getParameterValues("hobby");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		int history = Integer.parseInt(request.getParameter("history"));
		int age = Integer.parseInt(request.getParameter("age"));
		String sbirth = request.getParameter("birth");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      java.sql.Date birth = null;
	      try {
	         birth = new java.sql.Date(sdf.parse(sbirth).getTime());
	      }catch(Exception e) {
	         e.printStackTrace();
	      }		
		String intro =  request.getParameter("intro");
		//String uid, String pwd, String gender, String[] hobbies, int history, int age, Date birth,String intro
		MemberVO mem = new MemberVO(uid,pwd,gender,hobbies,history,age,birth,intro);
		UserDAO dao = new UserDAO();
		boolean added = dao.memadd(mem);
		if(added) {
			
		}
		//MemberVO,UserDAO,member 테이블에 저장
		//hobby 테이블 별도 생성
		return false;
	}
}
