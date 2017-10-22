package com.spb.sezam.adapters;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.spb.sezam.R;
import com.spb.sezam.adapters.MessageAdapter.ViewHolder;
import com.spb.sezam.management.Pictogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PredictionAdapter extends ArrayAdapter<JSONObject> {

	private final Context context;
	private final List<JSONObject> messages;
	
	static class ViewHolder {
		public ImageView messageItem;
	}
	
	public PredictionAdapter(Context context, List<JSONObject> messages) {
		super(context, R.layout.row_layout, messages);
		this.context = context;
		this.messages = messages;
	}
	
	@Override
	public int getCount() {
		return messages.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
/*		View elementView = convertView;
		
		// reuse views
		if(elementView == null){
			LayoutInflater inflater = (LayoutInflater)context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			elementView = inflater.inflate(R.layout.message_element_layout, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.messageItem  = (ImageView)elementView.findViewById(R.id.messageItem);
			elementView.setTag(viewHolder);
		}
		
		// fill data
			ViewHolder holder = (ViewHolder) elementView.getTag();
			Pictogram pic = getItem(position);
			
			ImageLoader imageLoader = ImageLoader.getInstance();
			int messageHeight = (int)context.getResources().getDimension(R.dimen.new_message_height);
			ImageSize imageSize = new ImageSize(messageHeight, messageHeight); //to economy memory
			Bitmap bitmap = imageLoader.loadImageSync(pic.getPathWithAssests(), imageSize);
			
			BitmapDrawable drBitmap = new BitmapDrawable(context.getResources(), bitmap); 
			holder.messageItem.setBackground(drBitmap);*/

/*		// fill data
		ViewHolder holder = (ViewHolder) rowView.getTag();
		JSONObject user = users.get(position);
		String username = "";
		int onlineStatus = 0;
		String unreadMessagesCount = null;
		try {
			username = user.getString("first_name") + " "+ user.getString("last_name");
			onlineStatus = user.getInt("online");
			// maybe maybe unreadmessage here
			unreadMessagesCount = user.getString("unread_count");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		holder.text.setText(username);
		
		if (onlineStatus == 1) {
			holder.onlineIcon.setImageResource(R.drawable.online);
		} else {
			holder.onlineIcon.setImageResource(R.drawable.ofline);
		}
		
		//has unread messages
		if (unreadMessagesCount != null && !"0".equals(unreadMessagesCount)) {
			holder.unreadCount.setText("+" + unreadMessagesCount);
			holder.unreadCount.setBackgroundResource(R.drawable.unread_message);
		} else {
			//no unread message
			holder.unreadCount.setText("");
			holder.unreadCount.setBackgroundResource(0);
		}*/
		
		return null;
	}

	
}
