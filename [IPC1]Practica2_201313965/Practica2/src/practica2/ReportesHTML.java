package practica2;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportesHTML {

    public ReportesHTML(String pasos, String tiempo, String algoritmo, String velocidad,
            String orden, float mayor, float menor, String mayor1, String menor1,
            String[][] datos_desordenados, float[] y, String[] x) {

        try {

            String ruta = "Reporte.html";
            PrintWriter writer = new PrintWriter(ruta);

            writer.print("<html>");

            writer.print("<head>");
            writer.print("<title> Practica2</title>");
            writer.print("<link rel=stylesheet type=text/css href=Estilos.css >");
            writer.print("</head>");

            writer.print("<body background=\"fondo.jpg\">");

            writer.print("<h1 align= \"center\"><marquee >Luis Fernando Gonzalez Real 201313965</marquee></h1>");

            /*writer.print("<marquee align= right direction=\"down\" width=\"250\" height=\"200\" behavior=\"alternate\" style=\"border:solid\">\n"
                    + "  <marquee behavior=\"alternate\">\n"
                    + "    IPC1.\n"
                    + "  </marquee>\n"
                    + "</marquee>");*/

            writer.print("<p class=pA>Algoritmo: ");
            writer.print(algoritmo);
            writer.print("</p>");

            writer.print("<p class=pV>Velocidad: ");
            writer.print(velocidad);
            writer.print("</p>");

            writer.print("<p class=pO>Orden: ");
            writer.println(orden);
            writer.print("</p>");

            writer.print("<p class=pT>Tiempo: ");
            writer.print(tiempo);
            writer.print("</p>");

            writer.print("<p class=pP>Pasos: ");
            writer.print(pasos);
            writer.print("</p>");

            writer.print("<table class=tmayor border=\"1\">"
                    + "<tr>"
                    + "<td align=center colspan=\"2\">Dato Mayor</td>"
                    + "</tr>");

            writer.print("<tr>");
            writer.print("<td>");
            writer.print(mayor1);
            writer.print("</td>");
            writer.print("<td>");
            writer.print(mayor);
            writer.print("</td>");
            writer.print("</tr>");

            writer.print("</table>");

            writer.print("<br>");

            writer.print("<table class=tmenor border=\"1\">"
                    + "<tr>"
                    + "<td align= center colspan =\"2\">Dato Menor</td>"
                    + "</tr>");

            writer.print("<tr>");
            writer.print("<td>");
            writer.print(menor1);
            writer.print("</td>");
            writer.print("<td>");
            writer.print(menor);
            writer.print("</td>");
            writer.print("</tr>");

            writer.print("</table>");

            writer.print("<br>");

            writer.print("<h1 align=\"center\">Datos Desordenados</h1>");

            writer.print("<table class=desordenado border=\"1\">");
            writer.print("<tr>");
            for (int i = 0; i < datos_desordenados.length; i++) {

                writer.print("<td>");
                writer.print(datos_desordenados[i][0]);
                writer.print("</td>");

            }
            writer.print("</tr>");

            writer.print("<tr>");
            for (int i = 0; i < datos_desordenados.length; i++) {

                writer.print("<td>");
                writer.print(datos_desordenados[i][1]);
                writer.print("</td>");

            }
            writer.print("</tr>");
            writer.print("</table>");

            writer.print("<p align=center>");
            writer.print("<img align=center alt=\"Grafica Desordenada\" src=\"gd.jpg\"  />");
            writer.print("</p>");

            writer.print("<br>");

            writer.print("<h1 align=\"center\">Datos Ordenados</h1>");

            writer.print("<table class=ordenado border=\"1\">");
            writer.print("<tr>");
            for (int i = 0; i < x.length; i++) {

                writer.print("<td>");
                writer.print(x[i]);
                writer.print("</td>");

            }
            writer.print("</tr>");

            writer.print("<tr>");
            for (int i = 0; i < y.length; i++) {

                writer.print("<td>");
                writer.print(y[i]);
                writer.print("</td>");

            }
            writer.print("</tr>");
            writer.print("</table>");

            writer.print("<br>");

            writer.print("<p align=center>");
            writer.print("<img align=center  alt=\"Grafica Ordenada\" src=\"go.jpg\"  />");
            writer.print("</p>");

            writer.print("</body>");
            writer.print("</html>");

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
