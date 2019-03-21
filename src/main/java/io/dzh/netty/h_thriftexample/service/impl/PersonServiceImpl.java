package io.dzh.netty.h_thriftexample.service.impl;


import io.dzh.netty.h_thriftexample.service.generated.DataException;
import io.dzh.netty.h_thriftexample.service.generated.Person;
import io.dzh.netty.h_thriftexample.service.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @author Do
 * @description
 * @date 2019-03-09 15:17
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("client param:" + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("client person:"+ person.toString());

}
}
