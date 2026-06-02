package com.wipro.ddvs.service;
import java.util.ArrayList;
import com.wipro.ddvs.entity.Document;
import com.wipro.ddvs.entity.Officer;
import com.wipro.ddvs.entity.User;
import com.wipro.ddvs.entity.VerificationLog;
import com.wipro.ddvs.util.DocumentNotFoundException;
import com.wipro.ddvs.util.InvalidVerificationException;
import com.wipro.ddvs.util.OfficerNotFoundException;
import com.wipro.ddvs.util.UserNotFoundException;

public class VerificationService {
	ArrayList<User> users;
	ArrayList<Document> documents;
	ArrayList<Officer> officers;
	ArrayList<VerificationLog> logs;
	
	 public VerificationService(ArrayList<User> users,ArrayList<Document> documents,ArrayList<Officer> officers,ArrayList<VerificationLog> logs) {
		 				this.users = users;
		 				this.documents = documents;
		 				this.officers = officers;
		 				this.logs = logs;
	 }
	
	public void addUser(User u) {
		for(User user : users) {
			if(user.getUserId().equals(u.getUserId())) {
				System.out.println("User is already found");
				return;
			}
		}
		users.add(u);
	}
	
	public User findUser(String userId) throws UserNotFoundException{
		for(User u : users) {
			if(u.getUserId().equals(userId)) {
				return u;
			}
		}
		throw new UserNotFoundException("User not found");
	}
	
	public void registerOfficer(Officer o) {
		officers.add(o);
	}
	
	public Officer findOfficer(String officerId) throws OfficerNotFoundException{
		for(Officer off : officers) {
			if(off.getOfficerId().equals(officerId)) {
				return off;
			}
		}
		throw new OfficerNotFoundException("Officer not found ");
	}
	
	public void uploadDocument(Document d) throws UserNotFoundException{
		findUser(d.getUserId());
		d.setStatus("PENDING");
		documents.add(d);
	}
	
	public Document findDocument(String documentId) throws DocumentNotFoundException{
		for(Document docs : documents) {
			if(docs.getDocumentId().equals(documentId)) {
				return docs;
			}
		}
		throw new DocumentNotFoundException("Document Not Found");
	}
	
	 public void assignOfficer(String documentId, String officerId)
	            throws DocumentNotFoundException,
	            OfficerNotFoundException,
	            InvalidVerificationException {

	        Document d = findDocument(documentId);
	        findOfficer(officerId);

	        if (d.getAssignedOfficerId() != null) {
	            throw new InvalidVerificationException("Document already assigned to another officer");
	        }
	        d.setAssignedOfficerId(officerId);
	        d.setStatus("UNDER_REVIEW");
	  }
	 
	 public void updateStatus(String documentId, String newStatus)
	            throws DocumentNotFoundException,
	            InvalidVerificationException {

	        Document d = findDocument(documentId);
	        String currentStatus = d.getStatus();

	        if (currentStatus.equals("VERIFIED") && newStatus.equals("UNDER_REVIEW")) {
	            throw new InvalidVerificationException("Cannot move VERIFIED to UNDER_REVIEW");
	        }

	        if (currentStatus.equals("REJECTED") && newStatus.equals("PENDING")) {
	            throw new InvalidVerificationException("Cannot move REJECTED to PENDING");
	        }
	        d.setStatus(newStatus);
	  }
	 
	 public void addVerificationLog(String logId,String documentId,String officerId,String date,String notes)
            		 throws InvalidVerificationException,DocumentNotFoundException {
		 				findDocument(documentId);
		 					if (notes == null || notes.trim().isEmpty()) {
		 						throw new InvalidVerificationException("Notes cannot be empty");
		 					}
		 					VerificationLog log = new VerificationLog(logId,documentId,officerId,date,notes);
		 					logs.add(log);
	 }
	 
	 public ArrayList<VerificationLog> getLogsForDocument(String documentId) {
	        ArrayList<VerificationLog> result = new ArrayList<>();
	        for (VerificationLog log : logs) {
	            if (log.getDocumentId().equals(documentId)) {
	                result.add(log);
	            }
	        }
	        return result;
	    }
	 
	 public String generateVerificationReport(String documentId) {
	        try {
	            Document d = findDocument(documentId);
	            StringBuilder sb = new StringBuilder();
	            sb.append("      VERIFICATION REPORT     \n\n");
	            sb.append("Document ID: ").append(d.getDocumentId()).append("\n");
	            sb.append("File Name: ").append(d.getFileName()).append("\n");
	            sb.append("Document Type: ").append(d.getDocType()).append("\n");
	            sb.append("Uploaded By: ").append(d.getUserId()).append("\n");
	            sb.append("Assigned Officer: ").append(d.getAssignedOfficerId()).append("\n");
	            sb.append("Current Status: ").append(d.getStatus()).append("\n");
	            sb.append("\n      VERIFICATION LOGS    \n\n");
	            for (VerificationLog log : logs) {
	                if (log.getDocumentId().equals(documentId)) {
	                    sb.append("Log ID: ").append(log.getLogId()).append("\n");
	                    sb.append("Officer ID: ").append(log.getOfficerId()).append("\n");
	                    sb.append("Date: ").append(log.getDate()).append("\n");
	                    sb.append("Notes: ").append(log.getNotes()).append("\n\n");
	                }
	            }
	            return sb.toString();
	            
	        } 
	        catch (Exception e) {
	            return e.getMessage();
	        }
	    }  
}