import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class PdfServlet
 */
@WebServlet("/PdfServlet")
@MultipartConfig(maxFileSize = 16177215)
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 388110564278942780L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kumaresanlogin", "root",
					"root");
			Statement stmt = conn.createStatement();
			/* Define the SQL query */
			ResultSet set = stmt
					.executeQuery("SELECT * from kumaresanlogin.student");
			Document document = new Document();

			PdfWriter writer = PdfWriter
					.getInstance(
							document,
							new FileOutputStream(
									"C:\\Users\\i00588\\Desktop\\vairavan\\WebContent\\GeneratedResults\\HelloWorld.pdf"));
			document.open();

			PdfPTable firsttable = new PdfPTable(8);
			PdfPCell table_cell;
			// Add table column Names
			firsttable.addCell("NAME");
			firsttable.addCell("AGE");
			firsttable.addCell("ADDRESS");
			firsttable.addCell("PHONE NUMBER");
			firsttable.addCell("EMAIL ID");
			firsttable.addCell("STUDETN NUMBER");
			firsttable.addCell("GENDER");
			firsttable.addCell("IMAGE");

			while (set.next()) {
				String name = set.getString("name");
				table_cell = new PdfPCell(new Phrase(name));
				firsttable.addCell(table_cell);

				String age = set.getString("age");
				table_cell = new PdfPCell(new Phrase(age));
				firsttable.addCell(table_cell);

				String address = set.getString("address");
				table_cell = new PdfPCell(new Phrase(address));
				firsttable.addCell(table_cell);

				String phone_no = set.getString("phone number");
				table_cell = new PdfPCell(new Phrase(phone_no));
				firsttable.addCell(table_cell);

				String emailId = set.getString("emailId");
				table_cell = new PdfPCell(new Phrase(emailId));
				firsttable.addCell(table_cell);

				String student_no = set.getString("student no");
				table_cell = new PdfPCell(new Phrase(student_no));
				firsttable.addCell(table_cell);

				String gender = set.getString("gender");
				table_cell = new PdfPCell(new Phrase(gender));
				firsttable.addCell(table_cell);
				
				// adding image to pdf
				java.sql.Blob blob = set.getBlob("image");
				InputStream in = blob.getBinaryStream();
				BufferedImage image = ImageIO.read(in);

				java.awt.Image awtImage = image;
				com.lowagie.text.Image img1 = com.lowagie.text.Image
						.getInstance(awtImage, null);

				Image image1 = Image.getInstance(img1);// extra line just for verification
				image1.scaleAbsolute(50, 50);
				firsttable.addCell(image1);
				//document.add(image1);

			}

			document.add(firsttable);

			document.add(new Paragraph(new Date().toString()));
			PrintWriter our = response.getWriter();
			if ((new File(
					"C:\\Users\\i00588\\Desktop\\vairavan\\WebContent\\GeneratedResults\\HelloWorld.pdf"))
					.exists()) {

				Process p = Runtime
						.getRuntime()
						.exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\i00588\\Desktop\\vairavan\\WebContent\\GeneratedResults\\HelloWorld.pdf");

				p.waitFor();
				our.println("pdf File genertated");
				request.getRequestDispatcher("student.jsp").include(request,
						response);
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0);
				

			} else {

				// System.out.println("File is not exists");
				our.println("File is not exists");
				request.getRequestDispatcher("student.jsp").include(request,
						response);
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0);
				

			}

			document.close();
			writer.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PDF GENERATOR</title>
<link href="login.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor=#6B8E23>
	<form name="myForm1" method="post" action="PdfServlet" >
		<center>
			<div class="clearfix">
				<button type="submit">Pdf</button>
			</div>
		</center>
		<p><h3>This PDF page and Pdf button one and only for generationg pdf file.</h3></p>
		<p><b><u>copy rights </u></b></p>
		<p><b>www.kumaresanramu.in</b></p>
		
	</form>
</body>
</html>