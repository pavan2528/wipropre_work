var employees = [
    { empId: 101, empName: "John Doe", salary: 50000 },
    { empId: 102, empName: "Jane Smith", salary: 60000 },
    { empId: 103, empName: "Michael Johnson", salary: 55000 }
];
function printEmployees(empList) {
    console.log("Employee Details:");
    empList.forEach(function (emp) {
        console.log("ID: ".concat(emp.empId, ", Name: ").concat(emp.empName, ", Salary: ").concat(emp.salary));
    });
    return empList.length;
}
var count = printEmployees(employees);
console.log("Total Employees:", count);
