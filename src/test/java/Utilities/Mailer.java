package Utilities;


//Java program to send email 
//with attachments 

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*;    
public class Mailer{  
    public static void send(final String from,final String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {
              // Create a default MimeMessage object.
              Message message = new MimeMessage(session);

              // Set From: header field of the header.
              message.setFrom(new InternetAddress(from));

              // Set To: header field of the header.
              message.setRecipients(Message.RecipientType.TO,
                 InternetAddress.parse(to));

              // Set Subject: header field
              message.setSubject(sub);

              // Create the message part
              BodyPart messageBodyPart = new MimeBodyPart();

              // Now set the actual message
              messageBodyPart.setText(msg);

              // Create a multipar message
              Multipart multipart = new MimeMultipart();

              // Set text message part
              multipart.addBodyPart(messageBodyPart);

              // Part two is attachment
              messageBodyPart = new MimeBodyPart();
              String filename = "C:\\Users\\Rajat.Gupta2\\Desktop\\tresting\\rajat.jpg";
              DataSource source = new FileDataSource(filename);
              messageBodyPart.setDataHandler(new DataHandler(source));
              messageBodyPart.setFileName(filename);
              multipart.addBodyPart(messageBodyPart);

              // Send the complete message parts
              message.setContent(multipart);
              message.setContent(Constant.link, "text/html");
              

              // Send message
              Transport.send(message);

              System.out.println("Sent message successfully....");
       
           } catch (MessagingException e) {
              throw new RuntimeException(e);
           }
        }
     }