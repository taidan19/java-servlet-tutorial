<html>
    <body>
        <%
            int x = 2;
            out.println("<p>We declared a variable named x in a scriptlet. " +
                        "It's value is currently " + x + "</p>");

            x = x + 3;
        %>

        <p>
            We changed the value of x in the scriplet. It's value is now <%= x %>
        </p>

        <%
            for(int i = 0; i < 3; i++) {
        %>
            <p>Repeat this line</p>
        <%
            }
        %>
    </body>
</html>
