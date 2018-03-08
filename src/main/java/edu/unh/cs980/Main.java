package edu.unh.cs980;

import java.util.ArrayList;

import edu.unh.cs980.methods.EntityLinking;
import edu.unh.cs980.methods.EntityWord;
import edu.unh.cs980.methods.SpotClient;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setProperty("file.encoding", "UTF-8");

		String testStr = "Jordan is also known for his product endorsements. He fueled the success of Nike's Air Jordan sneakers, which were introduced in 1985 and remain popular today.[7] Jordan also starred in the 1996 film Space Jam as himself. In 2006, he became part-owner and head of basketball operations for the then-Charlotte Bobcats, buying a controlling interest in 2010. In 2015, Jordan became the first billionaire NBA player in history as a result of the increase in value of NBA franchises. He is the third-richest African-American, behind Oprah Winfrey and Robert F. Smith.";
		String jsonStr = SpotClient.getAnootatedJson(testStr);

		ArrayList<EntityWord> list = new ArrayList<EntityWord>();
		list = EntityLinking.getEntityList(jsonStr);
		System.out.println(list);
	}
}
