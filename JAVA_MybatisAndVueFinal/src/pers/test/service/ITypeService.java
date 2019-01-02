package pers.test.service;

import pers.test.entity.Type;

import java.io.IOException;
import java.util.List;

public interface ITypeService {
    List<Type> findAllType() throws IOException;
}
