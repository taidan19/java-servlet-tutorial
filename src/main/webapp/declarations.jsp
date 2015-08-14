<html>
    <body>
        <%! String str = "Test String";%>
        <%!
            String getStr() {
                return str;
            }
        %>
        <p>Let's call <code>getStr -</code> <%= getStr() %></p>
    </body>
</html>
