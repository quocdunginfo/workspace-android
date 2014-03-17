package com.qdcatplayer.main.DAOs;

import java.sql.SQLException;
import java.util.ArrayList;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.qdcatplayer.main.entities.MyAlbum;

public class MyAlbumDAO extends _MyDAOAbstract<MyAlbum> {
	/**
	 * Neu khong chi dinh GlobalDAO thi dat g=null (se tu dong tao)
	 * @param ctx
	 * @param g
	 */
	public MyAlbumDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyAlbum, Integer> getDao() {
		// TODO Auto-generated method stub
		if(getManager()!=null && getHelper()!=null)
		{
			return getHelper().getMyAlbumDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyAlbum> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyAlbum getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean update(MyAlbum obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(MyAlbum obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
