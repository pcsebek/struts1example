<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">


<%@ include file="/pages/include/tagLibraryInclude.jsp" %>
<html>
    <tiles:useAttribute id="screenName" name="title"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            $j(document).ready(function() {
            	
            	   enableDisableButtons("0");
            	   $j('#selectedEmployee').change(function () {retrieveSelectedEmployee();});
            	
               loadEmployeeList();
               
            });
            
            function loadEmployeeList() {
            	   $j.ajax({
            		   type: "GET",
            		   url: $j('#contextPath').val() + "/do/ajax/getEmployeeList",
            		   cache: "false",
            		   success: function(response) {
            			   $j('#selectedEmployee').append('<option value="0">Select one to edit or leave blank to add</option>').append(response);
            		   }
            	   });
            };
            
            function retrieveSelectedEmployee() {
            	   var value = $j("#selectedEmployee").val();
               $j('#employeeId').val(value);
               enableDisableButtons(value);
            }
            
            function enableDisableButtons(value) {            	
            	   $j('#displayButton').prop('disabled',(value === "0"));
            	   $j('#addButton').prop('disabled',(value !== "0"));
            }
            
        </script>
        <title><c:out value="${screenName}"/></title>
    </head>
    <body>
        <html:form action="/employee.do">
            <html:hidden styleId="employeeId" property="employeeId"/>
            <input type="hidden" id="contextPath" value='<c:out value="${pageContext.request.contextPath}"/>'/>
            
		    <table>
                <tr align="left">
                    <td>Select Employee (optional):</td>
                    <td>
                        <html:select  styleId="selectedEmployee" property="selectedId" tabindex="1">
                        </html:select>
                    </td> 
                <tr align="left">
                    <td><html:submit styleId="displayButton" styleClass="button"  property="method" value="display" >Display</html:submit></td>
		            <td><html:submit styleId="addButton" styleClass="button" property="method" value="add">Add</html:submit></td>
		        </tr>
		    </table>
		</html:form>
    </body>
</html>
