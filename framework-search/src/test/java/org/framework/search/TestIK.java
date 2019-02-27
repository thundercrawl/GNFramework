package org.framework.search;

import java.io.IOException;

import org.framework.search.AI.WordParticiple;

import com.github.framework.starter.logging.CommonLogger;

import junit.framework.TestCase;

public class TestIK extends TestCase {

	public void testParticipleCN() throws IOException
	{
		CommonLogger.consolePrint("start participle");
		WordParticiple wp = WordParticiple.getInstance();
		wp.dialogNext("你好");
		CommonLogger.consolePrint("finish participle");
	}
}
