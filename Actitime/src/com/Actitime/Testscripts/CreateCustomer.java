package com.Actitime.Testscripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.ObjectiveRepository.Homepage;
import com.Actitime.ObjectiveRepository.Taskpage;

@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void createCustomer() throws IOException, InterruptedException {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		Taskpage tp=new Taskpage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcustbtn().click();
		FileLibrary fl=new FileLibrary();
		String name=fl.ReadDataFromExelFile("Automation", 2,1);
		tp.getCustname().sendKeys(name);
		String discr=fl.ReadDataFromExelFile("Automation", 2,2);
		tp.getCustdescr().sendKeys(discr);
		tp.getCreatecust().click();
		Thread.sleep(5000);
	}
}
