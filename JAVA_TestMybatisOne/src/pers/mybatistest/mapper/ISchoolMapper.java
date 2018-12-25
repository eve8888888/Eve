package pers.mybatistest.mapper;

import pers.mybatistest.entity.School;

import java.util.List;

public interface ISchoolMapper{
    void addSchool(School school);

    void deleteSchool(Integer id);

    void updateSchool(School school);

    List<School> findAllSchools();
}
