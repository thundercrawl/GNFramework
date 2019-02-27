package org.framework.search.AI;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.framework.search.results.SearchResult;
import org.framework.search.status.CommonStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;


public class WordParticiple {
private static WordParticiple instance;
private static final Logger logger = LoggerFactory.getLogger(WordParticiple.class);
	public static WordParticiple getInstance()
	{
		if(instance == null)
		{
			instance = new WordParticiple();
		}
		
		return instance;
	}
	
	public CommonStatus<SearchResult>  dialogNext(String before) throws IOException
	{
		CommonStatus<SearchResult> st = new CommonStatus<SearchResult>();
		logger.debug("before:"+before);
		
		String text = "";
		// 创建分词对象
		Analyzer anal = new IKAnalyzer(true);
		StringReader reader = new StringReader(before);
		// 分词
		final TokenStream ts = anal.tokenStream("", reader);
		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
		// 遍历分词数据
		while (ts.incrementToken()) {
			text += term.toString() + "|";
		}
		reader.close();
		logger.debug("after:"+text);

		return st;
	}
}
