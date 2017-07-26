<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
    <tiles:useAttribute id="screenName" name="title"/>
    <head>
    </head>
    <body>
        <table width="100%">
            <tr align="center">
                <td><b><c:out value="${screenName}"/></b></td>
            </tr>
            <tr align="100%">
                <td>
                </td>
            </tr>           
        </table> 
    </body>
</html>