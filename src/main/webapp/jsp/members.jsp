<%@ page import="com.example.study01.domain.member.MemberRepo" %>
<%@ page import="com.example.study01.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    MemberRepo memberRepository = MemberRepo.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("<tr>");
            out.write("<td>" + member.getId() + "</td>");
            out.write("<td>" + member.getUsername() + "</td>");
            out.write("<td>" + member.getAge() + "</td>");
            out.write("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
