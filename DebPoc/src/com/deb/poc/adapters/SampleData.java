package com.deb.poc.adapters;

import java.util.ArrayList;

public class SampleData {

public static final int SAMPLE_DATA_ITEM_COUNT = 5;

public static ArrayList<Data> generateLeftData(Integer[] items) {

		String[] description = { "Description One", "Description Two",
				"Description Three", "Description Four", "Description Five", };
		String[] title = { "Title One", "Title Two", "Title Three",
				"Title Four", "Title Five", };
	
//	Integer[] items = new Integer[]{R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5};

	
	final ArrayList<Data> datas = new ArrayList<Data>();
	for (int i = 0; i < SAMPLE_DATA_ITEM_COUNT; i++) {
		Data data = new Data();
		data.title = "Item "+ title[i];
		data.imgDraw = items[i];
		data.description = "Super awesome description" + description[i];
		datas.add(data);
	}
	
	
	return datas;
}
public static ArrayList<Data> generateRightData(Integer[] items) {
	
	String [] description = {
			"Description Six",
			"Description Seven",
			"Description Eight",
			"Description Nine",
			"Description Ten"};
	String [] title = {
			"Title Six",
			"Title Seven",
			"Title Eight",
			"Title Nine",
			"Title Ten"};
	
//	Integer[] items = new Integer[]{R.drawable.ic_6, R.drawable.ic_7, R.drawable.ic_8, R.drawable.ic_9, R.drawable.ic_10};

	
	final ArrayList<Data> datas = new ArrayList<Data>();
	for (int i = 0; i < SAMPLE_DATA_ITEM_COUNT; i++) {
		Data data = new Data();
		data.title = "Item "+ title[i];
		data.imgDraw = items[i];
		data.description = "Super awesome description" + description[i];
		datas.add(data);
	}
	
	
	return datas;
}
}
