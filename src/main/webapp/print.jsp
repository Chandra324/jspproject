<%@page import="java.sql.Statement"%>
<%@page import="mavengrocery.Register"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mavengrocery.StudentDAO"%>

<jsp:useBean class="mavengrocery.Student" id="stu" scope="session"></jsp:useBean>
<jsp:useBean class="mavengrocery.Student" id="stu1" scope="session"></jsp:useBean>
<h1>User Details</h1>
Name:<jsp:getProperty property="name" name="stu"></jsp:getProperty><br>
possword:<jsp:getProperty property="possword" name="stu"></jsp:getProperty>

item:<jsp:getProperty property="item" name="stu"></jsp:getProperty>
<br>
quantity:<jsp:getProperty property="quantity" name="stu"></jsp:getProperty><br><br><br>


<table border="1">
    <tr>
        <th>Item</th>
        <th>Quantity</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
        <c:forEach var="student">
    
    <tr>
        <td><c:out value="${stu.item}"/></td>
                <td><jsp:getProperty property="item" name="stu" /></td>
        
        <td><jsp:getProperty property="quantity" name="stu" /></td>
        <td><a href="edit.jsp"?item=>Edit</a></td>
        <td><a href="delete.jsp"?item=>Delete</a></td>
    </tr>
     <tr>
        <td><c:out value="${stu.item}"/></td>
        <td><jsp:getProperty property="quantity" name="stu" /></td>
        <td><a href="edit.jsp"?item=>Edit</a></td>
        <td><a href="delete.jsp"?item=>Delete</a></td>
    </tr>
        </c:forEach>  
</table>
</body>
</html>


<% StudentDAO ob= new StudentDAO();
int r=ob.saveRecord(stu);

if(r>0){
	out.print("<h3>Record are save in db</h3>");
}
else{
	out.print("<h3>Rescords are not save</h3>");
}
%>


<%--Edit  --%>
<% 
    StudentDAO rg = new StudentDAO();
    String item = request.getParameter("item");
    String quantity = request.getParameter("quantity");
    
    stu1.setItem(item);
    stu1.setQuantity(quantity);

    boolean success = rg.editRecord(stu1);
    
    if (success) {
        out.print("Item details have been saved in the database.");
    } else {
        out.print("Item details could not be saved.");
    }
%>

