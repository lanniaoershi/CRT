package com.example.crt;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerFragment extends Fragment {


	private GridView playersGridView; 
	
	private int[] playersList = new int[]{        
            R.drawable.guest1, R.drawable.host, R.drawable.guest2,  
            R.drawable.guest3, R.drawable.guest4, R.drawable.guest5, R.drawable.guest6, R.drawable.guest7,
            R.drawable.guest8};
	private int[] readyList = new int[]{        
            R.string.ready, R.string.ready,R.string.ready,R.string.ready,R.string.ready,R.string.ready,
            R.string.ready,R.string.ready,R.string.ready,};
	
	private int[] nameList = new int[]{        
            R.string.name, R.string.name,R.string.name,R.string.name,R.string.name,R.string.name,
            R.string.name,R.string.name,R.string.name};
	
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        View view = inflater.inflate(R.layout.player_table, container, false);  
        playersGridView = (GridView) view.findViewById(R.id.players);  
        PictureAdapter adapter = new PictureAdapter(playersList, readyList,nameList, getActivity());
        playersGridView.setAdapter(adapter);
        
        return view;  
    } 
	
	class PictureAdapter extends BaseAdapter{ 
	    private LayoutInflater inflater; 
	    private List<Picture> pictures; 
	 
	    public PictureAdapter(int[] players, int[] ready, int[] name, Context context) 
	    { 
	        super(); 
	        pictures = new ArrayList<Picture>(); 
	        inflater = LayoutInflater.from(context); 
	        for (int i = 0; i < players.length; i++) 
	        { 
	            Picture picture = new Picture(players[i], ready[i], name[i]); 
	            pictures.add(picture); 
	        } 
	    } 
	 
	    @Override
	    public int getCount() 
	    { 
	        if (null != pictures) 
	        { 
	            return pictures.size(); 
	        } else
	        { 
	            return 0; 
	        } 
	    } 
	 
	    @Override
	    public Object getItem(int position) 
	    { 
	        return pictures.get(position); 
	    } 
	 
	    @Override
	    public long getItemId(int position) 
	    { 
	        return position; 
	    } 
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) 
	    { 
	    	int positionNotShow = position;
	        ViewHolder viewHolder; 
	        if (convertView == null) 
	        { 
	            convertView = inflater.inflate(R.layout.player, null); 
	            viewHolder = new ViewHolder(); 
	            viewHolder.playerImageView = (ImageView) convertView.findViewById(R.id.player_icon); 
	            viewHolder.readyText = (TextView) convertView.findViewById(R.id.ready); 
	            viewHolder.nameText = (TextView) convertView.findViewById(R.id.name); 
	            
	            convertView.setTag(viewHolder); 
	        } else
	        { 
	            viewHolder = (ViewHolder) convertView.getTag(); 
	        } 
	        viewHolder.playerImageView.setImageResource(pictures.get(position).getPlayerId()); 
	        viewHolder.readyText.setText(pictures.get(position).getreadyId()); 
	        viewHolder.nameText.setText(pictures.get(position).getnameId());  
	        
	        if (positionNotShow == 0 || positionNotShow == 2 || positionNotShow == 4 ||
	        		positionNotShow == 6 || positionNotShow == 8) {
	        	viewHolder.playerImageView.setVisibility(View.INVISIBLE);
		        viewHolder.readyText.setVisibility(View.INVISIBLE);
		        viewHolder.nameText.setVisibility(View.INVISIBLE);
	        }
	       
	        return convertView; 
	    } 
	 
	} 
	 
	class ViewHolder 
	{ 
	    public ImageView playerImageView; 
	    public TextView readyText; 
	    public TextView nameText;
	} 
	 
	class Picture 
	{ 
	    private int playerId; 
	    private int readyId;
	    private int nameId;
	 
	    public Picture() 
	    { 
	        super(); 
	    } 
	 
	    public Picture(int playerId, int readyId,int nameId) 
	    { 
	        super(); 
	        this.playerId = playerId; 
	        this.readyId = readyId; 
	        this.nameId = nameId;
	    } 
	 
	    public int getPlayerId() 
	    { 
	        return playerId; 
	    } 
	 
	    public void setPlayerId(int playerId) 
	    { 
	        this.playerId = playerId; 
	    } 
	 
	    public int getreadyId() 
	    { 
	        return readyId; 
	    } 
	 
	    public void setreadyId(int readyId) 
	    { 
	        this.readyId = readyId; 
	    } 
	    public int getnameId() 
	    { 
	        return nameId; 
	    } 
	 
	    public void setnameId(int nameId) 
	    { 
	        this.nameId = nameId; 
	    } 
	} 

}
