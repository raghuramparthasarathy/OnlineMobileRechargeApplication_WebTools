package com.neu.edu.pojo;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

public class PdfReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> arg0, Document doc, PdfWriter arg2, HttpServletRequest request,
			HttpServletResponse arg4) throws Exception {
		// TODO Auto-generated method stub

		TransactionDetails td = (TransactionDetails) request.getSession().getAttribute("tc");
		RechargeDetails rd = (RechargeDetails) request.getSession().getAttribute("rc");
		
		Paragraph paragraph1 = new Paragraph();
	     paragraph1.add("Invoice Details");
	     paragraph1.setAlignment(Element.ALIGN_CENTER);
	     doc.add(paragraph1);
	     doc.add(Chunk.NEWLINE);
	     doc.add(new LineSeparator());
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	     Paragraph paragraph2 = new Paragraph();
	     paragraph2.add("Recharge ID: " + rd.getRechargeID());
	     paragraph2.setAlignment(Element.ALIGN_LEFT);
	     doc.add(paragraph2);
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	     Paragraph paragraph3 = new Paragraph();
	     paragraph3.add("Message : " + td.getMessage());
	     paragraph3.setAlignment(Element.ALIGN_LEFT);
	     doc.add(paragraph3);
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	     Paragraph paragraph4 = new Paragraph();
	     paragraph4.add("Card Type : " + td.getCard());
	     paragraph4.setAlignment(Element.ALIGN_LEFT);
	     doc.add(paragraph4);
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	     Paragraph paragraph5 = new Paragraph();
	     paragraph5.add("Card Number : " + td.getCardNumber());
	     paragraph5.setAlignment(Element.ALIGN_LEFT);
	     doc.add(paragraph5);
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	      doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	      Paragraph paragraph6 = new Paragraph();
	      paragraph6.add("Thank you for choosing Easy Recharge");
	     paragraph6.setAlignment(Element.ALIGN_JUSTIFIED);
	     doc.add(paragraph6);
	     doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	      doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
	     doc.add(new LineSeparator());
	     
	     doc.close();
		
	}

}
