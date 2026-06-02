package com.wipro.ddvs.entity;

public class VerificationLog {
		private String logId;
		private String documentId;
		private String officerId;
		private String date;
		private String notes;
		
		
		public VerificationLog(String logId,String documentId,String officerId,String date,String notes) {
			this.logId=logId;
			this.documentId=documentId;
			this.officerId=officerId;
			this.date=date;
			this.notes=notes;
		}
		
		public String getLogId() {
			return logId;
		}
		public void setLogId(String logId) {
			this.logId = logId;
		}
		public String getDocumentId() {
			return documentId;
		}
		public void setDocumentId(String documentId) {
			this.documentId = documentId;
		}
		public String getOfficerId() {
			return officerId;
		}
		public void setOfficerId(String officerId) {
			this.officerId = officerId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
}
