package net.softsociety.spring3.service;

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
}
