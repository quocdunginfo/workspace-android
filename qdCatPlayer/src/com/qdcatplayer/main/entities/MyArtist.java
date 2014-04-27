package com.qdcatplayer.main.Entities;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.qdcatplayer.main.DAOs.MyArtistDAO;

@DatabaseTable(tableName = "MyArtists")
public class MyArtist extends _MyEntityAbstract<MyArtistDAO, MyArtist> {
	public static final String NAME_F = "name";

	@DatabaseField(unique = true)
	private String name = "";// never null

	/**
	 * KHÔNG dùng ForeignCollection, vì một vài lý do như
	 * setDao
	 * setLoaded
	 */
	private ArrayList<MySong> songs = null;

	public MyArtist() {

	}

	public MyArtist(String name) {
		setName(name);
	}

	public String getName() {
		super.load();
		return name;
	}

	public ArrayList<MySong> getSongs() {
		if(songs==null)
		{
			songs = getDao().getSongs(this);
		}
		return songs;
	}


	@Override
	public Integer insert() {
		//very importance
		//since MyBitrate may be loaded when fetching MySong
		//if not force to set loaded=true then
		//new load script will be acted and reset will be called
		//then all data pre-loaded will swiped out
		setLoaded(true);
		return super.insert();
	}

	@Override
	public void reset() {
		super.reset();
		name = null;
	}
	public void setName(String name_) {
		name = name_ == null ? "" : name_;
	}

}
