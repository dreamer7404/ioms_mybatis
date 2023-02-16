package hae.basic.board.dao;

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

public interface PersonDAO {
    public List<Person> selectPersonList() throws Exception;
}
