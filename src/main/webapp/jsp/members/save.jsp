<%@ page import="com.example.study01.domain.member.MemberRepository" %>
<%@ page import="com.example.study01.domain.member.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // request, response 그냥 사용 가능 (서블릿으로 자동 변환)
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=
    </li>
    <li>username=
    </li>
    <li>age=
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
