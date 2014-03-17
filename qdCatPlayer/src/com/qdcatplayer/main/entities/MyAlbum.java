package com.qdcatplayer.main.entities;

import android.graphics.Bitmap;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.qdcatplayer.main.DAOs.MyAlbumDAO;

@DatabaseTable(tableName = "MyAlbums")
public class MyAlbum extends _MyEntityAbstract<MyAlbumDAO> {
	private Bitmap cover = null;
	@DatabaseField(unique = true, useGetSet = true)
	private String name = "";// never null

	@ForeignCollectionField
	private ForeignCollection<MySong> songs = null;

	public MyAlbum() {

	}

	public MyAlbum(String name) {
		setName(name);
	}

	@Override
	public Integer delete() {
		// TODO Auto-generated method stub
		return null;
	}

	public Bitmap getCover() {
		return cover;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ForeignCollection<MySong> getSongs() {
		return songs;
	}

	@Override
	public Integer insert() {
		// TODO Auto-generated method stub
		return getDao().insert(this);
	}

	@Override
	public Boolean loadAllProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reset() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCover(Bitmap cover) {
		this.cover = cover;
	}

	public void setId(Integer id_) {
		id = id_ == null ? 0 : id_;
	}

	public void setName(String name_) {
		name = name_ == null ? "" : name_;
	}

	public void setSongs(ForeignCollection<MySong> songs) {
		this.songs = songs;
	}

	@Override
	public Boolean update() {
		// TODO Auto-generated method stub
		return null;
	}
}
