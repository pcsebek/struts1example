<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<tiles:importAttribute/>
<html>
    
    <table width="100%" border="0" cellspacing="5px" cellpadding="1px" >
        <tr align="center">
            <td>&nbsp;</td>
            <logic:iterate id="item" name="items" type="org.apache.struts.tiles.beans.MenuItem" indexId="i">
                <td width="20%"><a href='<c:out value="${pageContext.request.contextPath}"/><c:out value="${item.link}"/>'><c:out value="${item.value}"/></a></td>
            </logic:iterate>
            <td>&nbsp;</td>
        </tr>
    </table>
</html>