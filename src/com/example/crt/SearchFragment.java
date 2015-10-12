package com.example.crt;

import java.util.ArrayList;
import java.util.List;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SearchFragment extends Fragment {

	private ListView mGameListView; 
	
	private int[] groupImageList = new int[]{        
            R.drawable.guest1,R.drawable.guest7,
            R.drawable.guest8};
	
	private String[] groupNameList = new String[]{        
            "group one", "group two", "group three",
            "group four"};
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        View view = inflater.inflate(R.layout.search_fragment, container, false); 
        mGameListView = (ListView) view.findViewById(R.id.game_listview);
        
        GroupAdapter groupAdapter = new GroupAdapter(getActivity(),groupImageList,groupNameList);
        mGameListView.setAdapter(groupAdapter);
        
        mGameListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				PlayerFragment pf = new PlayerFragment();
				ft.replace(R.id.main_fragment, pf);
				ft.commit();
				
			}});
        
        return view;  
    } 
	
	class GroupAdapter extends BaseAdapter{
		
		private LayoutInflater inflater;
		private List<Group> groups;
		
		public GroupAdapter (Context context, int[] groupImage, String[] groupName){
			
			inflater = LayoutInflater.from(context);
			groups = new ArrayList<Group>(); 
			
			for (int i = 0; i < groupImage.length; i++) 
	        { 
	            Group group = new Group(groupImage[i], groupName[i]); 
	            groups.add(group); 
	        }
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return (groups != null) ? groups.size() : 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return groups.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder; 
	        if (convertView == null) 
	        { 
	            convertView = inflater.inflate(R.layout.game_list_layout, null); 
	            viewHolder = new ViewHolder(); 
	            viewHolder.groupImageView = (ImageView) convertView.findViewById(R.id.group_icn); 
	            viewHolder.groupName = (TextView) convertView.findViewById(R.id.group_name); 
	            
	            
	            convertView.setTag(viewHolder); 
	        } else
	        { 
	            viewHolder = (ViewHolder) convertView.getTag(); 
	        } 
	        viewHolder.groupImageView.setImageResource(groups.get(position).getGroupImageId()); 
	        viewHolder.groupName.setText(groups.get(position).getGroupName()); 
	         
	        
	       
	       
	        return convertView; 
		}
		
		class ViewHolder 
		{ 
		    public ImageView groupImageView; 
		    public TextView groupName; 
		} 
		class Group 
		{ 
		    private int groupImageId; 
		    private String groupName;
		    
		    public Group(int groupImageId, String groupName) {
				super();
				this.setGroupImageId(groupImageId);
				this.setGroupName(groupName);
			}

			public int getGroupImageId() {
				return groupImageId;
			}

			public void setGroupImageId(int groupImageId) {
				this.groupImageId = groupImageId;
			}

			public String getGroupName() {
				return groupName;
			}

			public void setGroupName(String groupName) {
				this.groupName = groupName;
			}
			
			
		 
		   
		} 
		
	}
	
	
	 

}
