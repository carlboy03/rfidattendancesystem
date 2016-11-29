package persistence;

import models.Person;

import java.util.ArrayList;


public interface DAOGeneric {
    public Object getAllObjetcs();

    public Object getObjectById(Integer id);

    public void updateObject(Object object);

    public void deleteObject(Object object);

}
