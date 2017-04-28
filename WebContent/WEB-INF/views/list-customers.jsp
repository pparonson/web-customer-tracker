<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Customers</title>
</head>
<body>
  <div>
    <div>
      <h2>CRM - Customer Relationship Manager</h2>
    </div>
  </div>
  
  <div>
    <div>
      <table>
        <thead>
          <tr>
            <th><label>First Name</label></th>
            <th><label>Last Name</label></th>
            <th><label>Email</label></th>
           </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${ customers }">
            <tr>
              <td>${ item.firstName }</td>
              <td>${ item.lastName }</td>
              <td>${ item.email }</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>