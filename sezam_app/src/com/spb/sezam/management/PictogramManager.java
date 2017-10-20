package com.spb.sezam.management;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.res.AssetManager;
import android.util.Log;

public class PictogramManager {
	
	private static PictogramManager instance = null;
	public static final String BASE_FOLDER = "pictograms";
	
	private List<GroupPictogram> allGroups = new ArrayList<>();
	private List<GroupPictogram> firstLevelGroups = new ArrayList<>();
	
	private final String imagePatern = ".*?[\\.jpg|\\.png]";
	
	private AssetManager assetManager;
	
	private boolean isInitialized = false;
	
	private PictogramManager(){
	}
	
	public static PictogramManager getInstance() {
		if(instance == null){
			instance = new PictogramManager();
		}
		return instance;
	}
	
	public void init(AssetManager assetManager){
		if(isInitialized){
			Log.w("Reinit", "Pictogrammanager is already initialized");
			return;
		}
		try {
			collectPictograms(assetManager);
			isInitialized = true;
		} catch (IOException e) {
			Log.e("I/O Error in Assets", e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void collectPictograms(AssetManager am) throws IOException{
		//Only folders in first level
		for(String name : am.list(BASE_FOLDER)){
			
			if(!name.matches(imagePatern)){
				GroupPictogram pGroup = new GroupPictogram(name);
				firstLevelGroups.add(pGroup);
				allGroups.add(pGroup);
				collectPictograms(pGroup, am);
			}
			Collections.sort(firstLevelGroups);

			//for test
			/*BitmapDrawable bd = new BitmapDrawable(ctx.getResources(), am.open(FOLDER_NAME + File.separator + name));
			Pictogram p = new Pictogram(name);
			p.setIcon(bd);
			linearPicotgrams.add(p);*/
			
		}
	}
	
	private void collectPictograms(GroupPictogram pGroup, AssetManager am) throws IOException{
		String path = pGroup.getPath();
		String fullFolderPath = BASE_FOLDER + File.separator + path;
		for(String name : am.list(fullFolderPath)){
			if(name.matches(imagePatern)){
				Pictogram pictogram= new Pictogram(path + File.separator + name);
				pGroup.addInnerPictogram(pictogram);
			} else {
				GroupPictogram nestedGroup = new GroupPictogram(path + File.separator + name);
				pGroup.addInnerPictogram(nestedGroup);
				allGroups.add(nestedGroup);
				collectPictograms(nestedGroup, am);
			}
		}
		Collections.sort(pGroup.getInnerPictograms());
		System.out.println("");
	}

	public List<GroupPictogram> getallGroups() {
		return allGroups;
	}

	public List<GroupPictogram> getFirstLevelGroups() {
		return firstLevelGroups;
	}
	
	
}
