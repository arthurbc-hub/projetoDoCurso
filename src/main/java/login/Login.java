package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("users");
        String senha = request.getParameter("passw");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if("admin".equals(usuario)){
        response.sendRedirect("Pagina1.html");
        //out.println("<h2>login realizado</h2>");
            
        }else{
            out.println("<h2>Usuario ou senha incorretos</h2>");
        }

}
}