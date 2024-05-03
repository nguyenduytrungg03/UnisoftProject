package com.example.projecttraining.model;



public class Account {

    private int accountId;

    private String accountName;

    private String password;

    private int versionAccount;
    
 

	private Role role;
    private  boolean statusDelete ;


    public Account() {

    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getVersionAccount() {
 		return versionAccount;
 	}

 	public void setVersionAccount(int versionAccount) {
 		this.versionAccount = versionAccount;
 	}

   
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(boolean statusDelete) {
        this.statusDelete = statusDelete;
    }
}
