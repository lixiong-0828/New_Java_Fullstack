package com.ibm.service;

import java.util.List;
import com.ibm.pojo.dept;

public interface DeptService {

    public List<dept> getDept();

    public void deleteById(Integer id);

    public void add(dept dept);

    public  String getDeptByIs(Integer id);

    void updateName(dept dept);
}
