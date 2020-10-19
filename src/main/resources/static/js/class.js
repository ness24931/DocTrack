class TUser {
    constructor(username, passwd, status, tEmployee, tRole) {
        this.username = username;
        this.passwd = passwd;
        this.status = status;
        this.tEmployee = tEmployee;
        this.tRole = tRole;
    }
}

class TRole {
    constructor(roleId, name) {
        this.roleId = roleId;
        this.name = name;
    }
}

export class TDepartment {
    // TEmployee tEmployee => este atributo es el que dice quien es el lider de ese departamento
    constructor(departmentId, departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        // TEmployee = tEmployee;
    }
}

class TEmployee {
    constructor(employeeId, dni, email, firstName, firstSurname,
        secondSurname, status, telephone, tDepartment) {
        this.employeeId = employeeId;
        this.dni = dni;
        this.email = email;
        this.firstName = firstName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.status = status;
        this.telephone = telephone;
        this.TDepartment = tDepartment;
    }
}

//  export { TDepartment };

// export {TUser,TRole,TDepartment,TEmployee};