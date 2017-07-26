<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">


<%@ include file="/pages/include/tagLibraryInclude.jsp" %>
<html>
    <tiles:useAttribute id="screenName" name="title"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            $j(document).ready(function() {
            });
            
            
            function loadJobList() {
            	   $j.ajax({
            		   type: "SUBMIT",
            		   url: $j('#contextPath').val() + "/do/ajax/getJobList",
            		   cache: "false",
            		   success: function(response) {
            			   $j('#jobList').append('<option value="0">Select Job</option>').append(response);
            			   alert($j('#currentJobId').val());
            			   if ($j('#currentJobId').val() !== undefined && $j('#currentJobId').val() !== "") {
            				   $j('#jobList option[value=' + $j('currentJobId').val() +']').attr('selected','selected');
            			   }
            		   }
            	   });
            }
            
            
        </script>
        <title><c:out value="${screenName}"/></title>
    </head>
    <body>
        <br/>
        <html:form action="/employeeUpdate.do">
            <html:hidden styleId="employeeId" property="employeeId"/>
            <html:hidden property="priorJobId"/>
            <input type="hidden" id="contextPath" value='<c:out value="${pageContext.request.contextPath}"/>'/>
            
		    <table>
		        <tr align="left">
		            <td>First Name: </td>
		            <td><html:text tabindex="1" property="firstName"/></td>
		        </tr>
                <tr align="left">
		            <td>Last Name: </td>
		            <td><html:text tabindex="2" property="lastName"/></td>
		        </tr>
                <tr align="left">
		            <td>Current Salary: </td>
		            <td>$<html:text tabindex="3" property="salary"/></td>
		        </tr>
                <tr align="left">
		            <td>Current Job: </td>
		            <td>
		                <html:select tabindex="4" styleId="jobList" property="currentJobId">
                            <html:option value="0">Select Job</html:option>
                            <html:optionsCollection name="employeeForm" property="jobList" label="description" value="id" />
		                </html:select>
		            </td>
		        </tr>
                <tr align="left">
		            <td></td>
		        </tr>
                <tr align="left">
		            <td>Previous Jobs:</td>
		            <td>
		                <c:forEach items="${employeeForm.previousJobs}" var="oldJob">
		                    <c:out value="${oldJob.description}"/><br/>
		                </c:forEach>
		            </td>
		        </tr>
                <tr align="left">
                    <td><html:submit property="method" styleClass="button" value="save">Save</html:submit></td>
                    <td><html:submit property="method" styleClass="button" value="saveAndAdd">Save and Add</html:submit></td>
                    <td><html:submit property="method" styleClass="button" value="delete">Delete</html:submit></td>
		        </tr>
		    </table>
		</html:form>
    </body>
</html>
