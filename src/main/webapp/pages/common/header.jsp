<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<html>
    <head>
        <script type="text/javascript" src="/struts1example/js/jquery-1.8.3.js"></script>
        
        <script type="text/javascript">
            jQuery.noConflict();
            $j = jQuery;
        </script>
    </head>
    <body>
		<table border="0" width="100%">
		    <tr align="center">
		        <th>
		            <font color="green">
		                This is some message in the header to prove the header is displayed
		            </font>
		        </th>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.one"/></td>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.two"/></td>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.three"/></td>
		    </tr>
		</table>
	</body>
</html>