package com.sample.dao;

import java.util.List;

import com.sample.model.Pattern;

public interface PatternDoa {

public void save(Pattern p);
    
    public List<Pattern> list();
}
