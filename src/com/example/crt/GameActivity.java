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
	private SearchFragment mSearchFragment;
	
	FragmentManager mFragmentManager;
	FragmentTransaction mTransaction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		Intent intent = getIntent();
		mIsGameOwner = intent.getBooleanExtra("OWNER", true);
		mFragmentManager = getFragmentManager();
		mTransaction = mFragmentManager.beginTransaction();  
        
        mGamePadFragment = new GamePadFragment();
        mTransaction.replace(R.id.gamepad_fragment, mGamePadFragment);  
        //mTransaction.commit();
        
		
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
		mSearchFragment = new SearchFragment();
		mTransaction.replace(R.id.main_fragment, mSearchFragment);  
		mTransaction.commit();
	}
	
	private void createGame(){
		mPlayerFragment = new PlayerFragment();
		mTransaction.replace(R.id.main_fragment, mPlayerFragment);  
		mTransaction.commit();
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
