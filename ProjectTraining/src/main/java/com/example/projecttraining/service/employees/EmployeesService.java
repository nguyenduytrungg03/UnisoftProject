package com.example.projecttraining.service.employees;

import com.example.projecttraining.mapper.AccountMapper;
import com.example.projecttraining.mapper.EmployeesMapper;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Employees;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeesService implements IEmployeesService{

    @Autowired
    private EmployeesMapper employeesMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public List<Map<String, Object>> findAllEmployees( String accountName,String nameEmployees, String phoneNumber,  int pageIndex, int pageSize) {
        return employeesMapper.getAllEmployees(accountName, nameEmployees, phoneNumber, pageIndex, pageSize);
    }


    @Override
    public int countEmployees( String accountName, String nameEmployees, String phoneNumber) {
        return employeesMapper.countEmployees(accountName, nameEmployees, phoneNumber);
    }

    @Override
    public void deleteEmployees(int idEmployees) {
        employeesMapper.deleteEmployees(idEmployees);
    }

    @Override
    public Employees getEmployeesByIdEmployees(int idEmployees) {
        Map<String, Object>  map = employeesMapper.getEmployeesByIdEmployees(idEmployees);
        Employees employees = new Employees();
        Account account = new Account();
        employees.setIdEmployees((Integer) map.get("idEmployees"));
        employees.setNameEmployees((String) map.get("nameEmployees"));
        employees.setPhoneNumber((String) map.get("phoneNumber"));
        employees.setVersionEmployees((int) map.get("versionEmployees"));
        account.setAccountId((Integer) map.get("accountId"));
        account.setAccountName((String) map.get("accountName"));
        employees.setAccount(account);
        return employees;
    }

    @Override
    @Transactional
    public int createEmployees(String accountName,String password, Employees employees) {
        int role = 2;
        int rowCreateAccount = accountMapper.createAccount(accountName, encoder.encode(password), role);

        if (rowCreateAccount == 1) {
//            Map<String, Object> getIdByAccountCreate = accountMapper.findByAccountName(accountName);
//            int accountId = (int) getIdByAccountCreate.get("accountId");
            int accountId = accountMapper.findByIdAccountByAccountName(accountName);
            int rowCreateEmployees = employeesMapper.createEmployees(employees.getNameEmployees(), employees.getPhoneNumber(), accountId);
            if (rowCreateEmployees == 1) {
                return 1;
            }
      }
        return 0;
    }

    @Override
    public Employees getEmployeesByAccountId(int idAccount) {
        return employeesMapper.getEmployeesByAccountId(idAccount);
    }


//public int insertEmployee(Account account, Employee employee) {
//		int roleIdOfUser = 2;
//		int rowEffectByInsertAccount = accountMapper.insertAccount(account.getUsername(), BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()),roleIdOfUser);
//		if (rowEffectByInsertAccount == 1) {
//			Map<String,Object> getIdByAccountAddNew = accountMapper.getAccountByUsername(account.getUsername());
//			int accountId = (int) getIdByAccountAddNew.get("id");
//			int rowEffectByInsertEmployee = employeeMapper.insertEmployee(employee.getName(),employee.getPhoneNumber(),accountId);
//			if (rowEffectByInsertEmployee == 1) {
//				return 1;
//			}
//		}
//		return 0;
//	}

//	int roleIdOfUser = 2;
//		int rowEffectByInsertAccount = accountMapper.insertAccount(account.getUsername(), BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()),roleIdOfUser);
//		if (rowEffectByInsertAccount == 1) {
//			Map<String,Object> getIdByAccountAddNew = accountMapper.getAccountByUsername(account.getUsername());
//			int accountId = (int) getIdByAccountAddNew.get("id");
//			int rowEffectByInsertEmployee = employeeMapper.insertEmployee(employee.getName(),employee.getPhoneNumber(),accountId);
//			if (rowEffectByInsertEmployee == 1) {
//				return 1;
//			}
//		}
//		return 0;
//    @Override
//    public int createEmployees( Employees employees) {
//        EmployeesDTO employeesDTO = new EmployeesDTO();
//        Role role = new Role(2,"ROLE_EMPLOYEES");
//        Account account = new Account();
//        account.setRole(role);
//        Account savedAccount = accountMapper.createAccount(account);
//        BeanUtils.copyProperties(employeesDTO, employees);
//        employees.setAccount(savedAccount);
//        return employeesMapper.createEmployees(employees);
//    }


}
