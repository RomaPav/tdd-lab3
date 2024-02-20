package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
  @author   user
  @project   lab3
  @class  CompanyServiceImplTest
  @version  1.0.0 
  @since 20.02.2024 - 20.39
*/class CompanyServiceImplTest {
    private final Company main = new Company(null, 2);
    private final Company book = new Company(main, 3);
    private final Company manager = new Company(main, 4);
    private final Company developer = new Company(manager, 8);
    private final Company design = new Company(manager, 6);
    private final Company lawyer = new Company(null, 1);
    private final List<Company> list = List.of(main, book, manager, developer, design, lawyer);
    private final ICompanyService companyService = new CompanyServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenCompanyIsNullThenNull() {
        Company result = companyService.getTopLevelParent(null);
        Assertions.assertNull(result);
    }

    @Test
    void whenCompanyHasNoParentItIsOnTop() {
        Company result = companyService.getTopLevelParent(main);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsSingleItIsOnTop() {
        Company result = companyService.getTopLevelParent(lawyer);
        Assertions.assertEquals(lawyer, result);
    }

    @Test
    void whenCompanyHasOneStepToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(book);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyHasTwoStepsToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(developer);
        Assertions.assertEquals(main, result);
    }
    @Test
    void whenCompanyIsNullThenZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(null,list);
        Assertions.assertEquals(0,result);
    }
    @Test
    void whenCListIsNullThenZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(manager,null);
        Assertions.assertEquals(0, result);
    }
    @Test
    void whenCompanyIsNullAndListIsNullThenZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(null,null);
        Assertions.assertEquals(0, result);
    }
    @Test
    void whenListHasSizeZeroThenZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(manager,new ArrayList<>());
        Assertions.assertEquals(0, result);
    }
    @Test
    void whenCompanyHasOneStepToChildrenCompanyThenCountEmployee() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(manager,list);
        Assertions.assertEquals(18, result);
    }
    @Test
    void whenCompanyHasTwoStepToChildrenCompanyCountEmployee() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(main,list);
        Assertions.assertEquals(23, result);
    }
    @Test
    void whenCompanyHasNoChildrenCompanyThenCountEmployee() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(lawyer,list);
        Assertions.assertEquals(1, result);
    }
}