package com.haiyi.residence.mediafile.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.model.MediaFile;

public interface MediaFileService {
	
	public void addMediaFile(MediaFile mediaFile);
	public List<MediaFile> getAll();
	
	public void updateMediaFile(MediaFile mf);
	
	public void updateMediaFileWords(MediaFile mf);
	
	public List<MediaFile> selectMediaFiles(MediaFile mf);
	
}
