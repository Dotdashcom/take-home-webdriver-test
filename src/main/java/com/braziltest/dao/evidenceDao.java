package com.braziltest.dao;

import com.braziltest.dto.evidence;
import java.util.Collection;

public interface evidenceDao {


    public Collection<evidence> evidenceGet(String Runner) throws Exception;

    public void evidenceSave(String Runner, String Evidence, Integer COD_BU) throws Exception;

}

