package com.demo.cus;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailAlert {
	 public static void sendmail(String cmail) {
	final String username = "teammphasis3rll@gmail.com";
    final String password = "@3TeamRll";
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); 
    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("teammphasis3rll@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(cmail)
         //       InternetAddress.parse("darshanakhil1@gmail.com, darshan.nagesh10@gmail.com")
        );
        message.setSubject("Confirmation Mail");
        message.setText("Dear Customer ,"
                + "\n\nYour details is sucessfully inserted!\nThankyou");
        Transport.send(message);
        System.out.println("Done");
    } catch (MessagingException e) {
        e.printStackTrace();
    }


}
	 public static void ordermail(String cmail) {
			final String username = "teammphasis3rll@gmail.com";
		    final String password = "@3TeamRll";
		    Properties prop = new Properties();
		    prop.put("mail.smtp.host", "smtp.gmail.com");
		    prop.put("mail.smtp.port", "587");
		    prop.put("mail.smtp.auth", "true");
		    prop.put("mail.smtp.starttls.enable", "true"); 
		    Session session = Session.getInstance(prop,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		    
		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("teammphasis3rll@gmail.com"));
		        message.setRecipients(
		                Message.RecipientType.TO,
		                InternetAddress.parse(cmail)
		         //       InternetAddress.parse("darshanakhil1@gmail.com, darshan.nagesh10@gmail.com")
		        );
		        message.setSubject("Order Placed");
		        message.setText("Dear Customer ,"
		                + "\n\nYour order is sucessfully placed!\nThankyou");
		        Transport.send(message);
		        System.out.println("Done");
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }


		}	 public static void rejectmail(String cmail) {
			final String username = "teammphasis3rll@gmail.com";
		    final String password = "@3TeamRll";
		    Properties prop = new Properties();
		    prop.put("mail.smtp.host", "smtp.gmail.com");
		    prop.put("mail.smtp.port", "587");
		    prop.put("mail.smtp.auth", "true");
		    prop.put("mail.smtp.starttls.enable", "true"); 
		    Session session = Session.getInstance(prop,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		    
		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("teammphasis3rll@gmail.com"));
		        message.setRecipients(
		                Message.RecipientType.TO,
		                InternetAddress.parse(cmail)
		         //       InternetAddress.parse("darshanakhil1@gmail.com, darshan.nagesh10@gmail.com")
		        );
		        message.setSubject("Order Rejected");
		        message.setText("Dear Customer ,"
		                + "\n\nYour order has been rejected\nThankyou");
		        Transport.send(message);
		        System.out.println("Done");
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }


		}	
		public static void acceptmail(String cmail) {
			final String username = "teammphasis3rll@gmail.com";
		    final String password = "@3TeamRll";
		    Properties prop = new Properties();
		    prop.put("mail.smtp.host", "smtp.gmail.com");
		    prop.put("mail.smtp.port", "587");
		    prop.put("mail.smtp.auth", "true");
		    prop.put("mail.smtp.starttls.enable", "true"); 
		    Session session = Session.getInstance(prop,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		    
		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("teammphasis3rll@gmail.com"));
		        message.setRecipients(
		                Message.RecipientType.TO,
		                InternetAddress.parse(cmail)
		         //       InternetAddress.parse("darshanakhil1@gmail.com, darshan.nagesh10@gmail.com")
		        );
		        message.setSubject("Order Accepted");
		        message.setText("Dear Customer ,"
		                + "\n\nYour order is sucessfully accepted!\nThankyou");
		        Transport.send(message);
		        System.out.println("Done");
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }


		}	 
}
