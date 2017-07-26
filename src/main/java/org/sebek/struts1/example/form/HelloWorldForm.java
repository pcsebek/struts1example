package org.sebek.struts1.example.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class HelloWorldForm extends ActionForm {

		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
