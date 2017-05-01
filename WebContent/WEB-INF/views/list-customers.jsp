<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />

  <title>List Customers</title>
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
    </div>
  </div>
  
  <div id="container">
    <div id="content">
      <!-- Button: add customer with method call for spring controller mapping -->
      <button type="button" onclick="window.location.href='showCustomerCreateForm'; return false;"
        class="add-button">
          Add customer
      </button>
      
      <table>
        <thead>
          <tr>
            <th><label>First Name</label></th>
            <th><label>Last Name</label></th>
            <th><label>Email</label></th>
            <th><label>Action</label>
           </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${ customers }">
            <!-- Create an update link with embedded customer id -->
            <c:url var="updateLink" value="/customer/showCustomerEditForm">
              <c:param name="customerId" value="${ item.id }"></c:param>
            </c:url>
            
            <!-- Create a delete link with embedded customer id -->
            <c:url var="deleteLink" value="/customer/deleteCustomer">
              <c:param name="customerId" value="${ item.id }"></c:param>
            </c:url>
            
            <tr>
              <td>${ item.firstName }</td>
              <td>${ item.lastName }</td>
              <td>${ item.email }</td>
              <td>
                <span>
                  <a href="${ updateLink }">
                    Edit
                  </a>
                </span>
                <span>|</span>
                <span>
                <a href="${ deleteLink }" onclick="if (!(confirm('Confirm delete customer?'))) return false ">
                    Delete
                  </a>
                </span>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>