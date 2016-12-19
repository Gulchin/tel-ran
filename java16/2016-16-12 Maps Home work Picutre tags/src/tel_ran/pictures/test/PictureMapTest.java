package tel_ran.pictures.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tel_ran.pictures.dao.PicturesMaps;
import tel_ran.pictures.enteries.Picture;

public class PictureMapTest {
	PicturesMaps map;
	private final static String urlPattern="http;//www.pictures.com/pic";
	private final static String TAG1="tree";
	private final static  String TAG2="bird";
	private final static  String TAG3="kid";
	private final static  String TAG4="weapon";
	private final static  String TAG5="river";
	private final static  String TAG6="rabit";
	private final  static String TAG0="money";
	private final  static String TAG7="blood";
	private final static  String TAG8="winter";
	private final static  String TAG9="girl";
	private final static  String[] allTags={TAG0,TAG1,TAG2,TAG3,TAG4,TAG5,TAG6,TAG7,TAG8,TAG9};
	
	
	 static Picture [] pictures;
	

	
	@Before
	public void init(){
		map=new PicturesMaps(50);
		for (Picture pic: pictures){
			map.add(pic);
		}
	}

	@Test
	public void testPront() {
		map.setSimilarityPercent(30);
		for(Picture picture: map.getSimilarPictures(allTags)){
			System.out.println(picture);
		}
	}
	
	@Test
	public void testGet(){
		map.setSimilarityPercent(100);
		testListArray(new Picture[]{pictures[9]},map.getSimilarPictures(allTags));
		map.setSimilarityPercent(90);
		testListArray(new Picture[]{pictures[8],pictures[9]},map.getSimilarPictures(allTags));
		
		map.setSimilarityPercent(50);
		testListArray(new Picture[]{pictures[4],pictures[5],pictures[6],pictures[7],
				pictures[8],pictures[9]},map.getSimilarPictures(allTags));
		
		map.setSimilarityPercent(10);
		testListArray(pictures,map.getSimilarPictures(allTags));
	}

	private static String getUrl(int num){
		return urlPattern+num+".jpg";
	}
	
	@BeforeClass
	public static void initPictures(){
		pictures=new Picture[10];
		for (int i=0;i<pictures.length;i++){
			String [] tgs=new String [i+1];
			for (int j=0;j<=i;j++){
				tgs[j]=allTags[j];
			}			
			pictures[i]=new Picture(getUrl(i),tgs);
		}
	}
	
	private void testListArray(Picture [] array,List<Picture> list){
		assertEquals(array.length,list.size());
		for(Picture pic: array){
			assertTrue(list.contains(pic));
		}
	}
}
