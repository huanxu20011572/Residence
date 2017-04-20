package com.haiyi.residence.mediafile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.MediaFile;

public interface MediaFileDao extends SuperMapper{
	
	public void addMediaFile(@Param(value = "mf")MediaFile mf);
	public List<MediaFile> getAll();
	
	public void updateMediaFile(@Param(value="mf")MediaFile mf);
	
	public void updateMediaFileWords(@Param(value="mf")MediaFile mf);
	
	public List<MediaFile> selectMediaFiles(@Param(value = "mf")MediaFile mf);
}
