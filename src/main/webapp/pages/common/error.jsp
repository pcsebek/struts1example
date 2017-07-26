<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <table>
            <tr>
                <th align="left">Information</th>
            </tr>
            <tr>
                <td>
                    <div id="screen">
                        <div id="content">
                            <logic:messagesPresent>
                                <div class="error" align="left" style="font-color:red;">
                                    <html:messages id="error" >
                                        <bean:write name="error" filter="false" /><br/>
                                    </html:messages>
                                </div>
                            </logic:messagesPresent>
                            <logic:messagesNotPresent>&nbsp;</logic:messagesNotPresent>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <!-- 
        <div id="error_messages">
            <html:errors/>
        </div>
         -->
    </body>
</html>