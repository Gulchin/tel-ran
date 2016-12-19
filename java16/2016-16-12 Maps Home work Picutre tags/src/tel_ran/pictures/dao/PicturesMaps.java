package tel_ran.pictures.dao;

import java.util.*;
import java.util.Map.Entry;

import tel_ran.pictures.enteries.Picture;
import tel_ran.pictures.util.TwoDimItarable;

public class PicturesMaps {
	Map<String,Picture> pictures=new HashMap<>();
	Map<String,List<Picture>> picturesByTag=new HashMap<>();
	private int similarityPercent;
	
	
	public PicturesMaps(int similarityPercent) {
		super();
		this.similarityPercent = similarityPercent;
	}
	
	

	public PicturesMaps() {
	}



	public void setSimilarityPercent(int similarityPercent) {
		this.similarityPercent = similarityPercent;
	}



	public boolean add(Picture picture){
		if (pictures.putIfAbsent(picture.getUrl(), picture)!=null) return false;
		for (String tag: picture.getTags()){
			addPictureToTag(tag,picture);
		}
		return true;
	}

	private void addPictureToTag(String tag, Picture picture) {
		List<Picture> newList=new ArrayList<>();
		List<Picture> list=picturesByTag.putIfAbsent(tag, newList);
		if (list==null) newList.add(picture);
		else list.add(picture);		
	}
	
	public List<Picture> getSimilarPictures(String [] tags){
		List<Iterable<Picture>> lists=new ArrayList<>();
		for(String tag: tags){
			Iterable<Picture> list=picturesByTag.get(tag);
			if (list!=null) lists.add(list);
		}
		HashMap<Picture,Integer> map=new HashMap<>();
		TwoDimItarable<Picture> di=new TwoDimItarable<Picture>((Iterable<Iterable<Picture>>)lists);
		for(Picture picture: di){
			Integer number=map.putIfAbsent(picture, 1);
			if (number!=null) map.put(picture, number+1);
		}

		int minReauared= (tags.length*similarityPercent)/100;
		//System.out.println(minReauared);
		
		List<Picture> res=new ArrayList<>();
		for (Entry<Picture,Integer> entry: map.entrySet()){
			if(entry.getValue()>=minReauared)
			res.add(entry.getKey());
		}
		return res;
	}
	
}
