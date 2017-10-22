package com.spb.sezam;

import android.view.View;

/**
 * Must be implemented by classes who would be able to send pictograms(images) in messages
 * @author Serob
 */
public interface IPictogramHolder {
	
	public View.OnClickListener getOnPictogramClickListener();
}
