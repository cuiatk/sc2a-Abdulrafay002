/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Filter consists of methods that filter a list of tweets for those matching a
 * condition.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Filter {

    /**
     * Find tweets written by a particular user.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param username
     *            Twitter username, required to be a valid Twitter username as
     *            defined by Tweet.getAuthor()'s spec.
     * @return all and only the tweets in the list whose author is username,
     *         in the same order as in the input list.
     */
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
   List <Tweet> authors =new LinkedList<Tweet>();
     for (int i=0;i<tweets.size();i++) {
    	 String author = tweets.get(i).getAuthor();
         if (author == username) {
        	 authors.add(tweets.get(i));
         }
    	//  throw new RuntimeException("not implemented");
    }
	return authors;
    }
    /**
     * Find tweets that were sent during a particular timespan.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param timespan
     *            timespan
     * @return all and only the tweets in the list that were sent during the timespan,
     *         in the same order as in the input list.
     */
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
      List<Tweet> Time = new LinkedList<Tweet>();
      for (int j = 0; j<tweets.size();j++) {
    	  Instant getTime = tweets.get(j).getTimestamp();
    	  Instant getStart = timespan.getStart();
    	  Instant getEnd = timespan.getEnd();
    	  if (getTime.compareTo(getStart)>0 && getTime.compareTo(getEnd)<=0) {
    		  Time.add(tweets.get(j));
    	  }
      }
    	//  throw new RuntimeException("not implemented");
	return Time;
    }

    /**
     * Find tweets that contain certain words.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param words
     *            a list of words to search for in the tweets. 
     *            A word is a nonempty sequence of nonspace characters.
     * @return all and only the tweets in the list such that the tweet text (when 
     *         represented as a sequence of nonempty words bounded by space characters 
     *         and the ends of the string) includes *at least one* of the words 
     *         found in the words list. Word comparison is not case-sensitive,
     *         so "Obama" is the same as "obama".  The returned tweets are in the
     *         same order as in the input list.
     */
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
      List <Tweet> cont = new ArrayList<Tweet>();
      for (int k=0; k<tweets.size(); k++) {
    	  String text = tweets.get(k).getText();
    	  for (int j=0; j< words.size();j++) {
    		  if (text.contains(words.get(j))){
    			  cont.add(tweets.get(k));
    			  break;
    		  }
    		  break;
    	  }
      }
      return cont;
    	
    	//  throw new RuntimeException("not implemented");
    }

}
