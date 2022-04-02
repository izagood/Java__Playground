package com.zagood.inflearnthejavatest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback{

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
//		context.getStore(ExtensionContext.Namespace.create(null));
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
