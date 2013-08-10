package de.myreality.acidsnake;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;

public class MainActivity extends AndroidApplication implements
		GameHelperListener, de.myreality.acidsnake.google.GoogleInterface {

	private GameHelper aHelper;

	private OnLeaderboardScoresLoadedListener theLeaderboardListener;

	public MainActivity() {
		aHelper = new GameHelper(this);
		aHelper.enableDebugLog(true, "MYTAG");

		// create a listener for getting raw data back from leaderboard
		theLeaderboardListener = new OnLeaderboardScoresLoadedListener() {

			@Override
			public void onLeaderboardScoresLoaded(int statusCode,
					LeaderboardBuffer leaderboard, LeaderboardScoreBuffer scores) {
				System.out.println("In call back");

				for (int i = 0; i < scores.getCount(); i++) {
					System.out.println(scores.get(i)
							.getScoreHolderDisplayName()
							+ " : "
							+ scores.get(i).getDisplayScore());
				}
			}
		};
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = true;
		aHelper.setup(this);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		initialize(new SnakeGame(this), cfg);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	@Override
	public void login() {
		try {
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					aHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (final Exception ex) {

		}
	}

	@Override
	public void logout() {
		try {
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					aHelper.signOut();
				}
			});
		} catch (final Exception ex) {

		}
	}

	@Override
	public boolean getSignedIn() {
		return aHelper.isSignedIn();
	}

	@Override
	public void submitScore(int score) {
		if (aHelper.getGamesClient().isConnected()) {
			System.out.println("in submit score");
			aHelper.getGamesClient().submitScore(getString(R.string.leaderBoardID), score);
		}
	}
	
	@Override
	public void submitArchivement(String id) {
		if (aHelper.getGamesClient().isConnected()) {
			GamesClient client = aHelper.getGamesClient();
			client.unlockAchievement(id);
		}
		//startActivityForResult(client.getAchievementsIntent(), REQUEST_ACHIEVEMENTS);
	}

	@Override
	public void getScores() {
		startActivityForResult(
				aHelper.getGamesClient().getLeaderboardIntent(
						getString(R.string.leaderBoardID)), 105);
	}

	@Override
	public void getScoresData() {
		aHelper.getGamesClient().loadPlayerCenteredScores(
				theLeaderboardListener, getString(R.string.leaderBoardID), 1,
				1, 25);
	}

	@Override
	public void onSignInFailed() {
		System.out.println("sign in failed");
	}

	@Override
	public void onSignInSucceeded() {
		System.out.println("sign in succeeded");
	}

	@Override
	protected void onStart() {
		super.onStart();
		aHelper.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		aHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		aHelper.onActivityResult(requestCode, resultCode, data);
	}

}