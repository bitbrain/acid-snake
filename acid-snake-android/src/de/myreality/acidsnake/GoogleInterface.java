package de.myreality.acidsnake;

/**
 * Basic google interface for Google PlayService API
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public interface GoogleInterface {

	public void login();

	public void logout();

	// get if client is signed in to Google+
	public boolean getSignedIn();

	// submit a score to a leaderboard
	public void submitScore(int score);

	// gets the scores and displays them threw googles default widget
	public void getScores();

	// gets the score and gives access to the raw score data
	public void getScoresData();
}
