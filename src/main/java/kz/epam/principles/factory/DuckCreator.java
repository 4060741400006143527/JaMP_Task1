/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.epam.principles.factory;

import kz.epam.principles.model.DuckType;
import kz.epam.principles.model.MovableDuck;

/**
 *
 * @author RedSweet
 */
public interface DuckCreator {
    
    MovableDuck getDuck(DuckType duckType);
}
