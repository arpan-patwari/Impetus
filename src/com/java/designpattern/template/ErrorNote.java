package com.java.designpattern.template;

public class ErrorNote extends NoteTemplate
{

	@Override
	public void setUpNote()
	{
		super.message = "error";
	}

	public void addErrorTag()
	{
		super.message = new StringBuilder(super.message).append(" with error number 400").toString();
	}

}
