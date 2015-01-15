package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.Local;

import com.backlog.model.Agency;

@Local
public interface AgencyDaoLocal {

	void addAgency(Agency p);

	void editAgency(Agency p);

	void deleteAgency(int id);

	List<Agency> getAllAgencies();

	Agency getAgency(int id);

}
