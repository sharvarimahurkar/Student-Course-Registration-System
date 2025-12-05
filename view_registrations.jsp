<h2>Registrations</h2>

<table border="1">
<tr>
    <th>Reg ID</th>
    <th>Student Name</th>
    <th>Course Name</th>
</tr>
<%
    ResultSet rs = (ResultSet) request.getAttribute("data");
    while(rs.next()) {
%>
<tr>
    <td><%= rs.getInt(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3) %></td>
</tr>
<% } %>
</table>
