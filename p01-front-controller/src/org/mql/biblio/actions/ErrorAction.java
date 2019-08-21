package org.mql.biblio.actions;

public class ErrorAction extends AbstractAction {


	public ErrorAction(String actionName) {
		this.setActionName(actionName);
	}

	private String getNotFoundPage() {
		return "Error";
	}

	private String getNotSupportedAction() {
		return "Error";
	}

	@Override
	public String execute() {
		if (this.getActionName().equalsIgnoreCase(NOT_SUPPORTED_ACTION))
			return this.getNotSupportedAction();
		return this.getNotFoundPage();
	}

}
