/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crosswalking;

import Dataverse.DataverseJavaObject;

import java.util.LinkedList;

/**
 * An interface used for crosswalking from a datasource Java Object to
 * a metadata schema.
 * @author pdante
 */
public interface Crosswalk {
    //TODO create interface for metadata crosswalks
    void convertDJO(LinkedList<DataverseJavaObject> records);
}
