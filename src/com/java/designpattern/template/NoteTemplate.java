package com.java.designpattern.template;

public abstract class NoteTemplate
{

	public String message;

	public abstract void setUpNote();

	public void sendSignal()
	{
		System.out.println("Send Signals to backend :---\n " + this.message);
	}

}
