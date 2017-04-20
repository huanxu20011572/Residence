package com.haiyi.residence.mediafile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haiyi.residence.mediafile.dao.MediaFileDao;
import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;
@Service("mediaFileService")
public class MediaFileServiceImpl implements MediaFileService{

	private MediaFileDao mediaFileDao;

	public MediaFileDao getMediaFileDao() {
		return mediaFileDao;
	}
	@Resource(name="mediaFileDao")
	public void setMediaFileDao(MediaFileDao mediaFileDao) {
		this.mediaFileDao = mediaFileDao;
	}
	
	@Override
	public void addMediaFile(MediaFile mediaFile) {
		this.mediaFileDao.addMediaFile(mediaFile);
	}
	@Override
	public List<MediaFile> getAll() {
		// TODO Auto-generated method stub
		return this.mediaFileDao.getAll();
	}
	@Override
	public void updateMediaFile(MediaFile mf) {
		// TODO Auto-generated method stub
		this.mediaFileDao.updateMediaFile(mf);
	}
	@Override
	public void updateMediaFileWords(MediaFile mf) {
		// TODO Auto-generated method stub
		this.mediaFileDao.updateMediaFileWords(mf);
	}
	@Override
	public List<MediaFile> selectMediaFiles(MediaFile mf) {
		// TODO Auto-generated method stub
		return this.mediaFileDao.selectMediaFiles(mf);
	}
}
