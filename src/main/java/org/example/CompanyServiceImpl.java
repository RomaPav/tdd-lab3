package org.example;/*
  @author   user
  @project   lab3
  @class  CompanySreviceUmpl
  @version  1.0.0 
  @since 20.02.2024 - 20.36
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CompanyServiceImpl implements ICompanyService {

    @Override
    public Company getTopLevelParent(Company child) {
        if (child == null) {
            return null;
        } else if (child.getParent() == null) {
            return child;
        } else {
            while (child.getParent() != null) {
                child = child.getParent();
            }
            return child;
        }
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null ) {
            return 0;
        } else if (companies == null) {
            return company.getEmployeesCount();
        } else if (companies.isEmpty()) {
            return company.getEmployeesCount();
        } else {
            long result = 0;
            Set<Company> childCompanies = new HashSet<>();
            Queue<Company> companiesToProcess = new LinkedList<>();
            companiesToProcess.add(company);
            while (!companiesToProcess.isEmpty()) {
                Company currentCompany = companiesToProcess.remove();
                childCompanies.add(currentCompany);
                for (Company comp : companies) {
                    if (comp.getParent() == currentCompany) {
                        companiesToProcess.add(comp);
                    }
                }
            }
            for (Company el : childCompanies) {
                result += el.getEmployeesCount();
            }
            return result;
        }
    }
}
