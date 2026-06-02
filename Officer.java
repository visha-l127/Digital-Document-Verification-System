package com.wipro.ddvs.entity;

public class Officer {
		private String officerId;
		private String name;
		private String department;
		
		public Officer(String officerId,String name,String department) {
			this.officerId=officerId;
			this.name=name;
			this.department=department;
		}
		
		public String getOfficerId() {
			return officerId;
		}
		
		public void setOfficerId(String officerId) {
			this.officerId=officerId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public String getDeaprtment() {
			return department;
		}
		
		public void setDepartment(String department) {
			this.department=department;
		}
		
}
