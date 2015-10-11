package com.example.crt;

public abstract class GamePlayer {

	private String name;
	private boolean isHost;
	private boolean isReady2Go;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHost() {
		return isHost;
	}
	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}
	public boolean isReady2Go() {
		return isReady2Go;
	}
	public void setReady2Go(boolean isReady2Go) {
		this.isReady2Go = isReady2Go;
	}
	
	
}
