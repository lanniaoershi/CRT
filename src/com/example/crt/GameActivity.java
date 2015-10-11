package com.example.crt;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameActivity extends Activity {
	
	private boolean mIsGameOwner;
	private PlayerFragment mPlayerFragment;
	private GamePadFragment mGamePadFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		Intent intent = getIntent();
		mIsGameOwner = intent.getBooleanExtra("OWNER", true);
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();  
		
		
		mPlayerFragment = new PlayerFragment();
		transaction.replace(R.id.player_fragment, mPlayerFragment);  
//        transaction.commit();
        
        mGamePadFragment = new GamePadFragment();
        transaction.replace(R.id.gamepad_fragment, mGamePadFragment);  
        transaction.commit();
        
		
		if (mIsGameOwner){
			startGameAsHost();
		} else
			startGameAsGuest();
	}

	private void startGameAsHost() {
		createGame();
	}
	
	private void startGameAsGuest() {
		findGameOwner();
	}
	
	private void findGameOwner(){
		
	}
	
	private void createGame(){
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
