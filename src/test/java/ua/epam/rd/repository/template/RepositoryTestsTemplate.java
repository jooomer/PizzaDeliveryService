package ua.epam.rd.repository.template;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // runs spring framework container
@FixMethodOrder(MethodSorters.JVM) // not required
abstract class RepositoryTestsTemplate extends AbstractTransactionalJUnit4SpringContextTests{

}