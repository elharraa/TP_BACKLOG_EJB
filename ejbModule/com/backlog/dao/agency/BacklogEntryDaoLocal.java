package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.Local;

import com.backlog.model.BacklogEntry;

@Local
public interface BacklogEntryDaoLocal {

	void addBacklogEntry(BacklogEntry p);

	void editBacklogEntry(BacklogEntry p);

	void deleteBacklogEntry(int id);

	List<BacklogEntry> getAllBacklogEntries();
	
	List<BacklogEntry> getAllBacklogEntries(int id);

	BacklogEntry getBacklogEntry(int id);

}
