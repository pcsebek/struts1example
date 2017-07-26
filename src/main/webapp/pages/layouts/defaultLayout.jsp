<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<html>
    <tiles:useAttribute id="screenTitle" name="title"/>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${screenTitle}"/></title>        
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/stylesheet/stylesheet.css" type="text/css"/>
        
        <title><bean:message key="index.title"/></title>
        <html:base/>
    </head>
    <body>
        <table id="defaultLayoutTableZ" border="1" style="width: 100%;" cellspacing="5">
            <tr>
                <td nowrap colspan="2" align="center">
                    <tiles:insert attribute="header"/>
                </td>
            </tr>
            <tr>
                <td>
                    <tiles:insert name="menu" ignore="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <tiles:insert attribute="errors"/>
                </td>
            </tr>
            <tr>
                <td nowrap width="80%" valign="top" align="left">
                    <tiles:insert attribute="body-content">
                        <tiles:put name="title"><c:out value='${screenTitle}'/></tiles:put>
                    </tiles:insert>
                </td>
            </tr>
            <tr>
                <td nowrap colspan="2" align="center">
                    <tiles:insert attribute="footer"/>
                </td>
            </tr>
        </table>
    </body>
</html>