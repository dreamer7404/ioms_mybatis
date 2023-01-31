package hae.basic.board.service.impl;

import java.util.List;

import able.cloud.core.service.HService;

import hae.basic.board.dao.PersonDAO;
import hae.basic.board.model.Person;
import hae.basic.board.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 1. 6.
 * @see
 */

@Service
public class PersonServiceImpl extends HService implements PersonService{
    private PersonDAO personDAO;
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    /**
     * 게시판 리스트 불러오기
     *
     * @param vo 정보 조회를 위한 VO
     * @return 게시글 목록
     * @throws Exception
     */
    @Override
    public List<Person> selectPersonList() throws Exception {
        return personDAO.selectPersonList();
    }
}
