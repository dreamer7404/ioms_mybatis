package hae.basic.board.service;

import java.util.List;

import hae.basic.board.model.Person;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 1. 6.
 * @see
 */

public interface PersonService {
    List<Person> selectPersonList() throws Exception;
    
}
