package net.softsociety.spring3.service;

import java.util.ArrayList;
import net.softsociety.spring3.domain.Person;

/**
 * 회원 정보 처리 서비스
 * 
 * @author hwikun
 *
 */
public interface PersonService {
  /**
   * 회원정보 저장 기능
   * 
   * @param p 저장할 회원정보
   * @return 저장한 행개수
   */
  public int insertPerson(Person p);

  /**
   * 회원정보 삭제기능
   * 
   * @param idnum 삭제할 회원의 주민등록번호
   * @return 삭제된 행 개수
   */
  public int deletePerson(String idnum);

  /**
   * 이름으로 검색 후 삭제
   * 
   * @param name 삭제할 이름
   * @return 삭제된 행 개수
   */
  public int deletesByName(String name);

  /**
   * 정보 수정
   * 
   * @param p 수정할 데이터
   * @return 수정된행개
   */
  public int updatePerson(Person p);

  /**
   * 주민번호로회원 정로 조 회
   * 
   * @param idnum 주민번호
   * @return 검색 결과, 없으면 널
   */
  public Person selectOne(String idnum);

  public ArrayList<Person> selectAll();
}
