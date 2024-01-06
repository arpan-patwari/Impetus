package com.java.designpattern.template;

public class SuccesNote extends NoteTemplate
{

	@Override
	public void setUpNote()
	{
		super.message = "success";
	}

	public void addSuccessTag()
	{
		super.message = new StringBuilder(super.message).append(" with 200").toString();
	}

}
